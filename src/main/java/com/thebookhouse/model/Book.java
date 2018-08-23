package com.thebookhouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BOOK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @Column(name="ID")
    private int id;

    @Size(min = 1, max = 500, message = "Name must be in range 1-500 characters")
    @NotBlank(message="This field is required")
    @Column(name="NAME")
    private String name;

    @NotNull(message="This field is required")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TYPE_ID", foreignKey = @ForeignKey(name = "FK_BOOK_TYPE"))
    private BookType type;

    @NotNull(message="This field is required")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_AUTHOR"))
    private Author author;

    @NotNull(message="This field is required")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID", foreignKey = @ForeignKey(name = "FK_COMPANY"))
    private Company company;

    @Min(value=0, message="Price must be in range 0-9999.99$")
    @Max(value=10000, message="Price must be in range 0-9999.99$")
    @NotBlank(message="This field is required")
    @Column(name="PRICE")
    private float price;

    @Min(value=0, message="Rate must be in range 0-5")
    @Max(value=5, message="Rate must be in range 0-5")
    @Column(name="RATE")
    private float rate;

    @Column(name="PREVIEW_ID")
    private int previewId;

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

    public BookType getType() {
        return type;
    }

    public void setTypeId(BookType type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompanyId(Company company) {
        this.company = company;
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
