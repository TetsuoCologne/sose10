#ifndef VEHICLE
#define VEHICLE
#include "Vehicle.h"
#endif
class RoadVehicle : public Vehicle{
public:
	RoadVehicle(int=0, double=0, int=0) ;
	int getWheels();
protected:
	int wheels;
};