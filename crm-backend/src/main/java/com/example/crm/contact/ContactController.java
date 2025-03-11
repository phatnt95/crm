package com.example.crm.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    // GET a contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) {
        Optional<Contact> contactData = contactRepository.findById(id);
        return contactData.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK)) // 200 OK if found
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // 404 Not Found if not found
    }
    // POST a new contact
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        try {
            Contact _contact = contactRepository.save(
                    new Contact(
                        contact.getName(),
                        contact.getEmail(),
                        contact.getPhone(),
                        contact.getCompany()
                    )
            );
            return new ResponseEntity<>(_contact, HttpStatus.CREATED); // 201 Created
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Error
        }
    }

    // PUT (Update) a contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
        Optional<Contact> contactData = contactRepository.findById(id);
        if (contactData.isPresent()) {
            Contact _contact = contactData.get();
            _contact.setName(contact.getName());
            _contact.setEmail(contact.getEmail());
            _contact.setPhone(contact.getPhone());
            _contact.setCompany(contact.getCompany());
            return new ResponseEntity<>(contactRepository.save(_contact), HttpStatus.OK); // 200 OK after update
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found if contact ID doesn't exist
        }
    }
}
