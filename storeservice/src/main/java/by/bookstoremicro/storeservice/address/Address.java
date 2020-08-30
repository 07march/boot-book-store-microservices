package by.bookstoremicro.storeservice.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private static int incId = 1;
    private int id = incId++;

    @NotNull(message = "address is not null")
    @Size(min = 2, message = "enter more then 2 characters!")
    public String address;

}
