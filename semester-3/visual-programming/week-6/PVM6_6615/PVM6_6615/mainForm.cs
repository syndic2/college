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

namespace PVM6_6615
{
    public partial class mainForm : Form
    {
        Random r = new Random();
        int numb = 0, pressed = 0, happy = 0;
        Timer tmove = new Timer();
        Timer tenemy = new Timer();
        Timer tdialog = new Timer();
        Timer temote = new Timer();
        Label box;
        obj player, chest;
        obj npc1, npc2, npc3, m1, m2, m3;
        Panel game;
        bool talk1 = false, talk2 = false, talk3 = false;
        bool up = false, down = false, left = false, right = false, get = false;
        public mainForm()
        {
            InitializeComponent();
            setLayer();
            gameLayer();
            tdialog.Interval = 100;
            temote.Interval = 500;
            tmove.Interval = 100;
            tenemy.Interval = 1000;
        }
        private void setLayer()
        {
            this.MaximizeBox = false;
            this.Text = "RPG";
            this.WindowState = FormWindowState.Maximized;
            menuStrip1.BackColor = Color.Green;
        }
        private void gameLayer()
        {
            game = new Panel();
            game.Size = new Size(800, 600);
            game.Location = new Point(290, 60);
            game.BackColor = Color.Silver;
            game.BackgroundImage = Image.FromFile("map/village.jpg");
            game.Hide();
            this.Controls.Add(game);
        }
        private void dialogBox(obj npc)
        {
            box = new Label();
            box.BackColor = Color.White;
            box.Size = new Size(200, 50);
            box.Location = new Point(npc.Icon.Left + npc.Icon.Width, npc.Icon.Top);
            game.Controls.Add(box);
        }
        private void createNPC()
        {
            npc1 = new obj("npc1");
            npc2 = new obj("npc2");
            npc3 = new obj("npc3");

            npc1.Icon.Location = new Point(120, 200);
            npc2.Icon.Location = new Point(440, 50);
            npc3.Icon.Location = new Point(600, 400);

            game.Controls.Add(npc1.Icon);
            game.Controls.Add(npc2.Icon);
            game.Controls.Add(npc3.Icon);
        }
        private void createMons()
        {
            int rlocate = r.Next(1, 4);
            m1 = new obj("monster");
            m2 = new obj("monster");
            m3 = new obj("monster");

            if (rlocate == 1)
            {
                m1.Icon.Location = new Point(570, 120);
                m2.Icon.Location = new Point(250, 280);
                m3.Icon.Location = new Point(300, 550);
            }
            else if (rlocate == 2)
            {
                m1.Icon.Location = new Point(570, 150);
                m2.Icon.Location = new Point(150, 70);
                m3.Icon.Location = new Point(300, 300);
            }
            else if (rlocate == 3)
            {
                m1.Icon.Location = new Point(100, 550);
                m2.Icon.Location = new Point(480, 500);
                m3.Icon.Location = new Point(550, 300);
            }
            game.Controls.Add(m1.Icon);
            game.Controls.Add(m2.Icon);
            game.Controls.Add(m3.Icon);
        }
        private void createChest()
        {
            chest = new obj("chest");
            chest.Icon.Location = new Point(500, 500);
            game.Controls.Add(chest.Icon);
        }
        int other = 0;
        private void moveMons()
        {
            int dir = r.Next(1, 5);
            tenemy.Tick += (s, e) =>
            {
                if (dir == 1)
                {
                    m1.Icon.Top -= 50;
                    m1.Icon.Image = m1.Icons[0, 0].Image;
                    m2.Icon.Top += 50;
                    m2.Icon.Image = m2.Icons[1, 0].Image;
                    m3.Icon.Left += 40;
                    m3.Icon.Image = m3.Icons[3, 0].Image;
                }
                else if (dir == 2)
                {
                    m1.Icon.Left -= 40;
                    m1.Icon.Image = m1.Icons[2, 0].Image;
                    m2.Icon.Top += 50;
                    m2.Icon.Image = m2.Icons[1, 0].Image;
                    m3.Icon.Left += 40;
                    m3.Icon.Image = m3.Icons[3, 0].Image;
                }
                else if (dir == 3)
                {
                    m1.Icon.Left -= 40;
                    m1.Icon.Image = m1.Icons[2, 0].Image;
                    m2.Icon.Left += 40;
                    m2.Icon.Image = m2.Icons[3, 2].Image;
                    m3.Icon.Top -= 50;
                    m3.Icon.Image = m3.Icons[0, 0].Image;
                }
                else if (dir == 4)
                {
                    m1.Icon.Top -= 50;
                    m1.Icon.Image = m1.Icons[0, 0].Image;
                    m2.Icon.Left += 40;
                    m2.Icon.Image = m2.Icons[3, 0].Image;
                    m3.Icon.Top += 50;
                    m3.Icon.Image= m3.Icons[1, 0].Image;
                }
            };
            tenemy.Start();
        }
        private void goForrest()
        {
            if (player.Icon.Top >= game.Height - player.Icon.Height && 
               (player.Icon.Left >= 350 && player.Icon.Left <=500))
            {
                game.Controls.Remove(npc1.Icon);
                game.Controls.Remove(npc2.Icon);
                game.Controls.Remove(npc3.Icon);
                npc1 = null;
                npc2 = null;
                npc3 = null;
                game.BackgroundImage = Image.FromFile("map/forrest.png");
                player.Icon.Location = new Point(100, 100);
                createChest();
                createMons();
                moveMons();
            }
        }
        private void talkWithNPC()
        {
            if (npc1 != null && npc2 != null && npc3 != null) 
            {
                if (player.Icon.Left == npc1.Icon.Left - 40 || player.Icon.Left == npc1.Icon.Left + 40)
                {
                    dialogBox(npc1);
                    talk1 = true;
                    talk2 = false;
                    talk3 = false;
                }
                else if (player.Icon.Top == npc2.Icon.Top + 50 || player.Icon.Top == npc2.Icon.Top - 50 ||
                         player.Icon.Left == npc2.Icon.Left + 40 || player.Icon.Left == npc2.Icon.Left - 40)
                {
                    dialogBox(npc2);
                    talk2 = true;
                    talk1 = false;
                    talk3 = false;
                }
                else if (player.Icon.Top == npc3.Icon.Top + 50 || player.Icon.Top == npc3.Icon.Top - 50 ||
                         player.Icon.Left == npc3.Icon.Left + 40 || player.Icon.Left == npc3.Icon.Left - 40)
                {
                    dialogBox(npc3);
                    talk3 = true;
                    talk1 = false;
                    talk2 = false;
                }
            }
        }
        private void getFaint()
        {
            if (m1 != null && m2 != null && m3 != null)
            {
                if (player.Icon.Bounds.IntersectsWith(m1.Icon.Bounds) || player.Icon.Bounds.IntersectsWith(m2.Icon.Bounds) ||
                    player.Icon.Bounds.IntersectsWith(m3.Icon.Bounds))
                {
                    tmove.Stop();
                    player.Icon.Image = player.Faint.Image;
                    player.Icon.Location = new Point(100, 100);
                }
            }
        }
        private void getChest()
        {
            if (chest != null)
            {
                if (player.Icon.Top == chest.Icon.Top + 50 || player.Icon.Top == chest.Icon.Top - 50 ||
                     player.Icon.Left == chest.Icon.Left + 40 || player.Icon.Left == chest.Icon.Left - 40)
                {
                    get = true;
                    happy++;
                }
            }
        }
        private void startGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            player = new obj("player");
            createNPC();
            game.Show();
            game.Controls.Add(player.Icon);
            tdialog.Tick += Tdialog_Tick;
            temote.Tick += Temote_Tick;
            tmove.Tick += Tmove_Tick;
            this.KeyDown += MainForm_KeyDown;
        }
        private void resumeGameToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Do you want to quit?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                this.Close();
            }
        }
        int ctr1 = 0, ctr2= 0, ctr3= 0;
        private void Tdialog_Tick(object sender, EventArgs e)
        {
            if (talk1 == true)
            {
                ctr1++;
                if (ctr1 < npc1.Dialog.Length)
                {
                    if (pressed <= 1) box.Text = npc1.Dialog.Substring(0, ctr1);
                    else if (pressed > 1)
                    {
                        tdialog.Stop();
                        ctr1 = 0;
                        box.Text = "";
                        box.Text = npc1.Dialog;
                    }
                }
                else
                {
                    pressed = 0;
                    ctr1 = 0;
                    game.Controls.Remove(box);
                    tdialog.Stop();
                }
            }
            if (talk2 == true)
            {
                ctr2++;
                if (ctr2 < npc2.Dialog.Length)
                {
                    if (pressed <= 1) box.Text = npc2.Dialog.Substring(0, ctr2);
                    else if (pressed > 1)
                    {
                        tdialog.Stop();
                        ctr2 = 0;
                        box.Text = "";
                        box.Text = npc2.Dialog;
                    }
                }
                else
                {
                    pressed = 0;
                    ctr2 = 0;
                    game.Controls.Remove(box);
                    tdialog.Stop();
                }
            }
            if (talk3 == true)
            {
                ctr3++;
                if (ctr3 < npc3.Dialog.Length)
                {
                    if (pressed <= 1) box.Text = npc3.Dialog.Substring(0, ctr3);
                    else if (pressed > 1)
                    {
                        tdialog.Stop();
                        ctr3 = 0;
                        box.Text = "";
                        box.Text = npc3.Dialog;
                    }
                }
                else
                {
                    pressed = 0;
                    ctr3 = 0;
                    game.Controls.Remove(box);
                    tdialog.Stop();
                }
            }
        }

        private void Temote_Tick(object sender, EventArgs e)
        {
            if (get == true)
            {
                if (happy % 1 == 0) player.Icon.Image = player.Emote[0].Image;
                if (happy % 2 == 0) player.Icon.Image = player.Emote[1].Image;
            }
        }

        private void Tmove_Tick(object sender, EventArgs e)
        {
            if (up == true)
            {
                if (numb % 1 == 0) player.Icon.Image = player.Icons[0, 0].Image;
                if (numb % 2 == 0) player.Icon.Image = player.Icons[0, 2].Image;
            }
            if (down == true)
            {
                if (numb % 1 == 0) player.Icon.Image = player.Icons[1, 0].Image;
                if (numb % 2 == 0) player.Icon.Image = player.Icons[1, 2].Image;
            }
            if (left == true)
            {
                if (numb % 1 == 0) player.Icon.Image = player.Icons[2, 0].Image;
                if (numb % 2 == 0) player.Icon.Image = player.Icons[2, 2].Image;
            }
            if (right == true)
            {
                if (numb % 1 == 0) player.Icon.Image = player.Icons[3, 0].Image;
                if (numb % 2 == 0) player.Icon.Image = player.Icons[3, 2].Image;
            }
        }
        private void MainForm_KeyDown(object sender, KeyEventArgs e)
        {
            tmove.Start();
            if (e.KeyCode == Keys.W)
            {
                player.Icon.Top -= 50;
                up = true;
                down = false;
                left = false;
                right = false;
                numb++;
            }
            else if (e.KeyCode == Keys.A)
            {
                player.Icon.Left -= 40;
                left = true;
                up = false;
                down = false;
                right = false;
                numb++;
            }
            else if (e.KeyCode == Keys.S)
            {
                player.Icon.Top += 50;
                down = true;
                up = false;
                left = false;
                right = false;
                numb++;
            }
            else if (e.KeyCode == Keys.D)
            {
                player.Icon.Left += 40;
                right = true;
                up = false;
                down = false;
                left = false;
                numb++;
            }
            else if (e.KeyCode == Keys.Space)
            {
                tdialog.Start();
                temote.Start();
                talkWithNPC();
                getChest();
                pressed++;
            }
            goForrest();
            getFaint();
            getChest();
        }
    }
}
