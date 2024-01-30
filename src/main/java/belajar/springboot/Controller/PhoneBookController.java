package belajar.springboot.Controller;

import org.springframework.web.bind.annotation.RestController;

import belajar.springboot.Model.Contact;
import belajar.springboot.Model.ContactRepository;
import belajar.springboot.Service.PhoneBookServiceImpl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/contacts")
public class PhoneBookController {

	private final AtomicLong counter = new AtomicLong();
    @Autowired
    ContactRepository cRepository;

    @Autowired
    private PhoneBookServiceImpl contactService;
    
    @GetMapping("/searchAll")
    public List<Contact> searchPhoneBook() {
        return contactService.getAllContacts();
    } 

    @GetMapping("/searchById")
    public Contact searchPhoneBookById(@RequestBody Contact contact) {
        Long id = contact.getId();
        return contactService.getContactById(id);
    } 

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/update")
    public Contact updateContact(@RequestBody Contact contact) {
        Long id = contact.getId();
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/delete")
    public void deleteContact(@RequestBody Contact contact) {
        Long id = contact.getId();
        contactService.deleteContact(id);
    }
    
    
}
