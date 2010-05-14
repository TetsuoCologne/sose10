#include "stdafx.h"
#include "MyPoint.h"
#include <cmath>

MyPoint::MyPoint()
{
	x = 0;
	y = 0;
}

MyPoint::MyPoint(int value)
{
	x = value;
	y = value;
}

MyPoint::MyPoint(int x1, int y1)
{
	this -> x = x1;
	this -> y = y1;
}

double MyPoint::Norm()
{
	double norm = sqrt((double)(x*x + y*y));
	return norm;
}