#include "stdafx.h"
#include "MyVector.h"


MyVector::MyVector(int dim)
{
	feld = new double[dim];
}

MyVector::MyVector()
{
	MyVector(1);
}