#include "stdafx.h"		// nur windows

#include "MyPtr.h"

int MyPtr::counter = 0;
int MyPtr::memory = 0;

MyPtr::MyPtr()
	{ 
	// todo
	}

MyPtr::MyPtr(const MyPtr& ptr)
	{
	this->m_size = ptr.size();
	for (int i = 0; i < this->size(); i++)
		{
		m_p[i] = ptr.m_p[i];
		}
	}

MyPtr::~MyPtr()
	{ 
	free ( this -> m_p );
	}

MyPtr& MyPtr::operator=(const MyPtr& ptr) 
	{
	// todo
	return *this;
	}

unsigned int MyPtr::size() const
	{
	// todo
	return 0;
	}

MyPtr::operator void*() 
	{
	// todo
	return NULL;
	}

MyPtr::operator int*() 
	{
	// todo
	return NULL;
	}

MyPtr::operator char*() 
	{
	// todo
	return NULL;
	}

void* MyPtr::allocMem(int bytes) 
	{
	// todo
	return NULL;
	}
void MyPtr::freeMem() 
	{
	// todo
	}

