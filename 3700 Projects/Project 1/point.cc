#include "point.h"

Point :: Point(Fraction _x, Fraction _y){
    x = _x;
    y = _y;
}

Point Point :: operator+(Fraction rhs){
    Fraction newX = x + rhs;
    Fraction newY = y + rhs;

    return(Point(newX,newY));
}

Point Point :: operator-(Fraction rhs){
    Fraction newX = x - rhs;
    Fraction newY = y - rhs;

    return(Point(newX,newY));
}

Point Point :: operator*(Fraction rhs){
	Fraction newX = x * rhs;
    Fraction newY = y * rhs;

    return(Point(newX,newY));
}

Point Point :: operator/(Fraction rhs){
    Fraction newX = x / rhs;
    Fraction newY = y / rhs;

    return(Point(newX,newY));
}

Point& Point::operator=(Fraction rhs){
    x = rhs;
    y = rhs;

    return *this;
}

Fraction Point :: operator*(Point rhs){
    Fraction temp, tempX, tempY;
    tempX = x*rhs.y;
    tempY = y*rhs.x;
    temp = tempX - tempY;
    return(temp);
}

Point Point :: operator+(Point rhs){
    return Point(x + rhs.x, y + rhs.y);
}

Point Point :: operator-(Point rhs){
    return Point(x - rhs.x, y + rhs.y);
}

Point& Point :: operator=(Point rhs){
    x = rhs.x;
    y = rhs.y;
    return *this;
}

Point Point :: operator/(Point rhs){
    return(x * rhs.getY() - y * rhs.getX());
}


bool Point :: operator == (Point rhs){
    return (x == rhs.getX()) && (y == rhs.getY());
}

bool Point :: operator != (Point rhs){
    return (x != rhs.getX()) || (y != rhs.getY());
}

bool Point :: operator <= (Point rhs){
    return (x <= y);
}

bool Point :: operator >= (Point rhs){
    return (x >= y);
}

bool Point :: operator < (Point rhs){
    return x < rhs.x || (x == rhs.x && y < rhs.y);
}

bool Point :: operator > (Point rhs){
    return x > rhs.x || (x == rhs.x && y > rhs.y);
}

std::istream& operator >> (std::istream& is, Point& p) {
    Fraction
            x, y;
    char
            l, comma, r;
    is >> l >> x >> comma >> y >> r;
    p = Point(x, y);
    return is;
}

std::ostream& operator << (std::ostream& os, Point p) {
    os << "(" << p.getX() << ", " << p.getY() << ") ";
    return os;
}