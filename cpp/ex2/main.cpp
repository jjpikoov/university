
#include "rational.h"
#include "matrix.h"

int main( int argc, char* argv [ ] )
{
   // rational r1( 2, 6 );
   // rational r2( 4, 3 ); 
   // rational r3( 5,6 );
   // rational r4( 1, 2 );

   // matrix m1 = { { 2, 3 }, { 4, 6 } };
   // std::cout << m1 << "\n";

   // matrix m2 = { { 5,4 }, { 6, rational(1,2) } }; 
   // std::cout << m2 << "\n";

   // matrix m3 = { { 4,5}, { -1, 2 }};

   // std::cout << m1. determinant( ) << "\n";

   // std::cout << m1. adjugate( ) << "\n";
   // std::cout << m1. inverse( ) * m1 << "\n";


   std::cout << "\nMY TESTS\n";


   matrix mm1 = { {rational(1, 2), rational(-2, 7)},
                  {rational(1, 3), rational(2, 8)}
   };

   matrix mm2 = { {rational(-1, 3), rational(2, 5)},
                  {rational(2, 7), rational(-1, 7)}

   };

   matrix mm3 = { {rational(1, 2), rational(3, 4)},
                  {rational(5, 6), rational(7, 8)}

   };




   std::cout << mm1 << "\n";
   std::cout << "TIMES\n";
   std::cout << mm2;
   std::cout << "EQUALS\n";
   std::cout << mm1 * mm2 << "\n";

   std::cout << "INVERSE OF THAT MATRIX\n";
   std::cout << mm1.inverse() << "\n";

   std::cout << "1\n";
   std::cout << (mm1 * mm2) * mm3 << "\n";
   std::cout << mm1 * (mm2 * mm3) << "\n";

   std::cout << "2\n";
   matrix foo = mm1 * mm2;
   std::cout << (mm1 * mm2).determinant() << "\n";
   std::cout <<  (mm1.determinant() * mm2.determinant()) << "\n";

   std::cout << "3\n";
   std::cout << mm1 * mm1.inverse() << "\n" << matrix::identity() << "\n";
   std::cout << mm1.inverse() * mm1 << "\n" <<  matrix::identity() << "\n";


   std::cout << "4\n";
   std::cout << mm1 * (mm2 + mm3) << "\n";
   std::cout << mm1 * mm2  + mm1 * mm3 << "\n\n";

   std::cout << (mm1 + mm2) * mm3 << "\n";
   std::cout << mm1 * mm3  + mm2 * mm3 << "\n";

   return 0;
}

