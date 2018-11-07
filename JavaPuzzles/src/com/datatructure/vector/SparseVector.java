package com.datatructure.vector;

import java.util.HashMap;
import java.util.Map;

/**
 * A Sparse Vector is a one-dimensional array of elements
 * The natural C++ implementation of a vector is as a one-dimensional array. However, in many applications, the elements of a vector have mostly zero values.
 * Such a vector is said to be sparse. It is inefficient to use a one-dimensional array to store a sparse vector. It is also inefficient to add elements
 * whose values are zero in forming sums of sparse vectors. Consequently, we should choose a different representation.
 * <p>
 * One possibility is to represent the elements of a sparse vector as a linked list of nodes, each of which contains an integer index,
 * a numerical value, and a pointer to the next node. Generally, the entries of the list will correspond to the non-zero elements of the vector in order,
 * with each entry containing the index and value for that entry. (This restriction may be violated if a zero value is explicitly assigned to an element).
 */
public class SparseVector {

    Map<Integer,Integer> map = new HashMap<>();

    public int get(int index) {
        if(map.containsKey(index)) {
            return map.get(index);
        }
        return 0;
    }

    public void increment(int index, int delta) {
        if(map.containsKey(index)) {
            int val = map.get(index);
            if((val+delta) == 0 ) {
                map.remove(index);
            } else {
                map.put(index, val+delta);
            }
        } else if(delta!=0){
            map.put(index, delta);
        }
    }

    public int numberNonNumZeros() {
        return map.size();
    }

    public SparseVector dotProduct(SparseVector other) {
        SparseVector result = new SparseVector();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {

            int key = entry.getKey();
            int v1 = entry.getValue();
            int v2 = other.get(key);
            if(v2!=0 && v1!=0){
                result.increment(key, v2*v1);
            }
        }
        return result;

    }

}

