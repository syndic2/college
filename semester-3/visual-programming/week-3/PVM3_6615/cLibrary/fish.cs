using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cLibrary
{
    public class fish
    {
        Random r = new Random();
        private string type;
        private int x, y;
        private int score;
        private int ctrsmall;
        private int ctrmedium;

        public fish(int x, int y)
        {
            this.type = "small";
            this.score = 0;
            this.x = x;
            this.y = y;
            this.ctrsmall = 0;
            this.ctrmedium = 0;
        }

        public fish(string type)
        {
            if (type == "small")
            {
                int x = r.Next(1, 800);
                int y = r.Next(1, 400);
                this.type = type;
                this.x = x;
                this.y = y;
            }
            else if (type == "medium")
            {
                int x = r.Next(1, 800);
                int y = r.Next(1, 400);
                this.type = type;
                this.x = x;
                this.y = y;
            }
            else if (type == "big")
            {
                int x = r.Next(1, 800);
                int y = r.Next(1, 400);
                this.type = type;
                this.x = x;
                this.y = y;
            }
            else if (type == "whale")
            {
                int x = r.Next(1, 800);
                int y = r.Next(1, 400);
                this.type = type;
                this.x = x;
                this.y = y;
            }
            else if (type == "powerup")
            {
                int x = r.Next(1, 800);
                int y = r.Next(1, 400);
                this.type = type;
                this.x = x;
                this.y = y;
            }
        }

        public string Type
        {
            set { this.type = value; }
            get { return this.type; }
        }

        public int Score
        {
            set { this.score = value; }
            get { return this.score; }
        }
        public int X
        {
            set { this.x = value; }
            get { return this.x; }
        }

        public int Y
        {
            set { this.y = value; }
            get { return this.y; }
        }

        public int Ctrsmall
        {
            set { this.ctrsmall = value; }
            get { return this.ctrsmall; }
        }

        public int Ctrmedium
        {
            set { this.ctrmedium = value; }
            get { return this.ctrmedium; }
        }
    }
}
