import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Product {
    private int ID;
    private String Name;
    private String Producer;
    private double Price;
    private int ShelfLife;
    private int Quantity;


    public Product(int ID, String Name, String Producer, double Price, int ShelfLife, int Quantity) {
        this.ID = ID;
        this.Name = Name;
        this.Producer = Producer;
        this.Price = Price;
        this.ShelfLife = ShelfLife;
        this.Quantity = Quantity;
    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getManufacturer() {
        return Producer;
    }

    public double getPrice() {
        return Price;
    }

    public int getShelfLife() {
        return ShelfLife;
    }

    public int getQuantity() {
        return Quantity;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(889, "Fish", "FishCompany 'Alert'", 27.56, 14, 47));
        products.add(new Product(515, "Eggs", "Aggver", 10.00, 17, 205));
        products.add(new Product(421, "Fish", "Farm 'Moror'", 22.12, 5, 50));
        products.add(new Product(468, "Bacon", "KartWears", 35.21, 6, 240));
        products.add(new Product(146, "Apple", "UkraineCompLviv", 40.00, 7, 30));
        products.add(new Product(180, "Protein", "PowerMS 'Gera'", 697.00, 100, 412));
        products.add(new Product(831, "Chocolate", "WillyWonka factory'", 100.00, 30, 152));

        Scanner scanner = new Scanner(System.in);


        System.out.println("Операція:");
        System.out.println("1. Вивести товари для заданого найменування");
        System.out.println("2. Вивести товари для заданого найменування, ціна яких не перевищує задану");
        System.out.println("3. Вивести товари, термін зберігання яких більше заданого");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Введіть найменування товару:");
                String desiredName = scanner.nextLine();
                System.out.println("Товари \"" + desiredName + "\":");
                for (Product product : products) {
                    if (product.getName().equalsIgnoreCase(desiredName)) {
                        System.out.println(product.getName() + " від " + product.getManufacturer() + ", Ціна: " + product.getPrice());

                    }
                }
                break;

            case 2:
                System.out.println("Введіть назву товару:");
                desiredName = scanner.nextLine();
                System.out.println("Введіть максимальну ціну:");
                double maxPrice = scanner.nextDouble();
                System.out.println("Товари з назвою \"" + desiredName + "\" та ціною не більше " + maxPrice + ":");
                for (Product product : products) {
                    if (product.getName().equalsIgnoreCase(desiredName) && product.getPrice() <= maxPrice) {
                        System.out.println(product.getName() + " від " + product.getManufacturer() + ", Ціна: " + product.getPrice());

                    }
                }
                break;

            case 3:
                System.out.println("Введіть термін зберігання:");
                int minShelfLifeMonths = scanner.nextInt();
                System.out.println("Товари з терміном зберігання більше " + minShelfLifeMonths + " днів:");
                for (Product product : products) {
                    if (product.getShelfLife() > minShelfLifeMonths) {
                        System.out.println(product.getName() + " від " + product.getManufacturer() + ", Термін зберігання: " + product.getShelfLife() + " днів.");

                    }
                }
                break;
            case 0:
                System.out.println("Вихід");
                break;

            default:
                System.out.println("Неправильний вибір.");
                break;

        }
        scanner.close();
    }

}