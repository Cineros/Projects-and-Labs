#include <stdexcept>
#include "sampler.h"


Sampler::Sampler(uint32_t _nElements){

		//Create Space for Elements
		elements = new uint32_t[_nElements];
		// fill in the array
		for(uint32_t i=0; i<_nElements;i++){
			elements[i] = i;
		}
		//remember the element count
		nElements = _nElements;
		//create a random number of objects
		rd = new std::random_device;

		mt = new std::mt19937((*rd)());
	}
Sampler::~Sampler(){
		//delete array
		delete[] elements;
		//delete random number of objects
		delete mt;

		delete rd;
	}

	uint32_t Sampler::getSample(){
		// if no elements throw exception
		std::uniform_int_distribution<>
			dis(0,nElements-1);
		uint32_t
			r,e;
		//get random number 'r' in that range [0, nelements-1]
		if(nElements == 0){
			throw std::underflow_error("Sampler is empty");
		}
		// decrement nElements
		r = dis(*mt);
		// remember element in chosen position 'r'
		nElements--;
		e=elements[r];
		elements[r] = elements[nElements];
		return e;
		// copy last element to position 'r'

		//return chosen element
	}