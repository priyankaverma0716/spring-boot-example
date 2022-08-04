package com.infosys.example.springbootexample.repositories;

import com.infosys.example.springbootexample.entities.Contact;
import com.infosys.example.springbootexample.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepo {
    @PersistenceContext
    private EntityManager manager;



    @Transactional
    public Product getProduct(Long productId) {
       // manager.getReference(ProductEntity.class,productId);
        Query query =  manager.createQuery("from Product where productId =:productId");
        query.setParameter("productId",productId);
        return (Product)
                query.getResultList().stream().findFirst().orElse(null);


    }

    @Transactional
    public void createProduct(Product product) {
        manager.persist(product);

    }

    public List<Product> getProducts(String keyword) {
        if(keyword==null) {
        Query createQuery = manager.createQuery("FROM Product");
        List<Product> users = createQuery.getResultList();
        return (List<Product>) users;
        }

        try {
            String HQL = "SELECT p FROM Product p WHERE p.productName like :keyword";
            return manager.createQuery(HQL)
                    .setParameter("keyword", "%" + keyword.toUpperCase() + "%")
                    .getResultList();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void deleteProduct(Long id) {

            Query query = manager.createQuery("delete from Supplier where supplierId=:id");
            query.setParameter("id", id);
            query.executeUpdate();


    }
}

