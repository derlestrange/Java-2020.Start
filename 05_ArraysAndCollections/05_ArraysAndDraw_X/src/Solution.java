public class Solution {
    public static void main(String[] args) {
        int size = 9;
        int i = size;
        int j = size;
        String[][] pattern = new String[i][j];

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (i == j || i + j + 1 == size) {
                    pattern[i][j] = "X";
                } else {
                    pattern[i][j] = " ";
                }
                System.out.print(pattern[i][j]);
            }
            System.out.print("\n");
        }
    }
}
