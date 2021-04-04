using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;

namespace cLibrary
{
    public class player
    {
        private string name;
        private int score;
        private Button icon;
        private Color color;
        public player(string name, Color color)
        {
            this.name = name;
            this.score = 0;
            this.color = color;
            this.icon = new Button();
            this.icon.Location = new Point(10, 10);
            this.icon.Size = new Size(30, 30);
            this.icon.BackColor = this.color;
        }
        public string Name
        {
            set { this.name = value; }
            get { return this.name; }
        }
        public int Score
        {
            set { this.score = value; }
            get { return this.score; }
        }
        public Button Icon
        {
            set { this.icon = value; }
            get { return this.icon; }
        }
        public Color Color
        {
            set { this.color = value; }
            get { return this.color; }
        }
    }
}
