using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listas_Genericas
{
    interface Iterator<T>
    {
        bool hasNext();
        T next();
    }
}
