import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String calculate(int a, int b, String s){
        String answer = "";
        int temp = 0;
        switch (s) {
            case "+" :
            answer = a + b + "";
            break;
            case "-" :
            answer = a - b + "";
            break;
            case "*" :
            answer = a * b +"";
            break;
            case "/" :
            answer = a / b +"";
            break;
            default:
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        int firstInt = 0;
        int secondInt = 0;
        String result = "0";
        String firstString;
        String secondString;
        String thirdString;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] elements = input.split(" ");
        if (elements.length != 3)
        {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
            throw new IOException();
        }
        firstString = elements[0];
        secondString = elements[1];
        thirdString = elements[2];
            try {
                Integer.parseInt(firstString);
                Integer.parseInt(thirdString);
                firstInt = Integer.parseInt(firstString);
                secondInt = Integer.parseInt(thirdString);
                result = calculate(firstInt, secondInt, secondString);
                System.out.println(result);
                in.close();
                System.exit(0);
            } catch (Throwable t) {}
            try{
                firstInt = RomanNumerals.valueOf(firstString).getValue();
                secondInt = RomanNumerals.valueOf(thirdString).getValue();
                RomanNumerals[] array = RomanNumerals.values();
                int temp = Integer.parseInt(calculate(firstInt, secondInt, secondString));
                for(RomanNumerals rN : array)
                {
                    if(temp == rN.getValue()){
                        result = rN.getStringValue();
                        break;
                    } else if (Integer.parseInt(calculate(firstInt, secondInt, secondString)) < 0) {
                        System.out.println("В римских числах нет отрицательных значений");
                        in.close();
                        System.exit(0);
                    }
                    else {
                        result = calculate(firstInt, secondInt, secondString);
                    }
                }
                System.out.println(result);
                in.close();
                System.exit(0);
            }
            catch (IllegalArgumentException d){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
            }
    }
}