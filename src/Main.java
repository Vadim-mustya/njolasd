import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        gameSelection();
    }



    static void gameSelection() {
        System.out.println("Хотите угадать число или слово?");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        if(sc.equals("число")) setGameNumber();
        if (sc.equals("слово")) setGameWords();

    }


    static void setGameNumber() {
        System.out.println("Отлично, ваша задача угадать число от 1 до 10");
        System.out.println("---------------------------------------------------");
        boolean answer;
        while (true) {
            int randomNumber = (int) (Math.random() * 10) + 1;
            answer = checkNumber(randomNumber);
            if(!answer) {
                System.out.println("Хорошо, до встречи!");
                break;
            } else {
                System.out.println("Может теперь хотите угадать слово?");
                answer = yesOrNo();
                if(answer) {
                    setGameWords();
                    break;
                }

            }

        }
    }

    static boolean checkNumber(int number) {
        boolean h = false;

        int x = 3;

        System.out.println("У вас есть 3 попыткы");


        while (true) {

            if (x == 0) {
                System.out.println("Вы исчерапли все попытки,попробуете еще раз?(да/нет)");
                h = yesOrNo();
                break;
            }

            System.out.println("("+"Попыток осталось: " + x+")");

            Scanner numberGuess = new Scanner(System.in);
            int n = numberGuess.nextInt();
            System.out.println(n);


            if (n < number) {
                System.out.println("Ваше число меньше, попробуйте еще раз");
            }
            if (n > number) System.out.println("Ваше число больше, попробуйте еще раз");

            if (n == number) {
                System.out.println("Поздравляем, вы угадали!Хотите попробовать еще раз?(да/нет)");
                h = yesOrNo();
                break;
            }

            x--;
        }
        return h;
    }







    static void setGameWords() {

        System.out.println("Супер, испытаем ваше везение");
        String[] word = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon"
                , "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        boolean answer ;
        while (true){
            System.out.println("Я загадал слово, как думаете, какое?");
            answer = checkWord(word);
            if(!answer) {
                System.out.println("Хорошо, до встречи!");
                break;
            }else {
                System.out.println("Может хотите теперь угадывать числа?(да/нет)");
                answer = yesOrNo();
                if(answer) {
                    setGameNumber();
                    break;
                }
            }
        }

    }
    static boolean checkWord(String[] word) {

        boolean answer = false;

        int x = (int) (Math.random()*word.length);
        String w = word[x];

        char[] symbols = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        for(int i = 0;i < w.length();i++) {
            System.out.println();

            Scanner sc = new Scanner(System.in);
            String guessWord = sc.nextLine();


            if(guessWord.equals(w)) {
                System.out.println("Поздравляю, вы угадали!");
                System.out.println("Хотите начать заново?(да/нет)");
                answer = yesOrNo();
                break;

            } else {
                System.out.println("Нет =(,даю подсказу");
                symbols[i] = w.charAt(i);
                for (int j =0;j < symbols.length;j++) {

                    System.out.print(symbols[j]);

                }

                System.out.println();

                if (i == w.length() - 1) {

                    System.out.println("к сожалению не угадали, ваше слово было: " + w);
                    System.out.println("Хотите попробовать снова?(да/нет)");
                    answer = yesOrNo();
                    break;

                }
            }
        }
        return answer;
    }




    static boolean yesOrNo () {

        boolean q = false;
        Scanner yesOrNo = new Scanner(System.in);
        String answer = yesOrNo.nextLine();
        if (answer.equals("да")) {
            q = true;
        }
        else if ((answer.equals("нет"))) {
            q = false;
        }
        else {
            System.out.println("Буду считать, что это значит нет =)");
            System.out.println("-----------------------------------");
        }
        return q;
    }

}
