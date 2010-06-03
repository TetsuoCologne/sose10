// Blatt07.Aufgabe03.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include <cmath>

#include "MyPtr.h"

void TestResult(const char* pc, int& nTest, bool b)
{
	std::cout << "Test " << std::right << std::setw(2) << nTest << " : "
		<< std::left << std::setw(50) << pc 
		<< ( b ? "OK " : "NOK") << std::endl;
	++nTest;
}

int _tmain(int argc, _TCHAR* argv[])
{
	using std::cout;
	using std::endl;

	bool b;
	int nTest;

	if (true) {
		nTest = 1;
		std::cout << "Test MyPtr Begin" << std::endl 
			      << "----------------" << std::endl;

		b = (MyPtr::counter==0);
		TestResult("MyPtr: counter=0 at start",nTest,b);

		{
		MyPtr p1,p2;

		b = (MyPtr::counter==2);
		TestResult("MyPtr: counter=2 after mult. inst.",nTest,b);

		p1.allocMem(1000);
		p2.allocMem(10000);
		b = (MyPtr::memory==11000) && (p1.size()==1000) && (p2.size()==10000);
		TestResult("MyPtr: memory=11000",nTest,b);

		p1.allocMem(100);
		b = (MyPtr::memory==10100) && (p1.size()==100) && (p2.size()==10000);
		TestResult("MyPtr: memory=10100",nTest,b);

		p1.freeMem();
		b = (MyPtr::memory==10000) && (p1.size()==0) && (p2.size()==10000);
		TestResult("MyPtr: memory=10000",nTest,b);

		{
			MyPtr p3;
			p3.allocMem(250);

			b = (MyPtr::memory==10250) && (p3.size()==250);
			TestResult("MyPtr: memory=10250",nTest,b);
		}
		b = (MyPtr::memory==10000);
		TestResult("MyPtr: memory=10000",nTest,b);

		p2.freeMem();
		b = (MyPtr::memory==0) && (p1.size()==0) && (p2.size()==0);
		TestResult("MyPtr: memory=0",nTest,b);

		}
		b = (MyPtr::counter==0) && (MyPtr::memory==0);
		TestResult("MyPtr: counter=0 at end",nTest,b);

		std::cout << "--------------" << std::endl 
			      << "Test MyPtr End" << std::endl << std::endl;

		{
			MyPtr p;

			p.allocMem(100);
			strcpy(p,"Hallo"); // convert to char*
			std::cout << "Ptr-Test: '" << (char*)p << "'" << std::endl;
		}
	}

	return 0;
}

