package com.infosys.example.springbootexample.controller;

import com.infosys.example.springbootexample.model.request.ContactRequest;
import com.infosys.example.springbootexample.model.response.ContactResponse;
import com.infosys.example.springbootexample.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public void createContact(@RequestBody @Valid  ContactRequest contactRequest) {
    contactService.createContact(contactRequest);


    }

    @GetMapping
    public List<ContactResponse> getContacts() {
        return contactService.getContacts();
    }


  @GetMapping("/{id}")
    public ContactResponse getContact(@PathVariable Long id){

        return  contactService.getContact(id);
  }

  @PutMapping
    public void updateContacts(@RequestBody ContactRequest contactRequest){
      contactService.updateContact(contactRequest);


    }
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id){
          contactService.deleteContact(id);

    }
@GetMapping("/specific/{id}")
public Map<String,String> getRequiredFileds(@PathVariable Long id){

    return contactService.getRequiredField(id);



}

}