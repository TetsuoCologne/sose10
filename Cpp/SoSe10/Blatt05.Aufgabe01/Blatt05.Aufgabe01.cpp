// Blatt05.Aufgabe01.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

void CopyFromString(const string, char*&);

int _tmain(int argc, _TCHAR* argv[])
{
	const string sSrc = "1234567890";
	char* pc;
	CopyFromString(sSrc,pc);
	cout << "src: " << sSrc << endl;
	cout << "cpy: " << pc << endl;
	return 0;
}

void CopyFromString(const string sSrc, char*& pc)
{
	pc = new char[sSrc.size()+1];
	const char* tmp = sSrc.c_str(); 
	for (int i = 0; i < sSrc.size() + 1; i++){
		pc[i] = tmp[i];
	}
}

