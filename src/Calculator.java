import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Main main1 = new Main();
        String vvod;
        Scanner in = new Scanner(System.in);
        vvod = in.nextLine();

        String s = main1.calc(vvod);
        System.out.println(s);
    }
}

class Main{
    public static String calc(String input) throws Exception {
        String s = input;
        s = s.trim();
        String nova = "throws Exception";

        OnSamiy sam1 = new OnSamiy();
        int i = 0;
        int a = i;
        int numb1 = 0;
        int number1 = 0;
        if ((s.codePointAt(0) == 42) || (s.codePointAt(0) == 43) || (s.codePointAt(0) == 45) || (s.codePointAt(0) == 47)) {
            throw new Exception("Вы ввели оператор в начале строки");
        }
        while ((s.codePointAt(i) != 42) && (s.codePointAt(i) != 43) && (s.codePointAt(i) != 45) && (s.codePointAt(i) != 47)) {
            if (i == (s.length() - 1)){
                throw new Exception("Что то не так, проверьте корректность вводимых значений");
            }
            i++;
        }
        char[] stroka = s.toCharArray();
        String partOne = new String(stroka, a, i);
        partOne = partOne.trim();
        int curr = partOne.codePointAt(0);

        if ((curr == 73) || (curr == 86) || (curr == 88)) {
            numb1 = sam1.romeNumb(partOne);
        } else if ((curr >= 49) && (curr <= 57)) {
            number1 = sam1.romeNumb(partOne);
        } else {
            throw new Exception("Необходимо вводить числа");
        }

        int summ = 4004;
        int numb2 = 0;
        int number2 = 0;
        int first = i + 1;
        int last = s.length();
        last -= first;

        String partTwo = new String(stroka, first, last);
        partTwo = partTwo.trim();
        int current = partTwo.codePointAt(0);

        if ((current == 73) || (current == 86) || (current == 88)) {
            numb2 = sam1.romeNumb(partTwo);
        } else if ((current >= 49) && (current <= 57)) {
            number2 = sam1.romeNumb(partTwo);
        } else {
            throw new Exception("Необходимо вводить числа");
        }

        if ((numb1 != 0) && (numb2 != 0)) {
            summ = sam1.summToInt(s.codePointAt(i), numb1, numb2);
            if (summ < 1) {
                summ = 4004;
            } else {
                nova = sam1.romeStr(summ);
            }
        } else if ((number1 != 0) && (number2 != 0)) {
            summ = sam1.summToInt(s.codePointAt(i), number1, number2);
            nova = Integer.toString(summ);
        }
        if (nova.equals("throws Exception")){
            throw new Exception("Не правильно введенное значение");
        }
        return nova;
    }
}

class OnSamiy {
    String romeStr(int summ) {
        String str = Integer.toString(summ);
        String[] ch = new String[str.length()];
        int i = 0;
        int a = str.length();

        while (a > i) {
            if ((a - i) == 1) {
                ch[i] = edinich(str.codePointAt(i));
                i++;
            } else if ((a - i) == 2) {
                ch[i] = desyatich(str.codePointAt(i));
                i++;
            } else if ((a - i) == 3) {
                ch[i] = tysyach(str.codePointAt(i));
                i++;
            } else {
                i++;
            }
        }
        String nova = String.join("", ch);
        return nova;
    }

    String tysyach(int current){
        String ch = "";

        switch(current){
            case 49:
                ch = "C";
                break;
        }
        return ch;
    }

    String edinich(int current){
        String ch = "";

        switch(current){
            case 49:
                ch = "I";
                break;
            case 50:
                ch = "II";
                break;
            case 51:
                ch = "III";
                break;
            case 52:
                ch = "IV";
                break;
            case 53:
                ch = "V";
                break;
            case 54:
                ch = "VI";
                break;
            case 55:
                ch = "VII";
                break;
            case 56:
                ch = "VIII";
                break;
            case 57:
                ch = "IX";
                break;
        }
        return ch;
    }

    String desyatich(int current){
        String ch = "";

        switch(current){
            case 49:
                ch = "X";
                break;
            case 50:
                ch = "XX";
                break;
            case 51:
                ch = "XXX";
                break;
            case 52:
                ch = "XL";
                break;
            case 53:
                ch = "L";
                break;
            case 54:
                ch = "LX";
                break;
            case 55:
                ch = "LXX";
                break;
            case 56:
                ch = "LXXX";
                break;
            case 57:
                ch = "XC";
                break;
        }
        return ch;
    }

    int romeNumb(String rome) throws Exception {
        int numb1 = 0;

        if((rome.equals("I")) || (rome.equals("1"))){
            numb1 = 1;
        } else if((rome.equals("II")) || (rome.equals("2"))){
            numb1 = 2;
        } else if((rome.equals("III")) || (rome.equals("3"))){
            numb1 = 3;
        } else if((rome.equals("IV")) || (rome.equals("4"))){
            numb1 = 4;
        } else if((rome.equals("V")) || (rome.equals("5"))){
            numb1 = 5;
        } else if((rome.equals("VI")) || (rome.equals("6"))){
            numb1 = 6;
        } else if((rome.equals("VII")) || (rome.equals("7"))){
            numb1 = 7;
        } else if((rome.equals("VIII")) || (rome.equals("8"))){
            numb1 = 8;
        } else if((rome.equals("IX")) || (rome.equals("9"))){
            numb1 = 9;
        } else if((rome.equals("X")) || (rome.equals("10"))){
            numb1 = 10;
        }
        if (numb1 == 0){
            throw new Exception("Необходимо вводить либо римские, либо арабские числа от 1 до 10");
        }
        return numb1;
    }

    int summToInt(int symbol, int num1, int num2){
        int summ = 0;

        switch(symbol){
            case 42:
                summ = num1 * num2;
                break;
            case 43:
                summ = num1 + num2;
                break;
            case 45:
                summ = num1 - num2;
                break;
            case 47:
                summ = num1 / num2;
                break;
        }
        return summ;
    }
}