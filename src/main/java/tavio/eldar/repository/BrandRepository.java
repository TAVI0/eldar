package tavio.eldar.repository;

import org.springframework.data.repository.CrudRepository;
import tavio.eldar.entity.Brand;
import tavio.eldar.entity.Card;

import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    Optional<Brand> getById(Long id);
    Optional<Brand> findByName(String name);

}
