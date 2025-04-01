namespace RabbitMQTestClients
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
            this.BtnConsumerHelloWorld = new System.Windows.Forms.Button();
            this.BtnConsumerWorkQueues = new System.Windows.Forms.Button();
            this.BtnConsumerPubSub = new System.Windows.Forms.Button();
            this.BtnConsumerRouting = new System.Windows.Forms.Button();
            this.BtnConsumerTopic = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // BtnConsumerHelloWorld
            // 
            this.BtnConsumerHelloWorld.Location = new System.Drawing.Point(21, 12);
            this.BtnConsumerHelloWorld.Name = "BtnConsumerHelloWorld";
            this.BtnConsumerHelloWorld.Size = new System.Drawing.Size(196, 23);
            this.BtnConsumerHelloWorld.TabIndex = 1;
            this.BtnConsumerHelloWorld.Text = "Consumer Hello World";
            this.BtnConsumerHelloWorld.UseVisualStyleBackColor = true;
            this.BtnConsumerHelloWorld.Click += new System.EventHandler(this.BtnConsumerHelloWorld_Click);
            // 
            // BtnConsumerWorkQueues
            // 
            this.BtnConsumerWorkQueues.Location = new System.Drawing.Point(21, 41);
            this.BtnConsumerWorkQueues.Name = "BtnConsumerWorkQueues";
            this.BtnConsumerWorkQueues.Size = new System.Drawing.Size(196, 23);
            this.BtnConsumerWorkQueues.TabIndex = 2;
            this.BtnConsumerWorkQueues.Text = "Consumer Work Queues";
            this.BtnConsumerWorkQueues.UseVisualStyleBackColor = true;
            this.BtnConsumerWorkQueues.Click += new System.EventHandler(this.BtnConsumerWorkQueues_Click);
            // 
            // BtnConsumerPubSub
            // 
            this.BtnConsumerPubSub.Location = new System.Drawing.Point(21, 70);
            this.BtnConsumerPubSub.Name = "BtnConsumerPubSub";
            this.BtnConsumerPubSub.Size = new System.Drawing.Size(196, 23);
            this.BtnConsumerPubSub.TabIndex = 3;
            this.BtnConsumerPubSub.Text = "Consumer Pub/Sub";
            this.BtnConsumerPubSub.UseVisualStyleBackColor = true;
            this.BtnConsumerPubSub.Click += new System.EventHandler(this.BtnConsumerPubSub_Click);
            // 
            // BtnConsumerRouting
            // 
            this.BtnConsumerRouting.Location = new System.Drawing.Point(21, 99);
            this.BtnConsumerRouting.Name = "BtnConsumerRouting";
            this.BtnConsumerRouting.Size = new System.Drawing.Size(196, 23);
            this.BtnConsumerRouting.TabIndex = 4;
            this.BtnConsumerRouting.Text = "Consumer Routing";
            this.BtnConsumerRouting.UseVisualStyleBackColor = true;
            this.BtnConsumerRouting.Click += new System.EventHandler(this.BtnConsumerRouting_Click);
            // 
            // BtnConsumerTopic
            // 
            this.BtnConsumerTopic.Location = new System.Drawing.Point(21, 128);
            this.BtnConsumerTopic.Name = "BtnConsumerTopic";
            this.BtnConsumerTopic.Size = new System.Drawing.Size(196, 23);
            this.BtnConsumerTopic.TabIndex = 5;
            this.BtnConsumerTopic.Text = "Consumer Topic";
            this.BtnConsumerTopic.UseVisualStyleBackColor = true;
            this.BtnConsumerTopic.Click += new System.EventHandler(this.BtnConsumerTopic_Click);
            // 
            // FrmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(231, 162);
            this.Controls.Add(this.BtnConsumerTopic);
            this.Controls.Add(this.BtnConsumerRouting);
            this.Controls.Add(this.BtnConsumerPubSub);
            this.Controls.Add(this.BtnConsumerWorkQueues);
            this.Controls.Add(this.BtnConsumerHelloWorld);
            this.Name = "FrmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "RabbitMQ Tester Consumers";
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button BtnConsumerHelloWorld;
        private System.Windows.Forms.Button BtnConsumerWorkQueues;
        private System.Windows.Forms.Button BtnConsumerPubSub;
        private System.Windows.Forms.Button BtnConsumerRouting;
        private System.Windows.Forms.Button BtnConsumerTopic;
    }
}

