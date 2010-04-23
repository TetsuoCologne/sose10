// Blatt03.Aufgabe03.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

void MyAlloc(char **, int);
void MyAlloc(char *&, int);
void MyFree(char**);
void MyFree(char*&);

int _tmain(int argc, _TCHAR* argv[])
{
	char* pc = NULL;
	int Size = 100;
	MyAlloc (&pc, Size);
	MyFree(&pc);
	MyAlloc(pc, Size);
	MyFree(pc);
	return 0;
}

void MyAlloc(char** pc, int size){
	*pc = (char*) malloc(size);
}

void MyAlloc(char*& pc, int size){
	pc = (char*) malloc(size);
}

void MyFree (char** pc){
	free (*pc);
}

void MyFree (char*& pc){
	free (pc);
}

