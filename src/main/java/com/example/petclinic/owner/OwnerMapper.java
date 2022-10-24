package com.example.petclinic.owner;

public class OwnerMapper {

    public static OwnerDTO toOwnerDTO(Owner owner) {
        return OwnerDTO.builder()
                .ownerId(owner.getOwnerId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .city(owner.getCity())
                .phoneNumber(owner.getPhoneNumber())
                .email(owner.getEmail())
                .pets(owner.getPets())
                .build();
    }

    public static Owner toOwner(OwnerDTO ownerDTO) {
        return Owner.builder()
                .firstName(ownerDTO.getFirstName())
                .lastName(ownerDTO.getLastName())
                .city(ownerDTO.getCity())
                .phoneNumber(ownerDTO.getPhoneNumber())
                .email(ownerDTO.getEmail())
                .build();

    }
}
