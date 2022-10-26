package com.example.petclinic.owner;

import com.example.petclinic.utils.Group1;
import com.example.petclinic.utils.Group2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraintvalidation.SupportedValidationTarget;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> addOwner(@Validated({Group1.class}) @RequestBody OwnerDTO ownerDTO) {
        ownerService.add(ownerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@Validated({Group2.class}) @RequestBody OwnerDTO ownerDTO,
                                                @PathVariable Long id) {

        return new ResponseEntity<>(ownerService.update(id, ownerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        ownerService.delete(id);
        return new ResponseEntity<>("Owner deletes successfully", HttpStatus.OK);
    }
}
