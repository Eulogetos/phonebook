package belajar.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import belajar.springboot.Model.Contact;
import belajar.springboot.Model.ContactRepository;

@Service
public class PhoneBookServiceImpl implements PhoneBookService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElse(null);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setName(contact.getName());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            return contactRepository.save(existingContact);
        } else {
            return null; // Contact with the given id not found
        }
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
