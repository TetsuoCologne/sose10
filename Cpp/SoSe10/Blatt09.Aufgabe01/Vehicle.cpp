#include "stdafx.h";
#ifndef VEHICLE
#define VEHICLE
#include "Vehicle.h"
#endif


Vehicle::Vehicle(double w, int s)
{
	weight = w;
	serialNo = s;
}

double Vehicle::getWeight()
{
	return weight;
}

int Vehicle::getSerialNo()
{
	return serialNo;
}

std::string Vehicle::id()
{
	return "Vehicle";	
}