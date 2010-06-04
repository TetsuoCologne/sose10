#include "stdafx.h"
#include "RoadVehicle.h"

RoadVehicle::RoadVehicle(int wh, double w, int s)
{
  wheels = wh;
  weight = w;
  serialNo = s;
}

int RoadVehicle::getWheels()
{
	return wheels;
}

std::string RoadVehicle::id()
{
	return "RoadVehicle";
}