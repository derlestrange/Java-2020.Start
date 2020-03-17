public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        Integer test = sumDigits(222);
        System.out.println(test);
    }

    public static Integer sumDigits(Integer number) {

        String str = Integer.toString(number);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
//            num += Integer.parseInt(String.valueOf(Integer.toString(number).charAt(i)));
            num += Character.getNumericValue(str.charAt(i));
        }
        System.out.println(str);
        return num;
    }
}
