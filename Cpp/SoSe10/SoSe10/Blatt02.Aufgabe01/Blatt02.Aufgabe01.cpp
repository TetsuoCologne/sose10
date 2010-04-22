// Blatt02.Aufgabe01.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
	{
	int n = 3;
	const int m = 4;

	int* p1 = &n;
	const int* p2 = &n;
	int* const p3 = &n;
	const int* const p4 = &n;

	//Ändern des Wertes, auf den der Zeiger zeigt;
	*p1 = 0;
	//Fehler, da konstanter Integer
	//*p2 = 0;
	*p3 = 0;
	//Fehler, da konstanter Integer
	//*p4 = 0;
	return 0;

	//Ändern des Zeigers auf die Adresse von n
	p1 = &n;
	p2 = &n;
	//Fehler, da konstanter Zeiger
	//p3 = &n;
	//Fehler, da konstanter Zeiger
	//p4 = &n;

	//Ändern des Zeigers auf die Adresse von m
	//Fehler, da Zeiger nur Integer und nicht kosntanter Integer ist
	//p1 = &m;
	p2 = &m;
	//Fehler, da der Zeiger konstant ist
	//p3 = &m;
	//Fehler, da der Zeiger konstant ist
	//p4 = &m;
	}

