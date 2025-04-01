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
    public partial class FrmProducerWorkQueues : Form
    {
        private int _countMessage = 0;
        private string _instanceName;

        public FrmProducerWorkQueues()
        {
            InitializeComponent();
        }

        public FrmProducerWorkQueues(int instance) : this()
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
                channel.QueueDeclare(queue: "task_queue",
                                 durable: true,
                                 exclusive: false,
                                 autoDelete: false,
                                 arguments: null);

                var properties = channel.CreateBasicProperties();
                properties.Persistent = true;

                for (int count = 0; count < 1000; count++) {
                    _countMessage++;

                    string message = "Message Work Queue Nr " + _countMessage;
                    var body = Encoding.UTF8.GetBytes(message);

                    channel.BasicPublish(exchange: "",
                                routingKey: "task_queue",
                                basicProperties: properties,
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
