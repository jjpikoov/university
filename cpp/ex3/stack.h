#ifndef _STACK
#define _STACK 1

#include <iostream>
#include <initializer_list>


class stack
{
    size_t current_size;
    size_t current_capacity;
    double* tab;

    void ensure_capacity(size_t c);

 public:
    stack();

    stack(std::initializer_list<double> d);

    stack(const stack& s);

    ~stack();

    void operator = (const stack& s);

    void push(double d);
    void pop();
    void reset(size_t s);

    double& top();
    double top() const;

    size_t size() const {return current_size;}
    bool empty() const {return current_size == 0;}

    void printStack();
};


#endif
