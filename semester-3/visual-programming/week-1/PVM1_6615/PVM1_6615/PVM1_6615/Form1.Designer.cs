namespace PVM1_6615
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.buyButton = new System.Windows.Forms.Button();
            this.typeBox = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.newName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.sellButton = new System.Windows.Forms.Button();
            this.sellBox = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.moneyLabel = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.totalLabel = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.label14 = new System.Windows.Forms.Label();
            this.breedBox2 = new System.Windows.Forms.ComboBox();
            this.breedButton = new System.Windows.Forms.Button();
            this.breedBox1 = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.breedName = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.detailBox = new System.Windows.Forms.ComboBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.explabel = new System.Windows.Forms.Label();
            this.levelLabel = new System.Windows.Forms.Label();
            this.hpLabel = new System.Windows.Forms.Label();
            this.atkLabel = new System.Windows.Forms.Label();
            this.parentLabel = new System.Windows.Forms.Label();
            this.typeLabel = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.battleList = new System.Windows.Forms.ListBox();
            this.battleButton = new System.Windows.Forms.Button();
            this.battleBox = new System.Windows.Forms.ComboBox();
            this.label16 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.buyButton);
            this.groupBox1.Controls.Add(this.typeBox);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.newName);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(13, 13);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(199, 165);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Buy";
            // 
            // buyButton
            // 
            this.buyButton.Location = new System.Drawing.Point(69, 126);
            this.buyButton.Name = "buyButton";
            this.buyButton.Size = new System.Drawing.Size(75, 23);
            this.buyButton.TabIndex = 4;
            this.buyButton.Text = "Buy";
            this.buyButton.UseVisualStyleBackColor = true;
            this.buyButton.Click += new System.EventHandler(this.buyButton_Click);
            // 
            // typeBox
            // 
            this.typeBox.FormattingEnabled = true;
            this.typeBox.Items.AddRange(new object[] {
            "Water",
            "Fire",
            "Wind"});
            this.typeBox.Location = new System.Drawing.Point(69, 57);
            this.typeBox.Name = "typeBox";
            this.typeBox.Size = new System.Drawing.Size(118, 21);
            this.typeBox.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Type: ";
            // 
            // newName
            // 
            this.newName.Location = new System.Drawing.Point(69, 19);
            this.newName.Name = "newName";
            this.newName.Size = new System.Drawing.Size(118, 20);
            this.newName.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 23);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Name";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.sellButton);
            this.groupBox2.Controls.Add(this.sellBox);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Location = new System.Drawing.Point(252, 13);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(199, 165);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Sell";
            // 
            // sellButton
            // 
            this.sellButton.Location = new System.Drawing.Point(69, 126);
            this.sellButton.Name = "sellButton";
            this.sellButton.Size = new System.Drawing.Size(75, 23);
            this.sellButton.TabIndex = 4;
            this.sellButton.Text = "Sell";
            this.sellButton.UseVisualStyleBackColor = true;
            this.sellButton.Click += new System.EventHandler(this.sellButton_Click);
            // 
            // sellBox
            // 
            this.sellBox.FormattingEnabled = true;
            this.sellBox.Location = new System.Drawing.Point(69, 23);
            this.sellBox.Name = "sellBox";
            this.sellBox.Size = new System.Drawing.Size(118, 21);
            this.sellBox.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 27);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(35, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Name";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(488, 13);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(45, 13);
            this.label4.TabIndex = 2;
            this.label4.Text = "Money: ";
            // 
            // moneyLabel
            // 
            this.moneyLabel.Location = new System.Drawing.Point(591, 13);
            this.moneyLabel.Name = "moneyLabel";
            this.moneyLabel.Size = new System.Drawing.Size(45, 13);
            this.moneyLabel.TabIndex = 3;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(488, 48);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(83, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "No. of Monster: ";
            // 
            // totalLabel
            // 
            this.totalLabel.Location = new System.Drawing.Point(591, 48);
            this.totalLabel.Name = "totalLabel";
            this.totalLabel.Size = new System.Drawing.Size(45, 13);
            this.totalLabel.TabIndex = 5;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label14);
            this.groupBox3.Controls.Add(this.breedBox2);
            this.groupBox3.Controls.Add(this.breedButton);
            this.groupBox3.Controls.Add(this.breedBox1);
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.breedName);
            this.groupBox3.Controls.Add(this.label7);
            this.groupBox3.Location = new System.Drawing.Point(71, 194);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(325, 220);
            this.groupBox3.TabIndex = 6;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Breeding";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(20, 129);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(41, 13);
            this.label14.TabIndex = 6;
            this.label14.Text = "Name: ";
            // 
            // breedBox2
            // 
            this.breedBox2.FormattingEnabled = true;
            this.breedBox2.Location = new System.Drawing.Point(190, 62);
            this.breedBox2.Name = "breedBox2";
            this.breedBox2.Size = new System.Drawing.Size(118, 21);
            this.breedBox2.TabIndex = 5;
            // 
            // breedButton
            // 
            this.breedButton.Location = new System.Drawing.Point(119, 174);
            this.breedButton.Name = "breedButton";
            this.breedButton.Size = new System.Drawing.Size(75, 23);
            this.breedButton.TabIndex = 4;
            this.breedButton.Text = "Breed";
            this.breedButton.UseVisualStyleBackColor = true;
            this.breedButton.Click += new System.EventHandler(this.breedButton_Click);
            // 
            // breedBox1
            // 
            this.breedBox1.FormattingEnabled = true;
            this.breedBox1.Location = new System.Drawing.Point(23, 62);
            this.breedBox1.Name = "breedBox1";
            this.breedBox1.Size = new System.Drawing.Size(118, 21);
            this.breedBox1.TabIndex = 3;
            this.breedBox1.SelectedIndexChanged += new System.EventHandler(this.breedBox1_SelectedIndexChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(54, 30);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(54, 13);
            this.label6.TabIndex = 2;
            this.label6.Text = "Monster 1";
            // 
            // breedName
            // 
            this.breedName.Location = new System.Drawing.Point(86, 126);
            this.breedName.Name = "breedName";
            this.breedName.Size = new System.Drawing.Size(166, 20);
            this.breedName.TabIndex = 1;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(225, 30);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(54, 13);
            this.label7.TabIndex = 0;
            this.label7.Text = "Monster 2";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(7, 22);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(35, 13);
            this.label9.TabIndex = 0;
            this.label9.Text = "Name";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(6, 51);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(37, 13);
            this.label8.TabIndex = 2;
            this.label8.Text = "Type: ";
            // 
            // detailBox
            // 
            this.detailBox.FormattingEnabled = true;
            this.detailBox.Location = new System.Drawing.Point(69, 19);
            this.detailBox.Name = "detailBox";
            this.detailBox.Size = new System.Drawing.Size(118, 21);
            this.detailBox.TabIndex = 3;
            this.detailBox.SelectedIndexChanged += new System.EventHandler(this.detailBox_SelectedIndexChanged);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.explabel);
            this.groupBox4.Controls.Add(this.levelLabel);
            this.groupBox4.Controls.Add(this.hpLabel);
            this.groupBox4.Controls.Add(this.atkLabel);
            this.groupBox4.Controls.Add(this.parentLabel);
            this.groupBox4.Controls.Add(this.typeLabel);
            this.groupBox4.Controls.Add(this.label15);
            this.groupBox4.Controls.Add(this.label13);
            this.groupBox4.Controls.Add(this.label12);
            this.groupBox4.Controls.Add(this.label11);
            this.groupBox4.Controls.Add(this.label10);
            this.groupBox4.Controls.Add(this.detailBox);
            this.groupBox4.Controls.Add(this.label8);
            this.groupBox4.Controls.Add(this.label9);
            this.groupBox4.Location = new System.Drawing.Point(428, 194);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(199, 235);
            this.groupBox4.TabIndex = 7;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Detail";
            // 
            // explabel
            // 
            this.explabel.AutoSize = true;
            this.explabel.Location = new System.Drawing.Point(66, 204);
            this.explabel.Name = "explabel";
            this.explabel.Size = new System.Drawing.Size(0, 13);
            this.explabel.TabIndex = 14;
            // 
            // levelLabel
            // 
            this.levelLabel.AutoSize = true;
            this.levelLabel.Location = new System.Drawing.Point(66, 174);
            this.levelLabel.Name = "levelLabel";
            this.levelLabel.Size = new System.Drawing.Size(0, 13);
            this.levelLabel.TabIndex = 13;
            // 
            // hpLabel
            // 
            this.hpLabel.AutoSize = true;
            this.hpLabel.Location = new System.Drawing.Point(66, 144);
            this.hpLabel.Name = "hpLabel";
            this.hpLabel.Size = new System.Drawing.Size(0, 13);
            this.hpLabel.TabIndex = 12;
            // 
            // atkLabel
            // 
            this.atkLabel.AutoSize = true;
            this.atkLabel.Location = new System.Drawing.Point(66, 114);
            this.atkLabel.Name = "atkLabel";
            this.atkLabel.Size = new System.Drawing.Size(0, 13);
            this.atkLabel.TabIndex = 11;
            // 
            // parentLabel
            // 
            this.parentLabel.AutoSize = true;
            this.parentLabel.Location = new System.Drawing.Point(66, 81);
            this.parentLabel.Name = "parentLabel";
            this.parentLabel.Size = new System.Drawing.Size(0, 13);
            this.parentLabel.TabIndex = 10;
            // 
            // typeLabel
            // 
            this.typeLabel.AutoSize = true;
            this.typeLabel.Location = new System.Drawing.Point(66, 51);
            this.typeLabel.Name = "typeLabel";
            this.typeLabel.Size = new System.Drawing.Size(0, 13);
            this.typeLabel.TabIndex = 9;
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(7, 204);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(34, 13);
            this.label15.TabIndex = 8;
            this.label15.Text = "EXP: ";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(6, 174);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(39, 13);
            this.label13.TabIndex = 7;
            this.label13.Text = "Level: ";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(6, 81);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(44, 13);
            this.label12.TabIndex = 6;
            this.label12.Text = "Parent: ";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(6, 114);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(34, 13);
            this.label11.TabIndex = 5;
            this.label11.Text = "ATK: ";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(6, 144);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(28, 13);
            this.label10.TabIndex = 4;
            this.label10.Text = "HP: ";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.battleList);
            this.groupBox5.Controls.Add(this.battleButton);
            this.groupBox5.Controls.Add(this.battleBox);
            this.groupBox5.Controls.Add(this.label16);
            this.groupBox5.Location = new System.Drawing.Point(654, 13);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(321, 416);
            this.groupBox5.TabIndex = 8;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Battle";
            // 
            // battleList
            // 
            this.battleList.FormattingEnabled = true;
            this.battleList.Location = new System.Drawing.Point(9, 55);
            this.battleList.Name = "battleList";
            this.battleList.Size = new System.Drawing.Size(306, 355);
            this.battleList.TabIndex = 10;
            // 
            // battleButton
            // 
            this.battleButton.Location = new System.Drawing.Point(231, 16);
            this.battleButton.Name = "battleButton";
            this.battleButton.Size = new System.Drawing.Size(84, 23);
            this.battleButton.TabIndex = 9;
            this.battleButton.Text = "Battle";
            this.battleButton.UseVisualStyleBackColor = true;
            this.battleButton.Click += new System.EventHandler(this.battleButton_Click);
            // 
            // battleBox
            // 
            this.battleBox.FormattingEnabled = true;
            this.battleBox.Location = new System.Drawing.Point(66, 18);
            this.battleBox.Name = "battleBox";
            this.battleBox.Size = new System.Drawing.Size(148, 21);
            this.battleBox.TabIndex = 5;
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(6, 23);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(41, 13);
            this.label16.TabIndex = 5;
            this.label16.Text = "Name: ";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(987, 441);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.totalLabel);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.moneyLabel);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Breeding Sims";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox newName;
        private System.Windows.Forms.ComboBox typeBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button buyButton;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button sellButton;
        private System.Windows.Forms.ComboBox sellBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label moneyLabel;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label totalLabel;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button breedButton;
        private System.Windows.Forms.ComboBox breedBox1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox breedName;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ComboBox breedBox2;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox detailBox;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label typeLabel;
        private System.Windows.Forms.Label parentLabel;
        private System.Windows.Forms.Label atkLabel;
        private System.Windows.Forms.Label hpLabel;
        private System.Windows.Forms.Label levelLabel;
        private System.Windows.Forms.Label explabel;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.ComboBox battleBox;
        private System.Windows.Forms.Button battleButton;
        private System.Windows.Forms.ListBox battleList;
    }
}

