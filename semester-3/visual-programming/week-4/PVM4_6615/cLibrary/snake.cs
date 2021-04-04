using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace cLibrary
{
    public class snake
    {
        Random r = new Random();
        private int tailsize;
        private int x, y;
        private Brush brush;
        private Color color;
        private List<Rectangle> body = new List<Rectangle>();
        public snake()
        {
            this.tailsize = 1;
            for (int i = 0; i < this.tailsize; i++)
            {
                Rectangle btemp = new Rectangle(this.x + (i * 30), this.y, 30, 30);
                this.body.Add(btemp);
            }
        }
        public snake(int x, int y)
        {
            this.tailsize = r.Next(3, 6);
            this.x = x;
            this.y = y;
            for (int i = 0; i < this.tailsize; i++)
            {
                Rectangle btemp = new Rectangle(this.x + (i * 30), this.y, 30, 30);
                this.body.Add(btemp);
            }
        }
        public void draw(Graphics g)
        {
            for (int i = 0; i < this.body.Count; i++)
            {
                if (i == 0)
                {
                    this.color = Color.Red;
                    this.brush = new SolidBrush(this.color);
                }
                else
                {
                    this.color = Color.Green;
                    this.brush = new SolidBrush(this.color);
                }
                g.FillEllipse(this.brush, this.body[i]);
            }
        }
        public void drawSnakes(Graphics g)
        {
            for (int i = 0; i < this.body.Count; i++)
            {
                if (i == 0)
                {
                    this.color = Color.Red;
                    this.brush = new SolidBrush(this.color);
                }
                else
                {
                    this.color = Color.Blue;
                    this.brush = new SolidBrush(this.color);
                }
                g.FillEllipse(this.brush, this.body[i]);
            }
        }
        public void moveSnakes(int rmove, int w, int h)
        {
            for (int i = this.body.Count - 1; i > 0; i--)
            {
                this.body[i] = this.body[i - 1];
                this.x = this.body[i].X;
                this.y = this.body[i].Y;
            }
            Rectangle head = this.body[0];
            if (rmove == 1) //kanan
            {
                this.body[0] = new Rectangle(head.X + 30, head.Y, 30, 30);
                if (perfectMove(this.body[0]) == true) this.body[0] = new Rectangle(head.X - 30, head.Y, 30, 30); 
            }
            else if (rmove == 2) //kiri
            {
                this.body[0] = new Rectangle(head.X - 30, head.Y, 30, 30);
                if (perfectMove(this.body[0]) == true) this.body[0] = new Rectangle(head.X + 30, head.Y, 30, 30);
            }
            else if (rmove == 3) //atas 
            {
                this.body[0] = new Rectangle(head.X, head.Y - 30, 30, 30);
                if (perfectMove(this.body[0]) == true) this.body[0] = new Rectangle(head.X, head.Y + 30, 30, 30);
            }
            else if (rmove == 4) //bawah
            {
                this.body[0] = new Rectangle(head.X, head.Y + 30, 30, 30);
                if (perfectMove(this.body[0]) == true) this.body[0] = new Rectangle(head.X, head.Y - 30, 30, 30);
            }
            
            if (this.body[0].X > w) this.body[0] = new Rectangle(head.X - 30, head.Y, 30, 30);
            else if (this.body[0].X < 0) this.body[0] = new Rectangle(head.X + 30, head.Y, 30, 30);
            if (this.body[0].Y > h) this.body[0] = new Rectangle(head.X, head.Y - 30, 30, 30);
            else if (this.body[0].Y < 0) this.body[0] = new Rectangle(head.X, head.Y + 30, 30, 30);
        }
        private bool perfectMove(Rectangle head)
        {
            for (int i = 0; i < this.body.Count; i++)
            {
                if (i != 0) if (head.IntersectsWith(this.body[i])) return true;
            }
            return false;
        }
        public void snakesEat(List<food> f, int direct)
        {
            for (int i = 0; i < f.Count; i++)
            {
                if (this.body[0].IntersectsWith(f[i].Shape))
                {
                    if (direct == 1) this.body.Add(new Rectangle(this.x + (this.body.Count * 30), this.y, 30, 30));
                    else if (direct == 2) this.body.Add(new Rectangle(this.x - (this.body.Count * 30), this.y, 30, 30));
                    else if (direct == 3) this.body.Add(new Rectangle(this.x, this.y - (this.body.Count * 30), 30, 30));
                    else if (direct == 4) this.body.Add(new Rectangle(this.x, this.y + (this.body.Count * 30), 30, 30));
                    f.RemoveAt(i);
                }
            }
        }
        public bool canibal(snake s)
        {
            for (int i = 0; i < s.body.Count; i++)
            {
                if (this.body[0].IntersectsWith(s.body[i])) return true;
            }
            return false;
        }
        public bool collideWithPlayer(snake p)
        {
            for (int i = 0; i < this.body.Count; i++)
            {
                for (int j = 0; j < p.body.Count; j++)
                {
                    if (this.body[i].IntersectsWith(p.body[j])) return true;
                }
            }
            return false;
        }
        public void eat(List<food> f, ref int score)
        {
            if (f.Count > 0)
            {
                for (int i = 0; i < f.Count; i++)
                {
                    if (body[0].IntersectsWith(f[i].Shape))
                    {
                        if (f[i].Type == "small") score += 20;
                        else if (f[i].Type == "medium") score += 40;
                        else if (f[i].Type == "big") score += 60;
                        f.RemoveAt(i);
                        Rectangle btemp = new Rectangle(this.x + (this.tailsize * 30), this.y, 30, 30);
                        this.body.Add(btemp);
                    }
                }
            }
        }
        public void die(snake s, ref bool ya)
        {
            for (int i = 0; i < s.body.Count; i++)
            {
                for (int j = 0; j < this.body.Count; j++)
                {
                    if (this.body[j].IntersectsWith(s.body[i]))
                    {
                        ya = true;
                    }
                }
            }
        }
        public int Tailsize
        {
            set { this.tailsize = value; }
            get { return this.tailsize; }
        }
        public Brush Brush
        {
            set { this.brush = value; }
            get { return this.brush; }
        }
        public List<Rectangle> Body
        {
            set { this.body = value; }
            get { return this.body; }
        }
    }
}
