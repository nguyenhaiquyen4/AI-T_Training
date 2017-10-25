package com.chapter7;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String... args) {
        System.out.println(SieveOfErathostenes(100).toString());
        System.out.println(SieveOfErathostenes_b(100).toString());
    }

    public static HashSet<Integer> SieveOfErathostenes(int n) {
        HashSet<Integer> ret = new HashSet<>();
        for(int i = 2; i <= n; i++) {
            ret.add(i);
        }
        int s = 2;
        while (s * s <= n) {
            Integer rem = s*s;
            while (rem<=n) {
                ret.remove(rem);
                rem += s;
            }
            s = nextmin(ret, s);
        }
        return ret;
    }

    public static Integer nextmin(Set<Integer> setint, Integer s) {
        for(Integer a : setint) {
            if (a > s) return a;
        }
        return s;
    }

    public static BitSet SieveOfErathostenes_b(int n) {
        BitSet ret = new BitSet();
        ret.set(2, n);
        int s = 2;
        while (s * s <= n) {
            Integer rem = s*s;
            while (rem<=n) {
                ret.clear(rem);
                rem += s;
            }
            s = nextmin_b(ret, s);
        }
        return ret;
    }

    public static Integer nextmin_b(BitSet setint, Integer s) {
        Integer i = s;
        while(!setint.get(++i));
        return i;
    }
}
