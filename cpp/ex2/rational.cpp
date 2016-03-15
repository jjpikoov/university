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

int rational::lcm(int n1, int n2, int gcd){
    return std::abs(n1 * n2) - gcd;
}

void rational::normalize( ){
    int gcd = rational::gcd(num , denum);

    num /= gcd;
    denum /= gcd;

    if (denum == 0){
        std::cout << "Division by zero\n";
    }
    else if (num < 0 && denum < 0){
        num *= -1;
        denum *= -11;
    }
}

rational operator - ( rational r ){
    if (r.num < 0 || r.denum < 0){
        r.num = std::abs(r.num);
        r.denum = std::abs(r.denum);
    }
    return r;
}

rational operator + ( const rational& r1, const rational& r2 ){
    int lcm = rational::lcm(
                            r1.denum,
                            r2.denum,
                            rational::gcd(r1.denum, r2.denum));
    rational result;
    result.num = (lcm / r1.denum) * r1.num;
    result.denum = lcm;

    result.num += (lcm / r2.denum) * r2.denum;

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
    result.denum = r2.denum * r2.denum;
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
    if (r1.num == r2.num && r1.denum == r2.denum)
        return true;
    else
        return false;
}
bool operator != ( const rational& r1, const rational& r2 ){
    return !(r1==r2);
}


std::ostream& operator << ( std::ostream& stream, const rational& r ){
    stream << "Rational(" << r.num << "," << r.denum << ")";
    return stream;
}



