using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Windows.Forms;

namespace cLibrary
{
    public class obj
    {
        private string dialog;
        private PictureBox icon, faint;
        private PictureBox[] emote= new PictureBox[2];
        private PictureBox[,] icons = new PictureBox[4, 3];
        public obj(string type)
        {
            this.faint = new PictureBox();
            this.faint.Size = new Size(40, 50);
            this.faint.SizeMode = PictureBoxSizeMode.StretchImage;
            for (int i = 0; i < 2; i++)
            {
                this.emote[i] = new PictureBox();
                this.emote[i].Size = new Size(40, 50);
                this.emote[i].SizeMode = PictureBoxSizeMode.StretchImage;
            }
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    this.icons[i, j] = new PictureBox();
                    this.icons[i, j].Size = new Size(40, 50);
                    this.icons[i, j].SizeMode = PictureBoxSizeMode.StretchImage;
                }
            }
            if (type == "player")
            {
                this.icons[0, 0].Image = Image.FromFile("playerimg/atas1.png");
                this.icons[0, 1].Image = Image.FromFile("playerimg/atasidle.png");
                this.icons[0, 2].Image = Image.FromFile("playerimg/atas2.png");

                this.icons[1, 0].Image = Image.FromFile("playerimg/bawah1.png");
                this.icons[1, 1].Image = Image.FromFile("playerimg/bawahidle.png");
                this.icons[1, 2].Image = Image.FromFile("playerimg/bawah2.png");

                this.icons[2, 0].Image = Image.FromFile("playerimg/kiri1.png");
                this.icons[2, 1].Image = Image.FromFile("playerimg/kiriidle.png");
                this.icons[2, 2].Image = Image.FromFile("playerimg/kiri2.png");

                this.icons[3, 0].Image = Image.FromFile("playerimg/kanan1.png");
                this.icons[3, 1].Image = Image.FromFile("playerimg/kananidle.png");
                this.icons[3, 2].Image = Image.FromFile("playerimg/kanan2.png");

                this.emote[0].Image = Image.FromFile("playerimg/happy1.png");
                this.emote[1].Image = Image.FromFile("playerimg/happy2.png");
                this.faint.Image = Image.FromFile("playerimg/faint.png");
                this.icon = icons[1, 1];
            }
            else if (type == "npc1")
            {
                this.dialog = "May the God Bless You!";
                this.icons[0, 0].Image = Image.FromFile("npcimg/npc1.png");
                this.icon = icons[0, 0];
            }
            else if (type == "npc2")
            {
                this.dialog = "Hello, Advanture Welcome to this world!";
                this.icons[0, 1].Image = Image.FromFile("npcimg/npc2.png");
                this.icon = icons[0, 1];
            }
            else if (type == "npc3")
            {
                this.dialog = "Please get the treasure for us!";
                this.icons[0, 2].Image = Image.FromFile("npcimg/npc3.png");
                this.icon = icons[0, 2];
            }
            else if (type == "monster")
            {
                this.icons[0, 0].Image = Image.FromFile("monsimg/atas1.png");
                this.icons[0, 1].Image = Image.FromFile("monsimg/atasidle.png");
                this.icons[0, 2].Image = Image.FromFile("monsimg/atas2.png");

                this.icons[1, 0].Image = Image.FromFile("monsimg/bawah1.png");
                this.icons[1, 1].Image = Image.FromFile("monsimg/bawahidle.png");
                this.icons[1, 2].Image = Image.FromFile("monsimg/bawah2.png");

                this.icons[2, 0].Image = Image.FromFile("monsimg/kiri1.png");
                this.icons[2, 1].Image = Image.FromFile("monsimg/kiriidle.png");
                this.icons[2, 2].Image = Image.FromFile("monsimg/kiri2.png");

                this.icons[3, 0].Image = Image.FromFile("monsimg/kanan1.png");
                this.icons[3, 1].Image = Image.FromFile("monsimg/kananidle.png");
                this.icons[3, 2].Image = Image.FromFile("monsimg/kanan2.png");

                this.icon = icons[1, 1];
            }
            else if (type == "chest")
            {
                this.icons[0, 0].Image = Image.FromFile("map/chest.png");
                this.icon = this.icons[0, 0];
            }
        }
        public PictureBox Icon
        {
            set { this.icon = value; }
            get { return this.icon; }
        }
        public PictureBox[] Emote
        {
            set { this.emote = value; }
            get { return this.emote; }
        }
        public PictureBox[,] Icons
        {
            set { this.icons = value; }
            get { return this.icons; }
        }
        public PictureBox Faint
        {
            set { this.faint = value; }
            get { return this.faint; }
        }
        public string Dialog
        {
            set { this.dialog = value; }
            get { return this.dialog; }
        }
    }
}
