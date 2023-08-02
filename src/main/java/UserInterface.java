import java.util.Scanner;

public class UserInterface {
    public static int splitTheBill() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = 0;
        System.out.println("На какое количество человек необходимо разделить счёт?");

        if (scanner.hasNextInt()) {
            numberOfPeople = scanner.nextInt();
        } else {
            System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
            splitTheBill();
        }

        if (numberOfPeople == 1) {
            System.out.println("В этом случае нет смысла ничего считать и делить. Число должно быть больше 1. Давайте попробуем снова.");
            splitTheBill();
        } else if (numberOfPeople < 1) {
            System.out.println("Это некорректное значение для подсчёта. Число должно быть больше 1. Давайте попробуем снова.");
            splitTheBill();
        }
        return numberOfPeople;
    }

    public static void requestProductInformation(Calculator calculator, int numberOfPeople) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название товара.");
        String name = null;
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        } else {
            System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
            requestProductInformation(calculator, numberOfPeople);
        }

        System.out.println("Введите стоимость товара в формате [рубли,копейки].");
        double cost = 0;

        if (scanner.hasNextDouble()) {
            cost = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
            requestProductInformation(calculator, numberOfPeople);
        }

        // Добавила условие на проверку значения
        if (cost <= 0) {
            System.out.println("Стоимость товара не может быть нулевой или отрицательной. Давайте попробуем снова.");
            requestProductInformation(calculator, numberOfPeople);
        }

        calculator.addNewProduct(name, cost);
        calculator.count(numberOfPeople);

        System.out.println("Товар успешно добавлен.");
        System.out.println("Хотите добавить еще один товар?");
        System.out.println("Если нет, введите слово \"завершить\" в любом регистре.");
        System.out.println("Если хотите продолжить, введите любой символ.");

        String checking = scanner.next();

        if (!checking.equalsIgnoreCase("Завершить")) {
            requestProductInformation(calculator, numberOfPeople);
        } else {
            calculator.printList();
            scanner.close();
        }
    }
}
