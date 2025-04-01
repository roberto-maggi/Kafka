using RabbitMQTest.Forms.HelloWorld;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RabbitMQTest
{
    // https://www.rabbitmq.com/getstarted.html


    public partial class FrmMain : Form
    {
        public FrmMain()
        {
            InitializeComponent();
        }

        private int _producerHelloWordInstance = 0;
        private void BtnProducerHelloWorld_Click(object sender, EventArgs e)
        {
            _producerHelloWordInstance++;
            var frm = new FrmProducerHelloWorld(_producerHelloWordInstance);
            frm.Show();
        }

        private int _producerWorkQueuesInstance = 0;
        private void BtnProducerWorkQueues_Click(object sender, EventArgs e)
        {
            _producerWorkQueuesInstance++;
            var frm = new FrmProducerWorkQueues(_producerWorkQueuesInstance);
            frm.Show();
        }

        private int _producerPubSubInstance = 0;
        private void BtnProducerPubSub_Click(object sender, EventArgs e)
        {
            _producerPubSubInstance++;
            var frm = new FrmProducerPubSub(_producerPubSubInstance);
            frm.Show();
        }

        private int _producerRoutingInstance = 0;
        private void BtnProducerRouting_Click(object sender, EventArgs e)
        {
            _producerRoutingInstance++;
            var frm = new FrmProducerRouting(_producerRoutingInstance);
            frm.Show();
        }

        private int _producerTopicInstance = 0;
        private void BtnProducerTopic_Click(object sender, EventArgs e)
        {
            _producerTopicInstance++;
            var frm = new FrmProducerTopic(_producerTopicInstance);
            frm.Show();
        }
    }
}
