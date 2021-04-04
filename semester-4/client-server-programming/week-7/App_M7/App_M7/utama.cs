using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Oracle.DataAccess.Client;

namespace App_M7 {
    public partial class utama : Form {
        OracleConnection conn;
        personel master_person;
        club master_club;
        transaksi master_transaksi;
        report reporting;
	
        public utama() {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
            conn = new OracleConnection(
                "data source= orcl; user id= n217116657; password= 217116657;"
            );
            MessageBox.Show("Untuk memasuki edit mode, click data grid terlebih dahulu");
        }

        private void personelMenu_Click(object sender, EventArgs e) {
            personelMenu.Enabled = false;
            clubMenu.Enabled = true;
            transaksiMenu.Enabled = true;
            reportMenu.Enabled = true;

            if (master_club != null) {
                master_club.Close();
            }

            if (master_transaksi != null) {
                master_transaksi.Close();
            }

            if (reporting != null) {
                reporting.Close();
            }

            master_person = new personel(conn);
            master_person.MdiParent = this;
            master_person.Show();
            master_person.Location = new Point(0, 0);
        }

        private void clubMenu_Click(object sender, EventArgs e) {
            clubMenu.Enabled = false;
            personelMenu.Enabled = true;
            transaksiMenu.Enabled = true;
            reportMenu.Enabled = true;

            if (master_person != null) {
                master_person.Close();
            }

            if (master_transaksi != null) {
                master_transaksi.Close();
            }

            if (reporting != null) {
                reporting.Close();
            }

            master_club = new club(conn);
            master_club.MdiParent = this;
            master_club.Show();
            master_club.Location = new Point(0, 0);
        }

        private void transaksiMenu_Click(object sender, EventArgs e) {
            transaksiMenu.Enabled = false;
            personelMenu.Enabled = true;
            clubMenu.Enabled = true;
            reportMenu.Enabled = true;

            if (master_person != null) {
                master_person.Close();
            }

            if (master_club != null) {
                master_club.Close();
            }

            if (reporting != null) {
                reporting.Close();
            }

            master_transaksi = new transaksi(conn);
            master_transaksi.MdiParent = this;
            master_transaksi.Show();
            master_transaksi.Location = new Point(0, 0);
        }

        private void reportMenu_Click(object sender, EventArgs e) {
            reportMenu.Enabled = false;
            personelMenu.Enabled = true;
            clubMenu.Enabled = true;
            transaksiMenu.Enabled = true;

            if (master_person != null) {
                master_person.Close();
            }

            if (master_club != null) {
                master_club.Close();
            }

            if (master_transaksi != null) {
                master_transaksi.Close();
            }

            reporting = new report();
            reporting.MdiParent = this;
            reporting.Show();
            reporting.Location = new Point(0, 0);
        }
    }
}
