
#include "tree.h"

tree::tree( const tree& t ): pntr(t.pntr)
{
	pntr->refcnt++;
}

void tree::decrement_refcnt( )
{
	pntr->refcnt--;
 	if (!(pntr->refcnt))
 		delete(pntr);
}

void tree::operator = ( tree&& t )
{
	decrement_refcnt();
	pntr = t.pntr;
	pntr->refcnt++;
}

void tree::operator = ( const tree& t )
{
	(*this) = tree(t);
}

tree::~tree( )
{
	decrement_refcnt( );
}

const std::string& tree::functor( ) const
{
	return pntr->f;
}

const tree& tree::operator [ ] ( size_t i ) const
{
	return pntr->subtrees[i];
}

size_t tree::nrsubtrees( ) const
{
	return (pntr->subtrees).size();
}

std::ostream& operator << ( std::ostream& stream, const tree& t )
{
	stream << t.functor() << "[" << t.getRefCnt() << "]";
	for (size_t i = 0; i < t.nrsubtrees(); i++)
		stream << t[i];
	return stream;
}

void tree::ensure_not_shared( )
{
	if (pntr->refcnt > 1)
	{
		pntr->refcnt--;
		pntr = new trnode( pntr->f, pntr->subtrees, 1 );
	}
}

//void tree::replacesubtree(size_t i, const tree& t)
//{
//	if ( pntr->subtrees[i].pntr != t.pntr ) return;
//    ensure_not_shared();
//	pntr->subtrees[i] = t;
//}

void tree::replacefunctor(const std::string& f)
{
	if ( pntr->f != f ) return;
	ensure_not_shared();
	pntr->f = f;
}


void tree::replacesubtree( size_t i, const tree& t )
{
	if( pntr -> subtrees[i]. pntr != t. pntr )
	{
		ensure_not_shared( );
		pntr -> subtrees[i] = t;
	}
}

tree subst( const tree& t, const std::string& var, const tree& val )
{
	if( t. nrsubtrees( ) == 0 )
	{
		if( t. functor( ) == var ) return val;
		else return t;
	}
	else
	{
		tree res = t;
		for( size_t i = 0; i < t. nrsubtrees( ); ++ i )
			res. replacesubtree( i, subst( t[i], var, val ));
		return res;
	}
}