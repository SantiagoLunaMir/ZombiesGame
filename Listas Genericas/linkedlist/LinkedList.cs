using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas.linkedlist
{
    internal class LinkedList<T>: Listlist<T>
    {
        private Node<T> head = null;
        private Node<T> tail = null;
        private Node<T> currentNode;
        private int size = 0;

        public void addAtTail(T data)
        {
            Node<T> node = new Node<T>(data);
            node.previous = tail;
            if (isEmpty())
            {
                head = node;
            }
            else
            {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public Node<T> getCurrentNode()
        {
            return currentNode;
        }

        public void addAtFront(T data)
        {
            Node<T> node = new Node<T>(data);
            node.next = head;
            if (isEmpty())
            {
                tail = node;
            }
            else
            {
                head.previous = node;
            }
            head = node;
            size++;
        }

        public void remove(int index)
        {
            if (isInvalidIndex(index))
            {
                return;
            }
            LinkedListIterator<T> iterator = (LinkedListIterator<T>)getIterator();
            int current_index = 0;
            while (iterator.hasNext() && current_index != index)
            {
                iterator.next();
                current_index++;
            }
            deleteNode(iterator.getCurrentNode());
            size--;
        }

        public void removeAll()
        {
            LinkedListIterator<T> iterator = (LinkedListIterator<T>)getIterator();
            while (iterator.hasNext())
            {
                Node<T> temp = iterator.getCurrentNode();
                iterator.next();
                deleteNode(temp);
            }
            size = 0;
        }

        public void setAt(int index, T data)
        {
            if (isInvalidIndex(index))
            {
                return;
            }
            LinkedListIterator<T> iterator = (LinkedListIterator<T>)getIterator();
            int current_index = 0;
            while (iterator.hasNext() && current_index != index)
            {
                iterator.next();
                current_index++;
            }
            iterator.getCurrentNode().data = data;
        }

        public T getAt(int index)
        {
            if (isInvalidIndex(index))
            {
                return default(T); // error handling
            }
            LinkedListIterator<T> iterator = (LinkedListIterator<T>)getIterator();
            int current_index = 0;
            while (iterator.hasNext() && current_index != index)
            {
                iterator.next();
                current_index++;
            }
            return iterator.next();
        }

        public void removeAllWithValue(T data)
        {
            LinkedListIterator<T> iterator = (LinkedListIterator<T>)getIterator();
            while (iterator.hasNext())
            {
                Node<T> temp = iterator.getCurrentNode();
                if (temp.data.Equals(data))
                {
                    deleteNode(temp);
                    size--;
                }
                iterator.next();
            }
        }

        public int getSize()
        {
            return size;
        }

        public Iterator<T> getIterator()
        {
            return new LinkedListIterator<T>(head);
        }

        public bool isEmpty()
        {
            return head == null || tail == null;
        }

        private bool isInvalidIndex(int index)
        {
            return index >= size || index < 0;
        }
        private void deleteNode(Node<T> node) {
            if (node == null) {
                return;
            }
            if (head == node && tail == node) {
                head = null;
                tail = null;
                return;
            }
            if (head == node) {
                head = head.next;
                if (head != null) {
                    head.previous = null;
                }
                return;
            }
            if (tail == node) {
                tail = tail.previous;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }
}
