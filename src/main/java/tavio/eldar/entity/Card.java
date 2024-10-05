package tavio.eldar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String number;
    private String cardholder;
    @Column
    private LocalDate expDate;
    @Column(precision = 10, scale = 2)
    private BigDecimal rateValue;
    private String operRateStr;

    public Card(){

    }
    public Card(Long id, String brand, String number, String cardholder, LocalDate expDate, BigDecimal rateValue, String operRateStr) {
        this.id = id;
        this.brand = brand;
        this.number = number;
        this.cardholder = cardholder;
        this.expDate = expDate;
        this.rateValue = rateValue;
        this.operRateStr = operRateStr;
    }

    public double operationRate(LocalDate date){
        double rateValueD = rateValue.doubleValue();
        double value;
        double num = 0;
        double num2 = 0;
        String oper ="";
        for(int i = 0; i < operRateStr.length(); i++){
            char character = operRateStr.charAt(i);
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
