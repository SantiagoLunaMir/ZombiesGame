using Listas_Genericas;
using Listas_Genericas.linkedlist;
using Listas_Genericas.arraylist;
using System.Collections.Generic;
using ArrayList = Listas_Genericas.arraylist;
using LinkedList = Listas_Genericas.linkedlist;
namespace Prueba
{
    class Program
    {
        static void Main(string[] args)
        {
            Listlist<string> lista1 = new Listas_Genericas.arraylist.ArrayList<string>(); //se ha vuelto generico y funciona con ambos
            Listlist<string> lista2 = new Listas_Genericas.linkedlist.LinkedList<string>();//collections tiene uno que se llama igual por eso se agrega Listas_Genericas...
            //lista1 = null;
            //lista2 = null;
            lista1.addAtTail("I");
            //lista.Add(50);//int integer (wrapper classes) convierte los primitivos a wrapper class, ya se validaron
            //lista.Add(new LinkedList());//Generics List<int>, ya se validaron con <string>
            //Object object= lista1[0];//conservar el tipado para que sea fuerte tipado
                                     //si es string
                                     //((string)object).ToUpper();//ClassCastException, no se puede hacer el cast pq un integer no puede ser un string
            lista1.addAtTail("A");//F8 debugeo
            lista1.addAtTail("B");//stack trace indica en que linea es posiblemente el error
            lista1.addAtTail("C");
            lista1.addAtTail("D");
            lista1.addAtTail("E");
            PrintA(lista1);
            lista1.setAt(1,"I");
            PrintA(lista1);
            lista1.remove(4);
            PrintA(lista1);
            lista1.removeAllWithValue("B");
            PrintA(lista1);
            lista1.addAtFront("H");
            PrintA(lista1);
            lista1.removeAll();
            PrintA(lista1);
            Console.WriteLine("//////////////////////////");
            lista2.addAtTail("A");
            lista2.addAtTail("B");
            lista2.addAtTail("C");
            lista2.addAtTail("D");
            lista2.addAtTail("E");
            PrintA(lista2);
            lista2.setAt(1, "I");
            PrintA(lista2);
            lista2.remove(4);
            PrintA(lista2);
            lista2.removeAllWithValue("B");
            PrintA(lista2);
            lista2.addAtFront("H");
            PrintA(lista2);
            lista2.removeAll();
            PrintA(lista2);
        }
        public static void PrintA(Listlist<string> lista)
        {
            Console.WriteLine(lista.getSize());
            for (int i = 0; i < lista.getSize(); i++)
            {
                Console.WriteLine(lista.getAt(i));
            }
            Console.WriteLine("-------------------");
        }

    }
}