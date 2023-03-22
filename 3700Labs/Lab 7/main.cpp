#include <iostream>
#include "mrs.h"
#include "sampler.h"

using namespace std;

const uint32_t
	RADICES[] = {7,24,60,60};

const uint32_t
	N_RADICES = sizeof(RADICES) / sizeof(RADICES[0]),
	N_SECONDS = 7*24*60*60;


#define OPF(f) (f ? "pass" : "fail")

int main(){

	MRSCodec
		codec(N_RADICES,RADICES);
	Sampler
		samples(N_SECONDS);

	bool
		flags[7][24][60][60] = {false},
		okay;

	uint32_t
		decoded[N_RADICES],
        s;

	for(uint32_t i=0; i<N_SECONDS;i++){
		//std::cout << "Seconds: " << i  << std::endl;
		s = samples.getSample();

		codec.decode(s,decoded);
		
		flags[decoded[0]][decoded[1]][decoded[2]][decoded[3]] = {true};

	}

	okay = false;
	try{
		s = samples.getSample();
	}catch(underflow_error &e){
		okay = true;
	}

	cout << "Sampler empty: " <<OPF(okay) << endl;

	okay = true;
	for(int d = 0; d<7; d++){
		for(int h = 0; h<24;h++){
			for(int m = 0; m<60; m++){
				for(int s = 0; s<60; s++){
					okay = okay && flags[d][h][m][s];
				}
			}
		}
	}
	cout << "Sampler and codec: " << OPF(okay) << endl;
	return 0;
}