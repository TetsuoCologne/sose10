// Blatt03.Aufgabe01.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

void Sieb(int , int& , int*& );

int _tmain(int argc, _TCHAR* argv[])
{
	int SizeOfA, *A;
	Sieb (100, SizeOfA, A);
	for (int i = 0; i < SizeOfA; ++i){
		cout << A[i] << endl;
	}
	return 0;
}

void Sieb(int MaxPrims, int& SizeOfA, int*& A){
	bool* Prims = new bool[MaxPrims+1];
	for (int i = 0; i < MaxPrims + 1; ++i){
		Prims[i] = true;
	}
	SizeOfA = 1;		//da die 1 nicht berücksichtigt wird		
	for (int i = 2; i < (MaxPrims + 1) / 2; ++i){
		for (int j = i + 1; j < MaxPrims + 1; ++j){
			if ( j % i == 0 && Prims[j] == true){
				Prims[j] = false;
				SizeOfA++;
			}
		}
	}
	SizeOfA = MaxPrims - SizeOfA;
	int count = 0;
	A = new int [SizeOfA];
	for (int i = 2; i < MaxPrims + 1; ++i){
		if (Prims[i] == true){
			A[count] = i;
			count++;
		}
	}

	delete Prims;
}

