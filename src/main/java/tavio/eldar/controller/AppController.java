package tavio.eldar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tavio.eldar.entity.Card;
import tavio.eldar.service.BrandService;
import tavio.eldar.service.CardService;
import tavio.eldar.service.OperationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private CardService cardService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private BrandService brandService;

   /* @GetMapping("/card/all")
    public List<Card> getAll(){
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public Card getById(@PathVariable("id") Long id){
        return cardService.getById(id);
    }
*/
    @GetMapping("/rate")
    public double getOperationRate(@RequestParam("brand") String cardBrand, @RequestParam("amount") double amount){
        double operRate = operationService.operationRate(LocalDate.now(), brandService.getByName(cardBrand));
        return operRate*amount;
    }

}
