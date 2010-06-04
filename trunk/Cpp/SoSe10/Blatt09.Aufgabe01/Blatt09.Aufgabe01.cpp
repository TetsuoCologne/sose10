// Blatt09.Aufgabe01.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#ifndef VEHICLE
#define VEHICLE
#include "Vehicle.h"
#endif
#include "RoadVehicle.h"
#include "RailVehicle.h"
#include <iostream>
#include <string>

using namespace std;



int _tmain(int argc, _TCHAR* argv[])
{
	Vehicle v;
	RoadVehicle r;
	RailVehicle rV;
	cout << v.id() << endl;
	cout << r.id() << endl;
	cout << rV.id() << endl;
	return 0;
}

