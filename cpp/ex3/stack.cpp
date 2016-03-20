#include <iostream>
#include "stack.h"


void stack::ensure_capacity(size_t c)
{
    if (current_capacity < c)
    {
        if (c < 2 * current_capacity)
            c = 2 * current_capacity;

        double* newtab = new double[c];
        for (size_t  i = 0; i < current_capacity; i++)
            newtab[i] = tab[i];

        current_capacity = c;
        delete [] tab;
        tab = newtab;
    }
    //   stack();

}


stack::stack()
    : current_size(0),
      current_capacity(1),
      tab(new double[1]){}


stack::stack(std::initializer_list<double> d)
{
    stack::ensure_capacity(d.size());
    size_t pos = 0;
    for (double x : d){
        tab[pos++] = x;
    }
    stack::current_size = d.size();
}
