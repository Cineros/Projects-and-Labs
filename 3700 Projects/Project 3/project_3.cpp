#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include "linearlist-implementation.h"
#include "queue.h"


struct Rung{
    string word;
    int ptr = -1;
    LinearList<int> list;
};

Rung words[5757];

int hamming(string w1, string w2){
    int sum = 0;
    std::cout << w1 << ", " << w2 << std::endl;
    for(int i = 0; i < 5; i++){
        // std::cout << w1[i] << std::endl;
        // std::cout << w2[i] << std::endl;
        if(w1[i] == w2[i]){
            sum++;
        }
    }
    return sum;
}

int search(Rung words[5757], string w){
    for(int i=0; i<5757;i++){
        if(words[i].word == w){
            return i;
        }
    }
    return -1;
}

void linkList(string w1, string w2, Rung words[5757]){
    int w1i = search(words, w1);
    //std::cout << w1i << std::endl;
    int w2i = search(words, w2);
    //std::cout << w2i << std::endl;
    for(int i = 0; i < 5757; i++){
        //std::cout << hamming(w1, words[i].word) << std::endl;
        //std::cout << words[i].word << std::endl;
        if(hamming(w1, words[i].word) == 1){
            words[w2i].list.insert(0, i);
        }
        if(hamming(w2, words[i].word) == 1){
            words[w1i].list.insert(0, i);
        }
    }
}


void genLadder(Rung words[5757], string w1, string w2){
    linkList(w1, w2, words);
    Queue<int> Q;
    int w1i = search(words, w1);
    int w2i = search(words, w2);
    std::cout << w2i << std::endl;
    Q.enqueue(w2i);
    while(!Q.isEmpty()){
        int w = Q.dequeue();
        //std::cout << w << std::endl;
        // std::cout << words[w].word << std::endl;
        for(int v = 0; v < words[w].list.size(); v++){
           if(words[words[w].list[v]].ptr = -1 && words[w].list[v] != w2i){
                //std::cout << words[w].list[v] << std::endl;
                words[words[w].list[v]].ptr = w;
                Q.enqueue(words[words[w].list[v]].ptr);
           }
        }
    }
    if(words[w1i].ptr != -1){
        std::cout << words[w1i].word << std::endl;
        int w = words[w1i].ptr;

        while(w != -1){
            std::cout << words[w1i].word << std::endl;
            int w = words[w1i].ptr;
        }
    }else{
        std::cout << "No Ladder exists" << std::endl;
    }
}

void readFile(){
    std::ifstream inFile("sgb-words.txt");
    string temp;
    int counter = 0;
    while(getline(inFile, temp)){
        words[counter].word = temp;
        counter++;
    }
    inFile.close();
}


int main(){

    string w1, w2;

    readFile();

    while (true) {

        std::cout << "Word Ladders \n\nEnter two 5 letter words separated by a space.\nEnter # to exit.\n" << endl;
        std::cin >> w1 >> w2;

        // std::cout << w1 << std::endl;
        // std::cout << w2 << std::endl;        

        if (w1 == "#" || w2 == "#"){
            std::cout << "Exiting..." << std::endl;
            break;
        }else if(((search(words, w1) != -1)) && (search(words, w2)) != -1){
            genLadder(words, w1, w2);
        }else{
            std::cout << "One or more words were not in the list... " << std::endl;
        }
        
        
    }
}
