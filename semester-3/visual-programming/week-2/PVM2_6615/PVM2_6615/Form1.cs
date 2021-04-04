using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using cLibrary;

namespace PVM2_6615
{
    public partial class Form1 : Form
    {
        Random r = new Random();
        int mana = 30000;
        int scroll = 2;
        List<monster> dbmons;
        monster enemy= null;
        public Form1()
        {
            InitializeComponent();
            dbmons = new List<monster>();
            groupBox3.Enabled = false;
            groupBox4.Enabled = false;
            groupBox5.Enabled = false;
            resource();
        }

        private void resource()
        {
            manaLabel.Text = mana.ToString();
            scrollLabel.Text = scroll.ToString();
        }

        private void summonDetails(monster m)
        {
            summonRtb.Clear();
            summonRtb.Text += "Name: " + m.ToString() + "\n";
            summonRtb.Text += "Element: " + m.Element + "\n";
            summonRtb.Text += "Level: " + m.Level.ToString() + "\n";
            summonRtb.Text += "HP: " + m.Hp.ToString() + "/" +m.Maxhp.ToString() + "\n";
            summonRtb.Text += "ATK: " + m.Minatk.ToString() + "-" + m.Maxatk.ToString() + "\n";
            summonRtb.Text += "DEF: " + m.Mindef.ToString() + "-" + m.Maxdef.ToString() + "\n";
        }

        private void listDetails(monster m)
        {
            listRtb.Clear();
            listRtb.Text += "Name: " + m.ToString() + "\n";
            listRtb.Text += "Element: " + m.Element + "\n";
            listRtb.Text += "Level: " + m.Level.ToString() + "\n";
            listRtb.Text += "HP: " + m.Hp.ToString() + "/" + m.Maxhp.ToString() +"\n";
            listRtb.Text += "ATK: " + m.Minatk.ToString() + "-" + m.Maxatk.ToString() + "\n";
            listRtb.Text += "DEF: " + m.Mindef.ToString() + "-" + m.Maxdef.ToString() + "\n";
        }

        private void battleDetails(monster m)
        {
            battleRtb.Clear();
            battleRtb.Text += "Name: " + m.ToString() + "\n";
            battleRtb.Text += "Element: " + m.Element + "\n";
            battleRtb.Text += "Level: " + m.Level.ToString() + "\n";
            battleRtb.Text += "HP: " + m.Hp.ToString() + "/"+ m.Maxhp.ToString() + "\n";
            battleRtb.Text += "ATK: " + m.Minatk.ToString() + "-" + m.Maxatk.ToString() + "\n";
            battleRtb.Text += "DEF: " + m.Mindef.ToString() + "-" + m.Maxdef.ToString() + "\n";
        }

        private void statPlayer(monster mymons)
        {
            nameLabel1.Text = mymons.ToString();
            eleLabel1.Text = mymons.Element;
            levelLabel1.Text = mymons.Level.ToString();
            expBar1.Minimum = 0;
            expBar1.Maximum = mymons.Maxexp;
            expBar1.Value = mymons.Exp;
            hpBar1.Minimum = 0;
            hpBar1.Maximum = mymons.Maxhp;
            hpBar1.Value = mymons.Hp;
            atkLabel1.Text = mymons.Minatk + "-" + mymons.Maxatk;
            defLabel1.Text = mymons.Mindef + "-" + mymons.Maxdef;
        }

        private void statEnemy(monster enemy)
        {
            nameLabel2.Text = enemy.ToString();
            eleLabel2.Text = enemy.Element;
            levelLabel2.Text = enemy.Level.ToString();
            expBar2.Minimum = 0;
            expBar2.Maximum = enemy.Maxexp;
            expBar2.Value = enemy.Exp;
            hpBar2.Minimum = 0;
            hpBar2.Maximum = enemy.Maxhp;
            hpBar2.Value = enemy.Hp;
            atkLabel2.Text = enemy.Minatk + "-" + enemy.Maxatk;
            defLabel2.Text = enemy.Mindef + "-" + enemy.Maxdef;
        }

        private void summonButton_Click(object sender, EventArgs e)
        {
            if (scroll >= 1 && mana >= 10000)
            {
                scroll -= 1;
                mana -= 10000;
                resource();
                monster m = new monster();
                dbmons.Add(m);
                summonDetails(m);
                listBox.Items.Add(m);
                battleBox.Items.Add(m);
                groupBox3.Enabled = true;
            }
            else
            {
                if (scroll < 1 && mana < 10000)
                {
                    MessageBox.Show("Scroll dan Mana anda kurang!");
                }
                else if (mana < 10000)
                {
                    MessageBox.Show("Mana anda kurang!");
                }
                else if(scroll < 1)
                {
                    MessageBox.Show("Scroll anda kurang!");
                }
            }
        }

