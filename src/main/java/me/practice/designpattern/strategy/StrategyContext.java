package me.practice.designpattern.strategy;

public class StrategyContext {
    private Strategy strategy;

    StrategyContext(final Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}
