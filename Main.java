
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        try {
            System.out.println("Введите слово/строку/регулярное выражение:");
            Scanner in = new Scanner(System.in);
            String stringSearch = in.nextLine();

            System.out.println("Введите слово/строку/несколько строк. Окончание ввода обозначается вводом пустой строки!");

            if(stringSearch.length()>0) {
                String[] masStringSearch ;
                masStringSearch = stringSearch.split(" ");

                ArrayList<String> arrayOutput = new ArrayList<>();

                String stringInput;
                String[] masStringInput ;
                do {
                    stringInput = in.nextLine();
                    masStringInput = stringInput.split(" ");
                    Boolean bool = false;
                    for (String s1: masStringSearch){
                        if (bool){
                            break;
                        }
                        for (String s2 : masStringInput) {

                            if (s2.equals(s1)|| Pattern.matches(s1, s2)) {
                                arrayOutput.add(stringInput);
                                //System.out.println(str);
                                bool = true;
                                break;

                            }
                        }
                    }
                }
                while (stringInput.length() > 0);

                System.out.println("Вывод:");
                arrayOutput.forEach(stringFromList -> System.out.println(stringFromList));
            }
            else{
                System.out.println("Незадан аргумент для поиска строки.");
            }
        }
        catch (PatternSyntaxException e){
            System.out.println("Ошибка регулярного выражения:");
            System.out.println(e.getDescription());
        }
        catch(Exception e){
            System.out.println("Ошибка");
        }

    }
}


