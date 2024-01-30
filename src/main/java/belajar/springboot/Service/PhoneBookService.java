package belajar.springboot.Service;

import java.util.List;

import belajar.springboot.Model.Contact;

public interface PhoneBookService {
    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    Contact addContact(Contact contact);

    Contact updateContact(Long id, Contact contact);

    void deleteContact(Long id);
}
