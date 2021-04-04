namespace App_M6 {
    partial class utama {
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.personelMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.clubMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.transaksiMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.personelMenu,
            this.clubMenu,
            this.transaksiMenu});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(984, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // personelMenu
            // 
            this.personelMenu.Name = "personelMenu";
            this.personelMenu.Size = new System.Drawing.Size(75, 20);
            this.personelMenu.Text = "PERSONEL";
            this.personelMenu.Click += new System.EventHandler(this.personelMenu_Click);
            // 
            // clubMenu
            // 
            this.clubMenu.Name = "clubMenu";
            this.clubMenu.Size = new System.Drawing.Size(48, 20);
            this.clubMenu.Text = "CLUB";
            this.clubMenu.Click += new System.EventHandler(this.clubMenu_Click);
            // 
            // transaksiMenu
            // 
            this.transaksiMenu.Name = "transaksiMenu";
            this.transaksiMenu.Size = new System.Drawing.Size(80, 20);
            this.transaksiMenu.Text = "TRANSAKSI";
            this.transaksiMenu.Click += new System.EventHandler(this.transaksiMenu_Click);
            // 
            // utama
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(984, 661);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.Name = "utama";
            this.Text = "Master";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem personelMenu;
        private System.Windows.Forms.ToolStripMenuItem clubMenu;
        private System.Windows.Forms.ToolStripMenuItem transaksiMenu;
    }
}

