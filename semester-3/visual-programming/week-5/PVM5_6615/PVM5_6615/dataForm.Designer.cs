namespace PVM5_6615
{
    partial class dataForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.nameText1 = new System.Windows.Forms.TextBox();
            this.nameText2 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.playButton = new System.Windows.Forms.Button();
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            this.colorDialog2 = new System.Windows.Forms.ColorDialog();
            this.color1Button = new System.Windows.Forms.Button();
            this.color2Button = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Player 1:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 61);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(51, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Player 2: ";
            // 
            // nameText1
            // 
            this.nameText1.Location = new System.Drawing.Point(68, 13);
            this.nameText1.Name = "nameText1";
            this.nameText1.Size = new System.Drawing.Size(100, 20);
            this.nameText1.TabIndex = 2;
            // 
            // nameText2
            // 
            this.nameText2.Location = new System.Drawing.Point(68, 58);
            this.nameText2.Name = "nameText2";
            this.nameText2.Size = new System.Drawing.Size(100, 20);
            this.nameText2.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 108);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(46, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Color 1: ";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(13, 149);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 5;
            this.label4.Text = "Color 2: ";
            // 
            // playButton
            // 
            this.playButton.Location = new System.Drawing.Point(93, 211);
            this.playButton.Name = "playButton";
            this.playButton.Size = new System.Drawing.Size(103, 23);
            this.playButton.TabIndex = 8;
            this.playButton.Text = "Play !";
            this.playButton.UseVisualStyleBackColor = true;
            this.playButton.Click += new System.EventHandler(this.playButton_Click);
            // 
            // color1Button
            // 
            this.color1Button.Location = new System.Drawing.Point(68, 103);
            this.color1Button.Name = "color1Button";
            this.color1Button.Size = new System.Drawing.Size(75, 23);
            this.color1Button.TabIndex = 9;
            this.color1Button.Text = "Choose";
            this.color1Button.UseVisualStyleBackColor = true;
            this.color1Button.Click += new System.EventHandler(this.color1Button_Click);
            // 
            // color2Button
            // 
            this.color2Button.Location = new System.Drawing.Point(68, 144);
            this.color2Button.Name = "color2Button";
            this.color2Button.Size = new System.Drawing.Size(75, 23);
            this.color2Button.TabIndex = 10;
            this.color2Button.Text = "Choose";
            this.color2Button.UseVisualStyleBackColor = true;
            this.color2Button.Click += new System.EventHandler(this.color2Button_Click);
            // 
            // dataForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.color2Button);
            this.Controls.Add(this.color1Button);
            this.Controls.Add(this.playButton);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.nameText2);
            this.Controls.Add(this.nameText1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "dataForm";
            this.Text = "formData";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox nameText1;
        private System.Windows.Forms.TextBox nameText2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button playButton;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.ColorDialog colorDialog2;
        private System.Windows.Forms.Button color1Button;
        private System.Windows.Forms.Button color2Button;
    }
}