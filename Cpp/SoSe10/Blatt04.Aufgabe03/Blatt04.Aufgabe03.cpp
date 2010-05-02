// Blatt04.Aufgabe03.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

void AddComment();



int _tmain(int argc, _TCHAR* argv[])
{
	AddComment();
	return 0;
}

void AddComment()
{
	int szLineLen;
	int lineNo = 1;
	int spaces;
	ifstream in("../Debug/Folge.java");
	ofstream out("../Debug/FolgeC.java");
	char cLine[256+20+1];
	while (!in.eof()){
		in.getline(cLine,256,'\n');
		szLineLen = strlen(cLine);
		spaces = 0;
		for(int i = 0; i <= 86; i++){
			if (cLine[i] == 'Ì'){
				cLine[i] = ' ';
			}
		}
		cLine[87] = '\0';


		if (szLineLen < 80){
			spaces = 80 - szLineLen;
		}
		sprintf(cLine + 80,"//%5d",lineNo);
		cout << cLine << endl;
		lineNo++;
	}


}


