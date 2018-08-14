package com.thebookhouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="TYPE_ID")
    private int typeId;

    @Column(name="AUTHOR_ID")
    private int authorId;

    @Column(name="COMPANY_ID")
    private int companyId;

    @Column(name="PRICE")
    private float price;

    @Column(name="RATE")
    private float rate;

    @Column(name="PREVIEW_ID")
    private int previewId;

    public Book() {
    }

    public Book(int id, String name, int typeId, int authorId, int companyId,
            float price, float rate, int previewId) {
        super();
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.authorId = authorId;
        this.companyId = companyId;
        this.price = price;
        this.rate = rate;
        this.previewId = previewId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getPreviewId() {
        return previewId;
    }

    public void setPreviewId(int previewId) {
        this.previewId = previewId;
    }
}
