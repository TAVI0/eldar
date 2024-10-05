package tavio.eldar.repository;

import org.springframework.data.repository.CrudRepository;
import tavio.eldar.entity.Card;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Long> {
    Optional<Card> getById(Long id);
}
