namespace App_M5 {
    partial class club {
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
            this.dataGrid = new System.Windows.Forms.DataGridView();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.keyTb = new System.Windows.Forms.TextBox();
            this.fieldCb = new System.Windows.Forms.ComboBox();
            this.cariBtn = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.deleteBtn = new System.Windows.Forms.Button();
            this.updateBtn = new System.Windows.Forms.Button();
            this.insertBtn = new System.Windows.Forms.Button();
            this.ligaCb = new System.Windows.Forms.ComboBox();
            this.tahunDtp = new System.Windows.Forms.DateTimePicker();
            this.namaTb = new System.Windows.Forms.TextBox();
            this.idTb = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGrid
            // 
            this.dataGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGrid.Location = new System.Drawing.Point(301, 12);
            this.dataGrid.Name = "dataGrid";
            this.dataGrid.Size = new System.Drawing.Size(461, 557);
            this.dataGrid.TabIndex = 5;
            this.dataGrid.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGrid_CellClick);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.keyTb);
            this.groupBox2.Controls.Add(this.fieldCb);
            this.groupBox2.Controls.Add(this.cariBtn);
            this.groupBox2.Controls.Add(this.label8);
            this.groupBox2.Controls.Add(this.label7);
            this.groupBox2.Location = new System.Drawing.Point(12, 383);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(270, 137);
            this.groupBox2.TabIndex = 4;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "SEARCH";
            // 
            // keyTb
            // 
            this.keyTb.Location = new System.Drawing.Point(77, 56);
            this.keyTb.Name = "keyTb";
            this.keyTb.Size = new System.Drawing.Size(179, 20);
            this.keyTb.TabIndex = 19;
            // 
            // fieldCb
            // 
            this.fieldCb.FormattingEnabled = true;
            this.fieldCb.Location = new System.Drawing.Point(77, 29);
            this.fieldCb.Name = "fieldCb";
            this.fieldCb.Size = new System.Drawing.Size(179, 21);
            this.fieldCb.TabIndex = 18;
            // 
            // cariBtn
            // 
            this.cariBtn.Location = new System.Drawing.Point(77, 95);
            this.cariBtn.Name = "cariBtn";
            this.cariBtn.Size = new System.Drawing.Size(75, 23);
            this.cariBtn.TabIndex = 17;
            this.cariBtn.Text = "CARI";
            this.cariBtn.UseVisualStyleBackColor = true;
            this.cariBtn.Click += new System.EventHandler(this.cariBtn_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(19, 59);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(25, 13);
            this.label8.TabIndex = 1;
            this.label8.Text = "Key";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(16, 32);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(29, 13);
            this.label7.TabIndex = 0;
            this.label7.Text = "Field";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.deleteBtn);
            this.groupBox1.Controls.Add(this.updateBtn);
            this.groupBox1.Controls.Add(this.insertBtn);
            this.groupBox1.Controls.Add(this.ligaCb);
            this.groupBox1.Controls.Add(this.tahunDtp);
            this.groupBox1.Controls.Add(this.namaTb);
            this.groupBox1.Controls.Add(this.idTb);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(270, 351);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Club";
            // 
            // deleteBtn
            // 
            this.deleteBtn.Location = new System.Drawing.Point(181, 219);
            this.deleteBtn.Name = "deleteBtn";
            this.deleteBtn.Size = new System.Drawing.Size(75, 23);
            this.deleteBtn.TabIndex = 16;
            this.deleteBtn.Text = "DELETE";
            this.deleteBtn.UseVisualStyleBackColor = true;
            this.deleteBtn.Click += new System.EventHandler(this.deleteBtn_Click);
            // 
            // updateBtn
            // 
            this.updateBtn.Location = new System.Drawing.Point(100, 219);
            this.updateBtn.Name = "updateBtn";
            this.updateBtn.Size = new System.Drawing.Size(75, 23);
            this.updateBtn.TabIndex = 15;
            this.updateBtn.Text = "UPDATE";
            this.updateBtn.UseVisualStyleBackColor = true;
            this.updateBtn.Click += new System.EventHandler(this.updateBtn_Click);
            // 
            // insertBtn
            // 
            this.insertBtn.Location = new System.Drawing.Point(19, 219);
            this.insertBtn.Name = "insertBtn";
            this.insertBtn.Size = new System.Drawing.Size(75, 23);
            this.insertBtn.TabIndex = 14;
            this.insertBtn.Text = "INSERT";
            this.insertBtn.UseVisualStyleBackColor = true;
            this.insertBtn.Click += new System.EventHandler(this.insertBtn_Click);
            // 
            // ligaCb
            // 
            this.ligaCb.FormattingEnabled = true;
            this.ligaCb.Location = new System.Drawing.Point(19, 170);
            this.ligaCb.Name = "ligaCb";
            this.ligaCb.Size = new System.Drawing.Size(133, 21);
            this.ligaCb.TabIndex = 11;
            // 
            // tahunDtp
            // 
            this.tahunDtp.Location = new System.Drawing.Point(19, 129);
            this.tahunDtp.Name = "tahunDtp";
            this.tahunDtp.Size = new System.Drawing.Size(178, 20);
            this.tahunDtp.TabIndex = 10;
            // 
            // namaTb
            // 
            this.namaTb.Location = new System.Drawing.Point(19, 84);
            this.namaTb.Name = "namaTb";
            this.namaTb.Size = new System.Drawing.Size(107, 20);
            this.namaTb.TabIndex = 9;
            this.namaTb.TextChanged += new System.EventHandler(this.namaTb_TextChanged);
            // 
            // idTb
            // 
            this.idTb.Enabled = false;
            this.idTb.Location = new System.Drawing.Point(19, 43);
            this.idTb.Name = "idTb";
            this.idTb.Size = new System.Drawing.Size(107, 20);
            this.idTb.TabIndex = 8;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 154);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 13);
            this.label4.TabIndex = 5;
            this.label4.Text = "ID Liga";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 112);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Tahun Berdiri";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 68);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Nama Club";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 27);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(42, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "ID Club";
            // 
            // club
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(774, 591);
            this.Controls.Add(this.dataGrid);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "club";
            this.Text = "Master Club";
            this.Load += new System.EventHandler(this.club_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGrid;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.TextBox keyTb;
        private System.Windows.Forms.ComboBox fieldCb;
        private System.Windows.Forms.Button cariBtn;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button deleteBtn;
        private System.Windows.Forms.Button updateBtn;
        private System.Windows.Forms.Button insertBtn;
        private System.Windows.Forms.ComboBox ligaCb;
        private System.Windows.Forms.DateTimePicker tahunDtp;
        private System.Windows.Forms.TextBox namaTb;
        private System.Windows.Forms.TextBox idTb;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
    }
}