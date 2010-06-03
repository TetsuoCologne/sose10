#include <cstdlib>

class MyPtr {
	void* m_p;
	int m_size;

public:
	static int counter;
	static int memory;

	MyPtr();
	MyPtr(const MyPtr& ptr);
	~MyPtr();

	void* allocMem(int bytes);
	void freeMem();

	MyPtr& operator=(const MyPtr& ptr);

	unsigned int size() const;

	operator void*();
	operator int*();
	operator char*();
};
