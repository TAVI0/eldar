package tavio.eldar.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tavio.eldar.entity.Card;
import tavio.eldar.repository.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAll() {
        return (List<Card>) cardRepository.findAll();
    }

    @Transactional
    @Override
    public Card getById(Long id) {
        return cardRepository.getById(id).orElseThrow(() -> new EntityNotFoundException("Card not found"));
    }
}
