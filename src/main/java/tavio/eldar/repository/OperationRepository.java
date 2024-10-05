package tavio.eldar.repository;

import org.springframework.data.repository.CrudRepository;
import tavio.eldar.entity.Operation;

import java.util.Optional;

public interface OperationRepository extends CrudRepository<Operation, Long> {
    Operation getById(Long id);
}
