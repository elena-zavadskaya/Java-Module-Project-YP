import java.util.Scanner;

public class UserInterface {
    public static int splitTheBill() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople;
        System.out.println("На какое количество человек необходимо разделить счёт?");

        while (!scanner.hasNextInt()) {
            System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
            System.out.println("На какое количество человек необходимо разделить счёт?");
            scanner.next();
        }
        numberOfPeople = scanner.nextInt();

        while (numberOfPeople <= 1) {
            System.out.println("Число должно быть больше 1. Давайте попробуем снова.");
            System.out.println("На какое количество человек необходимо разделить счёт?");
            while (!scanner.hasNextInt()) {
                System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
                System.out.println("На какое количество человек необходимо разделить счёт?");
                scanner.next();
            }
            numberOfPeople = scanner.nextInt();
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
        double cost;

        while (!scanner.hasNextDouble()) {
            System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
            System.out.println("Введите стоимость товара в формате [рубли,копейки].");
            scanner.next();
        }
        cost = scanner.nextDouble();

        while (cost <= 0) {
            System.out.println("Стоимость товара не может быть нулевой или отрицательной. Давайте попробуем снова.");
            System.out.println("Введите стоимость товара в формате [рубли,копейки].");
            while (!scanner.hasNextDouble()) {
                System.out.println("Вы ввели что-то не то. Давайте попробуем снова.");
                System.out.println("Введите стоимость товара в формате [рубли,копейки].");
                scanner.next();
            }
            cost = scanner.nextDouble();
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
