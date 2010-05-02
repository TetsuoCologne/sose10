// Blatt01.Aufgabe06.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

void dreieckszeileAusgeben(int, int);
int binomialkoeffizient(int, int);

void _tmain(int argc, _TCHAR* argv[])
	{
	int LETZTEZEILE;
	cin >> LETZTEZEILE;
	for (int n = 0; n <= LETZTEZEILE; ++n)
		dreieckszeileAusgeben(n, LETZTEZEILE);
	}

void dreieckszeileAusgeben(int n, int m)
	{
	for (int k = m - n; k >= 1; --k)
		cout << " ";
	for (int k = 0; k <= n; ++k)
		cout << " " << binomialkoeffizient(n, k);
	cout << endl;
	}

int binomialkoeffizient(int n, int k)
	{
	int ergebnis = 1;
	for (int i = 1; i <= k; ++i)
		ergebnis  = (ergebnis * (n - i + 1)) / i;
	return ergebnis;
	}

