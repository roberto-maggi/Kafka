using RabbitMQTestClients.Forms.HelloWorld;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RabbitMQTestClients
{
    // https://www.rabbitmq.com/getstarted.html


    public partial class FrmMain : Form
    {
        public FrmMain()
        {
            InitializeComponent();
        }

        

        private int _consumerHelloWordInstance = 0;
        private void BtnConsumerHelloWorld_Click(object sender, EventArgs e)
        {
            _consumerHelloWordInstance++;
            var frm = new FrmConsumerHelloWorld(_consumerHelloWordInstance);
            frm.Show();
        }

        private int _consumerHelloWorkQueuesInstance = 0;
        private void BtnConsumerWorkQueues_Click(object sender, EventArgs e)
        {
            _consumerHelloWorkQueuesInstance++;
            var frm = new FrmConsumerWorkQueues(_consumerHelloWorkQueuesInstance);
            frm.Show();
        }

        private int _consumerPubSubInstance = 0;
        private void BtnConsumerPubSub_Click(object sender, EventArgs e)
        {
            _consumerPubSubInstance++;
            var frm = new FrmConsumerPubSub(_consumerPubSubInstance);
            frm.Show();
        }

        private int _consumerRoutingInstance = 0;
        private void BtnConsumerRouting_Click(object sender, EventArgs e)
        {
            _consumerRoutingInstance++;
            var frm = new FrmConsumerRouting(_consumerRoutingInstance);
            frm.Show();
        }

        private int _consumerTopicInstance = 0;
        private void BtnConsumerTopic_Click(object sender, EventArgs e)
        {
            _consumerTopicInstance++;
            var frm = new FrmConsumerTopic(_consumerTopicInstance);
            frm.Show();
        }
    }
}
