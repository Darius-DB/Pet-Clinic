package com.example.petclinic.owner;

import com.example.petclinic.pet.Pet;
import com.example.petclinic.utils.Group1;
import com.example.petclinic.utils.Group2;
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

    @NotBlank(groups = {Group1.class})
    private String firstName;

    @NotBlank(groups = {Group1.class})
    private String lastName;

    @NotBlank(groups = {Group1.class})
    private String city;

    @NotNull(groups = {Group1.class})
    @Size(max = 10, min = 10, groups = {Group1.class, Group2.class})
    @Pattern(regexp = "^[0-9]*$", groups = {Group1.class, Group2.class})
    private String phoneNumber;

    @NotBlank(groups = {Group1.class})
    @Email(groups = {Group1.class, Group2.class})
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
