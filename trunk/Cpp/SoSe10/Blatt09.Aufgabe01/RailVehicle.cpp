#include "stdafx.h"
#include "RailVehicle.h"

RailVehicle::RailVehicle(double wh, double w, int s)
{
  trackGauge = wh;
  weight = w;
  serialNo = s;
}

double RailVehicle::getTrackGauge()
{
	return trackGauge;
}

std::string RailVehicle::id()
{
	return "RailVehicle";
}