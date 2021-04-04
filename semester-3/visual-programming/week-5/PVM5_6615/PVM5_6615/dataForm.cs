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
    public partial class dataForm : Form
    {
        Color c1;
        Color c2;
        public dataForm()
        {
            InitializeComponent();
            this.Text = "Data Player";
        }
        private void color1Button_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                if (colorDialog1.Color == Color.Red || colorDialog1.Color == Color.Yellow || colorDialog1.Color == Color.Green)
                {
                    MessageBox.Show("Tidak boleh menggunakan warna tersebut!");
                }
                else c1 = colorDialog1.Color;
            }
        }
        private void color2Button_Click(object sender, EventArgs e)
        {
            if (colorDialog2.ShowDialog() == DialogResult.OK)
            {
                if (colorDialog2.Color == Color.Red || colorDialog2.Color == Color.Yellow || colorDialog2.Color == Color.Green)
                {
                    MessageBox.Show("Tidak boleh menggunakan warna tersebut!");
                }
                else c2 = colorDialog2.Color;
            }
        }        
        private void playButton_Click(object sender, EventArgs e)
        {
            mainForm parent = (mainForm)MdiParent;
            string n1 = nameText1.Text;
            string n2 = nameText2.Text;
            parent.getData(n1, n2, c1, c2);
            parent.startGame();
        }
    }
}
