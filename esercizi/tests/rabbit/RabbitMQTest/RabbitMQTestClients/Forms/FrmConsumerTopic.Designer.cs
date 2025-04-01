namespace RabbitMQTestClients.Forms.HelloWorld
{
    partial class FrmConsumerTopic
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
            this.BtnStart = new System.Windows.Forms.Button();
            this.BtnStop = new System.Windows.Forms.Button();
            this.LblTag = new System.Windows.Forms.Label();
            this.LblInstanceName = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // TxtConsole
            // 
            this.TxtConsole.BackColor = System.Drawing.Color.Black;
            this.TxtConsole.ForeColor = System.Drawing.Color.Lime;
            this.TxtConsole.Location = new System.Drawing.Point(12, 100);
            this.TxtConsole.Multiline = true;
            this.TxtConsole.Name = "TxtConsole";
            this.TxtConsole.ReadOnly = true;
            this.TxtConsole.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.TxtConsole.Size = new System.Drawing.Size(586, 380);
            this.TxtConsole.TabIndex = 5;
            // 
            // BtnStart
            // 
            this.BtnStart.Location = new System.Drawing.Point(12, 12);
            this.BtnStart.Name = "BtnStart";
            this.BtnStart.Size = new System.Drawing.Size(118, 23);
            this.BtnStart.TabIndex = 4;
            this.BtnStart.Text = "Start Load Message";
            this.BtnStart.UseVisualStyleBackColor = true;
            this.BtnStart.Click += new System.EventHandler(this.BtnStart_Click);
            // 
            // BtnStop
            // 
            this.BtnStop.Enabled = false;
            this.BtnStop.Location = new System.Drawing.Point(136, 12);
            this.BtnStop.Name = "BtnStop";
            this.BtnStop.Size = new System.Drawing.Size(118, 23);
            this.BtnStop.TabIndex = 6;
            this.BtnStop.Text = "Stop Load Message";
            this.BtnStop.UseVisualStyleBackColor = true;
            this.BtnStop.Click += new System.EventHandler(this.BtnStop_Click);
            // 
            // LblTag
            // 
            this.LblTag.BackColor = System.Drawing.Color.Maroon;
            this.LblTag.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblTag.ForeColor = System.Drawing.Color.Red;
            this.LblTag.Location = new System.Drawing.Point(12, 74);
            this.LblTag.Name = "LblTag";
            this.LblTag.Size = new System.Drawing.Size(586, 23);
            this.LblTag.TabIndex = 7;
            this.LblTag.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // LblInstanceName
            // 
            this.LblInstanceName.BackColor = System.Drawing.Color.Maroon;
            this.LblInstanceName.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblInstanceName.ForeColor = System.Drawing.Color.Red;
            this.LblInstanceName.Location = new System.Drawing.Point(12, 46);
            this.LblInstanceName.Name = "LblInstanceName";
            this.LblInstanceName.Size = new System.Drawing.Size(586, 23);
            this.LblInstanceName.TabIndex = 8;
            this.LblInstanceName.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // FrmConsumerTopic
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(610, 492);
            this.Controls.Add(this.LblInstanceName);
            this.Controls.Add(this.LblTag);
            this.Controls.Add(this.BtnStop);
            this.Controls.Add(this.TxtConsole);
            this.Controls.Add(this.BtnStart);
            this.Name = "FrmConsumerTopic";
            this.Text = "Consumer Topic";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TxtConsole;
        private System.Windows.Forms.Button BtnStart;
        private System.Windows.Forms.Button BtnStop;
        private System.Windows.Forms.Label LblTag;
        private System.Windows.Forms.Label LblInstanceName;
    }
}