package by.bookstoremicro.storeservice.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private static int incId = 1;
    private int id = incId++;

    @Size(min = 2, message = "enter more then 2 characters!")
    @NotNull(message = "city name is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String city;

}
