
#include <fstream>
#include <iostream>
#include <chrono> 
#include <random>

#include "listtest.h"
#include "vectortest.h"

std::list<std::string> vectorsToList(std::vector<std::string>& v);

int main( int argc, char* argv [] )
{

   std::vector< std::string > vect;
   vect = vectortest::randomstrings(999, 50);
   std::cout << vect << "\n";

   auto t1 = std::chrono::high_resolution_clock::now( ); 
   vectortest::sort_move( vect );
   auto t2 = std::chrono::high_resolution_clock::now( );
   std::chrono::duration< double > d = ( t2 - t1 );
   std::cout << "Vector sort move took " << d. count( ) << " seconds\n";
   
   
   t1 = std::chrono::high_resolution_clock::now( ); 
   vectortest::sort_assign( vect );
   t2 = std::chrono::high_resolution_clock::now( );
   d = ( t2 - t1 );
   std::cout << "Vector sort assign took " << d. count( ) << " seconds\n";
   
   
   t1 = std::chrono::high_resolution_clock::now( ); 
   vectortest::sort_std( vect );
   t2 = std::chrono::high_resolution_clock::now( );
   d = ( t2 - t1 );
   std::cout << "Vector standard sort took " << d. count( ) << " seconds\n\n\n";
   
   
   
   std::list<std::string> list = vectorsToList(vect);
   
   
   
   t1 = std::chrono::high_resolution_clock::now( ); 
   listtest::sort_assign(list);
   t2 = std::chrono::high_resolution_clock::now( );
   d = ( t2 - t1 );
   std::cout << "List assign sort took " << d. count( ) << " seconds\n";
   
   
   t1 = std::chrono::high_resolution_clock::now( ); 
   listtest::sort_move(list);
   t2 = std::chrono::high_resolution_clock::now( );
   d = ( t2 - t1 );
   std::cout << "List move sort took " << d. count( ) << " seconds\n";
   
   
   
   
   
   return 0;
}


std::list<std::string> vectorsToList(std::vector<std::string>& v)
{
    std::list<std::string> list;
    for (auto var : v)
        list.push_back(var);
    return list;
}


