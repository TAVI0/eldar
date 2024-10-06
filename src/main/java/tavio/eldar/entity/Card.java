package tavio.eldar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String cardholder;
    @Column
    private LocalDate expDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @JsonManagedReference
    private Brand brand;

    public Card(){

    }
    public Card(Long id, String number, String cardholder, LocalDate expDate) {
        this.id = id;
        this.number = number;
        this.cardholder = cardholder;
        this.expDate = expDate;
    }

}
