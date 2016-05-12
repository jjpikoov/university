
#include "tree.h"


int main( int argc, char* argv [ ] )
{
//   tree t1( std::string( "a" ));
//   tree t2( std::string( "b" )); 
//   tree t3 = tree( std::string( "f" ), { t1, t2 } ); 
//
//   std::vector< tree > arguments = { t1, t2, t3 };
//   std::cout << tree( "F", std::move( arguments )) << "\n";

//   t2 = t3;
//   t2 = std::move(t3);
   
   tree t1(std::string("a"));
   tree t2(std::string("b"));
   tree t3 = tree(std::string("p"), {t1, t2});
   tree tt1(std::string("a2"));

   std::cout << t3 << "\n";
   tree res = subst(t3, "a", tt1);
   std::cout << res << "\n";
   
   tree the_same("a2");
   tree res2 = subst(res, "a2", the_same);
   std::cout << res2 << "\n";

   
   
}



