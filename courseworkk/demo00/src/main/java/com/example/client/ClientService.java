package com.example.client;
import java.util.List; // ordered collection (sequence) односоставная. the elements of the list are of the same data type.
// Each element has an index and can be manipulated based on their position.
// The sequential nature of List allows the use of iteration methods (listIterator).
import org.springframework.beans.factory.annotation.Autowired; // для связи зависимостей из всех классов.
// Tells the application context to inject an instance of CarRepository here
import org.springframework.stereotype.Service; // аннотация для обнаружения всех зависимостей, указывает, что класс CarService принадлежит серверу SpringBoot.
@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;
    public List<Client> listAll(String keyword) {
        if (keyword!=null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    public void save(Client client) {
        repo.save(client);
    }
    public Client get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
