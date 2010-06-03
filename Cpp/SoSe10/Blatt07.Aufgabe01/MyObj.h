#include <iostream>

class MyObj {
public:
	static int counter;
	static int idNext;

private:
	int m_id;

public:
	MyObj();
	MyObj(const MyObj& o);
	~MyObj();

	int id() const;
};

std::ostream& operator<<(std::ostream& os, const MyObj& o);
