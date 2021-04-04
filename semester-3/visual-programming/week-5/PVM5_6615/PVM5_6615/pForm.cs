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
    public partial class pForm : Form
    {
        Random r = new Random();
        Button player1, player2;
        player fp1;
        player fp2;
        List<Button> foodform = new List<Button>();
        public pForm()
        {
            InitializeComponent();
            setLayer();
            this.Enabled = false;
        }
        private void setLayer()
        {
            this.Width = 450;
            this.Height = 450;
            this.MinimizeBox = false;
            this.MaximizeBox = false;
        }
        public void spawnPlayer(player p1, player p2)
        {
            p1.Icon = new Button();
            p1.Icon.Size = new Size(30, 30);
            p1.Icon.Location = new Point(10, 10);
            p1.Icon.BackColor = p1.Color;
            fp1 = p1;
            player1 = p1.Icon;
            this.Controls.Add(player1);

            p2.Icon = new Button();
            p2.Icon.Size = new Size(30, 30);
            p2.Icon.Location = new Point(40, 10);
            p2.Icon.BackColor = p2.Color;
            fp2 = p2;
            player2 = p2.Icon;
            this.Controls.Add(player2);
        }
        public void spawnFood(List<food> foods)
        {
            foods = new List<food>();
            for (int i = 0; i < 10; i++)
            {
                int rtype = r.Next(1, 4);
                int x = r.Next(this.Width);
                int y = r.Next(this.Height);
                food ftemp = new food(rtype, x + 100, y - 100);
                foods.Add(ftemp);
            }
            for (int i = 0; i < foods.Count; i++)
            {
                foodform.Add(foods[i].Icon);
            }
            for (int i = 0; i < foodform.Count; i++)
            {
                this.Controls.Add(foodform[i]);
            }
        }
        public void createMap(List<Button> obs)
        {
            obs = new List<Button>();
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    Button btemp = new Button();
                    btemp.Size = new Size(30, 30);
                    btemp.Location = new Point(50 + (i * 60), 40 + (j * 60));
                    obs.Add(btemp);
                }
            }

            for (int i = 0; i < obs.Count; i++)
            {
                this.Controls.Add(obs[i]);
            }
        }
        public void updateScore(player p)
        {
            scoreLabel.Location = new Point(this.Width - 50, 0);
            scoreLabel.Text = p.Score.ToString();
        }
        public void move(Keys k)
        {
            if (k == Keys.W)
            {
                player1.Top -= 30;
                eat(player1);
            }
            else if (k == Keys.A)
            {
                player1.Left -= 30;
                eat(player1);
            }
            else if (k == Keys.S)
            {
                player1.Top += 30;
                eat(player1);
            }
            else if (k == Keys.D)
            {
                player1.Left += 30;
                eat(player1);
            }

            if (k == Keys.Up)
            {
                player2.Top -= 30;
                eat(player2);
            }
            else if (k == Keys.Left)
            {
                player2.Left -= 30;
                eat(player2);
            }
            else if (k == Keys.Down)
            {
                player2.Top += 30;
                eat(player2);
            }
            else if (k == Keys.Right)
            {
                player2.Left += 30;
                eat(player2);
            }
        }
        public void eat(Button player)
        {
            for (int i = 0; i < foodform.Count; i++)
            {
                if ((player.Location.X + player.Width) >= (foodform[i].Location.X) &&
                    player.Location.X <= (foodform[i].Location.X + foodform[i].Width) &&
                    (player.Location.Y + player.Height) >= foodform[i].Location.Y &&
                    player.Location.Y <= (foodform[i].Location.Y + foodform[i].Height))
                {
                    this.Controls.Remove(foodform[i]);
                }
            }
        }
    }
}
