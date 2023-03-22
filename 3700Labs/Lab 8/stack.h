#ifndef _STACK_H
#define _STACK_H

#include <stdexcept>

using namespace std;

const uint32_t
    STACK_SIZE = 16;
  
template <typename StackType>
class Stack {
public:
    Stack(void) {
  
        data = new StackType[STACK_SIZE];
        capacity = STACK_SIZE;
    
        top = 0;
    }

    ~Stack() { delete[] data; }

    void clear() { top = 0; }

    uint32_t size() { return top; }

    bool isEmpty() { return !top; }
  

    void push(const StackType &d) {

        //if (top == capacity)
            //throw overflow_error("Stack is full");

        if(top == capacity){
            int
                tmpCap = 2 * capacity;
            StackType
                *tmpData = new StackType[tmpCap];

            if(tmpData == nullptr)
                throw std::overflow_error("Stack is full");

            for(int i=0;i<capacity;i++)
                tmpData[i] = data[i];

            delete[] data;

            data = tmpData;
            capacity = tmpCap;
        }

        data[top] = d;
        top++;
    }
  
    StackType pop() {

        if (top == 0)
            throw underflow_error("Stack is empty");
      
        return data[--top];
    }
    
    StackType peek() {
  
        if (top == 0)
            throw underflow_error("Stack is empty");
      
        return data[top-1];
    }
  
private:
    StackType
        *data;
    
    uint32_t
        top,
        capacity;
};

#endif

