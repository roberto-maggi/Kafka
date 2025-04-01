using RabbitMQ.Client;
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

namespace RabbitMQTest.Forms.HelloWorld
{
    public partial class FrmProducerHelloWorld : Form
    {
        private int _countMessage = 0;
        private string _instanceName;

        public FrmProducerHelloWorld()
        {
            InitializeComponent();
        }

        public FrmProducerHelloWorld(int instance) : this()
        {
            _instanceName = "Producer " + instance;
        }

        private void BtnSendMessages_Click(object sender, EventArgs e)
        {
            SendMessage();
        }

        private void SendMessage()
        {
            TxtConsole.Clear();

            var factory = new ConnectionFactory() { HostName = "localhost" };

            using (var connection = factory.CreateConnection(_instanceName))
            using (var channel = connection.CreateModel())
            {
                channel.ExchangeDeclare(exchange: "camel", type: ExchangeType.Direct, durable: true);


                channel.QueueDeclare(queue: "corso",
                                     durable: false,
                                     exclusive: false,
                                     autoDelete: false,
                                     arguments: null);

                for (int count = 0; count < 1000; count++) {
                    _countMessage++;

                    string message = "Message Hello World Nr " + _countMessage;
                    var body = Encoding.UTF8.GetBytes(message);

                    channel.BasicPublish(exchange: "camel",
                                         routingKey: "test",
                                         basicProperties: null,
                                         body: body);

                    

                    WriteMessage(String.Format("Sent {0}", message));
                    Application.DoEvents();
                }
            }


        }


        private void WriteMessage(string message)
        {
            TxtConsole.AppendText(message + Environment.NewLine);
        }

    }

}
