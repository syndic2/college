using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace App_M7 {
    public partial class report : Form {
        CrystalReport cr;

        public report() {
            InitializeComponent();
            cr = new CrystalReport();
            cr.SetDatabaseLogon("n217116657", "217116657", "orcl", "");
        }

        private void report_Load(object sender, EventArgs e) {
            usiaCb.SelectedIndex = 0;
            crViewer.ReportSource = cr;
            crViewer.Refresh();
        }

        private void usiaCb_SelectedIndexChanged(object sender, EventArgs e) {
            if (usiaCb.SelectedItem != null) {
                cr.SetParameterValue("usia", usiaCb.SelectedItem);
                crViewer.ReportSource = cr;
                crViewer.Refresh();
            }
        }
    }
}
