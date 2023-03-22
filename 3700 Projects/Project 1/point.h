#include "fraction.h"
#include <cstdint>
#include <iostream>
#include <numeric>

#ifndef _POINT_H
#define _POINT_H

class Point{
	public:
		Point(Fraction _x = Fraction(0,1), Fraction _y = Fraction(0,1));
		~Point() = default;

		Point operator+(Fraction rhs);
		Point operator-(Fraction rhs);
		Point operator*(Fraction rhs);
		Point operator/(Fraction rhs);
		Point& operator=(Fraction rhs);
		
        Fraction operator*(Point rhs);

        Point operator/(Point rhs);
        Point operator+(Point rhs);
        Point operator-(Point rhs);
        Point& operator=(Point rhs);

		bool operator == (Point rhs);
		bool operator != (Point rhs);
		bool operator <= (Point rhs);
		bool operator >= (Point rhs);
		bool operator < (Point rhs);
		bool operator > (Point rhs);

        //setters
        //void setX(Fraction newX);
        //void setY(Fraction newY);

        //getters
        Fraction getX() const {return x;}
        Fraction getY() const {return y;}



	private:
		Fraction x,y;
};

std::istream &operator >> (std::istream &is, Point &f);
std::ostream &operator << (std::ostream &os, Point f);

#endif
