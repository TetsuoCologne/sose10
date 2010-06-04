#include <iostream>

template <class T, int n>
class FixedVector
{
public:
	T data[n];
	enum {dim = n};
	FixedVector();
	FixedVector(const FixedVector&);

};