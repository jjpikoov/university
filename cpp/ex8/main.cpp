#include <iostream>
#include <vector>
#include "map.h"


int main(){
    
   std::vector<std::string> v = { "AA", "aA", "Aa", "this", "THIS" };
   
   std::cout << frequencytable(v);
   
   CaseInsensitive c;
   std::cout << c( "a", "A" ) << c( "a","b" ) << c( "A", "b" ) << c("X", "x") << "\n";    
   
   
   CaseInsensitiveHash h;
   std::cout << h("xxz") << " " << h("XXX") << "\n";
   std::cout << h("Abc") << " " << h("abC") << "\n";
   
   
   CaseInsensitiveEquality e;
   std::cout << e("XXX", "xxx") << "\n";
    
    return 0;
}


