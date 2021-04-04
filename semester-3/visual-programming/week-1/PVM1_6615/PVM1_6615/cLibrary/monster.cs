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
        private monster parent1, parent2;
        private string name, enemyele;
        private List<string> element = new List<string>();
        private int hp, maxhp, minatk, maxatk;
        private int exp, maxexp, level;

        public monster(string name, string element)
        {
            int randhp = r.Next(75, 120);
            this.name = name;
            this.element.Add(element);
            this.hp = randhp;
            this.maxhp = randhp;
            this.minatk = r.Next(10, 15);
            this.maxatk = r.Next(18, 25);
            this.exp = 0;
            this.maxexp = 10;
            this.level = 1;
            this.parent1 = null;
            this.parent2 = null;
        }

        public monster(string name, monster p1, monster p2)
        {
            int randhp = r.Next(75, 120);
            this.name = name;
            if (p1.element.Count == 1 && p2.element.Count == 1)
            {
                if (p1.element[0] == p2.element[0])
                {
                    this.element.Add(p1.element[0]);
                }
                else
                {
                    this.element.Add(p1.element[0]);
                    this.element.Add(p2.element[0]);
                }
            }
            else if (p1.element.Count == 1 && p2.element.Count == 2)
            {
                int elep2 = r.Next(0, 1);
                this.element.Add(p1.element[0]);
                this.element.Add(p2.element[elep2]);
            }
            else if (p1.element.Count == 2 && p2.element.Count == 1)
            {
                int elep1 = r.Next(0, 1);
                this.element.Add(p1.element[elep1]);
                this.element.Add(p2.element[0]);
            }
            else if (p1.element.Count == 2 && p2.element.Count == 2)
            {
                int elep1 = r.Next(0, 1);
                int elep2 = r.Next(0, 1);
                this.element.Add(p1.element[elep1]);
                this.element.Add(p2.element[elep2]);
            }
            this.hp = randhp;
            this.maxhp = randhp;
            this.minatk = r.Next(10, 15);
            this.maxatk = r.Next(18, 25);
            this.exp = 0;
            this.maxexp = 10;
            this.level = 1;
            this.parent1 = p1;
            this.parent2 = p2;
        }

        public monster()
        {
            int randhp = r.Next(75, 120);
            int randele = r.Next(1, 3);
            this.name = "Wild Monster";
            if (randele == 1)
            {
                enemyele = "Water";
            }
            else if (randele == 2)
            {
                enemyele = "Fire";
            }
            else if (randele == 3)
            {
                enemyele = "Wind";
            }
            this.hp = randhp;
            this.maxhp = randhp;
            this.minatk = r.Next(10, 15);
            this.maxatk = r.Next(18, 25);
            this.level = 1;
        }

        public override string ToString()
        {
            return this.name;
        }

        private void critical(int chance, ref int  atk, ListBox battleLog)
        {
            int crit = r.Next(1, 100);

            if (crit <= chance)
            {
                atk *= 2;
                battleLog.Items.Add("----------------------------------------------");
                battleLog.Items.Add(this.name + " attack! " + "Oh, its Critical! (" + atk + ")");
                battleLog.Items.Add("----------------------------------------------");
            }
            else if (crit > chance)
            {
                battleLog.Items.Add("----------------------------------------------");
                battleLog.Items.Add(this.name + " attack! " + "(" + atk + ")");
                battleLog.Items.Add("----------------------------------------------");
            }
        }

        public void myAttack(monster enemy, ListBox battleLog)
        {
            int atk = r.Next(this.minatk, this.maxatk);

            if (this.element.Count == 1)
            {
                if (this.element[0] == "Water")
                {
                    if (this.element[0] == "Water" && enemy.enemyele == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Water" && enemy.enemyele == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Water" && enemy.enemyele == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                }
                else if (this.element[0] == "Fire") 
                {
                    if (this.element[0] == "Fire" && enemy.enemyele == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Fire" && enemy.enemyele == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Fire" && enemy.enemyele == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                }
                else if (this.element[0] == "Wind")
                {
                    if (this.element[0] == "Wind" && enemy.enemyele == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Wind" && enemy.enemyele == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                    else if (this.element[0] == "Wind" && enemy.enemyele == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        enemy.hp -= atk;
                        if (enemy.hp <= 0)
                        {
                            enemy.hp = 0;
                        }
                    }
                }
            }
            else if (this.element.Count == 2)
            {
                critical(25, ref atk, battleLog);
                enemy.hp -= atk;
                if (enemy.hp <= 0)
                {
                    enemy.hp = 0;
                }
            }
        }

        public void eAttack(monster mymons, ListBox battleLog)
        {
            int atk = r.Next(this.minatk, this.maxatk);

            if (mymons.element.Count == 1)
            {
                if (this.enemyele == "Water")
                {
                    if (this.enemyele == "Water" && mymons.element[0] == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Water" && mymons.element[0] == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Water" && mymons.element[0] == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                }
                else if (this.enemyele == "Fire")
                {
                    if (this.enemyele == "Fire" && mymons.element[0] == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Fire" && mymons.element[0] == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Fire" && mymons.element[0] == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                }
                else if (this.enemyele == "Wind")
                {
                    if (this.enemyele == "Wind" && mymons.element[0] == "Wind")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Wind" && mymons.element[0] == "Water")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                    else if (this.enemyele == "Wind" && mymons.element[0] == "Fire")
                    {
                        critical(20, ref atk, battleLog);
                        mymons.hp -= atk;
                        if (mymons.hp <= 0)
                        {
                            mymons.hp = 0;
                        }
                    }
                }

            }
            else if (mymons.element.Count == 2)
            {
                critical(20, ref atk, battleLog);
                mymons.hp -= atk;
                if (mymons.hp <= 0)
                {
                    mymons.hp = 0;
                }
            }
        }

        public monster Parent1
        {
            set { this.parent1 = value; }
            get { return this.parent1; }
        }

        public monster Parent2
        {
            set { this.parent2 = value; }
            get { return this.parent2; }
        }

        public string Name
        {
            set { this.name = value; }
            get { return this.name; }
        }

        public List<string> Element
        {
            set { this.element = value; }
            get { return this.element; }
        }

        public string Enemyele
        {
            set { this.enemyele = value; }
            get { return this.enemyele; }
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

        public int Exp
        {
            set { this.exp = value; }
            get { return this.exp; }
        }

        public int Maxexp
        {
            set { this.maxexp = value; }
            get { return this.maxexp; }
        }

        public int Level
        {
            set { this.level = value; }
            get { return this.level; }
        }
    }
}