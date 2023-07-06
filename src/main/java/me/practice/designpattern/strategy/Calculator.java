package me.practice.designpattern.strategy;

import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        num1 = sc.nextInt();
        System.out.println("Enter second number");
        num2 = sc.nextInt();
        int choice;
        do {
            System.out.println("Select operation: ");
            System.out.println("1: ADD");
            System.out.println("2: SUBTRACT");
            System.out.println("3: MULTIPLY");
            System.out.println("4: DIVIDE");
            choice = sc.nextInt();
            process(num1, num2, choice);
        } while (choice != 0);


    }

    private static void process(int num1, int num2, int choice) {
        Operation operation = Operation.getOperation(choice);
        if (operation == null) {
            return;
        }
        Strategy strategy =
                switch (operation) {
                    case ADD -> new AdditionStrategy();
                    case SUBTRACT -> new SubtractionStrategy();
                    case MULTIPLY -> new MultiplicationStrategy();
                    case DIVIDE -> new DivisionStrategy();
                };
        StrategyContext context = new StrategyContext(strategy);
        int result = context.execute(num1, num2);
        System.out.println(result);
    }

    enum Operation {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

        final int choice;

        Operation(int choice) {
            this.choice = choice;
        }

        public static Operation getOperation(int choice) {
            return Stream.of(values()).filter(e -> e.choice == choice).findFirst().orElse(null);
                    //.orElseThrow(() -> new RuntimeException("No operation for choice " + choice));
        }
    }
}
