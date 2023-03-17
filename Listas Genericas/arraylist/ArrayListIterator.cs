using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas.arraylist
{
    internal class ArrayListIterator<H>:Iterator<H>
    {
        private int currentIndex;
        private readonly ArrayList<H> list;

        public ArrayListIterator(ArrayList<H> list)
        {
            this.list = list;
            currentIndex = 0;
        }

        public ArrayListIterator(ArrayList<H> list, int index)
        {
            this.list = list;
            currentIndex = index;
        }

        public bool hasNext()
        {
            return currentIndex < list.getSize();
        }

        public H next()
        {
            H data = list.getAt(currentIndex);
            currentIndex++;
            return data;
        }

        public bool HasPrevious()
        {
            return currentIndex >= 0;
        }

        public H Previous()
        {
            H data = list.getAt(currentIndex);
            currentIndex--;
            return data;
        }
    }
}
