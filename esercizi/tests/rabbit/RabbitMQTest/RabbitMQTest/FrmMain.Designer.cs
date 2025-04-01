namespace RabbitMQTest
{
    partial class FrmMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.BtnProducerHelloWorld = new System.Windows.Forms.Button();
            this.BtnProducerWorkQueues = new System.Windows.Forms.Button();
            this.BtnProducerPubSub = new System.Windows.Forms.Button();
            this.BtnProducerRouting = new System.Windows.Forms.Button();
            this.BtnProducerTopic = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // BtnProducerHelloWorld
            // 
            this.BtnProducerHelloWorld.Location = new System.Drawing.Point(12, 12);
            this.BtnProducerHelloWorld.Name = "BtnProducerHelloWorld";
            this.BtnProducerHelloWorld.Size = new System.Drawing.Size(196, 23);
            this.BtnProducerHelloWorld.TabIndex = 0;
            this.BtnProducerHelloWorld.Text = "Producer Hello World";
            this.BtnProducerHelloWorld.UseVisualStyleBackColor = true;
            this.BtnProducerHelloWorld.Click += new System.EventHandler(this.BtnProducerHelloWorld_Click);
            // 
            // BtnProducerWorkQueues
            // 
            this.BtnProducerWorkQueues.Location = new System.Drawing.Point(12, 41);
            this.BtnProducerWorkQueues.Name = "BtnProducerWorkQueues";
            this.BtnProducerWorkQueues.Size = new System.Drawing.Size(196, 23);
            this.BtnProducerWorkQueues.TabIndex = 1;
            this.BtnProducerWorkQueues.Text = "Producer Work Queues";
            this.BtnProducerWorkQueues.UseVisualStyleBackColor = true;
            this.BtnProducerWorkQueues.Click += new System.EventHandler(this.BtnProducerWorkQueues_Click);
            // 
            // BtnProducerPubSub
            // 
            this.BtnProducerPubSub.Location = new System.Drawing.Point(12, 70);
            this.BtnProducerPubSub.Name = "BtnProducerPubSub";
            this.BtnProducerPubSub.Size = new System.Drawing.Size(196, 23);
            this.BtnProducerPubSub.TabIndex = 2;
            this.BtnProducerPubSub.Text = "Producer Pub/Sub";
            this.BtnProducerPubSub.UseVisualStyleBackColor = true;
            this.BtnProducerPubSub.Click += new System.EventHandler(this.BtnProducerPubSub_Click);
            // 
            // BtnProducerRouting
            // 
            this.BtnProducerRouting.Location = new System.Drawing.Point(12, 99);
            this.BtnProducerRouting.Name = "BtnProducerRouting";
            this.BtnProducerRouting.Size = new System.Drawing.Size(196, 23);
            this.BtnProducerRouting.TabIndex = 3;
            this.BtnProducerRouting.Text = "Producer Routing";
            this.BtnProducerRouting.UseVisualStyleBackColor = true;
            this.BtnProducerRouting.Click += new System.EventHandler(this.BtnProducerRouting_Click);
            // 
            // BtnProducerTopic
            // 
            this.BtnProducerTopic.Location = new System.Drawing.Point(12, 128);
            this.BtnProducerTopic.Name = "BtnProducerTopic";
            this.BtnProducerTopic.Size = new System.Drawing.Size(196, 23);
            this.BtnProducerTopic.TabIndex = 4;
            this.BtnProducerTopic.Text = "Producer Topic";
            this.BtnProducerTopic.UseVisualStyleBackColor = true;
            this.BtnProducerTopic.Click += new System.EventHandler(this.BtnProducerTopic_Click);
            // 
            // FrmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(224, 168);
            this.Controls.Add(this.BtnProducerTopic);
            this.Controls.Add(this.BtnProducerRouting);
            this.Controls.Add(this.BtnProducerPubSub);
            this.Controls.Add(this.BtnProducerWorkQueues);
            this.Controls.Add(this.BtnProducerHelloWorld);
            this.Name = "FrmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "RabbitMQ Tester Producers";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BtnProducerHelloWorld;
        private System.Windows.Forms.Button BtnProducerWorkQueues;
        private System.Windows.Forms.Button BtnProducerPubSub;
        private System.Windows.Forms.Button BtnProducerRouting;
        private System.Windows.Forms.Button BtnProducerTopic;
    }
}

