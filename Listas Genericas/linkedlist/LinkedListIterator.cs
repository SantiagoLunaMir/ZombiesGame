using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas.linkedlist
{
    internal class LinkedListIterator<K> : Object, Iterator<K>
    {
        private Node<K> currentNode;
        public LinkedListIterator(Node<K> head)
        {
            currentNode = head;
        }
        public bool hasNext()
        {
            if (currentNode == null)
            {
                return false;
            }
            return true;
        }
        public K next()
        {
            K data = currentNode.data;
            currentNode=(Node<K>)currentNode.next;
            return data;
        }
        public bool hasPrevious()
        {
            if (currentNode == null)
            {
                return false;
            }
            return true;
        }
        public Object previous()
        {
            Object data = currentNode.data;
            currentNode=(Node<K>)currentNode.previous;
            return data;
        }
        public Node<K> getCurrentNode()
        {
            return currentNode;
        }
    }
}
