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
    public partial class transaksi : Form {
        OracleConnection conn;
        List<object> entries;

        public transaksi(OracleConnection conn) {
            InitializeComponent();
            this.conn = conn;
            entries = new List<object>();
            hargaNud.Maximum = Decimal.MaxValue;
        }

        private void addClubCb() {
            DataTable dt = new DataTable();
            string show = "SELECT id_club, nama_club FROM club";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(dt);
                clubCb.DataSource = dt;
                clubCb.DisplayMember = "nama_club";
                clubCb.ValueMember = "id_club";
                clubCb.SelectedIndex = -1;
                clubCb.SelectedValueChanged += ClubCb_SelectedValueChanged;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void addClubTargetCb(object id = null) {
            DataTable dt = new DataTable();
            string show = "";

            if (id == null) {
                show = "SELECT id_club, nama_club FROM club";
            } else {
                show = "SELECT id_club, nama_club FROM club WHERE id_club != '" + id + "'";
            }

            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(dt);
                clubTargetCb.DataSource = dt;
                clubTargetCb.DisplayMember = "nama_club";
                clubTargetCb.ValueMember = "id_club";
                clubTargetCb.SelectedIndex = -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }

        }

        private void addPlayerCb(object id) {
            DataTable dt = new DataTable();
            string show = "SELECT id_player, nama_player FROM player WHERE id_club = '" + id + "'";

            conn.Close();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(dt);
                playerCb.DataSource = dt;
                playerCb.DisplayMember = "nama_player";
                playerCb.ValueMember = "id_player";
                playerCb.SelectedIndex = -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void transaksi_Load(object sender, EventArgs e) {
            addClubCb();
            addClubTargetCb();
        }

        private void beliRb_CheckedChanged(object sender, EventArgs e) {
            if (beliRb.Checked) {
                playerCb.DataSource = null;

                if (clubTargetCb.SelectedValue != null) {
                    addPlayerCb(clubTargetCb.SelectedValue);
                }
            }
        }

        private void jualRb_CheckedChanged(object sender, EventArgs e) {
            if (jualRb.Checked) {
                playerCb.DataSource = null;

                if (clubCb.SelectedValue != null) {
                    addPlayerCb(clubCb.SelectedValue);
                }
            }
        }

        private void clubTargetCb_SelectedValueChanged(object sender, EventArgs e) {
            if (clubTargetCb.SelectedValue != null) {
                if (beliRb.Checked) {
                    addPlayerCb(clubTargetCb.SelectedValue);
                }
            }
        }

        private void showGrid(object id) {
            DataTable dt = new DataTable();
            string show = "SELECT * FROM player WHERE id_club = '" + id + "'";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(dt);
                dataGrid.DataSource = dt;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void ClubCb_SelectedValueChanged(object sender, EventArgs e) {
            if (clubCb.SelectedValue != null) {
                addClubTargetCb(clubCb.SelectedValue);
                showGrid(clubCb.SelectedValue);

                if (jualRb.Checked) {
                    addPlayerCb(clubCb.SelectedValue);
                }
            }
        }

        private void addBtn_Click(object sender, EventArgs e) {
            if (clubTargetCb.SelectedItem != null && playerCb.SelectedItem != null) {
                object entry = new {
                    nama_club = clubTargetCb.Text,
                    nama_player = playerCb.Text,
                    harga = hargaNud.Value,
                    display = clubTargetCb.Text + " - " + playerCb.Text + " - " + hargaNud.Value,
                    value = playerCb.SelectedValue
                };
                entries.Add(entry);
                refreshEntryLb();
            }
        }

        private void refreshEntryLb() {
            entryLb.DataSource = null;
            entryLb.DataSource = entries;
            entryLb.DisplayMember = "display";
            entryLb.ValueMember = "value";
        }

        private void deleteBtn_Click(object sender, EventArgs e) {
            if (entryLb.SelectedItem != null) {
                int idx = entryLb.SelectedIndex;
                entries.RemoveAt(idx);
                refreshEntryLb();
            }
        }

        private string getIdTrans() {
            int kode = 1;
            string id = "TRANS";

            conn.Open();
            try {
                string get_max = "SELECT MAX(SUBSTR(id_transaksi, 6)) FROM h_transaksi";
                OracleCommand cmd = new OracleCommand(get_max, conn);
                kode = int.Parse(cmd.ExecuteScalar().ToString()) + 1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();

            if (kode > 0 && kode < 10) {
                id += "00" + kode;
            } else if (kode >= 10 && kode < 100)  {
                id += "0" + kode;
            } else if (kode >= 100 && kode < 1000) {
                id += kode;
            }

            return id;
        }

        private void showNews(string mode, string target) {
            foreach (object i in entries) {
                var nama_club = i.GetType().GetProperty("nama_club").GetValue(i, null);
                var nama_player = i.GetType().GetProperty("nama_player").GetValue(i, null);
                var harga = i.GetType().GetProperty("harga").GetValue(i, null);
                string news = "";

                if (mode == "beli") {
                    news = nama_player + ": " + nama_club + " -> " + target + " (EUR " + harga + ")";
                } else {
                    news = nama_player + ": " + target + " -> " + nama_club + " (EUR " + harga + ")";
                }

                newsLb.Items.Add(news);
            }
        }

        private void finishBtn_Click(object sender, EventArgs e) {
            string new_id = getIdTrans();

            if (entryLb.Items.Count > 0) {
                int total_biaya = 0;

                foreach (object i in entries) {
                    int harga = int.Parse(i.GetType().GetProperty("harga").GetValue(i, null).ToString());
                    total_biaya += harga;
                }

                conn.Open();
                OracleTransaction trans = conn.BeginTransaction();
                try {
                    if (beliRb.Checked) {
                        string club_asal = clubTargetCb.SelectedValue.ToString();
                        string club_baru = clubCb.SelectedValue.ToString();
                        string htrans = "INSERT INTO h_transaksi VALUES ('" + new_id + "', '" + club_asal + "', '" + club_baru + "', " +
                                         total_biaya + ", TO_DATE(SYSDATE, 'DD-MM-YYYY'))";
                        OracleCommand cmd = new OracleCommand(htrans, conn);
                        cmd.ExecuteNonQuery();

                        foreach (object i in entries) {
                            string id_player = i.GetType().GetProperty("value").GetValue(i, null).ToString();
                            int harga = int.Parse(i.GetType().GetProperty("harga").GetValue(i, null).ToString());
                            string dtrans = "INSERT INTO d_transaksi VALUES ('" + new_id + "', '" + id_player + "', " + harga + ")";
                            cmd = new OracleCommand(dtrans, conn);
                            cmd.ExecuteNonQuery();
                            string player = "UPDATE player " +
                                            "SET id_club = '" + club_baru + "' " +
                                            "WHERE id_player = '" + id_player + "'";
                            cmd = new OracleCommand(player, conn);
                            cmd.ExecuteNonQuery();
                        }

                        showNews("beli", clubCb.Text);
                    } else {
                        string club_asal = clubCb.SelectedValue.ToString();
                        string club_baru = clubTargetCb.SelectedValue.ToString();
                        string htrans = "INSERT INTO h_transaksi VALUES ('" + new_id + "', '" + club_asal + "', '" + club_baru + "', " +
                                         total_biaya + ", TO_DATE(SYSDATE, 'DD-MM-YYYY'))";
                        OracleCommand cmd = new OracleCommand(htrans, conn);
                        cmd.ExecuteNonQuery();

                        foreach (object i in entries) {
                            string id_player = i.GetType().GetProperty("value").GetValue(i, null).ToString();
                            int harga = int.Parse(i.GetType().GetProperty("harga").GetValue(i, null).ToString());
                            string dtrans = "INSERT INTO d_transaksi VALUES ('" + new_id + "', '" + id_player + "', " + harga + ")";
                            cmd = new OracleCommand(dtrans, conn);
                            cmd.ExecuteNonQuery();
                            string player = "UPDATE player " +
                                            "SET id_club = '" + club_baru + "' " +
                                            "WHERE id_player = '" + id_player + "'";
                            cmd = new OracleCommand(player, conn);
                            cmd.ExecuteNonQuery();
                        }

                        showNews("jual", clubCb.Text);
                    }

                    trans.Commit();

                    entries.Clear();
                    entryLb.DataSource = null;
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                    trans.Rollback();
                }
                conn.Close();
            }

            if (clubCb.SelectedValue != null) {
                showGrid(clubCb.SelectedValue);
            }
        }
    }
}
