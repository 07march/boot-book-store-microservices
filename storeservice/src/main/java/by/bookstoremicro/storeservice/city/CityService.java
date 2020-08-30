package by.bookstoremicro.storeservice.city;

import java.util.List;

public interface CityService {

    City addCity(City city);
    City deleteCity(City city);
    City deleteCityById(int id);
    City updateCity(City city);
    List<City> findAllCities();
    City findCityByName(City city);
    City findCityById(int id);

}
