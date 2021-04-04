namespace PVM7_6615
{
    partial class Form1
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
            this.wordText = new System.Windows.Forms.TextBox();
            this.addBtn = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.scoreLbl = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.timerLbl = new System.Windows.Forms.Label();
            this.worddDGV = new System.Windows.Forms.DataGridView();
            this.playBtn = new System.Windows.Forms.Button();
            this.gameDGV = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.worddDGV)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gameDGV)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(282, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Kata: ";
            // 
            // wordText
            // 
            this.wordText.Location = new System.Drawing.Point(323, 48);
            this.wordText.Name = "wordText";
            this.wordText.Size = new System.Drawing.Size(100, 20);
            this.wordText.TabIndex = 1;
            // 
            // addBtn
            // 
            this.addBtn.Location = new System.Drawing.Point(440, 46);
            this.addBtn.Name = "addBtn";
            this.addBtn.Size = new System.Drawing.Size(75, 23);
            this.addBtn.TabIndex = 2;
            this.addBtn.Text = "ADD";
            this.addBtn.UseVisualStyleBackColor = true;
            this.addBtn.Click += new System.EventHandler(this.addBtn_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(677, 18);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(57, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "SCORE: ";
            // 
            // scoreLbl
            // 
            this.scoreLbl.AutoSize = true;
            this.scoreLbl.Location = new System.Drawing.Point(724, 18);
            this.scoreLbl.Name = "scoreLbl";
            this.scoreLbl.Size = new System.Drawing.Size(0, 13);
            this.scoreLbl.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(756, 18);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(54, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "TIMER: ";
            // 
            // timerLbl
            // 
            this.timerLbl.AutoSize = true;
            this.timerLbl.Location = new System.Drawing.Point(803, 18);
            this.timerLbl.Name = "timerLbl";
            this.timerLbl.Size = new System.Drawing.Size(0, 13);
            this.timerLbl.TabIndex = 6;
            // 
            // worddDGV
            // 
            this.worddDGV.AllowUserToAddRows = false;
            this.worddDGV.AllowUserToDeleteRows = false;
            this.worddDGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.worddDGV.Location = new System.Drawing.Point(285, 94);
            this.worddDGV.Name = "worddDGV";
            this.worddDGV.ReadOnly = true;
            this.worddDGV.Size = new System.Drawing.Size(230, 150);
            this.worddDGV.TabIndex = 7;
            // 
            // playBtn
            // 
            this.playBtn.Location = new System.Drawing.Point(539, 94);
            this.playBtn.Name = "playBtn";
            this.playBtn.Size = new System.Drawing.Size(57, 150);
            this.playBtn.TabIndex = 8;
            this.playBtn.Text = "PLAY";
            this.playBtn.UseVisualStyleBackColor = true;
            this.playBtn.Click += new System.EventHandler(this.playBtn_Click);
            // 
            // gameDGV
            // 
            this.gameDGV.AllowUserToAddRows = false;
            this.gameDGV.AllowUserToDeleteRows = false;
            this.gameDGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gameDGV.Location = new System.Drawing.Point(12, 268);
            this.gameDGV.Name = "gameDGV";
            this.gameDGV.ReadOnly = true;
            this.gameDGV.Size = new System.Drawing.Size(807, 272);
            this.gameDGV.TabIndex = 9;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(831, 552);
            this.Controls.Add(this.gameDGV);
            this.Controls.Add(this.playBtn);
            this.Controls.Add(this.worddDGV);
            this.Controls.Add(this.timerLbl);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.scoreLbl);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.addBtn);
            this.Controls.Add(this.wordText);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.worddDGV)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gameDGV)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox wordText;
        private System.Windows.Forms.Button addBtn;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label scoreLbl;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label timerLbl;
        private System.Windows.Forms.DataGridView worddDGV;
        private System.Windows.Forms.Button playBtn;
        private System.Windows.Forms.DataGridView gameDGV;
    }
}

