// Blatt06.Aufgabe01.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "MyPoint.h"
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	MyPoint pt1, pt2, pt3, pt4, pt5;
	pt1.x = 1;
	pt1.y = 1;
	pt2.x = 2;
	pt2.y = 2;
	cout << "pt1: " << pt1.x << ", " << pt1.y << endl;
	cout << "pt2: " << pt2.x << ", " << pt2.y << endl;

	pt1 = pt2;

	cout << "pt1: " << pt1.x << ", " << pt1.y << endl;
	cout << "pt2: " << pt2.x << ", " << pt2.y << endl;

	pt3 = MyPoint();
	pt4 = MyPoint(3);
	pt5 = MyPoint(4, 3);
	cout << "pt3: " << pt3.x << ", " << pt3.y << endl;
	cout << "pt4: " << pt4.x << ", " << pt4.y << endl;
	cout << "pt5: " << pt5.x << ", " << pt5.y << endl;
	cout << "pt3: " << pt3.Norm() << endl;
	cout << "pt3: " << pt4.Norm() << endl;
	cout << "pt3: " << pt5.Norm() << endl;
	return 0;
}

