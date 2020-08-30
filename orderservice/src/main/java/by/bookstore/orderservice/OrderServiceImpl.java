package by.bookstore.orderservice;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.addOrder(order);
    }

    @Override
    public Order deleteOrder(Order order) {
        return orderRepository.deleteOrder(order);
    }

    @Override
    public Order deleteOrderById(int id) {
        return orderRepository.deleteOrderById(id);
    }

    @Override
    public Order updateBookInOrder(long book, int id) {
        return orderRepository.updateBook(book, id);
    }

    @Override
    public Order updateStatusInOrder(long status, int id) {
        return orderRepository.updateStatus(status, id);
    }

    @Override
    public Order updateAddressInOrder(String address, int id) {
        return orderRepository.updateAddress(address, id);
    }

    @Override
    public Order updateStoreInOrder(long store, int id) {
        return orderRepository.updateStore(store, id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAllOrders();
    }

    @Override
    public List<Order> findAllById(int id) {
        return orderRepository.findAllById(id);
    }

    @Override
    public List<Order> findAllByStatus(long status) {
        return orderRepository.findAllByStatus(status);
    }

    @Override
    public List<Order> findAllByStore(long store) {
        return orderRepository.findAllByStore(store);
    }

    @Override
    public List<Order> findAllByAddress(String address) {
        return orderRepository.findAllByAddress(address);
    }

    @Override
    public List<Order> findAllByUser(long user) {
        return orderRepository.findAllByUser(user);
    }
}

