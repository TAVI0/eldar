package tavio.eldar.service;

import org.springframework.stereotype.Service;
import tavio.eldar.entity.Operation;

import java.util.List;
import java.util.Optional;

@Service
public interface OperationService {
    List<Operation> getAll();
    Operation getById(Long id);
}
