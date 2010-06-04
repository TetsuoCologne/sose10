#ifndef VEHICLE
#define VEHICLE
#include "Vehicle.h"
#endif
class RailVehicle : public Vehicle{
public:
	RailVehicle(double=0, double=0, int=0) ;
	double getTrackGauge();
	virtual std::string id();
protected:
	double trackGauge;
};