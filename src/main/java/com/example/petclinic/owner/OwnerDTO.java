package com.example.petclinic.owner;

import com.example.petclinic.pet.Pet;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OwnerDTO {

    private Long ownerId;

    @NotNull @NotBlank @NotEmpty
    private String firstName;

    @NotNull @NotBlank @NotEmpty
    private String lastName;

    @NotNull @NotBlank @NotEmpty
    private String city;

    @NotNull  @Size(max = 10, min = 10) @Pattern(regexp = "^[0-9]*$")
    private String phoneNumber;

    @NotNull @NotBlank @NotEmpty @Email
    private String email;

    private List<Pet> pets;

    public OwnerDTO(String firstName, String lastName, String city, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
