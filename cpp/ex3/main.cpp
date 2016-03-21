#include <iostream>
#include "stack.h"

int main(){

    stack s1 = {1, 2, 3, 4, 5};
    std::cout << s1 << "\n";

    s1.pop();
    std::cout << s1 << "\n";


    stack s2 = s1;
    std::cout << s2 << "\n";

    for (unsigned int j = 0; j < 20; ++j)
        s2.push(j*j);

    std::cout << s2 << "\n";
    s2.reset(5);
    std::cout << s2 << "\n";
    s2.reset(20);
    std::cout << s2 << "\n";

    s1 = s2;

    s1 = s1;
    std::cout << s1 << "\n";

    s1 = {100, 101, 102, 103};


    std::cout << s2 << "\n";
    for (int i = 0; i < 10; ++i)
    {
        s2.top();
    }


#if 1
    const stack& sconst = s1;
    std::cout << sconst << "\n";
    std::cout << sconst.top() << "\n";
    std::cout << sconst.top() << "\n";
#endif

    return 0;
}