        private void victory(monster mymons)
        {
            enemyNull();
            int reward = r.Next(1, 101);
            historyRtb.Text += mymons + " menang !!!" + "\n";
            historyRtb.Text += "---------------------------" + "\n";
            if (reward <= 10)
            {
                scroll += 1;
                historyRtb.Text += mymons + " mendapat EXP sebesar 50, " + "Scroll sebanyak 1" + "\n";
            }
            else if (reward > 10)
            {
                int getmana = r.Next(5000, 8001);
                mana += getmana;
                historyRtb.Text += mymons + " mendapat EXP sebesar 50, " + "Mana sebanyak " + getmana +"\n";
            }
            resource();
            mymons.Exp += 50;
            if (mymons.Exp >= mymons.Maxexp)
            {
                mymons.Exp = 0;
                mymons.Level+= 1;
                mymons.Maxexp = mymons.Level * 200;
                if (mymons.Level == 5)
                {
                    mymons.evolve();
                    statPlayer(mymons);
                    MessageBox.Show("Evolved");
                }
                if (mymons.Evolved == true) mymons.Maxhp += mymons.Level * 300;
                else mymons.Maxhp += mymons.Level * 200;
                mymons.Hp = mymons.Maxhp;
            }
        }

        private void defeated(monster mymons)
        {
            mymons.Hp = mymons.Maxhp;
            mymons.Exp += 50;
            if (mymons.Exp >= mymons.Maxexp)
            {
                mymons.Exp = 0;
                mymons.Level+= 1;
                mymons.Maxexp = mymons.Level * 200;
                if (mymons.Level == 5)
                {
                    mymons.evolve();
                    statPlayer(mymons);
                    MessageBox.Show("Evolved!");
                }
                if (mymons.Evolved == true) mymons.Maxhp += mymons.Level * 300;
                else mymons.Maxhp += mymons.Level * 200;
                mymons.Hp = mymons.Maxhp;
            }
            historyRtb.Text += mymons + " kalah !!!" + "\n";
            historyRtb.Text += "Mendapatkan EXP sebesar 10" + "\n";
            historyRtb.Text += "---------------------------" + "\n";
        }

        private void enemyNull()
        {
            battleRtb.Clear();
            nameLabel2.Text = "";
            eleLabel2.Text = "";
            levelLabel2.Text = "";
            expBar2.Minimum = 0;
            expBar2.Maximum = 0;
            expBar2.Value = 0;
            hpBar2.Minimum = 0;
            hpBar2.Maximum = 0;
            hpBar2.Value = 0;
            atkLabel2.Text = "";
            defLabel2.Text = "";
        }

        private void listBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idx = listBox.SelectedIndex;
            if (idx > -1)
            {
                monster m = dbmons[idx];
                listDetails(m);
            }
        }

        private void randomButton_Click(object sender, EventArgs e)
        {
            int idx = battleBox.SelectedIndex;
            int spawn = r.Next(1, 3);

            if (idx > -1)
            {
                historyRtb.Clear();
                monster mymons = dbmons[idx];
                mymons.Hp = mymons.Maxhp;
                enemy = new monster();

                if (spawn == 1) battleDetails(enemy);
                else if (spawn == 2)
                {
                    enemy.evolve();
                    battleDetails(enemy);
                }
                statPlayer(mymons);
                statEnemy(enemy);
                groupBox4.Enabled = true;
                groupBox5.Enabled = true;
            }
            else MessageBox.Show("Pilih monster dulu!");
        }

        private void battleButton_Click(object sender, EventArgs e)
        {
            int idx = battleBox.SelectedIndex;
            int turn = r.Next(1, 3);
            monster mymons = dbmons[idx];
            
            if (enemy.Hp > 0)
            {
                if (turn == 1)
                {
                    mymons.myAttack(enemy, historyRtb);
                    enemy.eAttack(mymons, historyRtb);
                    statPlayer(mymons);
                    statEnemy(enemy);
                }
                else if (turn == 2)
                {
                    enemy.eAttack(mymons, historyRtb);
                    mymons.myAttack(enemy, historyRtb);
                    statEnemy(enemy);
                    statPlayer(mymons);
                }

                if (enemy.Hp <= 0)
                {
                    victory(mymons);
                }
                else if (mymons.Hp <= 0)
                {
                    defeated(mymons);
                }
            }
            else MessageBox.Show("Tidak ada musuh!");
        }
    }
}
