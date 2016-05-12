/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   map.h
 * Author: jjpikoov
 *
 * Created on May 5, 2016, 2:03 PM
 */

#ifndef MAP_H
#define MAP_H

//#include <cctype>
#include <string>
#include <algorithm>
#include <iostream>
#include <vector>
#include <map>

struct CaseInsensitive
{
    bool operator() (const std::string& s1, const std::string& s2) const;
    // Return true if s1 < s2, ignoring case of the letters.
};

struct CaseInsensitiveHash
{
    size_t operator () (const std::string& s) const;
};

struct CaseInsensitiveEquality
{
    bool operator ( ) ( const std::string& s1, const std::string& s2 ) const;
};


//template<typename C = std::less<std::string>>
std::map<std::string, unsigned int, CaseInsensitive>
frequencytable(const std::vector<std::string>& text);


//template<typename C> 
std::ostream& operator << (std::ostream& stream, const std::map<std::string, unsigned int, CaseInsensitive> &freq);





#endif /* MAP_H */

