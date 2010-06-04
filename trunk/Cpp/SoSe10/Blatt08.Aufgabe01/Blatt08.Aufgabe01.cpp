// Blatt08.Aufgabe01.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

template <typename T>
T Min3 (T a, T b, T c)
{
	if (a < b)
	{
		return (a < c ? a : c);
	} else
	{
		return (b < c ? b : c);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	cout << "Test 1: " << Min3(2,3,1) << endl;
	cout << "Test 2: " << Min3(2.5,1.5,3.5) << endl; 
	cout << "Test 3: " << Min3("12","00","56") << endl;
	cout << "Test 4: " << Min3(string("12"),string("00"),string("56")) << endl;
	return 0;
}

