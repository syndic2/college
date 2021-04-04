using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace cLibrary
{
    public class word
    {
        private string kata;
        private List<char> splitted= new List<char>();
        public word(string kata)
        {
            this.kata = kata;
        }
        public void split()
        {
            for (int i = 0; i < this.kata.Length; i++)
            {
                this.splitted.Add(this.kata[i]);
            }
        }
        public override string ToString()
        {
            return this.kata;
        }
        public List<char> Splitted
        {
            set { this.splitted = value; }
            get { return this.splitted; }
        }
    }
}
