package com.github.ntphat.crm.data;

import com.github.ntphat.crm.dto.CustomerDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity {

    String lastName;
    String firstName;
    public Customer(CustomerDTO customerDTO) {
        id=customerDTO.getId();
        lastName=customerDTO.getLastName();
        firstName=customerDTO.getFirstName();
    }
}
