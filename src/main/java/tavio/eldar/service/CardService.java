package tavio.eldar.service;

import org.springframework.stereotype.Service;
import tavio.eldar.entity.Card;

import java.util.List;
import java.util.Optional;

@Service
public interface CardService {

   List<Card> getAll();
   Card getById(Long id);
}
