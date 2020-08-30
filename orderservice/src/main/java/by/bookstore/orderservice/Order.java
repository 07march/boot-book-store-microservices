package by.bookstore.orderservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private static int incId = 1;
    private int id = incId++;

    private List<Long> books;

    private String address;

    private long store;

    private long user;

    @Max(value = 100, message = "max price 100$")
    private BigDecimal totalPrice;

    @NotNull(message = "not null! enter ACTIVE or CLOSE")
    private long status;

    @NotNull
    private long type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return user == order.user &&
                Objects.equals(books, order.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, user);
    }
}
