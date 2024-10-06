package tavio.eldar.service;

import org.springframework.stereotype.Service;
import tavio.eldar.entity.Brand;
import tavio.eldar.entity.Card;

import java.util.List;

@Service
public interface BrandService {

   List<Brand> getAll();
   Brand getById(Long id);
   Brand getByName(String name);
}
