package com.chapter3;

import java.util.*;

public interface IntSequence {
    default boolean hasNext() {
        return true;
    }

    int next();

    public static Random generator = new Random();
    public static RandomSequence randomInts(int low, int high) {

        return new RandomSequence(low, high);
    }

    public class RandomSequence {
        private int low, high;
        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }

        public boolean hasNext() {
            return true;
        }
    }
}
