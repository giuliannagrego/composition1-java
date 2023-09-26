package application;

import model.entities.*;
import model.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = sc.next();
        System.out.print("E-mail: ");
        String emailClient = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date bdayClient = sdf.parse(sc.next());
        Client client = new Client(nameClient, emailClient, bdayClient);

        System.out.println();
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus statusOrder = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), statusOrder, client);

        System.out.println();
        System.out.print("How many items to this order? ");
        int totalItems = sc.nextInt();

        for( int i = 0; i < totalItems; i++) {
            System.out.println("Enter item #" + (i + 1) + " data:");
            System.out.print("Product name: ");
            String nameProduct = sc.next();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();

            Product product = new Product(nameProduct, priceProduct);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, priceProduct, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
