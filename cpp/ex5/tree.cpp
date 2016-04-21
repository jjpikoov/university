
#include "tree.h"


tree::tree(const tree& t)
{
    this->pntr = t.pntr;
    t.pntr->refcnt++;
}

tree::~tree()
{
    this->pntr--;
    if (this->pntr->refcnt == 0)
        delete this->pntr;
   
}

void tree::operator = ( tree&& t )
{
    this->pntr = std::move(t.pntr);
}

void tree::operator = ( const tree& t )
{
    this->pntr = t.pntr;
    this->pntr->refcnt++;
}

const std::string& tree::functor( ) const
{
    return this->pntr->f;
}

const tree& tree::operator [] ( size_t i ) const
{
    return this->pntr->subtrees[i];
}


std::ostream& operator << ( std::ostream& stream, const tree& t ) 
{ 
	stream<<t.functor()<<'\n';
	if(t.nrsubtrees() == 0) 
            return stream;
	else 
            for(size_t i = 0; i < t.nrsubtrees(); ++i)  
                stream << t[i] << " ";

	return stream;
}

//std::string& tree::functor( )
//{
//    ensure_not_shared();
//    return this->pntr->f;
//}
//
//tree& tree::operator [] ( size_t i )
//{
//    ensure_not_shared();
//    return this->pntr->subtrees[i];
//}

size_t tree::nrsubtrees( ) const
{
    return this->pntr->subtrees.size();
}

void tree::ensure_not_shared()
{
    if (this->pntr->refcnt != 1)
    {
        this->pntr->refcnt--;
        this->pntr = new trnode(this->pntr->f, this->pntr->subtrees, 1);
    }
    
}


void tree::replacesubtree( size_t i, const tree& t )
{
	if( this->pntr->subtrees[i].pntr != t.pntr)
	{
		ensure_not_shared();
		this->pntr -> subtrees[i] = t;
	}
}

void tree::replacefunctor( const std::string& ff )
{
    if (this->pntr->f != ff)
        this->pntr->f = ff;
}


tree subst(const tree& t, const std::string& var, const tree& val)
{
    if(t.nrsubtrees() == 0)
    {
        if(t.functor() == var) 
            return val;
        else
            return t;
    }
    else
    {
        tree res = t;
        for(size_t i = 0; i < t. nrsubtrees( ); ++ i)
            res. replacesubtree(i, subst( t[i], var, val));
        return res;
    }
}


size_t tree::getaddress( ) const
{
    return reinterpret_cast< size_t > ( pntr );
}






