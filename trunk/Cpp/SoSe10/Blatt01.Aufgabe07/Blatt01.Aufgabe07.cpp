// Blatt01.Aufgabe07.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

#define PI 3.14156

#define max(n,m) ((n > m) ? n : m)
#define AmulB(a,b) (a * b)

void _tmain(int argc, _TCHAR* argv[])
	{
#if defined(PI)
	cout << "Pi = " << PI << endl;
#else
	cout << "Pi unbekannt" << endl;
#endif

	int n = 3, m = 4;
	cout << "max(n,m) = " << max(++n,++m) << endl;
	cout << "n = " << n << ", m = " << m << endl;

	int a = 2, b = 3, c = 4;
	cout << "AmulB(a,b+c) = " << AmulB(a, b + c) << endl;
	}

