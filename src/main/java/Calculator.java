import java.util.*;

public class Calculator {
    private double account, amount;
    ArrayList<Product> products = new ArrayList<>();
    public Calculator() {}
    public void count(int numberOfPeople) {
        account = amount / numberOfPeople;
    }

    public void addNewProduct(String name, double cost) {
        products.add(new Product(name, cost));
        calculateTheAmount(cost);
    }

    public void calculateTheAmount(double cost) {
        amount += cost;
    }

    public void printList() {
        System.out.println("Добавленные товары:");
        for (Product x : products) {
            System.out.println(x.getName());
        }

        String rublesMessage = editRublesMessage();

        String messageTemplate = "Каждый человек должен заплатить %.2f %s.";
        System.out.printf((messageTemplate) + "%n", account, rublesMessage);
    }

    public String editRublesMessage() {
        String rublesMessage = "рубль";
        int accountFormat1 = (int) account % 100;
        int accountFormat2 = (int) account % 10;

        if (accountFormat1 >= 2 && accountFormat1 <= 4) {
            rublesMessage = "рубля";
        } else if (accountFormat1 >= 5 && accountFormat1 <= 20) {
            rublesMessage = "рублей";
        } else if (accountFormat2 >= 2 && accountFormat2 <= 4) {
            rublesMessage = "рубля";
        } else if (accountFormat2 >= 5) {
            rublesMessage = "рублей";
        }
        return rublesMessage;
    }
}
