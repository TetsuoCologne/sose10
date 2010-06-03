#include "stdafx.h"
#include "MyObj.h"

int MyObj::counter = 0;
int MyObj::idNext = 0;

MyObj::MyObj()
	{
	//a) counter inkrementieren
	counter++;
	//b) dem Objekt eine id zuweisen, idNext inkrementieren, damit id einzigartig
	this->m_id = idNext;
	idNext++;

	}

MyObj::MyObj(const MyObj& o)
	{
	//a) counter inkrementieren
	counter++;
	//b) dem Objekt eine id zuweisen, idNext inkrementieren, damit id einzigartig
	this->m_id = idNext;
	idNext++;
	}

MyObj::~MyObj() 
	{ 
	//a) counter dekrementieren
	counter--;
	}

int MyObj::id() const 
	{ 
	//b) getter für Member m_id
	return m_id;
	}

std::ostream& operator<<(std::ostream& os, const MyObj& o) {
	// c) Operator so überladen, dass die id des Objekts ausgegeben wird
	os << "id: " << o.id();
	return os;
	}

