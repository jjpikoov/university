#include "rational.h"
#include "matrix.h"

int main( int argc, char* argv [ ] )
{



   matrix mm1 = { {rational(1, 2), rational(1, 4)},
                  {rational(1, 3), rational(1, 5)}
   };

   matrix mm2 = { {rational(1, 2), rational(-2, 7)},
                  {rational(3, 3), rational(2, 8)}

   };

   matrix mm3 = { {rational(-1, 3), rational(2, 7)},
                  {rational(2, 5), rational(-1, 7)}

   };
   vector v(rational(1, 2), rational(1, 7));


   
   std::cout << "\n\n[I]\n\n";
   std::cout << mm2 * mm3 << "\n";
   std::cout << mm2.inverse() << "\n";


   std::cout << "\n\n[II]\n\n";
   std::cout << mm1 << "\n";
   std::cout << mm2 << "\n";
   std::cout << mm3 << "\n";
   std::cout << v << "\n\n";


   std::cout << "FIRST\n";
   std::cout << (mm1 * mm2) * mm3 << "\n";
   std::cout << mm1 * (mm2 * mm3) << "\n";

   std::cout << "SECOND\n";
   std::cout << "1)\n";
   std::cout << mm1*(mm2 + mm3) << "\n";
   std::cout << (mm1*mm2) + (mm1*mm3) << "\n";
   std::cout << "2)\n";
   std::cout << ((mm1 + mm2) * mm3) << "\n";
   std::cout << (mm1 * mm3) + (mm2 * mm3) << "\n";

   std::cout << "THIRD\n";
   std::cout << mm1((mm2(v))) << "\n";
   std::cout << (mm1 * mm2)(v) << "\n\n";

   std::cout << "FOURTH\n";
   std::cout << mm1.determinant() * mm2.determinant() << "\n";
   std::cout << (mm1 * mm2).determinant() << "\n\n";


   std::cout << "FIFTH\n";
   std::cout << mm1 * mm1.inverse() << "\n";
   std::cout << mm1.inverse() * mm1 << "\n";


   return 0;
}

