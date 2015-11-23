package MyPaser;

import java.util.Scanner;

/**
 * Created by User on 10.11.2015.
 */
public class MyClass {
    public static void main(String[] args) {
        String s = "";
        System.out.println("Write expression");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        Pars p = new Pars(s);   //разбор выражений методом Вогана Пратта
        System.out.println(p.calc(0));
        scanner.close();
    }
}
