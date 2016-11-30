package ru.javajoy.jps.w7;

import java.util.Stack;

/**
 * Метод для проверки корректно ли расставлены скобки
 *
 * @author Artem Zhukov
 */
public class BracketChecker { //AN: лучше тогда BracketChecker - как сущность

    private Stack<Character> stack = new Stack<>(); //AN: в Java 1.7 можно не ставить тип контейнера после равно. Это будет означать что берем внутренний тип слева

    private boolean isOpeningBrackets(char bracket) {
        return "({".indexOf(bracket) != -1;
    }

    private boolean isClosingBrackets(char bracket) {
        return "})".indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' ||
                opening == '{' && closing == '}';
    }

    public boolean check(String input) {
        for (char c : input.toCharArray()) {
            if (isClosingBrackets(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBrackets(c)) {
                stack.push(c);
            }
            if (isClosingBrackets(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
