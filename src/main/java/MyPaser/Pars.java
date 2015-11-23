package MyPaser;

import java.util.*;

public class Pars {
    private Queue<Character> chars; //очередь, в которой хранитс€ наше выражение

    public Pars(String s) {
        setString(s);
    }

    public void setString(String s){
        chars = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ')
                chars.add(c);
        }
        chars.add('&');//специальный символ, обозначающий конец выражени€
    }

    public Double calc(int r) {
        int rpb = r;
        char tmp;
        double result = 0;
        try {
            result = nud(chars.poll());
            while (priority(chars.peek()) > rpb) {
                tmp = chars.poll();
                result = operators(result, tmp);
            }
            if (priority(chars.peek()) == -1) {
                chars.poll();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }


    private double nud(char c) { //функци€, определ€юща€ назначение символа в начале выражени€
        int minusFlag = 1;// унарный минус
        if (c == '-') {
            minusFlag = -1;
            c = chars.poll();
        }
        switch (c) {
            case '(':
                return calc(0);
            default:
                String tmp = "" + c;
                try {
                    while (priority(c) == priority(chars.peek())) {
                        tmp += chars.poll();
                    }
                    return minusFlag * Double.parseDouble(tmp);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        return 0;
    }

    private double priority(char ch) { // функци€, возвращающа€ приоритет операции
        switch (ch) {
            case ('&'):
                return -2;
            case (')'):
                return -1;
            case ('('):
                return -1;
            case ('+'):
                return 1;
            case '-':
                return 1;
            case ('*'):
                return 2;
            case ('/'):
                return 2;
            case ('^'):
                return 3;
            default:
                return 0;
        }
    }

    private double operators(double m, char ch) throws Exception {
        double result = 0;
        switch (ch) {
            case ('+'):
                result = m + calc(1);
                break;
            case ('-'):
                result = m - calc(1);
                break;
            case ('*'):
                result = m * calc(2);
                break;
            case ('/'):
                result = m / calc(2);
                break;
            case ('^'):
                int t = calc(3).intValue();
                result = Math.pow(m,t);
                break;
            default:
                throw new Exception("Unknown operator: " + ch);
        }
        return result;
    }
}