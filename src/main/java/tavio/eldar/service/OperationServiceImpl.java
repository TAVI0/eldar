package tavio.eldar.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tavio.eldar.entity.Operation;
import tavio.eldar.repository.OperationRepository;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    private OperationRepository operationRepository;


    @Override
    public List<Operation> getAll() {
        return null;
    }

    @Transactional
    @Override
    public Operation getById(Long id) {
        return operationRepository.getById(id);
    }
}
