package com.example.petclinic.pet;

import com.example.petclinic.owner.Owner;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private Owner owner;

    public Pet(String species, Integer age, String name) {
        this.species = species;
        this.age = age;
        this.name = name;
    }
}
