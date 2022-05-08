package com.example.demo.domain;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "Taco_Order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    private Date placedAt;
    @NotBlank(message = "Vui lòng nhập trường này")
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;

//    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

//    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
//            message="Must be formatted MM/YY")
    private String ccExpiration;
    private String ccCVV;
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}

