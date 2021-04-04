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

namespace PVM5_6615
{
    public partial class mainForm : Form
    {
        Random r = new Random();
        int numb = 0;
        Timer gametime = new Timer();
        dataForm df;
        player p1, p2;
        pForm p1f, p2f;
        List<Button> obs;
        List<food> foods;

        public mainForm()
        {
            InitializeComponent();
            setLayer();
            p1f = new pForm();
            p2f = new pForm();
            obs = new List<Button>();
            foods = new List<food>();
            this.KeyDown += MainForm_KeyDown;
            gametime.Tick += Gametime_Tick;
            gametime.Interval = 1000;
        }
        private void setLayer()
        {
            this.Text = "Player VS Player";
            this.IsMdiContainer = true;
            this.DoubleBuffered = true;
            this.KeyPreview = true;
            this.WindowState = FormWindowState.Maximized;
        }
        public void getData(string n1, string n2, Color c1, Color c2)
        {
            p1 = new player(n1, c1);
            p2 = new player(n2, c2);
        }
        private void makeP1()
        {
            p1f.Text = "Name Player: " + p1.Name;
            p1f.MdiParent = this;
            p1f.updateScore(p1);
            p1f.spawnPlayer(p1, p2);
            for (int i = 0; i < 10; i++)
            {
                int rtype = r.Next(1, 4);
                int x = r.Next(this.Width);
                int y = r.Next(this.Height);
                food ftemp = new food(rtype, x + 100, y - 100);
                foods.Add(ftemp);
            }
            p1f.spawnFood(foods);
            p1f.createMap(obs);
            p1f.Show();
        }
        private void makeP2()
        {
            p2f.Text = "Name Player: " + p2.Name;
            p2f.MdiParent = this;
            p2f.updateScore(p2);
            p2f.spawnPlayer(p1, p2);
            for (int i = 0; i < 10; i++)
            {
                int rtype = r.Next(1, 4);
                int x = r.Next(this.Width);
                int y = r.Next(this.Height);
                food ftemp = new food(rtype, x + 100, y - 100);
                foods.Add(ftemp);
            }
            p2f.spawnFood(foods);
            p2f.createMap(obs);
            p2f.Show();
        }
        public void startGame()
        {
            makeP1();
            makeP2();
            p2f.Left = (p1f.Left + p1f.Width) + 100;
            p2f.Top = p1f.Top;
            gametime.Start();
            df.Close();
        }
        private void Gametime_Tick(object sender, EventArgs e)
        {
            numb++;
            if (numb % 10 == 0)
            {
                p1f.spawnFood(foods);
                p2f.spawnFood(foods);
            }
            if (numb == 120)
            {
                gametime.Stop();
                MessageBox.Show("GAME BERAKHIR!");
            }
        }
        private void MainForm_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.W)
            {
                Keys temp = Keys.W;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.A)
            {
                Keys temp = Keys.A;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.S)
            {
                Keys temp = Keys.S;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.D)
            {
                Keys temp = Keys.D;
                p1f.move(temp);
                p2f.move(temp);
            }

            if (e.KeyCode == Keys.Up)
            {
                Keys temp = Keys.Up;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.Left)
            {
                Keys temp = Keys.Left;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.Down)
            {
                Keys temp = Keys.Down;
                p1f.move(temp);
                p2f.move(temp);
            }
            else if (e.KeyCode == Keys.Right)
            {
                Keys temp = Keys.Right;
                p1f.move(temp);
                p2f.move(temp);
            }
        }
        private void startToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (df == null) df = new dataForm();
            df.MdiParent = this;
            df.Show();
        }
        private void highscoreToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
