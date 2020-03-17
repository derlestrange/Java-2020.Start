public class Loader {
    //task 5.2============================
    private static Cat getKitten(){
        return new Cat(1100.00);
    }
    public static void main(String[] args) {
        System.out.println("Количество кошек перед созданием кошек = " + Cat.getCount());
        Cat manya = new Cat();
        Cat kuzya = new Cat();
        Cat knopa = new Cat();
        Cat vasya = new Cat();
        Cat pushok = new Cat();

        System.out.println("Количество кошек после создания пяти кошек = " + Cat.getCount());
        // 1 task===========================
        System.out.println("Кормим и проверяем вес двух кошек");
        System.out.println(manya.getWeight());
        manya.feed(150.0);
        System.out.println(manya.getWeight());
        System.out.println(kuzya.getWeight());
        kuzya.feed(4.2);
        System.out.println(kuzya.getWeight());


        System.out.println("Перекармливаем и замяукиваем кошек");
        for (int i = 0; i < 10000; i++) {
            if (knopa.getWeight() >= 9000)
                break;
            knopa.feed(1.1);
            if (knopa.getWeight() >= 9000){
                System.out.println("Эта кошка уже мертва, она не может кушать");
            }
        }
        for (int j=0; j<10000; j++){
            if (vasya.getWeight() <= 1000)
                break;
            vasya.meow();
            if (vasya.getWeight() <= 1000){
                System.out.println("Эта кошка уже мертва, она не может мяукать");
            }
        }
        //task 3 with *=========================
        for (int k=0; k<1000; k++) {
            pushok.drink(1.0);
            if (pushok.getWeight() <= 999 || pushok.getWeight() >= 9001) {
                System.out.println("Пушок умер, он больше ничего не может");
                break;
            }
        }

        System.out.println(pushok.getStatus());
        System.out.println(vasya.getStatus());
        System.out.println(knopa.getStatus());

        //task 2===========================
        System.out.println("Сумма съеденной еды Мани и поход в туалет");
        manya.pee();
        manya.pee();
        System.out.println(manya.feedAmount());

        //task 5===========================
        Cat maxim = new Cat(2222.2);
        System.out.println(maxim.getStatus());

        //task 6===========================
        maxim.setCatColor(Colors.BLACK);
        System.out.println(maxim.getCatColor());

        //task 7===========================
        Cat cloneCat = new Cat();
        cloneCat.feed(9000.0);
        System.out.println(cloneCat.getWeight());
        Cat oneCat = Cat.copyCat(cloneCat);
        System.out.println(oneCat.getWeight());


        //task 3===========================
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        Cat test = new Cat();
        for (int q=0; q<10000; q++){
            test.pee();
            if (test.getWeight() <= 1000) {
                break;
            }
        }

        System.out.println(test.getWeight());
        test.pee();
        System.out.println(test.getWeight());
        test.meow();
        System.out.println(test.getWeight());
        test.feed(4.4);
        System.out.println(test.getWeight());
        System.out.println("Количество после смертельных операций = " + Cat.getCount());

        Cat test2 = new Cat(400.0);
        System.out.println("Количество после смертельных операций = " + Cat.getCount());

        test.pee();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        test.pee();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        test.pee();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        test.pee();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        test.pee();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        Cat hurray = new Cat();
        System.out.println("Количество после смертельных операций = " + Cat.getCount());
        Cat test3 = new Cat();
        test3.feed(34344.4);
        System.out.println("Количество после смертельных операций = " + Cat.getCount());




    }
}