namespace App_M7 {
    partial class report {
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
            this.crViewer = new CrystalDecisions.Windows.Forms.CrystalReportViewer();
            this.usiaCb = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // crViewer
            // 
            this.crViewer.ActiveViewIndex = -1;
            this.crViewer.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.crViewer.Cursor = System.Windows.Forms.Cursors.Default;
            this.crViewer.Location = new System.Drawing.Point(12, 75);
            this.crViewer.Name = "crViewer";
            this.crViewer.Size = new System.Drawing.Size(940, 504);
            this.crViewer.TabIndex = 0;
            // 
            // usiaCb
            // 
            this.usiaCb.FormattingEnabled = true;
            this.usiaCb.Items.AddRange(new object[] {
            "Tahun",
            "Bulan",
            "Hari"});
            this.usiaCb.Location = new System.Drawing.Point(523, 29);
            this.usiaCb.Name = "usiaCb";
            this.usiaCb.Size = new System.Drawing.Size(121, 21);
            this.usiaCb.TabIndex = 1;
            this.usiaCb.SelectedIndexChanged += new System.EventHandler(this.usiaCb_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(377, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(140, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Tampilkan usia berdasarkan";
            // 
            // report
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(964, 591);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.usiaCb);
            this.Controls.Add(this.crViewer);
            this.Name = "report";
            this.Text = "Report";
            this.Load += new System.EventHandler(this.report_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private CrystalDecisions.Windows.Forms.CrystalReportViewer crViewer;
        private System.Windows.Forms.ComboBox usiaCb;
        private System.Windows.Forms.Label label1;
    }
}