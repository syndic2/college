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

namespace App_M6 {
    public partial class club : Form {
        OracleConnection conn;
        bool edit;

        public club(OracleConnection conn) {
            InitializeComponent();
            this.conn = conn;
            edit = false;
        }

        private void addLigaCb() {
            DataSet ds = new DataSet();
            string show = "SELECT id_liga FROM liga";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(ds);
                ligaCb.DataSource = ds.Tables[0];
                ligaCb.DisplayMember = "id_liga";
                ligaCb.ValueMember = "id_liga";
                ligaCb.SelectedIndex = -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void addFieldCb() {
            fieldCb.Items.Add("ID Club");
            fieldCb.Items.Add("Nama Club");
        }

        private void showData() {
            DataSet ds = new DataSet();
            string show = "SELECT * FROM club";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(ds);
                dataGrid.DataSource = ds.Tables[0];
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();

            dataGrid.Columns[2].DefaultCellStyle.Format = "M/d/yyyy";
        }

        private void detailData(List<string> data) {
            idTb.Text = data[0];
            namaTb.Text = data[1];
            tahunDtp.Text = data[2];
            ligaCb.Text = data[3];
        }

        private void delDtrans(string id) {
            string get_player = "SELECT id_player FROM player WHERE id_club = '" + id + "'";
            string get_htrans = "SELECT id_transaksi FROM h_transaksi WHERE club_asal = '" + id + "' OR club_baru = '" + id + "'";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(get_player, conn);
                OracleDataReader reader = cmd.ExecuteReader();
                reader = cmd.ExecuteReader();
                while (reader.Read()) {
                    string del_by_player = "DELETE d_transaksi WHERE id_player = '" + reader.GetString(0) + "'";
                    try {
                        cmd = new OracleCommand(del_by_player, conn);
                        cmd.ExecuteNonQuery();
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                }

                cmd = new OracleCommand(get_htrans, conn);
                reader = cmd.ExecuteReader();
                while (reader.Read()) {
                    string del_by_dtrans = "DELETE d_transaksi WHERE id_transaksi = '" + reader.GetString(0) + "'";
                    try {
                        cmd = new OracleCommand(del_by_dtrans, conn);
                        cmd.ExecuteNonQuery();
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                }
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private string autoGenId(string nama) {
            int kode = 1;
            int space = nama.LastIndexOf(' ');
            string gen = "";

            if (nama.Length > 1) {
                if (space > 0 && space + 1 < nama.Length) {
                    gen = nama.Substring(0, 1) + nama.Substring(space + 1, 1);
                } else {
                    gen = nama.Substring(0, 2);
                }
            }

            gen = gen.ToUpper();

            string check = "SELECT id_club FROM club WHERE SUBSTR(id_club, 1, 2) = '" + gen + "'";
            string max = "SELECT MAX(SUBSTR(id_club, 3)) FROM club WHERE SUBSTR(id_club, 1, 2) = '" + gen + "'";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(check, conn);                
                if (cmd.ExecuteScalar() != null) {
                    cmd = new OracleCommand(max, conn);
                    kode = int.Parse(cmd.ExecuteScalar().ToString()) + 1;
                }
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();

            if (kode > 0 && kode < 10) {
                gen += "00" + kode;
            } else if (kode >= 10 && kode < 100) {
                gen += "0" + kode;
            } else if (kode >= 100 && kode < 1000) {
                gen += kode;
            }

            return gen;
        }

        private void club_Load(object sender, EventArgs e) {
            addLigaCb();
            addFieldCb();
            showData();
        }

        private void namaTb_TextChanged(object sender, EventArgs e) {
            string nama = namaTb.Text;

            if (!edit) {
                if (!String.IsNullOrEmpty(nama)) {
                    idTb.Text = autoGenId(nama);
                } else {
                    idTb.Clear();
                }
            }
        }

        private void dataGrid_CellClick(object sender, DataGridViewCellEventArgs e) {
            edit = true;
            List<string> data = new List<string>();
            data.Add(dataGrid.Rows[e.RowIndex].Cells[0].Value.ToString());
            data.Add(dataGrid.Rows[e.RowIndex].Cells[1].Value.ToString());
            data.Add(dataGrid.Rows[e.RowIndex].Cells[2].Value.ToString());
            data.Add(dataGrid.Rows[e.RowIndex].Cells[3].Value.ToString());

            detailData(data);
        }

        private void insertBtn_Click(object sender, EventArgs e) {
            if (!edit) {
                if (ligaCb.SelectedValue != null) {
                    string insert = "INSERT INTO club VALUES ('" + idTb.Text + "', '" + namaTb.Text + "', TO_DATE('" + tahunDtp.Value.Year + "', 'YYYY'), " +
                                    "'" + ligaCb.SelectedValue.ToString() + "')";

                    conn.Open();
                    try {
                        OracleCommand cmd = new OracleCommand(insert, conn);
                        cmd.ExecuteNonQuery();
                        MessageBox.Show("Insert berhasil!");
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                    conn.Close();
                }
            } else {
                MessageBox.Show("Keluar dari edit mode");
                edit = false;
            }
            
            showData();
        }

        private void updateBtn_Click(object sender, EventArgs e) {
            if (edit) {
                string update = "UPDATE club " +
                                "SET nama_club = '" + namaTb.Text + "', tahun_berdiri = TO_DATE('" + tahunDtp.Value.Year + "', 'YYYY'), " +
                                "id_liga = '" + ligaCb.SelectedValue.ToString() + "' " +
                                "WHERE id_club = '" + idTb.Text + "'";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(update, conn);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Update berhasil!");
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            } else {
                MessageBox.Show("Tidak dalam edit mode");
            }

            showData();
        }

        private void deleteBtn_Click(object sender, EventArgs e) {
            bool deleted = false;
            string id = idTb.Text;
            string[] commands = new string[5];

            if (edit) {
                commands[0] = "DELETE player WHERE id_club = '" + id + "'";
                commands[1] = "DELETE club_manager WHERE id_club = '" + id + "'";
                commands[2] = "DELETE stadium WHERE id_club = '" + id + "'";
                commands[3] = "DELETE h_transaksi WHERE club_asal = '" + id + "' OR club_baru = '" + id + "'";
                commands[4] = "DELETE club WHERE id_club = '" + id + "'";

                delDtrans(id);

                conn.Open();
                foreach (string i in commands) {
                    try {
                        OracleCommand cmd = new OracleCommand(i, conn);
                        cmd.ExecuteNonQuery();
                        deleted = true;
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                }
                conn.Close();

                if (deleted) {
                    MessageBox.Show("Delete berhasil!");
                }
            } else {
                MessageBox.Show("Tidak dalam edit mode");
            }

            showData();
        }

        private void cariBtn_Click(object sender, EventArgs e) {
            DataSet ds = new DataSet();
            string key = keyTb.Text;

            if (fieldCb.Text == "ID Club") {
                string search = "SELECT * FROM club WHERE id_club LIKE'%" + key.ToUpper() + "%'";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(search, conn);
                    OracleDataAdapter da = new OracleDataAdapter(cmd);
                    da.Fill(ds);
                    dataGrid.DataSource = ds.Tables[0];
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            } else if (fieldCb.Text == "Nama Club") {
                string search = "SELECT * FROM club WHERE nama_club LIKE'%" + key + "%' OR UPPER(nama_club) LIKE'%" + key.ToUpper() + "%'";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(search, conn);
                    OracleDataAdapter da = new OracleDataAdapter(cmd);
                    da.Fill(ds);
                    dataGrid.DataSource = ds.Tables[0];
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            }
        }
    }
}
