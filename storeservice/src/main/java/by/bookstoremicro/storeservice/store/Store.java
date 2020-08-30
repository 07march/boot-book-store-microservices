package by.bookstoremicro.storeservice.store;

import by.bookstoremicro.storeservice.address.Address;
import by.bookstoremicro.storeservice.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private static int incId = 1;
    private int id = incId++;

    @NotBlank(message = "not blank!")
    @NotNull(message = "store is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String store;

    @Size(min = 2, message = "enter more then 2 characters!")
    @NotBlank(message = "not blank!")
    @NotNull(message = "address is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private Address address;

    @NotBlank(message = "not blank!")
    @NotNull(message = "city is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private City city;

}
