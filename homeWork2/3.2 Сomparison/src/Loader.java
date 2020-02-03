public class Loader {
    public static void main(String[] args) {
        Integer dimaAge = 3522;
        Integer mishaAge = 182;
        Integer vasyaAge = 100;

        Integer oldest = 0;
        Integer youngest = 0;
        Integer middle = 0;

        if (dimaAge < mishaAge && dimaAge < vasyaAge) {
            youngest = dimaAge;
            if (mishaAge < vasyaAge) {
                middle = mishaAge;
                oldest = vasyaAge;
            } else {
                middle = vasyaAge;
                oldest = mishaAge;
            }
        }
        if (mishaAge < dimaAge && mishaAge < vasyaAge) {
            youngest = mishaAge;
            if (dimaAge < vasyaAge) {
                middle = dimaAge;
                oldest = vasyaAge;
            } else {
                middle = vasyaAge;
                oldest = dimaAge;
            }
        }
        if (vasyaAge < dimaAge && vasyaAge < mishaAge) {
            youngest = vasyaAge;
            if (dimaAge < mishaAge) {
                middle = dimaAge;
                oldest = mishaAge;
            } else {
                middle = mishaAge;
                oldest = dimaAge;
            }
        }
        System.out.println("oldest " + oldest);
        System.out.println("middle " + middle);
        System.out.println("youngest " + youngest);
    }
}