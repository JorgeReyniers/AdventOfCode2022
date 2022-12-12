package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DayFive implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        return 0;
    }

    @Override
    public String executeWithStringOutput(ArrayList<String> input) {
        List<Stack<Character>> stacksOfCratesReversed = readStacksOfCrates(input);
        List<Stack<Character>> stacksOfCrates = new ArrayList<>();
        for(Stack<Character> stack : stacksOfCratesReversed){
            stacksOfCrates.add(reverseStack(stack));
        }
        List<String> movingInstructions = input.stream().filter(line -> line.contains("move")).collect(Collectors.toList());
        for (String movingInstruction: movingInstructions) {
            executeMoveInstruction(movingInstruction, stacksOfCrates);
        }
        return constructTopCrates(stacksOfCrates);
    }

    private String constructTopCrates(List<Stack<Character>> stacksOfCrates) {
        String topCrates = "";
        for(Stack<Character> stack : stacksOfCrates) {
            topCrates += stack.pop();
        }
        return topCrates;
    }

    private void executeMoveInstruction(String movingInstruction, List<Stack<Character>> stacksOfCrates) {
        String[] movingInstructionParts = movingInstruction.split(" ");
        int amount = Integer.parseInt(movingInstructionParts[1]);
        int from = Integer.parseInt(movingInstructionParts[3]);
        int to = Integer.parseInt(movingInstructionParts[5]);
        Stack<Character> fromStackOfCrates = stacksOfCrates.get(from-1);
        Stack<Character> toStackOfCrates = stacksOfCrates.get(to-1);
        for (int i = 0; i < amount; i++) {
            toStackOfCrates.push(fromStackOfCrates.pop());
        }
    }

    private Stack<Character> reverseStack(Stack<Character> stack) {
        Stack<Character> crates = new Stack<>();
        int stackSize = stack.size();
        for(int i = 0; i < stackSize; i++) {
            Character crate = stack.pop();
            crates.push(crate);
        }
        return crates;
    }

    private List<Stack<Character>> readStacksOfCrates(List<String> input) {
        int i = 0;
        String inputLine = input.get(i);
        List<Stack<Character>> stacksOfCratesReversed = new ArrayList<>();
        int maxLists = 0;
        while (!inputLine.contains("1")) {
            int k = 0;
            for (int j = 1; j < inputLine.length(); j = j + 4) {
                if (maxLists < j) {
                    stacksOfCratesReversed.add(new Stack<>());
                    maxLists = j;
                }
                if (inputLine.charAt(j) != ' ') {
                    stacksOfCratesReversed.get(k).push(inputLine.charAt(j));
                }
                k++;
            }
            i++;
            inputLine = input.get(i);
        }
        return stacksOfCratesReversed;
    }
}
