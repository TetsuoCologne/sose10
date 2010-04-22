// Blatt01.Aufgabe05.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include "math.h"
#include <iostream>

using namespace std;
using namespace math;

int _tmain(int argc, _TCHAR* argv[])
	{
	int n;
	cout << "Zahl eingeben: ";
	cin >> n;
	cout << "Fakultaet: " << fakultaet(n) << endl;
	cout << n << ". Stelle der Fibonaccifolge: " << fib(n) << endl;
	return 0;
	}

