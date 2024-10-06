package tavio.eldar.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tavio.eldar.entity.Brand;
import tavio.eldar.entity.Card;
import tavio.eldar.repository.BrandRepository;
import tavio.eldar.repository.CardRepository;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Transactional
    @Override
    public Brand getById(Long id) {
        return brandRepository.getById(id).orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }

    @Override
    public Brand getByName(String name) {
        return brandRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }
}
