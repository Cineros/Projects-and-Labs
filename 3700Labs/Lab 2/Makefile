lab2: fraction.o ftest.o
	g++ -o lab2 ftest.o fraction.o

ftest.o: ftest.cc fraction.h
	g++ -c ftest.cc

fraction.o: fraction.cc fraction.h
	g++ -c fraction.cc