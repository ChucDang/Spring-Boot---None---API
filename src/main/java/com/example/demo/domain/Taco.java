package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name = "Taco")
public class Taco {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @NonNull
  private String name;
  private Date createdAt;

  @ManyToMany(targetEntity=Ingredient.class)
  private List<Ingredient> ingredients = new ArrayList<>();
  
  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }
}
