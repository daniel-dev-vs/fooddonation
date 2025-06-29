package org.foodbank.fooddonation.enterprise.entity.product;

import java.time.LocalDateTime;


public class Product {
    private Long id;
    private String name;
    private String unity;
    private LocalDateTime createdAt;

    public Product(String name, String unity, LocalDateTime createdAt) {
        this.name = name;
        this.unity = unity;
        this.createdAt = createdAt;
    }

    public Product(Long id,String name, String unity, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.unity = unity;
        this.createdAt = createdAt;
    }

    public void validateProduct() throws ProductInvalidException {
        this.validateName();
        this.validateUnity();


    }

    private void validateName() throws ProductInvalidException {
        if(this.name == null || this.name.isBlank())
            throw new ProductInvalidException("The name of product is invalid.");
    }

    private void validateUnity() throws ProductInvalidException {
        if(this.unity == null || this.unity.isBlank())
            throw new ProductInvalidException("The unity of product is invalid.");

        try{
            UnityWeightVolume.valueOf(this.unity.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ProductInvalidException("The unity of product just accept ML,L,G,KG and U");
        }

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
