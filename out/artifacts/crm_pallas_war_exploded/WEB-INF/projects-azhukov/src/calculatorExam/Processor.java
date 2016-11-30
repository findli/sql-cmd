package calculatorExam;

import java.awt.event.KeyEvent;

/**
 * Калькулятор
 * Обработка операций
 *
 * @ author Artem Zhukov
 */
public class Processor {

    private double firstNum;
    private double secondNum;
    private double total;
    private char operation;
    private char previousOperand;
    private char memorySymbol;
    private int countPoint;
    private int countOperand;
    private char[] listInputSymbols = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '-', '/', '*', '=', '.'};
    private Calculator calculator;

    public Processor(Calculator calculator) {
        this.calculator = calculator;
    }

    public void actionKeyListener(char symbol) {
        calculator.getInputOutputField().setEditable(true);
        //Проверка на ввод операций и операндов
        if (controlInput(symbol)) {
            //Проверка было ли нажато равно для операции без обнуления итога
            checkEqualSignEntered();
            chooseOperand(symbol);
            switch (symbol) {
                case Constants.POINT:
                    calculator.getInputOutputField().setEditable(false);
                    String memoryNums = calculator.getInputOutputField().getText();
                    if (countPoint == 0) {
                        if (calculator.getInputOutputField().getText().equals(Constants.EMPTY_STRING)) {
                            calculator.viewResult("0" + Constants.POINT);
                            countPoint++;
                        } else {
                            calculator.viewResult(memoryNums + Constants.POINT);
                            countPoint++;
                        }
                    } else {
                        calculator.getInputOutputField().setEditable(false);
                    }
                    break;
                //Запрет на ввод разделительной запятой.
                case Constants.COMMA:
                    calculator.getInputOutputField().setEditable(false);
                    break;
            }
        } else {
            calculator.getInputOutputField().setEditable(false);
        }
    }

    //Действие на Enter,Esc,BackSpace
    public void checkInputEnterEscBackSpace(int keyCode) {
        switch (keyCode) {
            //Esc
            case KeyEvent.VK_ESCAPE:
                resetCountersAndFields();
                break;
            //Enter
            case KeyEvent.VK_ENTER:
                checkPushEqually();
                break;
            case KeyEvent.VK_BACK_SPACE:
                if (!calculator.getInputOutputField().getText().equals(Constants.EMPTY_STRING)) {
                    deleteLastNum();
                    break;
                }
        }
    }

    //Удаление последней цифры
    public void deleteLastNum() {
        calculator.viewResult(Constants.EMPTY_STRING + calculator.getInputOutputField().getText().substring
                (0, calculator.getInputOutputField().getText().length() - 1));
    }

    //Проверка на ввод повторно разделительного знака
    public void checkDoublePoint(int keyCode) {
        if (countPoint > 0) {
            if (keyCode != KeyEvent.VK_DECIMAL) {
                if (keyCode != KeyEvent.VK_BACK_SPACE) {
                    countPoint++;
                } else {
                    countPoint--;
                }
            }
        }
    }

    public void resetCountersAndFields() {
        calculator.viewResult(Constants.EMPTY_STRING);
        showDisplayText(Constants.EMPTY_STRING);
        total = 0;
        countPoint = 0;
        countOperand = 0;
    }

    private void showDisplayText(String text) {
        calculator.getDisplayLabel().setText(text);
    }

    private boolean controlInput(char symbol) {
        for (char listInputSymbol : listInputSymbols) {
            if (symbol == listInputSymbol) {
                return true;
            }
        }
        return false;
    }

    //проверка на ввод цифр
    public void pushOperand(char symbol) {
        String memoryNums = calculator.getInputOutputField().getText();
        for (int i = 0; i < 10; i++) {
            if (symbol == listInputSymbols[i]) {
                calculator.viewResult(memoryNums + symbol);
            }
        }
    }

    //Обработка кнопки С
    public void pushButtonC() {
        if (calculator.getInputOutputField().getText().equals(Constants.EMPTY_STRING))
            calculator.getInputOutputField().setEditable(false);
        calculator.processor.resetCountersAndFields();
    }

    //Обработка кнопки BackSpace
    public void pushButtonBackSpace() {
        if (calculator.getInputOutputField().getText().equals(Constants.EMPTY_STRING) || (calculator.getDisplayLabel().
                getText().equals(Constants.EQUALLY))) {
            calculator.getInputOutputField().setEditable(false);
        } else {
            deleteLastNum();
        }
    }

    //Действия на ввод =
    public void checkPushEqually() {
        //Запрет на ввод равно до ввода операнда и операции
        if (calculator.getDisplayLabel().getText().equals(Constants.EMPTY_STRING)) {
            return;
        }
        //При повторном нажатии равно осуществляется операция с последним уканным числом
        if (calculator.getDisplayLabel().getText().equals(Constants.EQUALLY)) {
            firstNum = total;
            operation = memorySymbol;
        } else {
            //Рабочий блок
            if (isEmptySnum()) {
                secondNum = Double.parseDouble(calculator.getInputOutputField().getText());
                showDisplayText(Constants.EQUALLY);
            } else {
                secondNum = firstNum;
                showDisplayText(Constants.EQUALLY);
            }
        }
        calculate(operation);
        calculator.viewResult(String.valueOf(total));
    }

    //Проверка не пустая ли строка с 2м операндом
    private boolean isEmptySnum() {
        return !calculator.getInputOutputField().getText().isEmpty();
    }

    //Определение знака для операции
    private void chooseOperand(char keyChar) {
        if (previousOperand != keyChar) {
            switch (keyChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    controlKeyClick(keyChar);
                    break;
            }
            previousOperand = keyChar;
        } else if (keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/') {
            calculator.getInputOutputField().setEditable(false);
        }
    }

    private void checkEqualSignEntered() {
        if (calculator.getDisplayLabel().getText().equals(Constants.EQUALLY)) {
            calculator.viewResult(Constants.EMPTY_STRING);
            firstNum = total;
        }
    }

    //Проверка ввода перед осуществлением операции
    private void controlKeyClick(char operand) {
        if (calculator.getDisplayLabel().getText().equals(Constants.EQUALLY)) {
            countOperand = 0;
        }
        memorySymbol = operand;
        countPoint = 0;

        if (countOperand < 0) {
            secondNum = Double.parseDouble(calculator.getInputOutputField().getText());
            calculate(operation);
            calculator.viewResult(Constants.EMPTY_STRING);
            firstNum = total;
            countOperand++;
        }
        //Запрет на осуществление операции до ввода операнда
        if (calculator.getDisplayLabel().getText().equals(Constants.EMPTY_STRING) && calculator.getInputOutputField().
                getText().equals(Constants.EMPTY_STRING)) {
            calculator.getInputOutputField().setEditable(false);
            //Запрет на ввод подряд 2 операций одного типа
        } else if (calculator.getDisplayLabel().getText().equals(String.valueOf(operand))) {
            calculator.getInputOutputField().setEditable(false);
            //Изменние типа операции, если предыдущий тип операции отличается от текущего
        } else if (!calculator.getDisplayLabel().getText().equals(String.valueOf(operand)) && !calculator.getDisplayLabel().
                getText().equals(Constants.EMPTY_STRING)) {
            calculator.getInputOutputField().setEditable(false);
            showDisplayText(String.valueOf(operand));
            operation = operand;
            //Рабочий блок
        } else {
            calculator.getInputOutputField().setEditable(false);
            firstNum = Double.parseDouble(calculator.getInputOutputField().getText());
            showDisplayText(String.valueOf(operand));
            operation = operand;
            calculator.viewResult(Constants.EMPTY_STRING);
            countOperand++;
        }
    }

    //Выполнение операций над операндами
    private void calculate(char operand) {
        switch (operand) {
            case '+':
                total = firstNum + secondNum;
                break;
            case '*':
                total = firstNum * secondNum;
                break;
            case '/':
                total = firstNum / secondNum;
                break;
            case '-':
                total = firstNum - secondNum;
                break;
        }
    }

}
