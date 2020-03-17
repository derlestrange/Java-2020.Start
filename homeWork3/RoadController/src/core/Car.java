package core;

public class Car {
    public String number; //создание переменной
    public int height; //создание переменной
    public double weight; //создание переменной
    public boolean hasVehicle; //создание переменной
    public boolean isSpecial; //создание переменной

    //1
    private void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    //2
    private void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    //3
    private void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    //4
    private void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public boolean isVehicle() {
        return hasVehicle;
    }

    //5
    private void setSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
                special + "Автомобиль с номером " + number +
                ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}