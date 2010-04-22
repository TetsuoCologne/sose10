// Blatt03.Aufgabe04.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int PosZero(const char*);
char* TextCopy(const char*);

int _tmain(int argc, _TCHAR* argv[])
	{
	//a
	int pos;
	pos = PosZero("Hallo");
	cout << pos << endl;
	pos = PosZero("");
	cout << pos << endl;
	pos = PosZero("1234567890");
	cout << pos << endl;

	//b
	char* pc = TextCopy("Hallo");
	cout << "Txt '" << pc << "'" << endl;
	free(pc);
	return 0;
	}

int PosZero(const char* pc)
	{
	const char* pp = pc;
	while (*pp != (char)0)
		{
		pp++;
		}
	return pp - pc;
	}

char* TextCopy(const char* pc)
	{
	int i;
	int length = PosZero(pc);
	char* copy = (char*) malloc (length / sizeof(char));
	for (i = 0; i < length+1; ++i)
		{
		copy[i] = pc[i];
		}
	return copy;
	}