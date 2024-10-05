package tavio.eldar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tavio.eldar.entity.Card;
import tavio.eldar.service.CardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/all")
    public List<Card> getAll(){
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public Card getById(@PathVariable("id") Long id){
        return cardService.getById(id);
    }


}
