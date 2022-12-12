import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String calculate(int a, int b, String s) {
        String answer = "";
        int temp = 0;
        switch (s) {
            case "+":
                answer = a + b + "";
                break;
            case "-":
                answer = a - b + "";
                break;
            case "*":
                answer = a * b + "";
                break;
            case "/":
                answer = a / b + "";
                break;
            default:
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
        }
        return answer;
    }

    public static String calc(String input) throws IOException{
        int firstInt = 0;
        int secondInt = 0;
        String result = "";
        String firstString;
        String secondString;
        String thirdString;
        String[] elements = input.split(" ");
        if (elements.length != 3) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
            throw new IOException();
        }
        firstString = elements[0];
        secondString = elements[1];
        thirdString = elements[2];
        try {
            Integer.parseInt(firstString);
            Integer.parseInt(thirdString);
            if ((Integer.parseInt(firstString) < 0 || Integer.parseInt(firstString) > 10) || (Integer.parseInt(thirdString) < 0 || Integer.parseInt(thirdString) > 10)) {
                System.out.println("Нужно ввести два числа от 1 до 10 включительно\n");
                throw new IOException();
            }
            firstInt = Integer.parseInt(firstString);
            secondInt = Integer.parseInt(thirdString);
            result = calculate(firstInt, secondInt, secondString);
            return result;
        } catch (Throwable t) {
        }
        if ((RomanNumerals.valueOf(firstString).getValue() < 0 || RomanNumerals.valueOf(firstString).getValue() > 10) || (RomanNumerals.valueOf(thirdString).getValue() < 0 || RomanNumerals.valueOf(thirdString).getValue() > 10)) {
            System.out.println("Нужно ввести два числа от 1 до 10 включительно\n");
            throw new IOException();
        }
        try {
            firstInt = RomanNumerals.valueOf(firstString).getValue();
            secondInt = RomanNumerals.valueOf(thirdString).getValue();
            RomanNumerals[] array = RomanNumerals.values();
            int temp = Integer.parseInt(calculate(firstInt, secondInt, secondString));
            for (RomanNumerals rN : array)
            {
                if (temp == rN.getValue())
                {
                    result = rN.getStringValue();
                    return result;
                } else if (Integer.parseInt(calculate(firstInt, secondInt, secondString)) <= 0)
                    {
                    System.out.println("В римских числах нет отрицательных значений");
                    throw new  IOException();
                    }
            }
            return result;
        } catch (IllegalArgumentException d) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
    }
}
