package by.bookstore.orderservice;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping(path = "/order")
@RestController
@Data
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<Order> delete(@RequestBody @Valid Order order) {
        return new ResponseEntity<>(orderService.deleteOrder(order), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Order> deleteById(@Min(1) int id) {
        return new ResponseEntity<>(orderService.deleteOrderById(id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/book")
    public ResponseEntity<Order> updateBookInOrder(long book, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateBookInOrder(book, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/status")
    public ResponseEntity<Order> updateStatusInOrder(long status, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateStatusInOrder(status, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/address")
    public ResponseEntity<Order> updateAddressInOrder(String address, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateAddressInOrder(address, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/store")
    public ResponseEntity<Order> updateStoreInOrder(long store, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateStoreInOrder(store, id), HttpStatus.CREATED);
    }

    @GetMapping(path = "/find/all/by/id")
    public ResponseEntity<List<Order>> findAllOrdersById(@Min(1) int id) {
        return new ResponseEntity<>(orderService.findAllById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/store")
    public ResponseEntity<List<Order>> findAllOrdersStore(long store) {
        return new ResponseEntity<>(orderService.findAllByStore(store), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/address")
    public ResponseEntity<List<Order>> findAllOrdersAddress(String address) {
        return new ResponseEntity<>(orderService.findAllByAddress(address), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/user")
    public ResponseEntity<List<Order>> findAllOrdersUser(long user) {
        return new ResponseEntity<>(orderService.findAllByUser(user), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/status")
    public ResponseEntity<List<Order>> findAllOrdersStatus(long status) {
        return new ResponseEntity<>(orderService.findAllByStatus(status), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Order>> findAllOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
}
