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
    public partial class FrmConsumerTopic : Form
    {
        private bool _loadActive = false;
        private string _instanceName;

        public FrmConsumerTopic()
        {
            InitializeComponent();
        }

        public FrmConsumerTopic(int instance) : this()
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
            string[] keyArr = new string[12] {
                "anonymous.info",
                "anonymous.warning",
                "anonymous.error",
                "pluto.paperino",
                "pluto.paperoga",
                "gastone.a1",
                "gastone.a2",
                "gastone.a3",
                "testbanale",
                "paperon.a1.c1",
                "paperon.a2.c",
                "paperon.a1.c2",
            };
            
            var key = "anonymous.*";


            var factory = new ConnectionFactory() { HostName = "localhost" };
            using (var connection = factory.CreateConnection(_instanceName))
            {
                using (var channel = connection.CreateModel())
                {
                    //factory.DispatchConsumersAsync = true;

                    var cancellationTokenSource = new CancellationTokenSource();
                    CancellationToken cancellationToken = cancellationTokenSource.Token;

                    channel.ExchangeDeclare(exchange: "topic_logs", type: "topic");
                    var queueName = channel.QueueDeclare().QueueName;
                    var bindingKey = key; // "anonymous.info";

                    channel.QueueBind(queue: queueName,
                                 exchange: "topic_logs",
                                 routingKey: bindingKey);

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
