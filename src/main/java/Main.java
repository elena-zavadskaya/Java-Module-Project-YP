import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int numberOfPeople = splitTheBill(calculator);
        requestProductInformation(calculator, numberOfPeople);
    }

    public static int splitTheBill(Calculator calculator) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople;
        System.out.println("На скольких человек необходимо разделить счёт?");

        numberOfPeople = scanner.nextInt();

        if (numberOfPeople == 1) {
            System.out.println("В этом случае нет смысла ничего считать и делить. Давайте попробуем снова.");
            splitTheBill(calculator);
        } else if (numberOfPeople < 1) {
            System.out.println("Это некорректное значение для подсчёта. Давайте попробуем снова.");
            splitTheBill(calculator);
        }
        return numberOfPeople;
    }

    public static void requestProductInformation(Calculator calculator, int numberOfPeople) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название товара.");
        String name = scanner.nextLine();

        System.out.println("Введите стоимость товара.");
        double cost = scanner.nextDouble();

        calculator.addNewProduct(name, cost);
        calculator.count(numberOfPeople);

        System.out.println("Товар успешно добавлен.");
        System.out.println("Хотите добавить еще один товар?");

        String checking = scanner.next();

        if (!checking.equalsIgnoreCase("Завершить")) {
            requestProductInformation(calculator, numberOfPeople);
        } else {
            calculator.printList();
        }
    }
}