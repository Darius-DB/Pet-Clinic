package com.example.petclinic.owner;

import com.example.petclinic.exceptions.OwnerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public void add(OwnerDTO ownerDTO) {
        if (ownerRepository.findByEmail(ownerDTO.getEmail()).isPresent()) {
            throw new OwnerAlreadyExistsException("There is already an owner with this email address. " +
                    "Please log in instead.");
        }

        Owner owner = OwnerMapper.toOwner(ownerDTO);
        ownerRepository.save(owner);
    }
}
