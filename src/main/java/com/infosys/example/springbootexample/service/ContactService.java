package com.infosys.example.springbootexample.service;

import com.infosys.example.springbootexample.entities.Address;
import com.infosys.example.springbootexample.entities.Contact;
import com.infosys.example.springbootexample.entities.Phone;
import com.infosys.example.springbootexample.model.request.AddressRequest;
import com.infosys.example.springbootexample.model.request.ContactRequest;
import com.infosys.example.springbootexample.model.request.PhoneRequest;
import com.infosys.example.springbootexample.model.response.AddressResponse;
import com.infosys.example.springbootexample.model.response.ContactResponse;
import com.infosys.example.springbootexample.model.response.PhoneResponse;
import com.infosys.example.springbootexample.repositories.ContactRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactService {


    @Autowired
    ContactRepo contactRepo;
    public void createContact(ContactRequest contactRequest) {
        Contact contact = new Contact();


        contact.setName(contactRequest.getName());
        contact.setRollNo(contactRequest.getRollNo());
        contact.setEmail(contactRequest.getEmail());
        List<AddressRequest> addresses = contactRequest.getAddresses();
        List<Address> addresses1 = new ArrayList<>();
        if ((addresses!=null) && (addresses.size()>0)) {
            for (AddressRequest addressRequest : addresses) {
                if (addressRequest != null) {
                    Address address = new Address();
                    address.setAddressLine1(addressRequest.getAddressLine1());
                    address.setCity(addressRequest.getCity());
                    address.setCountry(addressRequest.getCountry());
                    addresses1.add(address);

                }
            }
        }

        contact.setAddresses(addresses1);

        PhoneRequest phoneRequest = contactRequest.getPhoneRequest();
        if(phoneRequest!=null){
        Phone phone = new Phone();
        phone.setMobileNo(phoneRequest.getMobileNo());
        phone.setWorkNo(phoneRequest.getWorkNo());
        contact.setPhone(phone);
    }
        contactRepo.createContact(contact);
    }

    public List<ContactResponse> getContacts() {
        List<Contact> contacts = contactRepo.getContacts();
        List<ContactResponse> usersList = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactResponse response = new ContactResponse();
            response.setId(contact.getId());
            response.setName(contact.getName());
            response.setRollNo(contact.getRollNo());


            Phone phone = contact.getPhone();
            if(phone!=null) {
                PhoneResponse phoneResponse = new PhoneResponse();
                phoneResponse.setMobileNo(phone.getMobileNo());
                phoneResponse.setWorkNo(phone.getWorkNo());
                response.setPhoneResponse(phoneResponse);
            }

            List<Address> addresses = contact.getAddresses();
            List<AddressResponse> addressResponse = new ArrayList<>();
            for (Address address: addresses) {
                AddressResponse addressResponse1 =  new AddressResponse();
                addressResponse1.setCity(address.getCity());
                addressResponse1.setCountry(address.getCountry());
                addressResponse1.setAddressLine1(address.getAddressLine1());
                addressResponse.add(addressResponse1);

            }
            response.setAddresses(addressResponse);

            usersList.add(response);

        }

        return usersList;

    }

    public ContactResponse getContact(Long id) {
        Contact contact = contactRepo.getContact(id);
        ContactResponse contactResponse = new ContactResponse();

        contactResponse.setId(contact.getId());
        contactResponse.setRollNo(contact.getRollNo());
        contactResponse.setName(contact.getName());

        List <Address>  addresses = contact.getAddresses();
        List <AddressResponse> addressResponses = new ArrayList<>();
        for (Address address :addresses) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddressLine1(address.getAddressLine1());
            addressResponse.setCity(address.getCity());
            addressResponse.setCountry(address.getCountry());
            addressResponses.add(addressResponse);

        }
        contactResponse.setAddresses(addressResponses);

        Phone phone = contact.getPhone();
        PhoneResponse phoneResponse = new PhoneResponse();
        if(phone!=null) {
            phoneResponse.setWorkNo(phone.getWorkNo());
            phoneResponse.setMobileNo(phone.getMobileNo());
        }
        contactResponse.setPhoneResponse(phoneResponse);
        return  contactResponse;

    }

    public void updateContact(ContactRequest contactRequest) {
       Contact contact = contactRepo.getContact(contactRequest.getId());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setDeepCopyEnabled(true)
          .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(contactRequest, contact);
        contactRepo.updateContact(contact);

    }



    public void deleteContact(Long id) {
        contactRepo.deleteContact(id);
    }

    public Map<String,String> getRequiredField(Long id) {

        Contact  contact = contactRepo.getContact(id);

        Map<String, String> getfieldMap = new HashMap<>();
        getfieldMap.put("name", contact.getName());
        getfieldMap.put("rollNo", contact.getRollNo());
        return getfieldMap;




    }
}
