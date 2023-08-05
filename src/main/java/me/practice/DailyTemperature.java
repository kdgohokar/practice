package me.practice;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }
            stack.add(currDay);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        DailyTemperature obj = new DailyTemperature();
        int[] ans = obj.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
}
