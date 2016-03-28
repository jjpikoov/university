#include <iostream>
#include "stack.h"
#include <limits>


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

}


stack::stack()
    : current_size(0),
      current_capacity(1),
      tab(new double[1])
{

}


stack::stack(std::initializer_list<double> d)
    : current_size(d.size()),
      current_capacity(current_size + 1),
      tab(new double[current_capacity])
{
    size_t pos = 0;
    for (double x : d){
        tab[pos++] = x;
    }
}


stack::stack(const stack& s)
    : current_size(s.current_size),
      current_capacity(s.current_size + 1),
      tab(new double[current_capacity])
{
    std::cout << "Copy constructor\n";
    for (size_t i = 0; i < s.current_size; i++)
        tab[i] = s.tab[i];
}


void stack::operator = (const stack& s)
{
    if (tab != s.tab)
    {
        current_size = s.current_size;
        current_capacity = current_size + 1;
        delete [] tab;
        tab = new double[current_capacity];
        for (size_t i = 0; i < s.current_size; ++i)
        {
            tab[i] = s.tab[i];
        }
    }
}


double stack::operator [] (size_t i) const
{
    if (i < current_size && i >= 0)
    {
        return tab[current_size - 1 - i];
    }
    else
    {
        throw std::runtime_error("Out of range!\n");
    }
    
}
double& stack::operator [] (size_t i)
{
    if (i < current_size && i >= 0)
    {
        return tab[current_size - 1 - i];
    }
    else
    {
        throw std::runtime_error("Out of range!\n");
    }
}

stack operator + (const stack& s1, const stack& s2)
{
    stack result;
    
    for (size_t i = 0; i < s1.size(); ++i)
        result += s1[i];
    
    for (size_t i = 0; i < s2.size(); ++i)
        result += s2[i];
    
    return result;
}

void stack::operator += (const stack& s)
{
    if (tab != s.tab)
    {
        for (size_t i = 0; i < s.size(); ++i)
        {
            push(s[i]);
        }
    }
}


stack::~stack()
{
    delete [] tab;
}


std::ostream& operator << (std::ostream& stream, const stack& s)
{
    stream << "[ ";
    for (size_t i = 0; i < s.current_size; i++)
    {
        stream << s.tab[i] << " ";
    }
    stream << "]\n";

    return stream;
}


void stack::push(double d)
{
    ensure_capacity(current_size + 1);
    tab[current_size++] = d;
}

void stack::pop()
{
    if (!empty())
        current_size--;
    else
        std::cerr << "EMPTY STACK!\n";
}

void stack::reset(size_t s)
{
    if (s < current_capacity && s < current_size)
    {
        double *newtab = new double[s * 2];
        
        for (size_t i = 0; i < s; i++)
        {
            newtab[i] = tab[i];
        }
        
        current_capacity = s * 2;
        
        delete [] tab;
        tab = newtab;
        
        current_size = s;
    }

}

double& stack::top()
{
    if (!empty())
    {
        return tab[--current_size];
    }
    std::cerr << "EMPTY STACK!\n";

    return tab[0]; // Co wtedy???

}

double stack::top() const
{
    if (!empty())
    {
        return tab[current_size - 1];
    }
    return std::numeric_limits<double>::max();
}


