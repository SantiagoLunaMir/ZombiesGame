using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas.linkedlist
{
    internal class Node<O>
    {
        public O data;
        public Node<O> next;
        public Node<O> previous;
        public Node()
        {
            data = default(O);
        }
        public Node(Object data)
        {
            this.data = (O)data;
        }

        public Node<object> Next { get; internal set; }

        public static implicit operator Node<O>(Node<object> v)
        {
            throw new NotImplementedException();
        }
    }
}
