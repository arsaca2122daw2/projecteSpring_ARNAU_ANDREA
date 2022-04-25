package fje.edu.daw2.Projecte_Spring_ARNAUSALINAS_ANDREASANCHEZ;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interficie de persistència amb Spring Data i MongoDB.
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2019
 */

    public interface MongoDBRepositori extends MongoRepository<Previsio, String> {

    Previsio findByTemperatura(float temperatura);
    List<Previsio> findByDia(String dia);
    List<Previsio> findByCiutat(String ciutat);
    List<Previsio> findByIcona(String icona);
    void deleteAllByCiutatAndDia(String ciutat, String dia);
    void deleteById(String id);
}
