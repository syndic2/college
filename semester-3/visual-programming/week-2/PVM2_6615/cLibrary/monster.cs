using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cLibrary
{
    public class monster
    {
        Random r = new Random();
        private string name, element;
        private int hp, maxhp;
        private int minatk, maxatk;
        private int mindef, maxdef;
        private int level;
        private int exp, maxexp;
        private bool evolved;

        public monster()
        {
            int mons = r.Next(1,4);
            int type = r.Next(1,4);
            this.evolved = false;
            if (mons == 1) this.name = "Phoenix";
            else if (mons == 2) this.name = "Dragon";
            else if (mons == 3) this.name = "Paladin";
            if (type == 1) this.element = "Api";
            else if (type == 2) this.element = "Angin";
            else if (type == 3) this.element = "Air";
            if (this.name == "Phoenix")
            {
                if (this.element == "Api")
                {
                    this.hp = 5400;
                    this.maxhp = 5400;
                    this.minatk = 500;
                    this.maxatk = 800;
                    this.mindef = 200;
                    this.maxdef = 350;
                }
                else if (this.element == "Angin")
                {
                    this.hp = 4500;
                    this.maxhp = 4500;
                    this.minatk = 600;
                    this.maxatk = 800;
                    this.mindef = 100;
                    this.maxdef = 250;
                }
                else if (this.element == "Air")
                {
                    this.hp = 4600;
                    this.maxhp = 4600;
                    this.minatk = 500;
                    this.maxatk = 900;
                    this.mindef = 200;
                    this.maxdef = 300;
                }
            }
            else if (this.name == "Dragon")
            {
                if (this.element == "Api")
                {
                    this.hp = 5200;
                    this.maxhp = 5200;
                    this.minatk = 500;
                    this.maxatk = 850;
                    this.mindef = 150;
                    this.maxdef = 250;
                }
                else if (this.element == "Angin")
                {
                    this.hp = 5800;
                    this.maxhp = 5800;
                    this.minatk = 400;
                    this.maxatk = 700;
                    this.mindef = 200;
                    this.maxdef = 250;
                }
                else if (this.element == "Air")
                {
                    this.hp = 6600;
                    this.maxhp = 6600;
                    this.minatk = 400;
                    this.maxatk = 550;
                    this.mindef = 300;
                    this.maxdef = 350;
                }
            }
            else if (this.name == "Paladin")
            {
                if (this.element == "Api")
                {
                    this.hp = 6500;
                    this.maxhp = 6500;
                    this.minatk = 400;
                    this.maxatk = 600;
                    this.mindef = 200;
                    this.maxdef = 300;
                }
                else if (this.element == "Angin")
                {
                    this.hp = 6300;
                    this.maxhp = 6300;
                    this.minatk = 400;
                    this.maxatk = 600;
                    this.mindef = 150;
                    this.maxdef = 300;
                }
                else if (this.element == "Air")
                {
                    this.hp = 6400;
                    this.maxhp = 6400;
                    this.minatk = 400;
                    this.maxatk = 650;
                    this.mindef = 100;
                    this.maxdef = 250;
                }
            }     
            this.level = 1;
            this.exp = 0;
            this.maxexp = 200;
        }

        private int bonusAttack(ref int atk)
        {
            atk = atk + (atk * 10 / 100);
            return atk;
        }

        public void evolve()
        {
            this.evolved = true;
            if (this.name == "Phoenix")
            {
                if (this.element == "Api")
                {
                    this.name = "Perna";
                    this.maxhp = 8400;
                    this.minatk = 600;
                    this.maxatk = 900;
                    this.mindef = 300;
                    this.maxdef = 450;
                }
                else if (this.element == "Angin")
                {
                    this.name = "Teshar";
                    this.maxhp = 7500;
                    this.minatk = 700;
                    this.maxatk = 900;
                    this.mindef = 200;
                    this.maxdef = 350;
                }
                else if (this.element == "Air")
                {
                    this.name = "Sigmarus";
                    this.maxhp = 7600;
                    this.minatk = 600;
                    this.maxatk = 1000;
                    this.mindef = 300;
                    this.maxdef = 400;
                }
            }
            else if (this.name == "Dragon")
            {
                if (this.element == "Api")
                {
                    this.name = "Zaiross";
                    this.maxhp = 8200;
                    this.minatk = 600;
                    this.maxatk = 950;
                    this.mindef = 250;
                    this.maxdef = 350;
                }
                else if (this.element == "Angin")
                {
                    this.name = "Jamire";
                    this.maxhp = 8800;
                    this.minatk = 500;
                    this.maxatk = 800;
                    this.mindef = 300;
                    this.maxdef = 350;
                }
                else if (this.element == "Air")
                {
                    this.name = "Verad";
                    this.maxhp = 9600;
                    this.minatk = 500;
                    this.maxatk = 650;
                    this.mindef = 400;
                    this.maxdef = 450;
                }
            }
            else if (this.name == "Paladin")
            {
                if (this.element == "Api")
                {
                    this.name = "Ophilia";
                    this.maxhp = 9500;
                    this.minatk = 500;
                    this.maxatk = 700;
                    this.mindef = 300;
                    this.maxdef = 400;
                }
                else if (this.element == "Angin")
                {
                    this.name = "Louise";
                    this.maxhp = 9300;
                    this.minatk = 500;
                    this.maxatk = 700;
                    this.mindef = 250;
                    this.maxdef = 400;
                }
                else if (this.element == "Air")
                {
                    this.name = "Josephine";
                    this.maxhp = 9400;
                    this.minatk = 500;
                    this.maxatk = 750;
                    this.mindef = 200;
                    this.maxdef = 350;
                }
            }
        }

        public void myAttack(monster enemy, RichTextBox history)
        {
            int atk = r.Next(this.minatk, this.maxatk);
            int enemydef = r.Next(enemy.mindef, enemy.maxdef);

            if (this.element == "Api")
            {
                if (enemy.element == "Angin")
                {
                    bonusAttack(ref atk);
                    enemy.hp -= atk + enemydef;
                }
                else enemy.hp -= atk + enemydef;
            }
            else if (this.element == "Angin")
            {
                if (enemy.element == "Air")
                {
                    bonusAttack(ref atk);
                    enemy.hp -= atk + enemydef;
                }
                else enemy.hp -= atk + enemydef;
            }
            else if (this.element == "Air")
            {
                if (enemy.element == "Api")
                {
                    bonusAttack(ref atk);
                    enemy.hp -= atk + enemydef;
                }
                else enemy.hp -= atk + enemydef;
            }
            if (enemy.hp <= 0) enemy.hp = 0;
            history.Text += this.name + " " + " menyerang dengan atk sebesar " + atk + "\n";
        }

        public void eAttack(monster mymons, RichTextBox history)
        {
            int atk = r.Next(this.minatk, this.maxatk);
            int mymonsdef = r.Next(mymons.mindef, mymons.maxdef);

            if (this.element == "Api")
            {
                if (mymons.element == "Angin")
                {
                    bonusAttack(ref atk);
                    mymons.hp -= atk + mymonsdef;
                }
                else mymons.hp -= atk + mymonsdef;
            }
            else if (this.element == "Angin")
            {
                if (mymons.element == "Air")
                {
                    bonusAttack(ref atk);
                    mymons.hp -= atk + mymonsdef;
                }
                else mymons.hp -= atk + mymonsdef;
            }
            else if (this.element == "Air")
            {
                if (mymons.element == "Api")
                {
                    bonusAttack(ref atk);
                    mymons.hp -= atk + mymonsdef;
                }
                else mymons.hp -= atk + mymonsdef;
            }
            if (mymons.hp <= 0) mymons.hp = 0;
            history.Text += this.name + " " + this.element + " menyerang dengan atk sebesar " + atk + "\n";            
        }

        public override string ToString()
        {
            return this.name;
        }

        public string Name
        {
            set { this.name = value; }
            get { return this.name; }
        }

        public string Element
        {
            set { this.element = value; }
            get { return this.element; }
        }

        public int Hp
        {
            set { this.hp = value; }
            get { return this.hp; }
        }

        public int Maxhp
        {
            set { this.maxhp = value; }
            get { return this.maxhp; }
        }

        public int Minatk
        {
            set { this.minatk = value; }
            get { return this.minatk; }
        }

        public int Maxatk
        {
            set { this.maxatk = value; }
            get { return this.maxatk; }
        }

        public int Mindef
        {
            set { this.mindef = value; }
            get { return this.mindef; }
        }

        public int Maxdef
        {
            set { this.maxatk = value; }
            get { return this.maxdef; }
        }

        public int Level
        {
            set { this.level = value; }
            get { return this.level; }
        }
        
        public int Exp
        {
            set { this.exp = value; }
            get { return this.exp; }
        }

        public int Maxexp
        {
            set { this.maxexp = value; }
            get { return this.maxdef; }
        }

        public bool Evolved
        {
            set { this.evolved = value; }
            get { return this.evolved; }
        }
    }
}
