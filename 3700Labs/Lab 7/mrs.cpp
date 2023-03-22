#include <iostream>
#include "mrs.h"

MRSCodec::MRSCodec(uint32_t _nRadices, const uint32_t *_radices){

	radices = new uint32_t[_nRadices];

	nRadices = _nRadices;

	for(int i = 0; i<nRadices; i++){
		radices[i] = _radices[i];
	}
}
MRSCodec::~MRSCodec() {
	delete[] radices;
}

uint32_t MRSCodec::encode(uint32_t *elements){

	int result = 0;
	for(int i = 0; i<nRadices-1; i++){
		result = result*radices[i]+elements[i];
	}

	return result;
}
void MRSCodec::decode(uint32_t value, uint32_t *digits){

	for(int i=nRadices-1; i>=0;i--){
		digits[i] = value%radices[i];
		value = value/radices[i];
	}
}