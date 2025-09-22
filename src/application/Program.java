package application;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Client;
import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import static util.CheckMethods.checkDate;
import static util.CheckMethods.checkStatus;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        Date birthday = checkDate(sc, sdf);
        Client client = new Client(name, email, birthday);

        sc.nextLine();
        OrderStatus stat = checkStatus(sc, null);
        Order order = new Order(new Date(), stat, client);


        System.out.print("How many items to order? ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.printf("Enter #%d item data:\n", i + 1);
            System.out.print("Product name: ");
            sc.nextLine();
            String prodName = sc.nextLine();
            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();
            Product product = new Product(prodName, prodPrice);

            System.out.print("Quantity: ");
            int prodQuantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(prodQuantity, prodPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);
    }
}
