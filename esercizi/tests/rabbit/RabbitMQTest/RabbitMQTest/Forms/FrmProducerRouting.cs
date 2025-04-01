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
    public partial class FrmProducerRouting : Form
    {
        private int _countMessage = 0;
        private string _instanceName;

        public FrmProducerRouting()
        {
            InitializeComponent();
        }

        public FrmProducerRouting(int instance) : this()
        {
            _instanceName = "Producer " + instance;
        }

        private void BtnSendMessages_Click(object sender, EventArgs e)
        {
            SendMessage();
        }

        private void SendMessage()
        {
            Random rnd = new Random();

            TxtConsole.Clear();
            string[] severityArr = new string[3] { "info", "warning", "error" };


            var factory = new ConnectionFactory() { HostName = "localhost" };

            using (var connection = factory.CreateConnection(_instanceName))
            using (var channel = connection.CreateModel())
            {
                channel.ExchangeDeclare(
                    exchange: "direct_logs",
                    type: "direct"
                );          

                

                for (int count = 0; count < 1000; count++) {
                    _countMessage++;
                   
                    int index = rnd.Next(0, 3);
                    var severity = severityArr[index];

                    string message = String.Format("Message Routing {0} Nr {1}", severity, _countMessage);
                    var body = Encoding.UTF8.GetBytes(message);

                    channel.BasicPublish(
                        exchange: "direct_logs",
                        routingKey: severity,
                        basicProperties: null,
                        body: body
                    );



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
