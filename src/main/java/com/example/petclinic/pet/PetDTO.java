package com.example.petclinic.pet;

import com.example.petclinic.owner.Owner;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PetDTO {

    private Long petId;

    @NotNull
    private String species;
    @NotNull
    private Integer age;
    @NotNull
    private String name;

    private Owner owner;

    public PetDTO(String species, Integer age, String name) {
        this.species = species;
        this.age = age;
        this.name = name;
    }
}
