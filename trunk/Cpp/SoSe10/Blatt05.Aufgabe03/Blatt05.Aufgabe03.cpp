// Blatt05.Aufgabe03.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <fstream>

using namespace std;

struct Data
{
	int x, y;
};

void readData(const char*, unsigned int&, Data*&);

int _tmain(int argc, _TCHAR* argv[])
{

	return 0;
}

void readData(const char* pcFileName, unsigned int& szData, Data*& data)
{
	ifstream in;
}