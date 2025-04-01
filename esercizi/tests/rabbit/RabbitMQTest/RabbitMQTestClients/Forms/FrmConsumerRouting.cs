using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RabbitMQTestClients.Forms.HelloWorld
{
    public partial class FrmConsumerRouting : Form
    {
        private bool _loadActive = false;
        private string _instanceName;

        public FrmConsumerRouting()
        {
            InitializeComponent();
        }

        public FrmConsumerRouting(int instance) : this()
        {
          
            _instanceName = "Consumer " + instance; 
            LblInstanceName.Text = _instanceName;
        }

        private void BtnStart_Click(object sender, EventArgs e)
        {
            BtnStart.Enabled = false;
            BtnStop.Enabled = true;
            _loadActive = true;
            LoadMessages();

        }

        private void BtnStop_Click(object sender, EventArgs e)
        {
            BtnStart.Enabled = true;
            BtnStop.Enabled = false;
            LblTag.Text = "";
            _loadActive = false;
        }


        private void LoadMessages()
        {
            TxtConsole.Clear();
            string[] severityArr = new string[3] { "info", "warning", "error" };
            var severity = severityArr[0];


            var factory = new ConnectionFactory() { HostName = "localhost" };
            using (var connection = factory.CreateConnection(_instanceName))
            {
                using (var channel = connection.CreateModel())
                {
                    //factory.DispatchConsumersAsync = true;

                    var cancellationTokenSource = new CancellationTokenSource();
                    CancellationToken cancellationToken = cancellationTokenSource.Token;

                    channel.ExchangeDeclare(
                        exchange: "direct_logs",
                        type: "direct"
                    );

                    var queueName = channel.QueueDeclare().QueueName;


                    if (ChkBoxInfo.Checked)
                        channel.QueueBind(
                            queue: queueName,
                            exchange: "direct_logs",
                            routingKey: severityArr[0]
                        );

                    if (ChkBoxWarning.Checked)
                        channel.QueueBind(
                            queue: queueName,
                            exchange: "direct_logs",
                            routingKey: severityArr[1]
                        );

                    if (ChkBoxError.Checked) 
                        channel.QueueBind(
                            queue: queueName,
                            exchange: "direct_logs",
                            routingKey: severityArr[2]
                        );

                   



                    var consumer = new EventingBasicConsumer(channel);
                    consumer.Received += HandleCustomEvent;


                    var tag = channel.BasicConsume(
                        queue: queueName,
                        autoAck: true,
                        consumer: consumer
                    );

                    LblTag.Text = tag;


                    cancellationTokenSource.Cancel();
                    WaitHandle.WaitAny(new[] { cancellationToken.WaitHandle });

                    while (_loadActive)
                    {
                        Application.DoEvents();
                    }

                    //channel.BasicCancel(tag);

                    //consumer.HandleModelShutdown(channel, null);
                    //consumer.HandleBasicCancel(tag);               

                    consumer.Received -= HandleCustomEvent;

                    //channel.BasicCancel(tag);

                    channel.Close();
                    channel.Dispose();

                }

                connection.Close();
                connection.Dispose();

            }
        }


        void HandleCustomEvent(object sender, BasicDeliverEventArgs e)
        {
            var senderCast = sender as EventingBasicConsumer;            
            var body = e.Body.ToArray();
            var message = Encoding.UTF8.GetString(body);
            WriteMessage(String.Format("Received {0} - {1} - {2}", message, e.ConsumerTag, e.RoutingKey));
            Application.DoEvents();
            //senderCast.Model.BasicAck(deliveryTag: e.DeliveryTag, multiple: false);
        }

        delegate void WriteMessageCallback(string text);

        private void WriteMessage(string message)
        {
            if (this.TxtConsole.InvokeRequired)
            {
                WriteMessageCallback d = new WriteMessageCallback(WriteMessage);
                this.Invoke(d, new object[] { message });
            }
            else
            {
                TxtConsole.AppendText(message + Environment.NewLine);
                Application.DoEvents();
            }
        }

        
    }

}
