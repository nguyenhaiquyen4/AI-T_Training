package com.chapter3;

@FunctionalInterface
public interface IntSequence {
    int abc = 0;

    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequence of(int... args) {
        return new IntSequence() {
            int p = 0;
            @Override
            public int next() {
                return args[p++];
            }

            @Override
            public boolean hasNext() {
                return p < args.length;
            }
        };
    }

    static IntSequence constant(int i) {
        return () -> abc;
    }
}
