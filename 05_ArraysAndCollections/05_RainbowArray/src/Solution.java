public class Solution {
    public static void main(String[] args) {

        String rainbow = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = rainbow.split(",?\\s+");

        //for (String color : colors) System.out.println(color);

        System.out.println();

        int size = colors.length - 1;

        for (int i = 0; i < size + 1; i++) {
            if (i < size / 2 + 1) {
                String words = colors[i];
                colors[i] = colors[size - i];
                colors[size - i] = words;
            }
            System.out.println(colors[i]);
        }

    }
}
