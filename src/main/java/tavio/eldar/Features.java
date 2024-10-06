package tavio.eldar;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import tavio.eldar.entity.Card;
import tavio.eldar.entity.Operation;
import tavio.eldar.service.CardService;
import tavio.eldar.service.OperationService;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Features {

    private final CardService cardService;
    private final OperationService operationService;

    public Features(CardService cardService, OperationService operationService) {
        this.cardService = cardService;
        this.operationService = operationService;
    }
    @Transactional
    public void process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a option:\n1) Card info\n2) Operation valid\n3) Card valid\n4) Compare cards\n5) Operation rate info");
        String opt = scanner.nextLine();
        long optL = 0l;
        long optL2 = 0l;
        switch (opt) {
            case "1":
                System.out.println("insert a card id: ");
                optL = scanner.nextLong();
                getCardInfo(cardService.getById(optL));
                break;
            case "2":
                System.out.println("insert a operation id: ");
                optL = scanner.nextLong();
                isOperationValid(operationService.getById(optL));
                break;
            case "3":
                System.out.println("insert a card id: ");
                optL = scanner.nextLong();
                isCardValid(cardService.getById(optL));
                break;
            case "4":
                System.out.println("insert a card id: ");
                optL = scanner.nextLong();
                System.out.println("insert a card2 id: ");
                optL2 = scanner.nextLong();
                isCardEqual(cardService.getById(optL), cardService.getById(optL2));
                break;
            case "5":
                System.out.println("insert a operation id: ");
                optL = scanner.nextLong();
                getOperationRate(operationService.getById(optL));
                break;
        }
    }

    public void getCardInfo(Card card){
        System.out.println("brand: "+card.getBrand()+"\nnumber: "+card.getNumber()
                +"\ncardholder: "+card.getCardholder()+"\nexpiration: "+card.getExpDate());
    }

    public void isOperationValid(Operation operation){
        if(operation.getValue()<1000){
            System.out.println("the operation: "+operation.getId()+" is valid");
        }else{
            System.out.println("the operation: "+operation.getId()+" is NOT valid");
        }
    }

    public void isCardValid(Card card){
        if(card.getExpDate().isAfter(LocalDate.now())) {
            System.out.println("The card: "+card.getNumber()+" is valid to operate");
        }else{
            System.out.println("The card: "+card.getNumber()+" is NOT valid to operate");
        }
    }

    public void isCardEqual(Card card1, Card card2){
        if(card1.equals(card2)){
            System.out.println("The cards "+ card1.getId()+" and "+card2.getId()+" are the same");
        }else{
            System.out.println("The cards "+ card1.getId()+" and "+card2.getId()+" are NOT the same");
        }
    }

    public void getOperationRate(Operation oper){
        Card card = cardService.getById(oper.getCardId());
        String brand= "";
        double amount=0;
        if(card != null){
            brand = card.getBrand();
            amount = operationService.operationRate(oper.getId());
            System.out.println("\nBrand: "+brand+"\namount: "+amount+"%");
            System.out.println("OperRateStr: "+card.getOperRateStr()+"\ndate: "+oper.getDate());
        }
    }


}
