
public class Loader {
    public static void main(String[] args) {

        String text = "Вася заработал 23 рублей, Петя - 235455443 рубля, а Маша - 34353434 рублей";

        System.out.println(text);

        int vasyaWage = Integer.parseInt
                (text.substring((text.indexOf(' ', 5)), (text.indexOf("руб"))).trim());

        int petyaWage = Integer.parseInt
                (text.substring((text.indexOf('-') + 2), (text.indexOf("рубля"))).trim());

        int mashaWage = Integer.parseInt
                (text.substring((text.lastIndexOf('-') + 2), (text.lastIndexOf("руб")) - 1));

        System.out.println("Сумма заработка всех друзей: " + (vasyaWage + petyaWage + mashaWage) + " рублей");
    }
}