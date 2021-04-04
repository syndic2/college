namespace PVM2_6615
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
            this.label2 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.summonRtb = new System.Windows.Forms.RichTextBox();
            this.summonButton = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.listRtb = new System.Windows.Forms.RichTextBox();
            this.listBox = new System.Windows.Forms.ComboBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.battleRtb = new System.Windows.Forms.RichTextBox();
            this.randomButton = new System.Windows.Forms.Button();
            this.battleBox = new System.Windows.Forms.ComboBox();
            this.manaLabel = new System.Windows.Forms.Label();
            this.scrollLabel = new System.Windows.Forms.Label();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.hpBar2 = new System.Windows.Forms.ProgressBar();
            this.expBar2 = new System.Windows.Forms.ProgressBar();
            this.hpBar1 = new System.Windows.Forms.ProgressBar();
            this.expBar1 = new System.Windows.Forms.ProgressBar();
            this.battleButton = new System.Windows.Forms.Button();
            this.defLabel2 = new System.Windows.Forms.Label();
            this.atkLabel2 = new System.Windows.Forms.Label();
            this.levelLabel2 = new System.Windows.Forms.Label();
            this.eleLabel2 = new System.Windows.Forms.Label();
            this.nameLabel2 = new System.Windows.Forms.Label();
            this.label20 = new System.Windows.Forms.Label();
            this.label21 = new System.Windows.Forms.Label();
            this.label22 = new System.Windows.Forms.Label();
            this.label23 = new System.Windows.Forms.Label();
            this.label24 = new System.Windows.Forms.Label();
            this.label25 = new System.Windows.Forms.Label();
            this.label26 = new System.Windows.Forms.Label();
            this.defLabel1 = new System.Windows.Forms.Label();
            this.atkLabel1 = new System.Windows.Forms.Label();
            this.levelLabel1 = new System.Windows.Forms.Label();
            this.eleLabel1 = new System.Windows.Forms.Label();
            this.nameLabel1 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.historyRtb = new System.Windows.Forms.RichTextBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(40, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Mana: ";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 48);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Scroll: ";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.summonRtb);
            this.groupBox1.Controls.Add(this.summonButton);
            this.groupBox1.Location = new System.Drawing.Point(117, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(132, 184);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Create Monster";
            // 
            // summonRtb
            // 
            this.summonRtb.Location = new System.Drawing.Point(6, 56);
            this.summonRtb.Name = "summonRtb";
            this.summonRtb.ReadOnly = true;
            this.summonRtb.Size = new System.Drawing.Size(120, 122);
            this.summonRtb.TabIndex = 1;
            this.summonRtb.Text = "";
            // 
            // summonButton
            // 
            this.summonButton.Location = new System.Drawing.Point(32, 19);
            this.summonButton.Name = "summonButton";
            this.summonButton.Size = new System.Drawing.Size(75, 23);
            this.summonButton.TabIndex = 0;
            this.summonButton.Text = "Summon";
            this.summonButton.UseVisualStyleBackColor = true;
            this.summonButton.Click += new System.EventHandler(this.summonButton_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.listRtb);
            this.groupBox2.Controls.Add(this.listBox);
            this.groupBox2.Location = new System.Drawing.Point(267, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(147, 184);
            this.groupBox2.TabIndex = 3;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "List Monster";
            // 
            // listRtb
            // 
            this.listRtb.Location = new System.Drawing.Point(7, 56);
            this.listRtb.Name = "listRtb";
            this.listRtb.ReadOnly = true;
            this.listRtb.Size = new System.Drawing.Size(134, 122);
            this.listRtb.TabIndex = 4;
            this.listRtb.Text = "";
            // 
            // listBox
            // 
            this.listBox.FormattingEnabled = true;
            this.listBox.Location = new System.Drawing.Point(7, 19);
            this.listBox.Name = "listBox";
            this.listBox.Size = new System.Drawing.Size(121, 21);
            this.listBox.TabIndex = 0;
            this.listBox.SelectedIndexChanged += new System.EventHandler(this.listBox_SelectedIndexChanged);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.battleRtb);
            this.groupBox3.Controls.Add(this.randomButton);
            this.groupBox3.Controls.Add(this.battleBox);
            this.groupBox3.Location = new System.Drawing.Point(437, 13);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(149, 183);
            this.groupBox3.TabIndex = 4;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Battle";
            // 
            // battleRtb
            // 
            this.battleRtb.Location = new System.Drawing.Point(7, 75);
            this.battleRtb.Name = "battleRtb";
            this.battleRtb.ReadOnly = true;
            this.battleRtb.Size = new System.Drawing.Size(136, 102);
            this.battleRtb.TabIndex = 6;
            this.battleRtb.Text = "";
            // 
            // randomButton
            // 
            this.randomButton.Location = new System.Drawing.Point(6, 45);
            this.randomButton.Name = "randomButton";
            this.randomButton.Size = new System.Drawing.Size(137, 23);
            this.randomButton.TabIndex = 5;
            this.randomButton.Text = "Random Monster";
            this.randomButton.UseVisualStyleBackColor = true;
            this.randomButton.Click += new System.EventHandler(this.randomButton_Click);
            // 
            // battleBox
            // 
            this.battleBox.FormattingEnabled = true;
            this.battleBox.Location = new System.Drawing.Point(6, 18);
            this.battleBox.Name = "battleBox";
            this.battleBox.Size = new System.Drawing.Size(126, 21);
            this.battleBox.TabIndex = 5;
            // 
            // manaLabel
            // 
            this.manaLabel.AutoSize = true;
            this.manaLabel.Location = new System.Drawing.Point(60, 13);
            this.manaLabel.Name = "manaLabel";
            this.manaLabel.Size = new System.Drawing.Size(0, 13);
            this.manaLabel.TabIndex = 5;
            // 
            // scrollLabel
            // 
            this.scrollLabel.AutoSize = true;
            this.scrollLabel.Location = new System.Drawing.Point(60, 48);
            this.scrollLabel.Name = "scrollLabel";
            this.scrollLabel.Size = new System.Drawing.Size(0, 13);
            this.scrollLabel.TabIndex = 6;
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.hpBar2);
            this.groupBox4.Controls.Add(this.expBar2);
            this.groupBox4.Controls.Add(this.hpBar1);
            this.groupBox4.Controls.Add(this.expBar1);
            this.groupBox4.Controls.Add(this.battleButton);
            this.groupBox4.Controls.Add(this.defLabel2);
            this.groupBox4.Controls.Add(this.atkLabel2);
            this.groupBox4.Controls.Add(this.levelLabel2);
            this.groupBox4.Controls.Add(this.eleLabel2);
            this.groupBox4.Controls.Add(this.nameLabel2);
            this.groupBox4.Controls.Add(this.label20);
            this.groupBox4.Controls.Add(this.label21);
            this.groupBox4.Controls.Add(this.label22);
            this.groupBox4.Controls.Add(this.label23);
            this.groupBox4.Controls.Add(this.label24);
            this.groupBox4.Controls.Add(this.label25);
            this.groupBox4.Controls.Add(this.label26);
            this.groupBox4.Controls.Add(this.defLabel1);
            this.groupBox4.Controls.Add(this.atkLabel1);
            this.groupBox4.Controls.Add(this.levelLabel1);
            this.groupBox4.Controls.Add(this.eleLabel1);
            this.groupBox4.Controls.Add(this.nameLabel1);
            this.groupBox4.Controls.Add(this.label9);
            this.groupBox4.Controls.Add(this.label8);
            this.groupBox4.Controls.Add(this.label7);
            this.groupBox4.Controls.Add(this.label6);
            this.groupBox4.Controls.Add(this.label5);
            this.groupBox4.Controls.Add(this.label4);
            this.groupBox4.Controls.Add(this.label3);
            this.groupBox4.Location = new System.Drawing.Point(16, 211);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(570, 227);
            this.groupBox4.TabIndex = 7;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Battle";
            // 
            // hpBar2
            // 
            this.hpBar2.Location = new System.Drawing.Point(459, 139);
            this.hpBar2.Name = "hpBar2";
            this.hpBar2.Size = new System.Drawing.Size(100, 15);
            this.hpBar2.TabIndex = 28;
            // 
            // expBar2
            // 
            this.expBar2.Location = new System.Drawing.Point(458, 109);
            this.expBar2.Name = "expBar2";
            this.expBar2.Size = new System.Drawing.Size(100, 13);
            this.expBar2.TabIndex = 27;
            // 
            // hpBar1
            // 
            this.hpBar1.Location = new System.Drawing.Point(68, 139);
            this.hpBar1.Name = "hpBar1";
            this.hpBar1.Size = new System.Drawing.Size(109, 15);
            this.hpBar1.TabIndex = 26;
            // 
            // expBar1
            // 
            this.expBar1.Location = new System.Drawing.Point(68, 109);
            this.expBar1.Name = "expBar1";
            this.expBar1.Size = new System.Drawing.Size(109, 13);
            this.expBar1.TabIndex = 25;
            // 
            // battleButton
            // 
            this.battleButton.Location = new System.Drawing.Point(240, 19);
            this.battleButton.Name = "battleButton";
            this.battleButton.Size = new System.Drawing.Size(95, 191);
            this.battleButton.TabIndex = 24;
            this.battleButton.Text = "Battle";
            this.battleButton.UseVisualStyleBackColor = true;
            this.battleButton.Click += new System.EventHandler(this.battleButton_Click);
            // 
            // defLabel2
            // 
            this.defLabel2.AutoSize = true;
            this.defLabel2.Location = new System.Drawing.Point(455, 198);
            this.defLabel2.Name = "defLabel2";
            this.defLabel2.Size = new System.Drawing.Size(0, 13);
            this.defLabel2.TabIndex = 23;
            // 
            // atkLabel2
            // 
            this.atkLabel2.AutoSize = true;
            this.atkLabel2.Location = new System.Drawing.Point(455, 168);
            this.atkLabel2.Name = "atkLabel2";
            this.atkLabel2.Size = new System.Drawing.Size(0, 13);
            this.atkLabel2.TabIndex = 22;
            // 
            // levelLabel2
            // 
            this.levelLabel2.AutoSize = true;
            this.levelLabel2.Location = new System.Drawing.Point(455, 81);
            this.levelLabel2.Name = "levelLabel2";
            this.levelLabel2.Size = new System.Drawing.Size(0, 13);
            this.levelLabel2.TabIndex = 21;
            // 
            // eleLabel2
            // 
            this.eleLabel2.AutoSize = true;
            this.eleLabel2.Location = new System.Drawing.Point(455, 50);
            this.eleLabel2.Name = "eleLabel2";
            this.eleLabel2.Size = new System.Drawing.Size(0, 13);
            this.eleLabel2.TabIndex = 20;
            // 
            // nameLabel2
            // 
            this.nameLabel2.AutoSize = true;
            this.nameLabel2.Location = new System.Drawing.Point(455, 20);
            this.nameLabel2.Name = "nameLabel2";
            this.nameLabel2.Size = new System.Drawing.Size(0, 13);
            this.nameLabel2.TabIndex = 19;
            // 
            // label20
            // 
            this.label20.AutoSize = true;
            this.label20.Location = new System.Drawing.Point(396, 198);
            this.label20.Name = "label20";
            this.label20.Size = new System.Drawing.Size(34, 13);
            this.label20.TabIndex = 18;
            this.label20.Text = "DEF: ";
            // 
            // label21
            // 
            this.label21.AutoSize = true;
            this.label21.Location = new System.Drawing.Point(396, 168);
            this.label21.Name = "label21";
            this.label21.Size = new System.Drawing.Size(34, 13);
            this.label21.TabIndex = 17;
            this.label21.Text = "ATK: ";
            // 
            // label22
            // 
            this.label22.AutoSize = true;
            this.label22.Location = new System.Drawing.Point(396, 139);
            this.label22.Name = "label22";
            this.label22.Size = new System.Drawing.Size(28, 13);
            this.label22.TabIndex = 16;
            this.label22.Text = "HP: ";
            // 
            // label23
            // 
            this.label23.AutoSize = true;
            this.label23.Location = new System.Drawing.Point(396, 109);
            this.label23.Name = "label23";
            this.label23.Size = new System.Drawing.Size(34, 13);
            this.label23.TabIndex = 15;
            this.label23.Text = "EXP: ";
            // 
            // label24
            // 
            this.label24.AutoSize = true;
            this.label24.Location = new System.Drawing.Point(396, 81);
            this.label24.Name = "label24";
            this.label24.Size = new System.Drawing.Size(39, 13);
            this.label24.TabIndex = 14;
            this.label24.Text = "Level: ";
            // 
            // label25
            // 
            this.label25.AutoSize = true;
            this.label25.Location = new System.Drawing.Point(396, 50);
            this.label25.Name = "label25";
            this.label25.Size = new System.Drawing.Size(45, 13);
            this.label25.TabIndex = 13;
            this.label25.Text = "Element";
            // 
            // label26
            // 
            this.label26.AutoSize = true;
            this.label26.Location = new System.Drawing.Point(397, 20);
            this.label26.Name = "label26";
            this.label26.Size = new System.Drawing.Size(41, 13);
            this.label26.TabIndex = 12;
            this.label26.Text = "Name: ";
            // 
            // defLabel1
            // 
            this.defLabel1.AutoSize = true;
            this.defLabel1.Location = new System.Drawing.Point(65, 198);
            this.defLabel1.Name = "defLabel1";
            this.defLabel1.Size = new System.Drawing.Size(0, 13);
            this.defLabel1.TabIndex = 11;
            // 
            // atkLabel1
            // 
            this.atkLabel1.AutoSize = true;
            this.atkLabel1.Location = new System.Drawing.Point(65, 168);
            this.atkLabel1.Name = "atkLabel1";
            this.atkLabel1.Size = new System.Drawing.Size(0, 13);
            this.atkLabel1.TabIndex = 10;
            // 
            // levelLabel1
            // 
            this.levelLabel1.AutoSize = true;
            this.levelLabel1.Location = new System.Drawing.Point(65, 81);
            this.levelLabel1.Name = "levelLabel1";
            this.levelLabel1.Size = new System.Drawing.Size(0, 13);
            this.levelLabel1.TabIndex = 9;
            // 
            // eleLabel1
            // 
            this.eleLabel1.AutoSize = true;
            this.eleLabel1.Location = new System.Drawing.Point(65, 50);
            this.eleLabel1.Name = "eleLabel1";
            this.eleLabel1.Size = new System.Drawing.Size(0, 13);
            this.eleLabel1.TabIndex = 8;
            // 
            // nameLabel1
            // 
            this.nameLabel1.AutoSize = true;
            this.nameLabel1.Location = new System.Drawing.Point(65, 20);
            this.nameLabel1.Name = "nameLabel1";
            this.nameLabel1.Size = new System.Drawing.Size(0, 13);
            this.nameLabel1.TabIndex = 7;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(6, 198);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(34, 13);
            this.label9.TabIndex = 6;
            this.label9.Text = "DEF: ";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(6, 168);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(34, 13);
            this.label8.TabIndex = 5;
            this.label8.Text = "ATK: ";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(6, 139);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(28, 13);
            this.label7.TabIndex = 4;
            this.label7.Text = "HP: ";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(6, 109);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(34, 13);
            this.label6.TabIndex = 3;
            this.label6.Text = "EXP: ";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 81);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(39, 13);
            this.label5.TabIndex = 2;
            this.label5.Text = "Level: ";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 50);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(51, 13);
            this.label4.TabIndex = 1;
            this.label4.Text = "Element: ";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(7, 20);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 13);
            this.label3.TabIndex = 0;
            this.label3.Text = "Name: ";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.historyRtb);
            this.groupBox5.Location = new System.Drawing.Point(16, 447);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(570, 119);
            this.groupBox5.TabIndex = 8;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "History";
            // 
            // historyRtb
            // 
            this.historyRtb.Location = new System.Drawing.Point(6, 19);
            this.historyRtb.Name = "historyRtb";
            this.historyRtb.Size = new System.Drawing.Size(558, 94);
            this.historyRtb.TabIndex = 0;
            this.historyRtb.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(603, 576);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.scrollLabel);
            this.Controls.Add(this.manaLabel);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Sumonner Sims";
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button summonButton;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ComboBox listBox;
        private System.Windows.Forms.RichTextBox summonRtb;
        private System.Windows.Forms.RichTextBox listRtb;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.ComboBox battleBox;
        private System.Windows.Forms.Button randomButton;
        private System.Windows.Forms.RichTextBox battleRtb;
        private System.Windows.Forms.Label manaLabel;
        private System.Windows.Forms.Label scrollLabel;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label nameLabel1;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label levelLabel1;
        private System.Windows.Forms.Label eleLabel1;
        private System.Windows.Forms.Label defLabel1;
        private System.Windows.Forms.Label atkLabel1;
        private System.Windows.Forms.Label defLabel2;
        private System.Windows.Forms.Label atkLabel2;
        private System.Windows.Forms.Label levelLabel2;
        private System.Windows.Forms.Label eleLabel2;
        private System.Windows.Forms.Label nameLabel2;
        private System.Windows.Forms.Label label20;
        private System.Windows.Forms.Label label21;
        private System.Windows.Forms.Label label22;
        private System.Windows.Forms.Label label23;
        private System.Windows.Forms.Label label24;
        private System.Windows.Forms.Label label25;
        private System.Windows.Forms.Label label26;
        private System.Windows.Forms.Button battleButton;
        private System.Windows.Forms.ProgressBar hpBar1;
        private System.Windows.Forms.ProgressBar expBar1;
        private System.Windows.Forms.ProgressBar hpBar2;
        private System.Windows.Forms.ProgressBar expBar2;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.RichTextBox historyRtb;
    }
}

