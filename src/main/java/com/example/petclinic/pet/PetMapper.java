package com.example.petclinic.pet;

import com.example.petclinic.owner.Owner;
import com.example.petclinic.owner.OwnerDTO;

public class PetMapper {

    public static PetDTO toPetDTO(Pet pet) {
        return PetDTO.builder()
                .petId(pet.getPetId())
                .species(pet.getSpecies())
                .age(pet.getAge())
                .name(pet.getName())
                .owner(pet.getOwner())
                .build();
    }

    public static Pet toPet(PetDTO petDTO) {
        return Pet.builder()
                .species(petDTO.getSpecies())
                .age(petDTO.getAge())
                .name(petDTO.getName())
                .build();

    }
}
