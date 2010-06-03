// Blatt07.Aufgabe02.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include <cmath>

#include "MyVector.h"

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
		std::cout << "Test MyVector Begin" << std::endl 
			      << "-------------------" << std::endl;

		{
		MyVector v1;

		b = (v1.dim()==1 && v1[0]==0.0);
		TestResult("MyVector: dim=1, v=0, default cstr",nTest,b);

		b = (MyVector::memory==1);
		TestResult("MyVector: memory=1 at start",nTest,b);

		MyVector v2(2),v3(3,1.0);
		b = (v2.dim()==2 && v2[0]==0.0 && v2[1]==0.0) 
			&& (v3.dim()==3 && v3[0]==1.0 && v3[1]==1.0 && v3[2]==1.0);
		TestResult("MyVector: dim in [2,3], v in [0,1], default cstr",nTest,b);

		b = (MyVector::memory==6);
		TestResult("MyVector: memory=6 after mult. defs.",nTest,b);

		MyVector v4(v3),v5=v4;
		b = (v4.dim()==v3.dim() && v4[0]==1.0 && v4[1]==1.0) 
			&& (v5.dim()==v4.dim() && v5[0]==1.0 && v5[1]==1.0 && v5[2]==1.0);
		TestResult("MyVector: dim in [2,3], v in [0,1], copy cstr",nTest,b);

		b = (MyVector::memory==12);
		TestResult("MyVector: memory=12 after mult. defs.",nTest,b);

		v2[0]=2.0; v2[1]=3.0;
		b = (v2[0]==2.0 && v2[1]==3.0);
		TestResult("MyVector: v in [2,3], op[] R/W",nTest,b);

		v3[0]=4.0; v3[1]=5.0; v3[2]=6.0;
		b = (v3[0]==4.0 && v3[1]==5.0 && v3[2]==6.0);
		TestResult("MyVector: v in [4,5,6], op[] R/W",nTest,b);

		v3 = v2;
		b = (v3.dim()==v2.dim() && v3[0]==v2[0] && v3[1]==v2[1]);
		TestResult("MyVector: op=(vector)",nTest,b);

		b = (MyVector::memory==11);
		TestResult("MyVector: memory=11 after mult. defs.",nTest,b);

		b = (v3==v2);
		TestResult("MyVector: op==(vector)",nTest,b);
		b = !(v3!=v2);
		TestResult("MyVector: op!=(vector)",nTest,b);

		v2 = 12.5;
		b = (v2[0]==12.5 && v2[1]==12.5);
		TestResult("MyVector: op=(value)",nTest,b);

		b = (v3!=v2);
		TestResult("MyVector: op==(vector)",nTest,b);
		b = !(v3==v2);
		TestResult("MyVector: op!=(vector)",nTest,b);

		v2[0]=3.0; v2[1]=4.0;
		b = (std::fabs(v2.Norm()-5.0)<1e-15);
		TestResult("MyVector: Norm()",nTest,b);


		MyVector w1(2), w2(2), w3;

		w1[0]=1.0; w1[1]=2.0;
		w2[0]=3.0; w2[1]=4.0;
		w1 += w2;
		b = (w1[0]==4.0 && w1[1]==6.0);
		TestResult("MyVector: op+=(vector)",nTest,b);

		w3 = w1+w2;
		b = (w3[0]==7.0 && w3[1]==10.0);

		TestResult("MyVector: op+(vector)",nTest,b);
		std::cout << "-----------------" << std::endl 
			      << "Test MyVector End" << std::endl << std::endl;
		}
	}

	return 0;
}

