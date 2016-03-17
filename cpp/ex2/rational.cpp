#include "rational.h"
#include <iostream>
#include <ostream>
#include <cstdlib>
#include <cmath>

// Complete these methods:



int rational::gcd( int n1, int n2 ){
    int t;
    while (n2){
        t = n1;
        n1 = n2;
        n2 = t % n2;
    }
    return n1 < 0 ? -n1 : n1;
}

// int rational::lcm(int n1, int n2, int gcd){
//     return std::abs(n1 * n2) / gcd;
// }

void rational::normalize( ){
    int gcd = rational::gcd(num , denum);

    if (denum == 0){
        std::cout << "Division by zero\n";
    }
    else if (num < 0 && denum < 0){
        num *= -1;
        denum *= -1;
    }

    num /= gcd;
    denum /= gcd;
}

rational operator - ( rational r ){
    return rational(-r.num, r.denum);
}


rational operator + ( const rational& r1, const rational& r2 ){

    rational result(r1.num*r2.denum+r1.denum*r2.num, r1.denum*r2.denum);
    result.normalize();

    return result;
}


rational operator - ( const rational& r1, const rational& r2 ){
    rational result = -r2;
    result = r1 + result;
    return result;
}

rational operator * ( const rational& r1, const rational& r2 ){
    rational result;
    result.num = r1.num * r2.num;
    result.denum = r1.denum * r2.denum;
    result.normalize();
    return result;
}

rational operator / ( const rational& r1, const rational& r2 ){
    rational result;
    result.num = r1.num * r2.denum;
    result.denum = r1.denum * r2.num;
    return result;
}

bool operator == ( const rational& r1, const rational& r2 ){
    return (r1.num == r2.num && r1.denum == r2.denum);
}

bool operator != ( const rational& r1, const rational& r2 ){
    return !(r1==r2);
}


std::ostream& operator << ( std::ostream& stream, const rational& r ){
    stream <<  r.num << "/" << r.denum;
    return stream;
}



