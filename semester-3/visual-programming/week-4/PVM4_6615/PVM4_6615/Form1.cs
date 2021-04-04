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

namespace PVM4_6615
{
    public partial class Form1 : Form
    {
        Random r = new Random();
        int xmouse= 0, ymouse= 0;
        int score = 0;
        Rectangle scoreBox;
        Timer tuniversal = new Timer();
        Timer tfood = new Timer();
        snake player;
        List<snake> enemies;
        List<food> foods;
        bool move = false;
        bool gameover = false;
        public Form1()
        {
            InitializeComponent();
            setLayer();
            scoreBox = new Rectangle(this.Width - 100, 0, 150, 60);
            player = new snake();
            enemies = new List<snake>();
            foods = new List<food>();
            this.MouseMove += Form1_MouseMove;
            this.Paint += Form1_Paint;
            tuniversal.Tick += Tuniversal_Tick;
            spawnFood();
            spawnSnakes();
            tuniversal.Start();
        }
        private void setLayer()
        {
            this.DoubleBuffered = true;
            this.MaximizeBox = false;
            this.WindowState = FormWindowState.Maximized;
            this.BackgroundImage = Image.FromFile("bg.jpg");
        }
        private void tableScore(Graphics g)
        {
            Font f = new Font(FontFamily.GenericMonospace, 40, FontStyle.Regular);
            Brush b = new SolidBrush(Color.IndianRed);
            Point p = new Point(this.Width - 200, 0);
            g.DrawString(score.ToString(), f, b, p);
        }
        private void spawnFood()
        {
            tfood.Interval = 1500;
            tfood.Tick += (s, e) => 
            {
                food ftemp = new food(this.Width, this.Height);
                foods.Add(ftemp);
                this.Refresh();
            };
            tfood.Start();
        }
        private void spawnSnakes()
        {
            for (int i = 0; i < 5; i++)
            {
                int x = r.Next(this.Width - 100);
                int y = r.Next(this.Height - 100);
                snake etemp = new snake(x, y);
                enemies.Add(etemp);
                this.Refresh();
            }
        }
        private void movePlayer()
        {
            if (move == true)
            {
                for (int i = player.Body.Count - 1; i > 0; i--)
                {
                    player.Body[i] = player.Body[i - 1];
                }
                move = false;
            }
            player.Body[0] = new Rectangle(xmouse, ymouse, 30, 30);
            player.eat(foods, ref score);
            for (int i = 0; i < enemies.Count; i++)
            {
                player.die(enemies[i], ref gameover);
            }
            if (gameover == true)
            {
                tuniversal.Stop();
                tfood.Stop();
                MessageBox.Show("Game Over!" + "\n" + "Score: " + score);
            }
        }
        private void moveSnakes()
        {
            for (int i = 0; i < enemies.Count; i++)
            {
                int rmove = r.Next(1, 5);
                enemies[i].moveSnakes(rmove, this.Width - 100, this.Height - 100);
                enemies[i].snakesEat(foods, rmove);
                if (enemies[i].collideWithPlayer(player) == true)
                {
                    if (gameover == false)
                    {
                        score += 100;
                        int x = r.Next(this.Width - 100);
                        int y = r.Next(this.Height - 100);
                        enemies.RemoveAt(i);
                        enemies.Add(new snake(x, y));
                    } 
                }
            }
            for (int i = 0; i < enemies.Count; i++)
            {
                for (int j = 0; j < enemies.Count; j++)
                {
                    if (i != j)
                    {
                        if (enemies[i].canibal(enemies[j]) == true)
                        {
                            int x = r.Next(this.Width - 100);
                            int y = r.Next(this.Height - 100);
                            enemies.RemoveAt(i);
                            enemies.Add(new snake(x, y));
                        }
                    }
                }
            }
        }
        private void Tuniversal_Tick(object sender, EventArgs e)
        {
            tuniversal.Interval = 100;
            movePlayer();
            moveSnakes();
            this.Refresh();
        }
        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            move = true;
            xmouse = e.X;
            ymouse = e.Y;
        }
        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            tableScore(g);
            player.draw(g);
            if (foods.Count > 0)
            {
                for (int i = 0; i < foods.Count; i++)
                {
                    foods[i].draw(g);
                }
            }
            if (enemies.Count > 0)
            {
                for (int i = 0; i < enemies.Count; i++)
                {
                    enemies[i].drawSnakes(g);
                }
            }
        }
    }
}
