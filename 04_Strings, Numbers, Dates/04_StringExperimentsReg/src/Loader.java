import java.util.Arrays;

public class Loader {
    public static void main(String[] args) {

        String text = "Вася заработал 2000 рублей, Петя - 500 рубля, а Маша - 500 рублей, 7000, 790000";

        System.out.println(text);

        String[] incomeFriends = text.replaceAll("[^0-9,]", "").split(",");
        System.out.println(Arrays.toString(incomeFriends));

        int sum=0;

        for (String income : incomeFriends) {
            sum += Integer.parseInt(income);
        }
        System.out.println("Зарплата всех друзей: " + sum + " рублей");

    }
}