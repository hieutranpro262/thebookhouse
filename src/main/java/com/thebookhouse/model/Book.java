package com.thebookhouse.model;

public class Book {

    /** Book ID */
    private int id;

    /** Book name */
    private String name;

    /** Book type ID */
    private int typeId;

    /** Author ID */
    private int authorId;

    /** Publication company */
    private int companyId;

    /** Book price */
    private float price;

    /** Current rate */
    private float rate;

    /** Preview content ID */
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
