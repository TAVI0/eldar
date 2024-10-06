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

}
