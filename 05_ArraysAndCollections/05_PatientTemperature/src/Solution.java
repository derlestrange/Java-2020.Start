public class Solution {
    public static void main(String[] args) {

        int healthyCount = 0;
        float average = 0.0f;
        float[] temperature = new float[30];

        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = (float) ((Math.random() * (40.0f - 32.0f)) + 32.0f);
            System.out.println("Пациент номер: " + i + ". " +
                    "Температура пациента: " + String.format("%.1f", temperature[i]));

            average += temperature[i];

            if (temperature[i] >= 36.2f && temperature[i] <= 36.9f) {
                healthyCount++;
                System.out.println("Найден здоровый пациент! Его номер: (" + i + "). Запишем.");
            }
        }
        System.out.println("Количество здоровых пациентов: " + healthyCount);
        System.out.println("Средняя температура всех пациентов: " + String.format("%.1f", average / 30));

    }
}
