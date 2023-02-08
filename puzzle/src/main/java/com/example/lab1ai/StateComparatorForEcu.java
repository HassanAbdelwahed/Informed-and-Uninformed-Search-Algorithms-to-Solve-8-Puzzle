package com.example.lab1ai;

import java.util.Comparator;

class StateComparatorForEcu implements Comparator<State> {

    // Overriding compare()method of Comparator
    // for ascending order of manh
    public int compare(State s1, State s2) {
        if (s1.getCostEuclidean() > s2.getCostEuclidean())
            return 1;
        else if (s1.getCostEuclidean() < s2.getCostEuclidean())
            return -1;
        return 0;
    }
}