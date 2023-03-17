using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas
{
    interface Listlist <G>
    {
        void setAt(int index, G data);
        void removeAll();
        void removeAllWithValue(G data);
        void remove(int index);
        void addAtTail(G data);
        void addAtFront(G data);
        G getAt(int index);
        int getSize();
        Iterator<G> getIterator();
        bool isEmpty();
    }
}
