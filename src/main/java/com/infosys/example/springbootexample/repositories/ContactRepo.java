package com.infosys.example.springbootexample.repositories;

import com.infosys.example.springbootexample.entities.Contact;
import com.infosys.example.springbootexample.model.request.PhoneRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class
ContactRepo {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void createContact(Contact contact)

    {
        manager.persist(contact);

    }
    public List<Contact> getContacts(){
        Query createQuery = manager.createQuery("FROM Contact");
        List<Contact> users = createQuery.getResultList();
        return (List<Contact>) users;
    }


public Contact getContact(Long id) {
    Query query = manager.createQuery("from Contact where id=:id");
    query.setParameter("id", id);
    return (Contact)
            query.getResultList().stream().findFirst().orElse(null);
}

    @Transactional
    public void updateContact(Contact contact) {
//        Query query = manager.createQuery("update Contact set name =:name where id =:id");
//    query.setParameter("name",contact.getName());
//    query.setParameter("id",contact.getId());
//
//     query.executeUpdate();
        manager.merge(contact);
    }

    @Transactional
    public void deleteContact(Long id){
        Query query = manager.createQuery("delete from Contact where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
      /* *//**//* query.getResultList().stream().findFirst().orElse(null);*/
    }

}



