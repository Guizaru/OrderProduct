package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> productList = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient(){
        return client;
    }

    public List<OrderItem> getProductList() {
        return productList;
    }

    public void addItem(OrderItem quantity ){
        productList.add(quantity);
    }
    public void removeItem(OrderItem quantity ){
        productList.remove(quantity);
    }
    public double total() {
        double totalPrice = 0.0;
        for (OrderItem item : productList) {
            totalPrice += item.subTotal();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append("Client: ");
        sb.append(client).append("\n");
        sb.append("Order items:\n");
        for (OrderItem item : productList) {
            sb.append(item).append("\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}