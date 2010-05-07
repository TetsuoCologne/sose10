// Blatt05.Aufgabe02.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

void Reverse (const string, string&);
int _tmain(int argc, _TCHAR* argv[])
{
	string sSrc = "1234567890", sDst;
	Reverse(sSrc,sDst);
	cout << sSrc << endl;
	cout << sDst << endl;
	return 0;
}

void Reverse (const string sSrc, string& sDst)
{
	sDst.resize(sSrc.size());
	for (int i = 0; i < sSrc.size(); i++)
	{
		sDst = sSrc.c_str()[i] + sDst;
	}
}

