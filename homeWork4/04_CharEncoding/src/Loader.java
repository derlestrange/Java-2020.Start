public class Loader {
    public static void main(String[] args) {

        String alphabetEng = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String aplhabetRus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        for (int i = 0; i < alphabetEng.length(); i++) {
            char code = alphabetEng.charAt(i);
            System.out.println("Буква: "  + alphabetEng.charAt(i) +" Код буквы: " + (int) code);
        }

        System.out.println();

        for (int j = 0; j < aplhabetRus.length(); j++){
            char codeRus = aplhabetRus.charAt(j);
            System.out.println("Русская буква: " + aplhabetRus.charAt(j) + " Код буквы: " + (int) codeRus);
        }

    }

}
