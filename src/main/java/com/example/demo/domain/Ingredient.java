package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;
    public static enum Type {
      WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
