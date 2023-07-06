package me.practice.designpattern.strategy;

public class DivisionStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 / num2;
    }
}
