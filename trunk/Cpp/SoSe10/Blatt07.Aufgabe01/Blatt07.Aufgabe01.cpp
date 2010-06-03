// Blatt07.Aufgabe01.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include <cmath>

#include "MyObj.h"

void TestResult(const char* pc, int& nTest, bool b)
{
	std::cout << "Test " << std::right << std::setw(2) << nTest << " : "
		<< std::left << std::setw(50) << pc 
		<< ( b ? "OK " : "NOK") << std::endl;
	++nTest;
}

void TestOhneRef(MyObj o)
{
	std::cout << o << " counter:" << MyObj::counter << std::endl;
}

void TestMitRef(MyObj& o)
{
	std::cout << o << " counter:" << MyObj::counter << std::endl;
}

int _tmain(int argc, _TCHAR* argv[])
{
	using std::cout;
	using std::endl;

	bool b;
	int nTest;

	if (true) {
		nTest = 1;
		std::cout << "Test MyObj Begin" << std::endl 
			      << "----------------" << std::endl;

		b = (MyObj::counter==0);
		TestResult("MyObj: counter=0 at start",nTest,b);

		MyObj o;

		b = (MyObj::counter==1);
		TestResult("MyObj: counter=1 after object def.",nTest,b);
		b = (o.id()==0);
		TestResult("MyObj: obj-id==0",nTest,b);

		{
		MyObj o1,o2,o3;

		b = (MyObj::counter==4);
		TestResult("MyObj: counter=4 after multiple object def.",nTest,b);

		b = (o1.id()==1) && (o2.id()==2) && (o3.id()==3);
		TestResult("MyObj: obj-id in [1,2,3]",nTest,b);
		}

		b = (MyObj::counter==1);
		TestResult("MyObj: counter=1 after multiple object free",nTest,b);

		{
		MyObj o1,o2;

		b = (MyObj::counter==3);
		TestResult("MyObj: counter=3 after multiple object def.",nTest,b);

		b = (o1.id()==4) && (o2.id()==5);
		TestResult("MyObj: obj-id in [4,5]",nTest,b);
		}

		b = (MyObj::counter==1);
		TestResult("MyObj: counter=1 after multiple object free",nTest,b);

		std::cout << "--------------" << std::endl 
			      << "Test MyObj End" << std::endl << std::endl;

		//e) TestOhneRef läuft nach dem CallByValue Prinzip, d.h. es wird eine Kopie
		//von mittels des CopyConstructors erstellt. Da auch innerhalb des CopyConstructors
		//sowhl id als auch counter gezählt werden, unterscheidet sich sowohl id als auch counterstand
		TestOhneRef(o);
		//e) TestMitREf läuft nach dem CallByReference Prinzip, d.h. es wird die Adresse
		//von o übergeben und kein neues Objekt erstellt.
		TestMitRef(o);
	}

	return 0;
}

