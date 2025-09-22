package util;

import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckMethods {

    public static Date checkDate(Scanner sc, SimpleDateFormat sdf) {
        Date birthdayDate = null;
        boolean valid = false;

        System.out.print("Birthday date (DD/MM/YYY): ");
        while (!valid) {
            try {
                sdf.setLenient(false);
                birthdayDate = sdf.parse(sc.next());
                valid = true;
            } catch (ParseException e) {
                System.out.print("Invalid date/format! Try again: ");
            }
        }
        return birthdayDate;
    }
    public static OrderStatus checkStatus(Scanner sc, OrderStatus orderStat) {

        while (orderStat == null) {
            System.out.println("Enter order data: ");
            System.out.print("Status : ");
            String status = sc.nextLine().toUpperCase().trim();
            try {
                orderStat = OrderStatus.valueOf(status);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status! Try again");
            }
        }
        return orderStat;
    }
}
