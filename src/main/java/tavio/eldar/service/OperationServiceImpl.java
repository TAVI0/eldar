package tavio.eldar.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import tavio.eldar.entity.Card;
import tavio.eldar.entity.Operation;
import tavio.eldar.repository.OperationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private CardService cardService;

    @Override
    public List<Operation> getAll() {
        return null;
    }

    @Transactional
    @Override
    public Operation getById(Long id) {
        return operationRepository.getById(id);
    }

    public double operationRate(Long id){
        Operation operation = getById(id);
        Card card =  cardService.getById(operation.getCardId());
        LocalDate date = operation.getDate();
//        LocalDate date = card.getExpDate();
        double rateValueD = card.getRateValue().doubleValue();
        double value;
        double num = 0;
        double num2 = 0;
        String oper ="";
        for(int i = 0; i < card.getOperRateStr().length(); i++){
            char character = card.getOperRateStr().charAt(i);
            switch (character){
                case 'y':
                    if(num == 0) {
                        num = date.getYear()-2000;
                    }else{
                        num2 = date.getYear()-2000;
                    }
                    System.out.print(date.getYear()-2000);
                    break;
                case 'm':
                    if(num == 0) {
                        num = date.getMonthValue();
                    }else{
                        num2 = date.getMonthValue();
                    }
                    System.out.print(date.getMonthValue());

                    break;
                case 'd':
                    if(num == 0) {
                        num = date.getDayOfMonth();
                    }else{
                        num2 = date.getDayOfMonth();
                    }
                    System.out.print(date.getDayOfMonth());

                    break;
                case '/':
                    oper = "/";
                    System.out.print("/");

                    break;
                case '*':
                    oper = "*";
                    System.out.print("*");

                    break;
            }
        }
        if(oper.equals("*")){
            value = num * num2 * rateValueD;
        } else if (oper.equals("/")) {
            value = (num / num2) * rateValueD;
        }else{
            value = num * rateValueD;
        }
        if(rateValueD<0.3){
            return 0.3;
        }
        if(rateValueD>5){
            return 5;
        }

        return value;
    }
}
