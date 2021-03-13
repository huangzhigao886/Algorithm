package com.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

public class BestRangeLesson {
    public static class Program {
        private int start;
        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class MyComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public int bestRange(Program[] programs, int start) {
        Arrays.sort(programs);
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }
}
