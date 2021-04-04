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

namespace App_M5 {
    public partial class utama : Form {
        OracleConnection conn;
        personel master_person;
        club master_club;
        
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

            if (master_club != null) {
                master_club.Close();
            }

            master_person = new personel(conn);
            master_person.MdiParent = this;
            master_person.Show();
            master_person.Location = new Point(0, 0);
        }

        private void clubMenu_Click(object sender, EventArgs e) {
            clubMenu.Enabled = false;
            personelMenu.Enabled = true;

            if (master_person != null) {
                master_person.Close();
            }

            master_club = new club(conn);
            master_club.MdiParent = this;
            master_club.Show();
            master_club.Location = new Point(0, 0);
        }
    }
}
