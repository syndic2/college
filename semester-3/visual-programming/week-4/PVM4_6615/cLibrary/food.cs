using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace cLibrary
{
    public class food
    {
        Random r = new Random();
        private int x, y;
        private string type;
        private Brush brush;
        private Color color;
        private Rectangle shape;
        public food(int w, int h)
        {
            this.x = r.Next(w);
            this.y = r.Next(h);
            this.color = Color.FromArgb(r.Next(256), r.Next(256), r.Next(256));
            this.brush = new SolidBrush(this.color);
            int rfood = r.Next(1, 4);
            if (rfood == 1)
            {
                this.type = "small";
                this.shape = new Rectangle(this.x - 100, this.y - 100, 20, 20);
            }
            else if (rfood == 2)
            {
                this.type = "medium";
                this.shape = new Rectangle(this.x, this.y, 30, 30);
            }
            else if (rfood == 3)
            {
                this.type = "big";
                this.shape = new Rectangle(this.x, this.y, 40, 40);
            }
        }

        public void draw(Graphics g)
        {
            g.FillEllipse(this.brush, this.shape);
        }
        public String Type
        {
            set { this.type = value; }
            get { return this.type; }
        }
        public Rectangle Shape
        {
            set { this.shape = value; }
            get { return this.shape; }
        }
    }
}
