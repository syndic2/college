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

namespace PVM1_6615
{
    public partial class Form1 : Form
    {
        Random r = new Random();
        int gold = 1000;
        int totalmons = 0;
        List<monster> dbmons;
        
        public Form1()
        {
            InitializeComponent();
            dbmons = new List<monster>();
            resource();
        }

        private void refresh()
        {
            newName.Clear();
            breedName.Clear();
        }

        private void resource()
        {
            moneyLabel.Text = gold.ToString();
            totalLabel.Text = totalmons.ToString();
        }

        private void newMons(monster m)
        {
            dbmons.Add(m);
            sellBox.Items.Add(m);
            detailBox.Items.Add(m);
            breedBox1.Items.Add(m);
            breedBox2.Items.Add(m);
            battleBox.Items.Add(m);
            resource();
        }

        private void sellMons(monster m)
        {
            sellBox.SelectedIndex = -1;
            dbmons.Remove(m);
            sellBox.Items.Remove(m);
            detailBox.Items.Remove(m);
            breedBox1.Items.Remove(m);
            breedBox2.Items.Remove(m);
            battleBox.Items.Remove(m);
            resource();
        }

        private void statsBattle(monster mymons, monster enemy)
        {
            if (mymons.Element.Count == 1)
            {
                battleList.Items.Add(mymons + " (" + mymons.Element[0] + ")");
            }
            else if (mymons.Element.Count == 2)
            {
                battleList.Items.Add(mymons + " (" + mymons.Element[0] + " - " + mymons.Element[1] + ")");
            }
            battleList.Items.Add("HP    : " + mymons.Hp);
            battleList.Items.Add("ATK   : " + mymons.Minatk + "-" + mymons.Maxatk);
            battleList.Items.Add("----------------------------------------------");
            battleList.Items.Add(enemy + " (" + enemy.Enemyele + ")");
            battleList.Items.Add("HP    : " + enemy.Hp);
            battleList.Items.Add("ATK   : " + enemy.Minatk + "-" + enemy.Maxatk);
        }

        private void victory(monster mymons)
        {
            int wingold = r.Next(200, 300);
            gold += wingold;
            mymons.Exp += 10;
            battleList.Items.Add("Victory! Player get " + wingold + " gold");
            resource();

            if (mymons.Exp >= mymons.Maxexp)
            {
                mymons.Maxhp += 10;
                mymons.Hp = mymons.Maxhp;
                mymons.Minatk += 5;
                mymons.Maxatk += 5;
                mymons.Exp = 0;
                mymons.Level += 1;
                mymons.Maxexp = mymons.Level * 10;
                battleList.Items.Add("Level up!");
                battleList.Items.Add("----------------------------------------------");
                battleList.Items.Add("ATK: " + mymons.Minatk + "-" + mymons.Maxatk);
                battleList.Items.Add("HP: " + mymons.Hp + "/" + mymons.Maxhp);
                battleList.Items.Add("Level: " + mymons.Level);
                battleList.Items.Add("EXP: " + mymons.Exp + "/" + mymons.Maxexp);
                battleList.Items.Add("----------------------------------------------");
            }
        }

        private void defeated(monster mymons)
        {
            dbmons.Remove(mymons);
            sellBox.Items.Remove(mymons);
            detailBox.Items.Remove(mymons);
            breedBox1.Items.Remove(mymons);
            breedBox2.Items.Remove(mymons);
            battleBox.SelectedIndex = -1;
            battleBox.Items.Remove(mymons);
            battleList.Items.Add("Defeated!");
            resource();
        }

        private void buyButton_Click(object sender, EventArgs e)
        {
            if (newName.Text != "" && typeBox.SelectedIndex != -1)
            {
                if (gold >= 500)
                {
                    int idx = typeBox.SelectedIndex;
                    string name = newName.Text;
                    string element = typeBox.Items[idx].ToString();

                    monster m = new monster(name, element);
                    gold -= 500;
                    totalmons += 1;
                    newMons(m);
                    refresh();
                    typeBox.SelectedIndex = -1;
                }
                else
                {
                    MessageBox.Show("Not enough money!");
                }
            }
            else
            {
                MessageBox.Show("Data still empty!");
            }
        }

