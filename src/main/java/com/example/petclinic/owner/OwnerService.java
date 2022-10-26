package com.example.petclinic.owner;

import com.example.petclinic.exceptions.OwnerAlreadyExistsException;
import com.example.petclinic.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    public OwnerDTO update(Long id, OwnerDTO ownerDTO) {
        Owner ownerToUpdate = ownerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The specified owner does not exist"));


        copyNonNullProperties(ownerDTO, ownerToUpdate);

        Owner updatedOwner = ownerRepository.save(ownerToUpdate);

        return OwnerMapper.toOwnerDTO(updatedOwner);
     }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public void delete(Long id) {
        if (ownerRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("The specified owner does not exist");
        }
        
        ownerRepository.deleteById(id);
    }
}
