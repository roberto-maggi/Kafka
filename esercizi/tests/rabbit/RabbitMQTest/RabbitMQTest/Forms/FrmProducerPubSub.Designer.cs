namespace RabbitMQTest.Forms.HelloWorld
{
    partial class FrmProducerPubSub
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
            this.TxtConsole = new System.Windows.Forms.TextBox();
            this.BtnSendMessages = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // TxtConsole
            // 
            this.TxtConsole.BackColor = System.Drawing.Color.Black;
            this.TxtConsole.ForeColor = System.Drawing.Color.DodgerBlue;
            this.TxtConsole.Location = new System.Drawing.Point(12, 55);
            this.TxtConsole.Multiline = true;
            this.TxtConsole.Name = "TxtConsole";
            this.TxtConsole.ReadOnly = true;
            this.TxtConsole.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.TxtConsole.Size = new System.Drawing.Size(466, 366);
            this.TxtConsole.TabIndex = 3;
            // 
            // BtnSendMessages
            // 
            this.BtnSendMessages.Location = new System.Drawing.Point(12, 12);
            this.BtnSendMessages.Name = "BtnSendMessages";
            this.BtnSendMessages.Size = new System.Drawing.Size(118, 23);
            this.BtnSendMessages.TabIndex = 2;
            this.BtnSendMessages.Text = "Send Messages";
            this.BtnSendMessages.UseVisualStyleBackColor = true;
            this.BtnSendMessages.Click += new System.EventHandler(this.BtnSendMessages_Click);
            // 
            // FrmProducerPubSub
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(491, 438);
            this.Controls.Add(this.TxtConsole);
            this.Controls.Add(this.BtnSendMessages);
            this.Name = "FrmProducerPubSub";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Producer Pub/Sub";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TxtConsole;
        private System.Windows.Forms.Button BtnSendMessages;
    }
}