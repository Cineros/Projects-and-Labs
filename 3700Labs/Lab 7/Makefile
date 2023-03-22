Lab7: mrs.o sampler.o main.o
	g++ -o Lab7 mrs.o sampler.o main.o
main.o: main.cpp mrs.h sampler.h
	g++ -c main.cpp
sampler.o: sampler.cpp sampler.h
	g++ -c sampler.cpp
mrs.o: mrs.cpp mrs.h
	g++ -c mrs.cpp