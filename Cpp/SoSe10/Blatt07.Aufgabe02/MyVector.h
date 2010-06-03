#include <iostream>
#include <cmath>

// #define VERBOSE

class MyVector
{
	double* m_pV;
	int	m_dim;

public:
	static int memory;

	MyVector(int n=1, double d=0.0);
	MyVector(const MyVector& v);

	~MyVector();

	MyVector& operator=(const MyVector& v);
	MyVector& operator=(double d);

	double MyVector::operator[](int i) const;
	double& MyVector::operator[](int i);

	int dim() const;
	double Norm() const;

	MyVector& operator+=(const MyVector& v);
	const MyVector operator+(const MyVector& v) const;

	bool operator==(const MyVector& v) const;
	bool operator!=(const MyVector& v) const;
};

std::ostream& operator<<(std::ostream& os, const MyVector& v);
