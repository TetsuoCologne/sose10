// Blatt02.Aufgabe02.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

void RingTausch(int*,int*,int*);
void RingTausch(int&,int&,int&);

int _tmain(int argc, _TCHAR* argv[])
	{
	int a = 12, b = 16, c = 32;
	RingTausch(&a,&b,&c);
	cout << "a = " << a << ", b = " << b << ", c = " << c << endl;
	RingTausch(a,b,c);
	cout << "a = " << a << ", b = " << b << ", c = " << c << endl;
	return 0;
	}

void RingTausch(int* a, int* b, int* c)
	{
	int temp = *a;
	*a = *b;
	*b = *c;
	*c = temp;
	}

void RingTausch(int& a, int& b, int& c)
	{
	int temp = a;
	a = b;
	b = c;
	c = temp;
	}

