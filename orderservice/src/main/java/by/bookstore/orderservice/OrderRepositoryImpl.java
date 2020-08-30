package by.bookstore.orderservice;

import by.bookstore.orderservice.exception.OrderExistsException;
import by.bookstore.orderservice.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    public List<Order> orders = new ArrayList<>();

    @Override
    public Order addOrder(Order order) {
        if (orders.contains(order)){
            throw new OrderExistsException("order already exists!");
        }
        orders.add(order);
        return order;
    }
    @Override
    public Order deleteOrder(Order order) {
        if (orders.contains(order)){
            orders.remove(order);
            return order;
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public Order deleteOrderById(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                Order order = orders.get(i);
                orders.remove(order);
                return order;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public Order updateBook(long book, int id) {
        for (Order order1 : orders) {
            if (order1.getId() == id) {
                order1.getBooks().add(book);
                return order1;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public Order updateStatus(long status, int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setStatus(status);
                return order;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public Order updateAddress(String address, int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setAddress(address);
                return order;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public Order updateStore(long store, int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setStore(store);
                return order;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public List<Order> findAllOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public List<Order> findAllById(int id) {
        List<Order> ordersById = new ArrayList<>();
        for (Order order1 : orders) {
            if (order1.getId() == id) {
                ordersById.add(order1);
                return ordersById;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public List<Order> findAllByStatus(long status) {
        List<Order> ordersByStatus = new ArrayList<>();
        for (Order ord : orders) {
            if (ord.getStatus() == status) {
                ordersByStatus.add(ord);
                return ordersByStatus;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public List<Order> findAllByStore(long store) {
        List<Order> ordersByStore = new ArrayList<>();
        for (Order ord : orders) {
            if (ord.getStore() == store) {
                ordersByStore.add(ord);
                return ordersByStore;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public List<Order> findAllByAddress(String address) {
        List<Order> ordersByAddress = new ArrayList<>();
        for (Order order1 : orders) {
            if (order1.getAddress().equals(address)) {
                ordersByAddress.add(order1);
                return ordersByAddress;
            }
        }
        throw new NotFoundException("order not found!");
    }
    @Override
    public List<Order> findAllByUser(long user) {
        List<Order> ordersByUser = new ArrayList<>();
        for (Order order1 : orders) {
            if (order1.getUser() == user) {
                ordersByUser.add(order1);
                return ordersByUser;
            }
        }
        throw new NotFoundException("order not found!");
    }
}