        private void sellButton_Click(object sender, EventArgs e)
        {
            if (sellBox.Items.Count > 0)
            {
                int idx = sellBox.SelectedIndex;
                monster m = dbmons[idx];

                if (m.Element.Count == 1)
                {
                    gold += 200;
                    totalmons -= 1;
                    sellMons(m);
                    MessageBox.Show("Got 200G!");
                }
                else if (m.Element.Count == 2)
                {
                    gold += 450;
                    totalmons -= 1;
                    sellMons(m);
                    MessageBox.Show("Got 450G!");
                }
            }
            else
            {
                MessageBox.Show("You don't have any monster!");
            }
        }

        private void detailBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idx = detailBox.SelectedIndex;
            monster m = dbmons[idx];

            if (m.Element.Count == 1)
            {
                typeLabel.Text = m.Element[0];
            }
            else
            {
                typeLabel.Text = m.Element[0] + " - " + m.Element[1];
            }

            if (m.Parent1 != null && m.Parent2 != null)
            {
                parentLabel.Text = m.Parent1 + " - " + m.Parent2;
            }
            else
            {
                parentLabel.Text = "-";
            }

            atkLabel.Text = m.Minatk.ToString() + "-" + m.Maxatk.ToString();
            hpLabel.Text = m.Hp.ToString() + "/" + m.Maxhp.ToString();
            levelLabel.Text = m.Level.ToString();
            explabel.Text = m.Exp.ToString() + "/" + m.Maxexp.ToString();
        }

        private void breedButton_Click(object sender, EventArgs e)
        {
            if (breedBox1.Items.Count > 0 && breedBox2.Items.Count > 0 && breedName.Text != "")
            {
                int idx1 = breedBox1.SelectedIndex;
                int idx2 = breedBox2.SelectedIndex;
                string name = breedName.Text;
                monster parent1 = (monster) breedBox1.Items[idx1];
                monster parent2 = (monster) breedBox2.Items[idx2];
                monster child = new monster(name, parent1, parent2);
                gold += 250;
                totalmons += 1;
                newMons(child);
                refresh();
                MessageBox.Show("Breed succes!");
                MessageBox.Show("Got 250G!");
            }
            else
            {
                MessageBox.Show("You don't have enough monster to breed!");
            }
        }

        private void battleButton_Click(object sender, EventArgs e)
        {
            int idx = battleBox.SelectedIndex;
            if (battleBox.Items.Count > 0 && idx > -1)
            {
                battleList.Items.Clear();
                monster mymons = dbmons[idx];
                monster enemy = new monster();
                mymons.Hp = mymons.Maxhp;

                do
                {
                    statsBattle(mymons, enemy);
                    if (mymons.Hp > 0)
                    {
                        mymons.myAttack(enemy, battleList);
                    }
                    battleList.Items.Add("\n");
                    statsBattle(mymons, enemy);
                    if (enemy.Hp > 0)
                    {
                        enemy.eAttack(mymons, battleList);
                    }
                    battleList.Items.Add("\n");
                } while (mymons.Hp > 0 && enemy.Hp > 0);
                
                if (enemy.Hp <= 0)
                {
                    enemy.Hp = 0;
                    victory(mymons);
                }
                else if (mymons.Hp <= 0)
                {
                    mymons.Hp = 0;
                    totalmons -= 1;
                    defeated(mymons);
                }
            }
            else
            {
                MessageBox.Show("You don't have any monster!");
            }
        }

        private void breedBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (breedBox1.SelectedIndex > -1)
            {
                breedBox2.Items.Clear();
                for (int i = 0; i < dbmons.Count; i++)
                {
                    breedBox2.Items.Add(dbmons[i]);
                }
                breedBox2.Items.RemoveAt(breedBox1.SelectedIndex);
            }
        }
    }
}
