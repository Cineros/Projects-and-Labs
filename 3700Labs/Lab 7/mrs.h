#ifndef _MRS_H
#define _MRS_H

#include <cstdint>

class MRSCodec{
public:
	MRSCodec(uint32_t _nRadices, const uint32_t *_radices);
	~MRSCodec();

	uint32_t encode(uint32_t *elements);
	void decode(uint32_t value, uint32_t *digits);

private:
	uint32_t
		nRadices,
		*radices;
};

#endif