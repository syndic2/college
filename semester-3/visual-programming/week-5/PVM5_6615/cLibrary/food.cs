using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Windows.Forms;

namespace cLibrary
{
    public class food
    {
        private string type;
        private int val;
        private Color color;
        private Button icon;
        public food(int rtype, int x, int y)
        {
            if (rtype == 1)
            {
                this.type = "Red";
                this.val = 25;
                this.color = Color.Red;
                this.icon = new Button();
                this.icon.Location = new Point(x, y);
                this.icon.Size = new Size(30, 30);
                this.icon.BackColor = this.color;
            }
            else if (rtype == 2)
            {
                this.type = "Yellow";
                this.val = 50;
                this.color = Color.Yellow;
                this.icon = new Button();
                this.icon.Location = new Point(x, y);
                this.icon.Size = new Size(30, 30);
                this.icon.BackColor = this.color;
            }
            else if (rtype == 3)
            {
                this.type = "Green";
                this.val = 100;
                this.color = Color.Green;
                this.icon = new Button();
                this.icon.Location = new Point(x, y);
                this.icon.Size = new Size(30, 30);
                this.icon.BackColor = this.color;
            }
        }
        public string Type
        {
            set { this.type = value; }
            get { return this.type; }
        }
        public int Val
        {
            set { this.val = value; }
            get { return this.val; }
        }
        public Color Color
        {
            set { this.color = value; }
            get { return this.color; }
        }
        public Button Icon
        {
            set { this.icon = value; }
            get { return this.icon; }
        }
    }
}
