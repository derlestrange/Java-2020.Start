public class Cat {
    private double originWeight;
    private double weight;

    private double feed;
    public static int count;
    public static final int COUNT_EYES = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private Colors catColor;
    private boolean catLife = true;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        if (!isAlive()) {
            System.out.println("Кошка родилась мертвой, попробуй снова!");
        } else {
            count++;
        }
    }

    public Cat(double weight) {
        this.weight = weight;
        originWeight = this.weight;
        if (!isAlive()) {
            System.out.println("Кошка получилась мертвая, попробуй снова");
        } else {
            count++;
        }
    }

    public static Cat copyCat(Cat cat) {
        if (cat.getWeight() <= MIN_WEIGHT || cat.getWeight() >= MAX_WEIGHT) {
            System.out.println("Копировать мертвую кошку нельзя!");
            count--;
        }
        Cat copyCat = new Cat();
        copyCat.weight = cat.getWeight();
        copyCat.catColor = cat.getCatColor();
        copyCat.originWeight = cat.originWeight;
        return copyCat;
    }

    public Colors getCatColor() {
        return catColor;
    }

    public void setCatColor(Colors color) {
        this.catColor = color;
    }

    public double feedAmount() {
        return feed;
    }

    public boolean isAlive() {
        return getWeight() >= MIN_WEIGHT && getWeight() <= MAX_WEIGHT;
    }

    private boolean catLife() {
        if (!isAlive()) {
            count--;
            this.catLife = false;
        }
        return true;
    }


    public void pee() {
        if (catLife) {
            weight = weight - 1;
            if (catLife()){
                System.out.println("Фух, с облегчением");
            }

        } else {
            System.out.println("Кошка мертва, она не может ходить в туалет");
        }
    }

    public static int getCount() {
        return count;
    }

    public void meow() {
        if (catLife) {
            weight = weight - 1;
            if (catLife()){
                System.out.println("Meow");
            }
        } else {
            System.out.println("Кошка мертва, она не может мяукать");
        }
    }

    public void feed(Double amount) {
        if (catLife) {
            weight = weight + amount;
            feed = weight - weight + amount;
            if (catLife());
        } else {
            System.out.println("Мертвую кошку нельзя кормить");
        }
    }

    public void drink(Double amount) {
        if (catLife) {
            weight = weight + amount;
            if (catLife());
        } else {
            System.out.println("Кошка мертва, она не может пить");
        }
    }

    private void setWeight(Double weight) {
        if (isAlive()) {
            this.weight = weight;
        }
        if (!isAlive()) {
            count--;
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}