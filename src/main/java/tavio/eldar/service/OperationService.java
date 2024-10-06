package tavio.eldar.service;

import org.springframework.stereotype.Service;
import tavio.eldar.entity.Brand;
import tavio.eldar.entity.Operation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface OperationService {
    List<Operation> getAll();
    Operation getById(Long id);

    double operationRate(LocalDate date, Brand brand);
}
