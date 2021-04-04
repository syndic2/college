namespace App_M6 {
    partial class transaksi {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.finishBtn = new System.Windows.Forms.Button();
            this.deleteBtn = new System.Windows.Forms.Button();
            this.addBtn = new System.Windows.Forms.Button();
            this.entryLb = new System.Windows.Forms.ListBox();
            this.hargaNud = new System.Windows.Forms.NumericUpDown();
            this.label3 = new System.Windows.Forms.Label();
            this.playerCb = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.clubTargetCb = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.newsLb = new System.Windows.Forms.ListBox();
            this.dataGrid = new System.Windows.Forms.DataGridView();
            this.beliRb = new System.Windows.Forms.RadioButton();
            this.jualRb = new System.Windows.Forms.RadioButton();
            this.clubCb = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.hargaNud)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.finishBtn);
            this.groupBox1.Controls.Add(this.deleteBtn);
            this.groupBox1.Controls.Add(this.addBtn);
            this.groupBox1.Controls.Add(this.entryLb);
            this.groupBox1.Controls.Add(this.hargaNud);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.playerCb);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.clubTargetCb);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(454, 247);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Transaksi";
            // 
            // finishBtn
            // 
            this.finishBtn.Location = new System.Drawing.Point(302, 209);
            this.finishBtn.Name = "finishBtn";
            this.finishBtn.Size = new System.Drawing.Size(75, 23);
            this.finishBtn.TabIndex = 9;
            this.finishBtn.Text = "Finish";
            this.finishBtn.UseVisualStyleBackColor = true;
            this.finishBtn.Click += new System.EventHandler(this.finishBtn_Click);
            // 
            // deleteBtn
            // 
            this.deleteBtn.Location = new System.Drawing.Point(134, 209);
            this.deleteBtn.Name = "deleteBtn";
            this.deleteBtn.Size = new System.Drawing.Size(75, 23);
            this.deleteBtn.TabIndex = 8;
            this.deleteBtn.Text = "Delete";
            this.deleteBtn.UseVisualStyleBackColor = true;
            this.deleteBtn.Click += new System.EventHandler(this.deleteBtn_Click);
            // 
            // addBtn
            // 
            this.addBtn.Location = new System.Drawing.Point(41, 209);
            this.addBtn.Name = "addBtn";
            this.addBtn.Size = new System.Drawing.Size(75, 23);
            this.addBtn.TabIndex = 7;
            this.addBtn.Text = "Add";
            this.addBtn.UseVisualStyleBackColor = true;
            this.addBtn.Click += new System.EventHandler(this.addBtn_Click);
            // 
            // entryLb
            // 
            this.entryLb.FormattingEnabled = true;
            this.entryLb.Location = new System.Drawing.Point(242, 27);
            this.entryLb.Name = "entryLb";
            this.entryLb.Size = new System.Drawing.Size(196, 173);
            this.entryLb.TabIndex = 6;
            // 
            // hargaNud
            // 
            this.hargaNud.Location = new System.Drawing.Point(95, 88);
            this.hargaNud.Name = "hargaNud";
            this.hargaNud.Size = new System.Drawing.Size(131, 20);
            this.hargaNud.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(17, 90);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(36, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Harga";
            // 
            // playerCb
            // 
            this.playerCb.FormattingEnabled = true;
            this.playerCb.Location = new System.Drawing.Point(95, 54);
            this.playerCb.Name = "playerCb";
            this.playerCb.Size = new System.Drawing.Size(131, 21);
            this.playerCb.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(17, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(36, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Player";
            // 
            // clubTargetCb
            // 
            this.clubTargetCb.FormattingEnabled = true;
            this.clubTargetCb.Location = new System.Drawing.Point(95, 27);
            this.clubTargetCb.Name = "clubTargetCb";
            this.clubTargetCb.Size = new System.Drawing.Size(131, 21);
            this.clubTargetCb.TabIndex = 1;
            this.clubTargetCb.SelectedValueChanged += new System.EventHandler(this.clubTargetCb_SelectedValueChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(17, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Club Target";
            // 
            // newsLb
            // 
            this.newsLb.FormattingEnabled = true;
            this.newsLb.Location = new System.Drawing.Point(12, 284);
            this.newsLb.Name = "newsLb";
            this.newsLb.Size = new System.Drawing.Size(454, 212);
            this.newsLb.TabIndex = 1;
            // 
            // dataGrid
            // 
            this.dataGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGrid.Location = new System.Drawing.Point(486, 45);
            this.dataGrid.Name = "dataGrid";
            this.dataGrid.Size = new System.Drawing.Size(406, 451);
            this.dataGrid.TabIndex = 2;
            // 
            // beliRb
            // 
            this.beliRb.AutoSize = true;
            this.beliRb.Location = new System.Drawing.Point(507, 12);
            this.beliRb.Name = "beliRb";
            this.beliRb.Size = new System.Drawing.Size(42, 17);
            this.beliRb.TabIndex = 3;
            this.beliRb.Text = "Beli";
            this.beliRb.UseVisualStyleBackColor = true;
            this.beliRb.CheckedChanged += new System.EventHandler(this.beliRb_CheckedChanged);
            // 
            // jualRb
            // 
            this.jualRb.AutoSize = true;
            this.jualRb.Location = new System.Drawing.Point(566, 12);
            this.jualRb.Name = "jualRb";
            this.jualRb.Size = new System.Drawing.Size(44, 17);
            this.jualRb.TabIndex = 4;
            this.jualRb.Text = "Jual";
            this.jualRb.UseVisualStyleBackColor = true;
            this.jualRb.CheckedChanged += new System.EventHandler(this.jualRb_CheckedChanged);
            // 
            // clubCb
            // 
            this.clubCb.FormattingEnabled = true;
            this.clubCb.Location = new System.Drawing.Point(771, 12);
            this.clubCb.Name = "clubCb";
            this.clubCb.Size = new System.Drawing.Size(121, 21);
            this.clubCb.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(728, 16);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(28, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Club";
            // 
            // transaksi
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(904, 591);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.clubCb);
            this.Controls.Add(this.jualRb);
            this.Controls.Add(this.beliRb);
            this.Controls.Add(this.dataGrid);
            this.Controls.Add(this.newsLb);
            this.Controls.Add(this.groupBox1);
            this.Name = "transaksi";
            this.Text = "Master Transaksi";
            this.Load += new System.EventHandler(this.transaksi_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.hargaNud)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ListBox newsLb;
        private System.Windows.Forms.DataGridView dataGrid;
        private System.Windows.Forms.RadioButton beliRb;
        private System.Windows.Forms.RadioButton jualRb;
        private System.Windows.Forms.ComboBox clubCb;
        private System.Windows.Forms.ComboBox clubTargetCb;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox playerCb;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown hargaNud;
        private System.Windows.Forms.ListBox entryLb;
        private System.Windows.Forms.Button finishBtn;
        private System.Windows.Forms.Button deleteBtn;
        private System.Windows.Forms.Button addBtn;
        private System.Windows.Forms.Label label4;
    }
}