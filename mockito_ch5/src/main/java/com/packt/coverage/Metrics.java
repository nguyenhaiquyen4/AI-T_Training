package com.packt.coverage;

public class Metrics {

    public int absSum(Integer op1, Integer op2) {
        if (op1 == null && op2 == null) {
            return 0;
        }

        if (op1 == null && op2 != null) {
            return Math.abs(op2);
        }

        if (op2 == null) {
            return Math.abs(op1);
        }

        return Math.abs(op1) + Math.abs(op2);
    }

    int[] visitedLine = new int[14];

    public int absSumModified(Integer op1, Integer op2) {
        visitedLine[0] = 1;
        if (op1 == null) {
            visitedLine[1] = 1;
            if (op2 == null) {
                visitedLine[2] = 1;
                return 0;
            } else {
                visitedLine[3] = 1;
            }
        } else {
            visitedLine[4] = 1;
        }

        visitedLine[5] = 1;
        if (op1 == null) {
            visitedLine[6] = 1;
            if (op2 != null) {
                visitedLine[7] = 1;
                return Math.abs(op2);
            } else {
                visitedLine[8] = 1;
            }
        } else {
            visitedLine[9] = 1;
        }

        visitedLine[10] = 1;
        if (op2 == null) {
            visitedLine[11] = 1;
            return Math.abs(op1);
        } else {
            visitedLine[12] = 1;
        }

        visitedLine[13] = 1;
        return Math.abs(op1) + Math.abs(op2);
    }
}
