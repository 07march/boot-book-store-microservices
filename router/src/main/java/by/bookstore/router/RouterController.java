package by.bookstore.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class RouterController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/auth")
    public Object auth(@RequestParam String login, @RequestParam String pass){
        return restTemplate.getForObject("http://localhost:8090/auth?login={login}&pass={pass}", Object.class, login, pass);
    }

    @PostMapping(path = "/author")
    public Object addAuthor(@RequestBody Object author){
        return restTemplate.postForObject("http://localhost:8091/author", author, Object.class);
    }

    @PostMapping(path = "/author/delete")
    public Object deleteAuthor(@RequestBody Object author){
        return restTemplate.postForObject("http://localhost:8091/author/delete", author, Object.class);
    }

    @PostMapping(path = "/author/delete/id")
    public Object deleteAuthorById(@RequestBody Object author){
        return restTemplate.postForObject("http://localhost:8091/author/delete/id", author, Object.class);
    }

    @PostMapping(path = "/author/update")
    public Object updateAuthorName(@RequestBody String name){
        return restTemplate.postForObject("http://localhost:8091/author/update", name, Object.class);
    }

    @GetMapping(path = "/author/find/all")
    public List findAllAuthors() {
        return restTemplate.getForObject("http://localhost:8091/author/find/all", List.class);
    }

    @GetMapping(path = "/author/find/name")
    public Object findAuthorByName(@RequestParam String name) {
        return restTemplate.getForObject("http://localhost:8091/author/find/name", Object.class, name);
    }

    @GetMapping(path = "/author/find/id")
    public Object findAuthorById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8091/author/find/id", Object.class, id);
    }

    @PostMapping(path = "/book/save")
    public Object bookSave(@RequestBody Object book) {
        return restTemplate.postForObject("http://localhost:8091/book/save", book, Object.class);
    }

    @PostMapping(path = "/book/delete")
    public Object deleteBook(@RequestBody Object book) {
        return restTemplate.postForObject("http://localhost:8091/book/delete", book, Object.class);
    }

    @PostMapping(path = "/book/delete/id")
    public Object deleteBookById(@RequestBody Object book) {
        return restTemplate.postForObject("http://localhost:8091/book/delete/id", book, Object.class);
    }

    @PostMapping(path = "/book/update/title")
    public Object updateTitle(@RequestParam String title) {
        return restTemplate.postForObject("http://localhost:8091/book/update/title", title, Object.class);
    }

    @PostMapping(path = "/book/update/description")
    public Object updateDescription(@RequestParam String description) {
        return restTemplate.postForObject("http://localhost:8091/book/update/description", description, Object.class);
    }

    @PostMapping(path = "/book/update/price")
    public Object updatePrice(@RequestParam BigDecimal price) {
        return restTemplate.postForObject("http://localhost:8091/book/update/price", price, Object.class);
    }

    @PostMapping(path = "/book/update/author")
    public Object updateAuthor(@RequestBody Object author) {
        return restTemplate.postForObject("http://localhost:8091/book/update/author", author, Object.class);
    }

    @GetMapping(path = "/book/find/all/books")
    public List findAllBooks() {
        return restTemplate.getForObject("http://localhost:8091/book/find/all/books", List.class);
    }

    @GetMapping(path = "/book/find/all/author")
    public List findAllBooksByAuthor(@RequestBody Object author) {
        return restTemplate.getForObject("http://localhost:8091/book/find/all/author", List.class, author);
    }

    @GetMapping(path = "/book/find/all/price")
    public List findAllBooksByPrice(@RequestParam BigDecimal price) {
        return restTemplate.getForObject("http://localhost:8091/book/find/all/price", List.class, price);
    }

    @GetMapping(path = "/book/find/id")
    public Object findBookById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8091/book/find/id", Object.class, id);
    }

    @PostMapping(path = "/order")
    public Object saveOrder(@RequestHeader("token") String token, @RequestBody Object order) {
        if (checkAuth(token)) {
            return restTemplate.postForObject("http://localhost:8092/order", order, Object.class);
        }
        return null;
    }

    private boolean checkAuth(String token) {
        HttpStatus statusCode = restTemplate.getForEntity("http://localhost:8090/auth/check?token={token}", String.class, token).getStatusCode();
        return statusCode.equals(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/order/delete")
    public Object deleteOrder(@RequestBody Object order){
        return restTemplate.postForObject("http://localhost:8092/order/delete", order, Object.class);
    }

    @PostMapping(path = "/order/delete/id")
    public Object deleteOrderById(@RequestBody Object order){
        return restTemplate.postForObject("http://localhost:8092/order/delete/id", order, Object.class);
    }

    @PostMapping(path = "/order/update/book")
    public Object updateBookInOrder(@RequestParam long book){
        return restTemplate.postForObject("http://localhost:8092/order/update/book", book, Object.class);
    }

    @PostMapping(path = "/order/update/status")
    public Object updateOrderStatus(@RequestParam long status){
        return restTemplate.postForObject("http://localhost:8092/order/update/status", status, Object.class);
    }

    @PostMapping(path = "/order/update/address")
    public Object updateAddressInOrder(@RequestParam String address){
        return restTemplate.postForObject("http://localhost:8092/order/update/address", address, Object.class);
    }

    @PostMapping(path = "/order/update/store")
    public Object updateStoreInOrder(@RequestParam long store) {
        return restTemplate.postForObject("http://localhost:8092/order/update/store", store, Object.class);
    }

    @GetMapping(path = "/order/find/all")
    public List findAllOrders() {
        return restTemplate.getForObject("http://localhost:8091/order/find/all", List.class);
    }

    @GetMapping(path = "/order/find/all/by/store")
    public List findAllOrdersByStore(@RequestParam long store) {
        return restTemplate.getForObject("http://localhost:8091/order/find/all/by/store", List.class, store);
    }

    @GetMapping(path = "/order/find/all/by/address")
    public List findAllOrdersByAddress(@RequestParam String address) {
        return restTemplate.getForObject("http://localhost:8091/order/find/all/by/address", List.class, address);
    }

    @GetMapping(path = "/order/find/all/by/user")
    public List findAllOrdersByUser(@RequestParam long user) {
        return restTemplate.getForObject("http://localhost:8091/order/find/all/by/user", List.class, user);
    }

    @GetMapping(path = "/order/find/all/by/status")
    public List findAllOrdersByStatus(@RequestParam long status) {
        return restTemplate.getForObject("http://localhost:8091/order/find/all/by/status", List.class, status);
    }

    @GetMapping(path = "/order/find/all/by/id")
    public List findAllOrdersById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8091/order/find/all/by/id", List.class, id );
    }

    @PostMapping(path = "/address")
    public Object addressSave(@RequestBody Object address) {
        return restTemplate.postForObject("http://localhost:8093/address", address, Object.class);
    }

    @PostMapping(path = "/address/delete")
    public Object deleteAddress(@RequestBody Object address) {
        return restTemplate.postForObject("http://localhost:8093/address/delete", address, Object.class);
    }

    @PostMapping(path = "/address/delete/id")
    public Object deleteAddressById(@RequestBody Object address) {
        return restTemplate.postForObject("http://localhost:8093/address/delete/id", address, Object.class);
    }

    @PostMapping(path = "/address/update")
    public Object updateAddress(@RequestBody Object address) {
        return restTemplate.postForObject("http://localhost:8093/address/update", address, Object.class);
    }

    @GetMapping(path = "/address/find/all")
    public List findAllAddresses() {
        return restTemplate.getForObject("http://localhost:8093/address/find/all", List.class);
    }

    @GetMapping(path = "/address/find/name")
    public Object findAddressByName(@RequestParam String address) {
        return restTemplate.getForObject("http://localhost:8093/address/find/name", Object.class, address);
    }

    @GetMapping(path = "/address/find/id")
    public Object findAddressById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8093/address/find/id", Object.class, id);
    }

    @PostMapping(path = "/city")
    public Object citySave(@RequestBody Object city) {
        return restTemplate.postForObject("http://localhost:8093/city", city, Object.class);
    }

    @PostMapping(path = "/city/delete")
    public Object deleteCity(@RequestBody Object city) {
        return restTemplate.postForObject("http://localhost:8093/city/delete", city, Object.class);
    }

    @PostMapping(path = "/city/delete/id")
    public Object deleteCityById(@RequestBody Object city) {
        return restTemplate.postForObject("http://localhost:8093/city/delete/id", city, Object.class);
    }

    @PostMapping(path = "/city/update")
    public Object updateCity(@RequestBody Object city) {
        return restTemplate.postForObject("http://localhost:8093/city/update", city, Object.class);
    }

    @GetMapping(path = "/city/find/all")
    public List findAllCities() {
        return restTemplate.getForObject("http://localhost:8093/city/find/all", List.class);
    }

    @GetMapping(path = "/city/find/name")
    public Object findCityByName(@RequestParam String city) {
        return restTemplate.getForObject("http://localhost:8093/city/find/name", Object.class, city);
    }

    @GetMapping(path = "/city/find/id")
    public Object findCityById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8093/city/find/id", Object.class, id);
    }

    @PostMapping(path = "/store")
    public Object storeSave(@RequestBody Object store) {
        return restTemplate.postForObject("http://localhost:8093/store", store, Object.class);
    }

    @PostMapping(path = "/store/delete")
    public Object deleteStore(@RequestBody Object store) {
        return restTemplate.postForObject("http://localhost:8093/store/delete", store, Object.class);
    }

    @PostMapping(path = "/store/delete/id")
    public Object deleteStoreById(@RequestBody Object store) {
        return restTemplate.postForObject("http://localhost:8093/store/delete/id", store, Object.class);
    }

    @PostMapping(path = "/store/update/name")
    public Object updateStoreName(@RequestParam String store) {
        return restTemplate.postForObject("http://localhost:8093/store/update/name", store, Object.class);
    }

    @PostMapping(path = "/store/update/address")
    public Object updateStoreAddress(@RequestBody Object address) {
        return restTemplate.postForObject("http://localhost:8093/store/update/address", address, Object.class);
    }

    @PostMapping(path = "/store/update/city")
    public Object updateStoreCity(@RequestBody Object city) {
        return restTemplate.postForObject("http://localhost:8093/store/update/city", city, Object.class);
    }

    @GetMapping(path = "/store/find/all")
    public List findAllStores() {
        return restTemplate.getForObject("http://localhost:8093/store/find/all", List.class);
    }

    @GetMapping(path = "/store/find/name")
    public Object findStoreByName(@RequestParam String store) {
        return restTemplate.getForObject("http://localhost:8093/store/find/name", Object.class, store);
    }

    @GetMapping(path = "/store/find/address")
    public Object findStoreByAddress(@RequestBody Object address) {
        return restTemplate.getForObject("http://localhost:8093/store/find/address", Object.class, address);
    }

    @GetMapping(path = "/store/find/city")
    public Object findStoreByCity(@RequestBody Object city) {
        return restTemplate.getForObject("http://localhost:8093/store/find/city", Object.class, city);
    }

    @GetMapping(path = "/store/find/id")
    public Object findStoreById(@RequestParam int id) {
        return restTemplate.getForObject("http://localhost:8093/store/find/id", Object.class, id);
    }

    @PostMapping(path = "/user")
    public Object saveUser(@RequestBody Object user) {
        return restTemplate.postForObject("http://localhost:8094/user", user, Object.class);
    }

    @PostMapping(path = "/user/delete")
    public Object deleteUser(@RequestBody Object user) {
        return restTemplate.postForObject("http://localhost:8094/user/delete", user, Object.class);
    }

    @PostMapping(path = "/user/update")
    public Object updateUser(@RequestBody Object user) {
        return restTemplate.postForObject("http://localhost:8094/user/update", user, Object.class);
    }

    @GetMapping(path = "/user/find/all")
    public List findAllUsers(){
        return restTemplate.getForObject("http://localhost:8094/user/find/all", List.class);
    }

    @GetMapping(path = "/user/find/id")
    public Object findUserById(@RequestParam int id){
        return restTemplate.getForObject("http://localhost:8094/user/find/id", Object.class, id);
    }

    @GetMapping(path = "/user/find/login")
    public Object findUserByLogin(@RequestParam String login){
        return restTemplate.getForObject("http://localhost:8094/user/find/login", Object.class, login);
    }

    @GetMapping(path = "/user/find/name")
    public Object findUserByName(@RequestParam String name){
        return restTemplate.getForObject("http://localhost:8094/user/find/name", Object.class, name);
    }

    @GetMapping(path = "/user/checkUser")
    public Object checkUser(@RequestParam String login, @RequestParam String pass){
        return restTemplate.getForObject("http://localhost:8094/user/checkUser", Object.class, login, pass);
    }
}
