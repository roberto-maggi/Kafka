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
    public partial class FrmProducerTopic : Form
    {
        private int _countMessage = 0;
        private string _instanceName;

        public FrmProducerTopic()
        {
            InitializeComponent();
        }

        public FrmProducerTopic(int instance) : this()
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

            var factory = new ConnectionFactory() { HostName = "localhost" };

            using (var connection = factory.CreateConnection(_instanceName))
            using (var channel = connection.CreateModel())
            {
                channel.ExchangeDeclare(
                    exchange: "topic_logs",
                    type: "topic"
                );

                //var routingKey = "anonymous.info";


                for (int count = 0; count < 1000; count++) {
                    _countMessage++;


                    int index = rnd.Next(0, 12);
                    var routingKey = keyArr[index];


                    string message = String.Format("Message Topic: {0} Nr {1}", routingKey, _countMessage);
                    var body = Encoding.UTF8.GetBytes(message);

                    channel.BasicPublish(
                        exchange: "topic_logs",
                        routingKey: routingKey,
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
