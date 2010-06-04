#include <iostream>

class Vehicle
{
public:
	Vehicle(double=0, int=0);
	double getWeight();
	int getSerialNo();
	virtual std::string id();
protected:
	double weight;
	int serialNo;
};