#include "map.h"

//template<typename C> std::map<std::string, unsigned int, C>
std::map<std::string, unsigned int, CaseInsensitive> frequencytable(const std::vector<std::string>& text){
    std::map<std::string, unsigned int, CaseInsensitive> ourMap;
    for (std::string word : text){
        ourMap[word]++;
    }
    return ourMap;
}



//template<typename C> 
std::ostream& operator << (std::ostream& stream, const std::map<std::string, unsigned int, CaseInsensitive> &freq){
    for (auto& kv : freq){
        stream << kv.first + " -> " << kv.second << "\n";
    }
    
    return stream;
}

bool CaseInsensitive::operator()(const std::string& s1, const std::string& s2) const {
    
    for (int i = 0; i < std::min<int>(s1.size(), s2.size()); ++i)
    {
        if (s1[i] == s2[i])
            continue;
        if (std::abs(s1[i] - s2[i]) == 32)
            continue;
        
        return s1[i] < s2[i];
    }

    if (s1.size() < s2.size())
        return true;
    
    return false;
}

size_t CaseInsensitiveHash::operator()(const std::string& s) const {

    size_t w = 0;
    
    for(size_t i = 0; i < s.size(); i++)
    {
        w = (w * 29)%1000000007 + (tolower(s[i]) - 'a' + 1);
        w %= 1000000007;
    }
    
    return w;
}

bool CaseInsensitiveEquality::operator()(const std::string& s1, const std::string& s2) const {
    CaseInsensitive c;
    return !c(s1, s2) && !c(s2,s1);
}

