main: dictionary.o fraction.o main.o
	g++ -o project2 dictionary.o fraction.o main.o

main.o: main.cpp dictionary.h stack.h
	g++ -c main.cpp

dictionary.o: dictionary.cpp fraction.h
	g++ -c dictionary.cpp

fraction.o: fraction.cc fraction.h
	g++ -c fraction.cc