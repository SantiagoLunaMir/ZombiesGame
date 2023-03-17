using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas.arraylist
{
    internal class ArrayList<T>: Listlist<T>
    {
        private const int INITIAL_SIZE = 2;
        private T[] array;
        private int size;
        private ArrayList<T> first;

        public ArrayList()
        {
            array = new T[INITIAL_SIZE];
        }

        private void increaseSize()
        {
            T[] newArray = new T[array.Length * 2];
            Array.Copy(array, 0, newArray, 0, array.Length);
            array = newArray;
        }

        public bool isEmpty()
        {
            return size == 0;
        }

        public int getSize()
        {
            return size;
        }

        public T getAt(int index)
        {
            return array[index];
        }

        public void addAtTail(T data)
        {
            if (size == array.Length)
            {
                increaseSize();
            }
            array[size] = data;
            size++;
        }

        public void addAtFront(T data)
        {
            if (size == array.Length)
            {
                increaseSize();
            }

            for (int i = size - 1; i >= 0; i--)
            {
                array[i + 1] = array[i];
            }

            array[0] = data;
            size++;
        }

        public void setAt(int index, T data)
        {
            if (index < array.Length)
            {
                array[index] = data;
            }
        }

        public void removeAll()
        {
            size = 0;
            Array.Clear(array, 0, array.Length);
            Console.WriteLine("Eliminado todo el arreglo");
        }

        public void removeAllWithValue(T data)
        {
            bool found = false;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] != null)
                {
                    if (array[i].Equals(data))
                    {
                        size--;
                    }

                    if (array[i].Equals(data) || found)
                    {
                        found = true;
                        array[i] = array[i + 1];
                    }
                }
            }

            if (!found)
            {
                Console.WriteLine("No se encontro la informacion");
            }
        }

        public void remove(int index)
        {
            if (index >= array.Length || index < 0)
            {
                Console.WriteLine("No existe");
                return;
            }

            array[index] = default(T);
            size--;
        }

        public ArrayListIterator<T> getIterator()
        {
            return new ArrayListIterator<T>(this);
        }

        private ArrayListIterator<T> getIteratorAt(int index)
        {
            return new ArrayListIterator<T>(this, index);
        }
        Iterator<T> Listlist<T>.getIterator()
        {
            return ((Listlist<T>)first).getIterator();
        }
    }
}
