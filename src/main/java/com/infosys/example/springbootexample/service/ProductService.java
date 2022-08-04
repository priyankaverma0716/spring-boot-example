package com.infosys.example.springbootexample.service;

import com.infosys.example.springbootexample.entities.*;
import com.infosys.example.springbootexample.model.request.*;
import com.infosys.example.springbootexample.model.response.*;
import com.infosys.example.springbootexample.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    //What is Autowired
//    Autowiring feature of spring framework enables you to inject the object dependency implicitly

    @Autowired
    ProductRepo productRepo;

    //
    public List<ProductResponse> getProducts(String keyword) {
        List<Product> productsList = productRepo.getProducts(keyword);
        List<ProductResponse> productResponses1 = new ArrayList<>();

        for (Product product : productsList) {

            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductName(product.getProductName());
            productResponse.setProductType(product.getProductType());
            productResponse.setDiameter(product.getDiameter());
            productResponse.setSize(product.getSize());
            //Get the value from ProductSpecification

            List<ProdSpecfication> prodSpecficationsList1 = product.getProdSpecfication();
            List<ProdSpecResponse> prodSpecResponsesList = new ArrayList<>();

            for(ProdSpecfication prdSpecification :  prodSpecficationsList1) {
                ProdSpecResponse prodSpecResponse = new ProdSpecResponse();
                prodSpecResponse.setProdSpecId(prdSpecification.getProdSpecId());
                prodSpecResponse.setColor(prdSpecification.getColor());
                prodSpecResponse.setModel(prdSpecification.getModel());
                prodSpecResponsesList.add(prodSpecResponse);
            }

            productResponse.setProdSpecResponse(prodSpecResponsesList);
            //GetProductFeatures

            List<ProductFeatureResponse> productFeatureResponsesList = new ArrayList<>();
            List<ProductFeaturesEntity> productFeaturesEntityList = product.getProductFeaturesEntity();

            for (ProductFeaturesEntity productFeaturesEntity : productFeaturesEntityList) {
                ProductFeatureResponse productFeatureResponse = new ProductFeatureResponse();
               // productFeatureResponse.setShape(productFeaturesEntity.getShape());
                productFeatureResponse.setColor(productFeaturesEntity.getColor());
                productFeatureResponse.setMetal(productFeaturesEntity.getMetal());
                productFeatureResponsesList.add(productFeatureResponse);
            }
            productResponse.setProductFeatureResponse(productFeatureResponsesList);

                // Get Product Price
            ProdPriceResponse prodPriceResponse = new ProdPriceResponse();
            ProdPriceEntity prodPriceEntity = product.getProdPriceEntity();
            prodPriceResponse.setWholesalePrice(prodPriceEntity.getWholesalePrice());
            prodPriceResponse.setCostPrice(prodPriceEntity.getCostPrice());
            prodPriceResponse.setSellingPrice(prodPriceEntity.getSellingPrice());
            prodPriceResponse.setPriceId(prodPriceEntity.getPriceId());
            productResponse.setProdPriceResponse(prodPriceResponse);

            //Get Supplier Details
            SupplierResponse supplierResponse = new SupplierResponse();
            Supplier supplier = product.getSupplier();
            supplierResponse.setSupplierName(supplier.getName());
            supplierResponse.setEmail(supplier.getEmail());
            supplierResponse.setPhoneNumber(supplier.getPhoneNumber());
            supplierResponse.setOrg(supplier.getOrg());
            productResponse.setSupplierResponse(supplierResponse);
            productResponses1.add(productResponse);


        }

        return productResponses1;
    }


    public void createProduct(ProductRequest productRequest) {

        SupplierRequest supplierRequest = productRequest.getSupplierRequest();

        Product product = new Product();

        Supplier supplier = new Supplier();

        if (supplierRequest != null) {
            supplier.setEmail(supplierRequest.getEmail());
            supplier.setName(supplierRequest.getSupplierName());
            supplier.setOrg(supplierRequest.getOrg());
            supplier.setPhoneNumber(supplierRequest.getPhoneNumber());
            product.setSupplier(supplier);
        }


        List<ProdSpecfication> prodSpecfication = new ArrayList<>();
        List<ProdSpecRequest> prodSpecRequest = productRequest.getProdSpecRequest();
        if (prodSpecRequest != null && prodSpecRequest.size() > 0) {
            for (ProdSpecRequest prodspecreq : prodSpecRequest) {
                ProdSpecfication prodSpecfication1 = new ProdSpecfication();
                prodSpecfication1.setColor(prodspecreq.getColor());
                prodSpecfication1.setModel(prodspecreq.getModel());
                prodSpecfication.add(prodSpecfication1);
            }
            product.setProdSpecfication(prodSpecfication);

            List<ProductFeaturesEntity> productFeaturesEntity = new ArrayList<>();

            List<ProductFeatureRequest> productFeatureRequests = productRequest.getProductFeatureRequests();
            if (productFeatureRequests != null && productFeatureRequests.size() > 0) {


                for (ProductFeatureRequest productFeatureReq : productFeatureRequests) {
                    ProductFeaturesEntity productFeaturesEntity1 = new ProductFeaturesEntity();
                  //  productFeaturesEntity1.setShape(productFeatureReq.getShape());
                    productFeaturesEntity1.setColor(productFeatureReq.getColor());
                    productFeaturesEntity1.setMetal(productFeatureReq.getMetal());

                    String shape = productFeatureReq.getShape();

                    if ("HEART".equalsIgnoreCase(shape))
                        productFeaturesEntity1.setShape1(Shape.HEART);
                    else if ("OVAL".equalsIgnoreCase(shape))
                        productFeaturesEntity1.setShape1(Shape.OVAL);
                    else if ("ROUND".equalsIgnoreCase(shape))
                        productFeaturesEntity1.setShape1(Shape.ROUND);

                    productFeaturesEntity.add(productFeaturesEntity1);


                }
                product.setProductFeaturesEntity(productFeaturesEntity);

            }

            ProdPriceRequest prodPriceRequest = productRequest.getProdPriceRequest();
            ProdPriceEntity prodPriceEntity = new ProdPriceEntity();

            prodPriceEntity.setCostPrice(prodPriceRequest.getCostPrice());
            prodPriceEntity.setSellingPrice(prodPriceRequest.getSellingPrice());
            prodPriceEntity.setWholesalePrice(prodPriceRequest.getWholesalePrice());

            product.setProductName(productRequest.getProductName());
            product.setSize(productRequest.getSize());
            product.setDiameter(productRequest.getDiameter());

            product.setProdPriceEntity(prodPriceEntity);
            product.setProdSpecfication((prodSpecfication));


            String type = productRequest.getProductType();


            if ("RING".equalsIgnoreCase(type))
                product.setProductType(ProductType.RING);
            else if ("BRACLETS".equalsIgnoreCase(type))
                product.setProductType(ProductType.BRACLETS);
            else if ("CHOKER".equalsIgnoreCase(type))
                product.setProductType(ProductType.CHOKER);
            else if ("EARRING".equalsIgnoreCase(type))
                product.setProductType(ProductType.EARRING);
            else if ("NECKLACE".equalsIgnoreCase(type))
                product.setProductType(ProductType.NECKLACE);




            productRepo.createProduct(product);


        }

    }

    public ProductResponse getProduct(Long id) {
        Product product = productRepo.getProduct(id);

        if (product != null) {
            ProductResponse productResponse = new ProductResponse();
            Supplier supplier = product.getSupplier();

            SupplierResponse supplierResponse = new SupplierResponse();

            supplierResponse.setSupplierName(supplier.getName());
            supplierResponse.setPhoneNumber(supplier.getPhoneNumber());
            supplierResponse.setEmail(supplier.getEmail());
            supplierResponse.setOrg(supplier.getOrg());
            productResponse.setSupplierResponse(supplierResponse);


            ProdPriceResponse prodPriceResponse = new ProdPriceResponse();
            ProdPriceEntity prodPriceEntity = product.getProdPriceEntity();
            prodPriceResponse.setCostPrice(prodPriceEntity.getCostPrice());
            prodPriceResponse.setSellingPrice(prodPriceEntity.getSellingPrice());
            productResponse.setProdPriceResponse(prodPriceResponse);

            List<ProductFeatureResponse> productFeatureResponses = new ArrayList<>();
            List<ProductFeaturesEntity> productFeaturesEntities = product.getProductFeaturesEntity();

            for (ProductFeaturesEntity productFeat : productFeaturesEntities) {

                ProductFeatureResponse productFeatureResponse = new ProductFeatureResponse();
                productFeatureResponse.setColor(productFeat.getColor());
                productFeatureResponse.setMetal(productFeat.getMetal());
                productFeatureResponse.setColor(productFeat.getColor());
                productFeatureResponses.add(productFeatureResponse);
            }
            productResponse.setProductFeatureResponse(productFeatureResponses);


            List<ProdSpecResponse> prodSpecficationResponseList = new ArrayList<>();
            List<ProdSpecfication> prodSpecList = product.getProdSpecfication();

            for (ProdSpecfication abc : prodSpecList) {
                ProdSpecResponse prodSpecResponse = new ProdSpecResponse();
                prodSpecResponse.setModel(abc.getModel());
                prodSpecResponse.setColor(abc.getColor());
                prodSpecficationResponseList.add(prodSpecResponse);
            }


            productResponse.setProductName(product.getProductName());
            productResponse.setSize(product.getSize());
            productResponse.setDiameter(product.getDiameter());

            ProductType type = product.getProductType();

            productResponse.setProductType(type);
            productResponse.setProdSpecResponse(prodSpecficationResponseList);
            return productResponse;
        }
        return null;


    }

    public void deleteProduct(Long id) {
        productRepo.deleteProduct(id);





    }
}
