// Blatt04.Aufgabe02.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//


#include "stdafx.h"
#include <iostream>
#include <stdexcept>

using namespace std;

void MyAlloc(char **, int);
void MyAlloc(char *&, int);
void MyFree(char**);
void MyFree(char*&);

int _tmain(int argc, _TCHAR* argv[])
{
	char* pc = NULL;
	int Size = 0;
	try{
		MyAlloc (&pc, Size);
		MyFree(&pc);
		MyAlloc(pc, Size);
		MyFree(pc);
	}
	catch (out_of_range ex){
		cout << "outOfRange" << ex.what() << endl;	
	}
	return 0;
}

void MyAlloc(char** pc, int size){
	if (size <= 0)
		throw out_of_range("size kleiner gleich 0");
	*pc = (char*) malloc(size);
}

void MyAlloc(char*& pc, int size){
	if (size <= 0)
		throw out_of_range("size kleiner gleich 0");
	pc = (char*) malloc(size);
}

void MyFree (char** pc){

	free (*pc);
}

void MyFree (char*& pc){

	free (pc);
}



