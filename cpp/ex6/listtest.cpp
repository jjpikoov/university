
#include "listtest.h"

#include <random>
#include <chrono>
#include <algorithm>

void listtest::sort_move( std::list< std::string > & v )
{
    std::list<std::string>::iterator i;
    std::list<std::string>::iterator j;
    for (i = v.begin(); i != v.end(); ++i)
    {
        for(j = v.begin(); j != i; ++j)
        {
            if (*j > *i)
            {
                std::swap(*i, *j);
            }
        }
    }
}

std::list<std::string> listtest::readfile( std::istream& input )
{
    std::list<std::string> words;
    std::string word;
    
    while (input >> word)
        words.push_back(word);
    
    return words;
}

std::ostream& 
operator << ( std::ostream& out, const std::list< std::string > & list)
{
    for (auto v : list)
        out << v << " ";
    out << "\n";
    return out;
}

std::list<std::string> listtest::randomstrings( size_t nr, size_t s )
{
    static std::default_random_engine gen( 
    std::chrono::system_clock::now( ). time_since_epoch( ). count( ) );
    // Narrowing long int into int, but that is no problem.
    
    static std::string alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345689";
    static std::uniform_int_distribution<int> distr( 0, alphabet. size( ) - 1);
    // More narrowing.
    
    std::list< std::string > res;
    
    for( size_t i = 0; i < nr; ++ i )
    {
        std::string rand;
        for( size_t j = 0; j < s; ++ j )
        {
            rand. push_back( alphabet[ distr( gen ) ] );  
        }
        
        res. push_back( std::move( rand ));
    }
    return res;
}

void listtest::sort_assign( std::list< std::string > & v )
{
    std::list<std::string>::iterator i;
    std::list<std::string>::iterator j;
    for (i = v.begin(); i != v.end(); ++i)
    {
        for(j = v.begin(); j != i; ++j)
        {
            if (*j > *i)
            {
                std::string s = *j;
                *j = *i;
                *i = s;
            }
        }
    }
}