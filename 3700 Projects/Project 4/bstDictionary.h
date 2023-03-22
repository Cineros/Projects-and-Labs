#ifndef _BST_DICTIONARY_H
#define _BST_DICTIONARY_H

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
            keys = new KeyType [_cap];
            values = new ValueType [_cap];

            capacity = _cap;

            //Generate Free list head.
            for(int i = 0; i < capacity-1; i++){
                left[i] = i+1;
            }
            left[capacity-1] = NULL_INDEX;

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
        return getCount(root);
    }

    uint32_t height(){
        return getHeight(root);
    }

    bool isEmpty(){
        return(root == NULL_INDEX);
    }

    ValueType &search(const KeyType &k){

        uint32_t n = root;

        while(n != NULL_INDEX){
            if(k == keys[n]){
                return values[n];
            }else if(k < keys[n]){
                n = left[n];
            }else{
                n = right[n];
            }
        }
        throw std::domain_error("Search: Key not found");
    }

    ValueType &operator[](const KeyType &k){
        uint32_t temp = prvAllocate();

        uint32_t n = temp;

        root = prvInsert(root, n, k);
        if(n != temp){
            prvFree(temp);
        }
        return(values[n]); 
        throw std::domain_error("Search[]: Key not found");
    }

    void remove(const KeyType &k){
        uint32_t ntbd;
        try{
            search(k);
        }catch(const std::domain_error &e){
            throw std::domain_error("Remove: Key not found");
        }

        root = prvRemove(root, ntbd, k);

        prvFree(ntbd);
    }

private:
    uint32_t 
        root;

    static uint32_t
        *counts,
        *heights,
        *left,
        *right,
        nTrees,
        capacity,
        freeListHead;

    static KeyType
        *keys;
    static ValueType
        *values;

    uint32_t getCount(uint32_t r){
        if(r == NULL_INDEX){
            return 0;
        }else{
            return counts[r];
        }
    }
    uint32_t getHeight(uint32_t r){
        if(r == NULL_INDEX){
            return 0;
        }else{
            return heights[r];
        }
    }


    uint32_t prvAllocate(){


        if(freeListHead == NULL_INDEX){
            auto _counts = new uint32_t[2*capacity];
            auto _heights = new uint32_t[2*capacity];
            auto _left = new uint32_t[2*capacity];
            auto _right = new uint32_t[2*capacity];
            auto _keys = new KeyType[2*capacity];
            auto _values = new ValueType[2*capacity];
        

        for(int i = 0; i < capacity; i++){
            _counts[i] = counts[i];
            _heights[i] = heights[i];
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

        left = _left;
        right = _right;
        counts = _counts;
        heights = _heights;
        keys = _keys;
        values = _values;

        //Generate Free list head.
        for(int i = capacity; i < 2*capacity-1; i++){
            left[i] = i+1;
        }
        left[2*capacity-1] = NULL_INDEX;
        freeListHead = capacity;


        capacity *= 2;

        }
        uint32_t temp = freeListHead;
        freeListHead = left[freeListHead];
        left[temp] = NULL_INDEX;
        right[temp] = NULL_INDEX;
        counts[temp] = 1;
        heights[temp] = 1;

        return temp;
    }

    void prvFree(uint32_t n){
        left[n] = freeListHead;

        freeListHead = n;

    }

    void prvClear(uint32_t r){
        if(r != NULL_INDEX){
            prvClear(left[r]);
            prvClear(right[r]);
            prvFree(r);
        }
    }

    void prvAdjust(uint32_t r){
        uint32_t 
            leftCount = getCount(left[r]),
            rightCount = getCount(right[r]),
            leftHeight = getHeight(left[r]),
            rightHeight = getHeight(right[r]);

        counts[r] = 1 + leftCount + rightCount;
        heights[r] = 1 + ((leftHeight > rightHeight) ? leftHeight : rightHeight);
    }

    uint32_t prvInsert(uint32_t r, uint32_t &n, const KeyType &k){
        if(r == NULL_INDEX){
            keys[n] = k;

            return n;
        }

        if(k == keys[r]){
            n = r;
        }else if(k < keys[r]){
            left[r] = prvInsert(left[r],n,k);
        }else{
            right[r] = prvInsert(right[r],n,k);
        }

        prvAdjust(r);
        return r;

    }
    uint32_t prvRemove(uint32_t r,uint32_t &ntbd, const KeyType &k){
        if(r == NULL_INDEX){
            throw std::domain_error("Remove: Key not found");
        }

        if(k<keys[r]){
            left[r] = prvRemove(left[r], ntbd, k);
        }else if(k > keys[r]){
            right[r] = prvRemove(right[r],ntbd,k);
        }else{
            ntbd = r;
            if(left[r] == NULL_INDEX){
                if(right[r] == NULL_INDEX){
                    r = NULL_INDEX;
                }else{
                    r = right[r];
                }
            }else{
                if(right[r] == NULL_INDEX){
                    r = left[r];
                }else{
                    //Reduce two-child case.
                    if(getHeight(right[r]) > getHeight(left[r])){
                        KeyType tKey;
                        ValueType tValue;
                        uint32_t temp = right[r];
                        while(left[temp] != NULL_INDEX){
                            temp = left[temp];
                        }
                        tKey = keys[r];
                        keys[r] = keys[temp];
                        keys[temp] = tKey;
                        tValue = values[r];
                        values[r] = values[temp];
                        values[temp] = tValue;

                        right[r] = prvRemove(right[r],ntbd,k);
                    }else{
                        KeyType tKey;
                        ValueType tValue;
                        uint32_t temp = left[r];

                        while(right[temp] != NULL_INDEX){
                            temp = right[temp];
                        }

                        tKey = keys[r];
                        keys[r] = keys[temp];
                        keys[temp] = tKey;
                        tValue = values[r];
                        values[r] = values[temp];
                        values[temp] = tValue;

                        left[r] = prvRemove(left[r],ntbd,k);
                    }
                }
            }
        }
        if(r != NULL_INDEX){
            prvAdjust(r);
        }
        return r;
    }

};

template <typename KeyType,typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::counts = nullptr;

template <typename KeyType,typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::heights = nullptr;

template <typename KeyType,typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::left = nullptr;

template <typename KeyType,typename ValueType>
uint32_t *BSTDictionary<KeyType,ValueType>::right = nullptr;

template <typename KeyType,typename ValueType>
uint32_t BSTDictionary<KeyType,ValueType>::nTrees = 0;

template <typename KeyType,typename ValueType>
uint32_t BSTDictionary<KeyType,ValueType>::capacity = 0;

template <typename KeyType,typename ValueType>
uint32_t BSTDictionary<KeyType,ValueType>::freeListHead = 0;

template <typename KeyType,typename ValueType>
KeyType *BSTDictionary<KeyType,ValueType>::keys = nullptr;

template <typename KeyType,typename ValueType>
ValueType *BSTDictionary<KeyType,ValueType>::values = nullptr;

#endif