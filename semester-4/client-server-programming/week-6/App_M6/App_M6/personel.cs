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
    public partial class personel : Form {
        OracleConnection conn;
        bool edit;

        public personel(OracleConnection conn) {
            InitializeComponent();
            this.conn = conn;
        }

        private void addClubCb() {
            DataSet ds = new DataSet();
            string show = "SELECT id_club, nama_club FROM club";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(ds);
                clubCb.DataSource = ds.Tables[0];
                clubCb.DisplayMember = "nama_club";
                clubCb.ValueMember = "id_club";
                clubCb.SelectedIndex= -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void addNegaraCb() {
            DataSet ds = new DataSet();
            string show = "SELECT id_negara, nama_negara FROM negara";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(ds);
                negaraCb.DataSource = ds.Tables[0];
                negaraCb.DisplayMember = "nama_negara";
                negaraCb.ValueMember = "id_negara";
                negaraCb.SelectedIndex = -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void addAgenCb() {
            DataSet ds = new DataSet();
            string show = "SELECT id_agen, nama_agen FROM agen";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(show, conn);
                OracleDataAdapter da = new OracleDataAdapter(cmd);
                da.Fill(ds);
                agenCb.DataSource = ds.Tables[0];
                agenCb.DisplayMember = "nama_agen";
                agenCb.ValueMember = "id_agen";
                agenCb.SelectedIndex = -1;
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void addFieldCb(string role) {
            fieldCb.Items.Clear();
            fieldCb.ResetText();

            if (role == "player") {
                fieldCb.Items.Add("ID Player");
                fieldCb.Items.Add("Nama Player");
            } else if (role == "manager") {
                fieldCb.Items.Add("ID Manager");
                fieldCb.Items.Add("Nama Manager");
            }
        }

        private void dataGridPlayer() {
            DataSet ds = new DataSet();
            string show = "SELECT * FROM player";

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

        private void dataGridManager() {
            DataSet ds = new DataSet();
            string show = "SELECT * FROM manager";

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

        private void detailPlayer(List<string> data) {
            idTb.Text = data[0];
            namaTb.Text = data[1];
            dobDtp.Text = data[2];

            string get_club = "SELECT nama_club FROM club WHERE id_club = '" + data[3] + "'";
            string get_negara = "SELECT nama_negara FROM negara WHERE id_negara = '" + data[4] + "'";
            string get_agen = "SELECT nama_agen FROM agen WHERE id_agen = '" + data[5] + "'";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(get_club, conn);
                clubCb.Text = cmd.ExecuteScalar().ToString();
                cmd = new OracleCommand(get_negara, conn);
                negaraCb.Text = cmd.ExecuteScalar().ToString();
                cmd = new OracleCommand(get_agen, conn);
                agenCb.Text = cmd.ExecuteScalar().ToString();
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private void detailManager(List<string> data) {
            idTb.Text = data[0];
            namaTb.Text = data[1];
            dobDtp.Text = data[2];

            string[] get_club = new string[2];
            get_club[0] = "SELECT id_club FROM club_manager WHERE id_manager = '" + data[0] + "'";
            string get_negara = "SELECT nama_negara FROM negara WHERE id_negara = '" + data[3] + "'";
            string get_agen = "SELECT nama_agen FROM agen WHERE id_agen = '" + data[4] + "'";
            
            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(get_club[0], conn);
                if (cmd.ExecuteScalar() != null) {
                    string id = cmd.ExecuteScalar().ToString();
                    get_club[1] = "SELECT nama_club FROM club WHERE id_club = '" + id + "'";
                    cmd = new OracleCommand(get_club[1], conn);
                    clubCb.Text = cmd.ExecuteScalar().ToString();
                } else {
                    clubCb.Text = "Tidak memiliki club";
                }
                cmd = new OracleCommand(get_negara, conn);
                negaraCb.Text= cmd.ExecuteScalar().ToString();
                cmd = new OracleCommand(get_agen, conn);
                if (cmd.ExecuteScalar() != null) {
                    agenCb.Text = cmd.ExecuteScalar().ToString();
                } else {
                    agenCb.Text = "Tidak memiliki agen";
                }
            } catch (Exception ex) {
                MessageBox.Show(ex.Message);
            }
            conn.Close();
        }

        private string idPlayer(string nama) {
            string gen = "";
            int kode = 1;
            int space = nama.LastIndexOf(' ');

            if (nama.Length > 1) {
                if (space > 0 && space + 1 < nama.Length) {
                    gen = nama.Substring(0, 1) + nama.Substring(space + 1, 1);
                } else {
                    gen = nama.Substring(0, 2);
                }
            }

            gen = gen.ToUpper();

            string check = "SELECT id_player FROM player WHERE SUBSTR(id_player, 1, 2) = '" + gen + "'";
            string max = "SELECT MAX(SUBSTR(id_player, 3)) FROM player WHERE SUBSTR(id_player, 1, 2) = '" + gen + "'";

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

        private string idManager() {
            int kode = 1;
            string gen = "MAN";
            string max = "SELECT MAX(SUBSTR(id_manager, 4)) FROM manager";

            conn.Open();
            try {
                OracleCommand cmd = new OracleCommand(max, conn);
                kode = int.Parse(cmd.ExecuteScalar().ToString()) + 1;
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

        private void insertData(List<string> data, string role) {
            if (role == "player") {
                string insert = "INSERT INTO player VALUES ('" + data[0] + "', '" + data[1] + "', TO_DATE('" + data[2] + "', 'DD-MM-YYYY'), " +
                                "'" + data[3] + "', '" + data[4] + "', '" + data[5] + "')";
                
                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(insert, conn);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Insert berhasil!");
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            } else if (role == "manager") {
                string[] insert = new string[2];
                insert[0] = "INSERT INTO manager VALUES ('" + data[0] + "', '" + data[1] + "', TO_DATE('" + data[2] + "', 'DD-MM-YYYY'), " +
                                "'" + data[4] + "', '" + data[5] + "')";
                insert[1] = "INSERT INTO club_manager VALUES ('" + data[3] + "', '" + data[0] + "')";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(insert[0], conn);
                    cmd.ExecuteNonQuery();
                    cmd= new OracleCommand(insert[1], conn);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Insert berhasil!");
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            }
        }

        private void updateData(List<string> data, string role) {
            if (role == "player") {
                string update = "UPDATE player " +
                                "SET nama_player = '" + data[1] + "', dob_player = TO_DATE('" + data[2] + "', 'DD-MM-YYYY'), " +
                                "id_club = '" + data[3] + "', id_negara = '" + data[4] + "', id_agen = '" + data[5] + "' " +
                                "WHERE id_player = '" + data[0] + "'";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(update, conn);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Update berhasil!");
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            } else if (role == "manager") {
                string[] update = new string[3];
                update[0] = "UPDATE manager " +
                            "SET nama_manager = '" + data[1] + "', dob_manager = TO_DATE('" + data[2] + "', 'DD-MM-YYYY'), " +
                            "id_negara = '" + data[4] + "', id_agen = '" + data[5] + "' " +
                            "WHERE id_manager = '" + data[0] + "'";
                update[1] = "UPDATE manager " +
                            "SET nama_manager = '" + data[1] + "', dob_manager = TO_DATE('" + data[2] + "', 'DD-MM-YYYY'), " +
                            "id_negara = '" + data[4] + "' " +
                            "WHERE id_manager = '" + data[0] + "'";
                update[2] = "UPDATE club_manager " +
                            "SET id_club = '" + data[3] + "' " +
                            "WHERE id_manager = '" + data[0] + "'";
                string check = "SELECT id_agen FROM manager WHERE id_manager = '" + data[0] + "'";

                conn.Open();
                try {
                    OracleCommand cmd = new OracleCommand(check, conn);
                    if (cmd.ExecuteScalar().ToString() != "") {
                        cmd = new OracleCommand(update[0], conn);
                        cmd.ExecuteNonQuery();
                    } else {
                        cmd = new OracleCommand(update[1], conn);
                        cmd.ExecuteNonQuery();
                    }
                    cmd = new OracleCommand(update[2], conn);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Update berhasil!");
                } catch (Exception ex) {
                    MessageBox.Show(ex.Message);
                }
                conn.Close();
            }
        }

        private void searchDataByID(string key, string role) {
            DataSet ds = new DataSet();

            if (role == "player") {
                string search = "SELECT * FROM player WHERE id_player LIKE'%" + key.ToUpper() + "%'";

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
            } else if (role == "manager") {
                string search = "SELECT * FROM manager WHERE id_manager LIKE'%" + key.ToUpper() + "%'";

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

        private void searchDataByNama(string key, string role) {
            DataSet ds = new DataSet();

            if (role == "player") {
                string search = "SELECT * FROM player WHERE nama_player LIKE'%" + key + "%' OR UPPER(nama_player) LIKE'%" + key.ToUpper() + "%'";

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
            } else if (role == "manager") {
                string search = "SELECT * FROM manager WHERE nama_manager LIKE'%" + key + "%' OR UPPER(nama_manager) LIKE'%" + key.ToUpper() + "%'";

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

        private void personel_Load(object sender, EventArgs e) {
            addClubCb();
            addNegaraCb();
            addAgenCb();
            dataGridPlayer();
        }

        private void playerRb_CheckedChanged(object sender, EventArgs e) {
            if (playerRb.Checked) {
                edit = false;
                addFieldCb("player");
                dataGridPlayer();
            }
        }

        private void managerRb_CheckedChanged(object sender, EventArgs e) {
            if (managerRb.Checked) {
                edit = false;
                addFieldCb("manager");
                dataGridManager();
            }
        }

        private void namaTb_TextChanged(object sender, EventArgs e) {
            string nama = namaTb.Text;

            if (!edit) {
                if (!String.IsNullOrEmpty(nama)) {
                    if (playerRb.Checked) {
                        idTb.Text = idPlayer(nama);
                    } else if (managerRb.Checked) {
                        idTb.Text = idManager();
                    }
                } else {
                    idTb.Clear();
                }
            }
        }

        private void dataGrid_CellClick(object sender, DataGridViewCellEventArgs e) {
            edit = true;
            List<string> data = new List<string>();

            if (playerRb.Checked) {
                data.Add(dataGrid.Rows[e.RowIndex].Cells[0].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[1].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[2].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[3].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[4].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[5].Value.ToString());

                detailPlayer(data);
            } else if (managerRb.Checked) {
                data.Add(dataGrid.Rows[e.RowIndex].Cells[0].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[1].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[2].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[3].Value.ToString());
                data.Add(dataGrid.Rows[e.RowIndex].Cells[4].Value.ToString());

                detailManager(data);
            }
        }

        private void insertBtn_Click(object sender, EventArgs e) {
            List<string> data = new List<string>();

            if (!edit) {
                if (clubCb.SelectedValue != null && negaraCb.SelectedValue != null && agenCb.SelectedValue != null) {
                    data.Add(idTb.Text);
                    data.Add(namaTb.Text);
                    data.Add(dobDtp.Value.ToString("dd-MM-yyyy"));
                    data.Add(clubCb.SelectedValue.ToString());
                    data.Add(negaraCb.SelectedValue.ToString());
                    data.Add(agenCb.SelectedValue.ToString());

                    if (playerRb.Checked) {
                        insertData(data, "player");
                        dataGridPlayer();
                    } else if (managerRb.Checked) {
                        insertData(data, "manager");
                        dataGridManager();
                    }
                }
            } else {
                MessageBox.Show("Keluar dari edit mode");
                edit = false;
            }
        }

        private void updateBtn_Click(object sender, EventArgs e) {
            List<string> data = new List<string>();

            if (edit) {
                data.Add(idTb.Text);
                data.Add(namaTb.Text);
                data.Add(dobDtp.Value.ToString("dd-MM-yyyy"));
                data.Add(clubCb.SelectedValue.ToString());
                data.Add(negaraCb.SelectedValue.ToString());
                data.Add(agenCb.SelectedValue.ToString());

                if (playerRb.Checked) {
                    updateData(data, "player");
                    dataGridPlayer();
                } else if (managerRb.Checked) {
                    updateData(data, "manager");
                    dataGridManager();
                }
            } else {
                MessageBox.Show("Tidak dalam edit mode");
            }
        }

        private void deleteBtn_Click(object sender, EventArgs e) {
            if (edit) {
                if (playerRb.Checked) {
                    string[] delete = new string[2];
                    delete[0] = "DELETE d_transaksi WHERE id_player = '" + idTb.Text + "'";
                    delete[1] = "DELETE player WHERE id_player = '" + idTb.Text + "'";

                    conn.Open();
                    try {
                        OracleCommand cmd = new OracleCommand(delete[0], conn);
                        cmd.ExecuteNonQuery();
                        cmd = new OracleCommand(delete[1], conn);
                        cmd.ExecuteNonQuery();
                        MessageBox.Show("Delete berhasil!");
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                    conn.Close();

                    dataGridPlayer();
                } else if (managerRb.Checked) {
                    string[] delete = new string[2];
                    delete[0] = "DELETE club_manager WHERE id_manager = '" + idTb.Text + "'";
                    delete[1] = "DELETE manager WHERE id_manager = '" + idTb.Text + "'";

                    conn.Open();
                    try {
                        OracleCommand cmd = new OracleCommand(delete[0], conn);
                        cmd.ExecuteNonQuery();
                        cmd = new OracleCommand(delete[1], conn);
                        cmd.ExecuteNonQuery();
                        MessageBox.Show("Delete berhasil!");
                    } catch (Exception ex) {
                        MessageBox.Show(ex.Message);
                    }
                    conn.Close();

                    dataGridManager();
                }
            } else {
                MessageBox.Show("Tidak dalam edit mode");
            }
        }

        private void cariBtn_Click(object sender, EventArgs e) {
            if (playerRb.Checked) {
                if (fieldCb.Text == "ID Player") {
                    searchDataByID(keyTb.Text, "player");
                } else if (fieldCb.Text == "Nama Player") {
                    searchDataByNama(keyTb.Text, "player");
                }
            } else if (managerRb.Checked) {
                if (fieldCb.Text == "ID Manager") {
                    searchDataByID(keyTb.Text, "manager");
                } else if (fieldCb.Text == "Nama Manager") {
                    searchDataByNama(keyTb.Text, "manager");
                }
            }
        }
    }
}
