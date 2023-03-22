#pragma once _BST_DICTIONARY_H

#include <cstdint>
#include <stdexcept>

static const uint32_t
    NULL_INDEX = 0xffffffff,
    DEFAULT_INITIAL_CAPACITY = 16;

template <typename KeyType, typename ValueType>
class BSTDictionary {
public:

    explicit BSTDictionary(uint32_t _cap = DEFAULT_INITIAL_CAPACITY){
        if(nTrees == 0){
            counts = new uint32_t [_cap];
            heights = new uint32_t [_cap];
            left = new uint32_t [_cap];
            right = new uint32_t [_cap];


            keys = new uint32_t [_cap];
            values = new uint32_t [_cap];

            capacity = _cap;

            for(int i = 0; i <= _cap - 1; i++){
                left[i] = i+1;
            }
            left[_cap] = NULL_INDEX;

            freeListHead = 0;
        }
        nTrees = nTrees + 1;

        root = NULL_INDEX;
    }

    ~BSTDictionary(){
        nTrees--;

        if(nTrees == 0){
            delete[] values;
            delete[] keys;
            delete[] heights;
            delete[] counts;
            delete[] left;
            delete[] right;
        }else{
            prvClear(root);
        }
    }

    void clear(){
        prvClear(root); root = NULL_INDEX;
    }

    uint32_t size(){
        return counts;
    }

    uint32_t height(){
        return heights;
    }

    bool isEmpty(){
        return(root == NULL_INDEX);
    }

    ValueType &search(const KeyType &k){
        for(uint32_t r = root; r != NULL_INDEX){
            if(k = keys[r]){
                return values[r];
            }
            if(k < keys[r]){
                r = left[r];
            }else{
                r = right[r];
            }
        }
        throw std::domain_error("Search: Key not found");
    }

    ValueType &operator[](const KeyType &k){
        root = prvInsert(root, k);

        for(uint32_t r = root; r != NULL_INDEX){
            if(k = keys[r]){
                return values[r];
            }
            if(k < keys[r]){
                r = left[r];
            }else{
                r = right[r];
            }
        }
        throw std::domain_error("Search: Key not found");

    }

    void remove(const KeyType &k){
        uint32_t ntbd;
        try{
            search(k);
        }catch(std::domain_error &e){
            throw std::domain_error("Remove: Key not found");
        }

        root = prvRemove(root, ntbd, k);

        prvFree(ntbd);
    }

private:

    uint32_t root;

    static uint32_t
        *counts,
        *heights,
        *left,
        *right,
        nTrees,
        capacity,
        freeListHead;

    static KeyType
        keys*;
    static ValueType
        *values;


    uint32_t prvAllocate(){


        if(freeListHead == NULL_INDEX){
            auto _counts = new uint32_t[2*capacity];
            auto _heights = new uint32_t[2*capacity];
            auto _left = new uint32_t[2*capacity];
            auto _right = new uint32_t[2*capacity];
            auto _keys = new KeyType[2+capacity];
            auto values = new ValueType[2*capacity];
        }

        for(int i = 0; i<capacity; i++){
            _counts[i] = counts[i];
            _heights[i] = height[i];
            _left[i] = left[i];
            _right[i] = right[i];
            _keys[i] = keys[i];
            _values[i] = values[i];
        }
        delete[] counts;
        delete[] heights;
        delete[] left;
        delete[] right;
        delete[] keys;
        delete[] values;
    }

    void prvFree(uint32_t n){

    }

    void prvClear(uint32_t r){

    }

    void prvAdjust(uint32_t r){

    }

    uint32_t prvInsert(uint32_t r, uint32_t &n, const KeyType &k){

    }
    uint32_t prvRemove(uint32_t r,uint32_t &ntbd, const Keytype &k){

    }

};

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::counts = nullptr;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::heights = nullptr;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::left = nullptr;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::right = nullptr;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::nTrees = 0;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::capacity = 0;

template <typename KeyType, typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::freeListHead = 0;

template <typename KeyType, typename ValueType>
KeyType *BSTDictionary<KeyType,ValueType>::keys = nullptr;

template <typename KeyType, typename ValueType>
ValueType *BSTDictionary<KeyType,ValueType>::values = nullptr;

#endif