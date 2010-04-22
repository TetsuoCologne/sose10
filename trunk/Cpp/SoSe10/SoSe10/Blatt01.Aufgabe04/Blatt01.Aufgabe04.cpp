// Blatt01.Aufgabe04.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int fakultaet (int);
int fib (int);

int _tmain(int argc, _TCHAR* argv[])
	{
	int n;
	cout << "Zahl eingeben: ";
	cin >> n;
	cout << "Fakultaet: " << fakultaet(n) << endl;
	cout << n << ". Stelle der Fibonaccifolge: " << fib(n) << endl;
	return 0;
	}

int fakultaet (int n)
	{
	if (n <= 1)
		return 1;
	else
		return n*fakultaet(n-1);
	}

int fib  (int n)
	{
	if (n == 1)
		return 1;
	else if (n == 0)
		return 0;
	else
		return fib(n - 1) + fib(n - 2);
	}

