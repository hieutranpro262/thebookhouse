package com.thebookhouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BOOK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name="TYPE_ID", foreignKey = @ForeignKey(name = "FK_BOOK_TYPE"))
    @NotNull
    private BookType type;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_AUTHOR"))
    private Author author;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID", foreignKey = @ForeignKey(name = "FK_COMPANY"))
    private Company company;

    @Column(name="PRICE")
    @NotNull
    private Float price;

    @Column(name="RATE")
    private Float rate;

    @Column(name="PREVIEW_ID")
    private Integer previewId;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public int getPreviewId() {
        return previewId;
    }

    public void setPreviewId(int previewId) {
        this.previewId = previewId;
    }
}
