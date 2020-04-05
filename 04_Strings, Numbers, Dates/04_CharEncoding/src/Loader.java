public class Loader {
    public static void main(String[] args) {

        char yoBig = 'Ё', yoSmall = 'ё';

        for(char i = 'A'; i <= 'я'; i++) {
            if (i == ('Z')) {
                i = 'a';
            }

            if (i == ('z')) {
                i = 'А';
            }

            System.out.print(i == 'Ж' ? yoBig + " - " + (int) yoBig + "\n" : "");
            System.out.print(i == 'ж' ? yoSmall + " - " + (int) yoSmall + "\n" : "");
            System.out.println(i + " - " + (int) i);
        }
    }
}



