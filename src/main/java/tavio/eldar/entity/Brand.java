package tavio.eldar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String operRateStr;
    private BigDecimal multiValue;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Card> cards = new ArrayList<>();
    public Brand() {
    }

    public Brand(Long id, String name, String operRateStr, BigDecimal multiValue) {
        this.id = id;
        this.name = name;
        this.operRateStr = operRateStr;
        this.multiValue = multiValue;
    }
}
/*
    "VISA", "y/m", 1
    "NARA", "d", 0.5
    "AMEX", "m", 0.1
    */