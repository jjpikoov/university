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
    return rational(-r.getNum(), r.getDenum());
}


rational operator + ( const rational& r1, const rational& r2 ){
    
    rational result(r1.getNum() * r2.getDenum() + r1.getDenum() * r2.getNum(), 
            r1.getDenum() * r2.getDenum());
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
    result.setNum(r1.getNum() * r2.getNum());
    result.setDenum(r1.getNum() * r2.getDenum());
    result.normalize();
    return result;
}

rational operator / ( const rational& r1, const rational& r2 ){
    rational result;
    result.setNum(r1.getNum() * r2.getDenum());
    result.setDenum(r1.getDenum() * r2.getNum());
    return result;
}

bool operator == ( const rational& r1, const rational& r2 ){
    return (r1.getNum() == r2.getNum() && r1.getDenum() == r2.getDenum());
}

bool operator != ( const rational& r1, const rational& r2 ){
    return !(r1==r2);
}


std::ostream& operator << ( std::ostream& stream, const rational& r ){
    stream <<  r.getNum() << "/" << r.getDenum();
    return stream;
}