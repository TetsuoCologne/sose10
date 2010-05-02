// Blatt02.Aufgabe03.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;


int _tmain(int argc, _TCHAR* argv[])
	{
	//Standardteil
	const int n = 16;
	void* p = (char*) malloc (n * sizeof(char));

	//char
	/*
	const int lenChar = n / sizeof(char);
	char* pc = (char*) p;

	for (int i = 0; i < lenChar; ++i)
		pc[i] = 65 + i;
	for (int i = 0; i < lenChar; ++i)
		*(pc + i) = 65 + i;
	for (char* pp = pc; pp < pc + lenChar; ++p)
		*pp = 65 + (pp - pc);
	*/

	//int
	
	const int lenChar = n / sizeof(int);
	int* pc = (int*) p;

	for (int i = 0; i < lenChar; ++i)
		pc[i] = 65 + i;
	for (int i = 0; i < lenChar; ++i)
		*(pc + i) = 65 + i;
	for (int* pp = pc; pp < pc + lenChar; ++p)
		*pp = 65 + (pp - pc);
	

	free(p);
	return 0;
	}

