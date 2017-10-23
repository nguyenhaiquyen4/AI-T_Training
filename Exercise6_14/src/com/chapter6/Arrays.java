package com.chapter6;

import java.util.ArrayList;

public class Arrays {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception{
        Exception retEx = null;
        int tryindex = 1;
        for (T elem : elems) {
            try {
                System.out.print("Close element " +  tryindex++ + " : ");
                elem.close();
                System.out.println("No exception");
            }
            catch (Exception ex) {
                if (retEx == null) {
                    retEx = ex;
                }
                else {
                    Exception temp = retEx;
                    retEx = ex;
                    retEx.initCause(temp);
                }
                System.out.println("with exception");
            }
        }
        if (retEx != null) {
            throw retEx;
        }
    }

}
