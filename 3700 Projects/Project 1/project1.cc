#include "point.h"

bool intersection(Point p1, Point p2, Point q1, Point q2, Point &x){
    Fraction t, u, dist, zero;
    Point r = p2 - p1;
    Point s = q2 - q1;
    Point v = q1 - p1;
    zero = Fraction(0,1);
    Fraction max(1,1);
    dist = (r*s);
    if(dist != zero){
        t = (v*s) / dist;
        u = (v*r) / dist;
        if ((zero <= t && t <= max) && (zero <= u && u <= max)){
            x = p1 + r * t;
            return true;
        }
    }
    return false;
}

bool hit(Point mark, Point corner, Point (polygons)[100][20], int32_t vertNum){
    int32_t counter = 0;
    Fraction origin(0,1);
    Fraction boardArea = corner.getX() * corner.getY();
    Point
        bottom(mark.getX(),origin),
        top(mark.getX(), corner.getY()),
        left(origin, mark.getY()),
        right(corner.getX(), mark.getY()),
        x, temp, temp2;
    std::cout << "Vert Num is.... " << vertNum << std::endl; 
    for(int i = 0; i < vertNum; i++){
        if(i == vertNum-1){
            if(intersection(bottom, top, polygons[vertNum][i], polygons[vertNum][0], x)){
                temp = x - mark;
                temp2 = polygons[0] - polygons[i];
                if(temp.getY() * temp2.getX() < origin){
                    counter++;
                }else{
                    counter--;
                }
            }   
            if(intersection(left, right, polygons[vertNum][i], polygons[vertNum][0], x)){
                temp = x - mark;
                temp2 = polygons[0] - polygons[i];

                if(temp.getX() * temp2.getY() > origin){
                    counter++;
                }else{
                    counter--;
                }
            }
        }else{
            if(intersection(bottom, top, polygons[vertNum][i], polygons[vertNum][i+1], x)){
                temp = x - mark;
                temp2 = polygons[i+1] - polygons[i];

                if(temp.getY() * temp2.getX() < origin){
                    counter++;
                }else{
                    counter--;
                }
            }
            if(intersection(left, right, polygons[vertNum][i], polygons[vertNum][i+1], x)){
                temp = x - mark;
                temp2 = polygons[i+1] - polygons[i];

                if(temp.getX() * temp2.getY() > origin){
                    counter++;
                }else{
                    counter--;
                }
            }
        }
            
    }    
    std::cout << "Counter is at... " << counter << std::endl;
    if(counter == 0){
        return false;
    }else{
        return true;
    }

}


Fraction areaOfPoly(Point p[], int k){
    Fraction area;
    for(int i = 0; i < k-1; i++){
        area = area + (p[i]*p[i+1]);
    }
    area = area+(p[k-1]*p[0]);
    area = Fraction(1,2) * area;
    return area;
}


int main(){
    int dartNum, vertNum[100], polyNum;
    Point boardEdge, dart, polys[100][20];
    Fraction boardArea, score;

    std::cin >> boardEdge;
    boardArea = boardEdge.getX() * boardEdge.getY();
    std::cin >> polyNum;

    for(int i=0; i<polyNum; i++){
        std::cin >> vertNum[i];
        for (int j=0; j<vertNum[i]; j++) {
            std::cin >> polys[i][j];
        }
    }

    std::cin >> dartNum;

    for(int i = 0; i<dartNum; i++){
        std::cin >> dart;
        for (int j=0; j<polyNum; j++) {
            if(hit(dart, boardEdge, polys, vertNum[j])){
                std::cout << polyNum << std::endl;
                //std::cout << vertNum[j] << std::endl;
                score = score + (boardArea/areaOfPoly(polys[j], vertNum[j]));
                std::cout << areaOfPoly(polys[j], vertNum[j]) << std::endl;
            }
        }
    }

    std::cout << "Score: " << score << std::endl;


    return 0;
}