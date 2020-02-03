public class Loader {
    public static void main(String[] args) {

        //for================================

        for (int i = 200000; i < 235001; i++) {
            System.out.println(i + " for");
            if (i == 210000) {
                i = 219999;
            }
        }

        //while===============================

        int q = 200000;
        while (q < 235000) {
            q++;
            System.out.println(q + " while");
            if (q == 210000) {
                q = 219999;
            }
        }
    }
}

