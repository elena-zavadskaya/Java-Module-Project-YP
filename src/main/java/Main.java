public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int numberOfPeople = UserInterface.splitTheBill();
        UserInterface.requestProductInformation(calculator, numberOfPeople);
    }
}