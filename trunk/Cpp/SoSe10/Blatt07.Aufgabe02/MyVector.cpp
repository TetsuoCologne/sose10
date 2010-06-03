#include "stdafx.h"

#include "MyVector.h"
#include <stdexcept>
#include <cmath>

int MyVector::memory = 0;

MyVector::MyVector(int n/*=1*/, double d/*=0.0*/) 
	{
#if defined(VERBOSE)
	std::cout << "cstr(1) id=" << id << std::endl;
#endif
	//a) Konstruktor n = dimension, d = wert
	this->m_dim = n;
	this->m_pV = new double [n];
	for (int i = 0; i < n; ++i)
		{
		this->m_pV[i] = d;
		}
	//i) memory
	memory += n;
	}

MyVector::MyVector(const MyVector& v) 
	{
#if defined(VERBOSE)
	std::cout << "cstr(2) id=" << id << std::endl;
#endif
	//a) CopyConstructor
	this->m_dim = v.dim();
	this->m_pV = new double[v.dim()];
	for (int i = 0; i < v.dim(); ++i)
		{
		this->m_pV[i] = v[i];
		}
	//i) memory
	memory += v.dim();
	}

MyVector::~MyVector() 
	{
#if defined(VERBOSE)
	std::cout << "dstr id=" << id << std::endl;
#endif
	//a) Deskruktor
	free (this->m_pV);
	//i) memory
	memory -= this->dim();
	}

MyVector& MyVector::operator=(const MyVector& v) 
	{
#if defined(VERBOSE)
	std::cout << "op=(1) " << id << " <- " << v.id << std::endl;
#endif
	//memory muss eventuell angepasst werden
	memory -= this->dim();
	memory += v.dim();
	this->m_dim = v.dim();
	this->m_pV = new double [v.dim()];
	for ( int i = 0; i < v.dim(); ++i)
		{
		this->m_pV[i] = v[i];
		}
	return *this;
	}

MyVector& MyVector::operator=(double d) 
	{
#if defined(VERBOSE)
	std::cout << "op=(2) " << id << " <- " << d << "f" << std::endl;
#endif
	for (int i = 0; i < this->dim(); ++i)
		{
		this->m_pV[i] = d;
		}
	return *this;
	}

double MyVector::operator[](int i) const 
	{
	//c) Operator überladung lesen
	if (i < 0 || i > this->dim() - 1)
		throw std::out_of_range("");
	return this->m_pV[i];
	}

double& MyVector::operator[](int i) 
	{
	//c) Operatorüberladung schreiben
	if (i < 0 || i > this->dim() - 1)
		throw std::out_of_range("");
	return this->m_pV[i];
	}

int MyVector::dim() const
	{
	//d) Getter für Dimension
	return this->m_dim;
	}

double MyVector::Norm() const 
	{ 
	//d) euklidische Norm 
	double result = 0;
	for (int i = 0; i < this->dim(); ++i)
		{
		result += this->m_pV[i] * this->m_pV[i];
		}
	return sqrt(result); 
	}

MyVector& MyVector::operator+=(const MyVector& v)
	{
	//e) Operatorüberladung
	if (this->dim() != v.dim())
		{
		throw std::out_of_range("");
		}
	for (int i = 0; i < v.dim(); ++i)
		{
		this->m_pV[i] += v[i];
		}
	return *this;
	}

const MyVector MyVector::operator+(const MyVector& v) const
	{
	// e) Operatorüberladung mit Hilfe von "+="
	MyVector temp;
	temp = *this;
	temp += v;
	return temp;
	}

bool MyVector::operator==(const MyVector& v) const
	{
	//f) Operatorüberladung
	if (this->dim() != v.dim())
		return false;

	bool result = true;
	for (int i = 0; i < v.dim(); ++i)
		{
		if ( this->m_pV[i] != v[i])
			result = false;
		}
	return result;
	}

bool MyVector::operator!=(const MyVector& v) const
	{
	//g) Operatorüberladung mit Hilfe von h)
	if (*this == v)
		return false;
	else
		return true;
	}

std::ostream& operator<<(std::ostream& os, const MyVector& v) 
	{
	os << "(";
	for (int i= 0; i < v.dim(); ++i)
		{
		os << v[i];
		if (i != v.dim() - 1)
			os << ", ";
		} 
	os << ")";
	return os;
	}

