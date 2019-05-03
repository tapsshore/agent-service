package com.shoshore.agentservice.domain.entities;

import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.enums.PropertyType;
import com.shoshore.agentservice.utils.keygen.KeyGen;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    private Long id;
    @Column(name = "property_status")
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;
    @Column(name = "property_type")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "suburb")
    private String suburb;
    @Column(name = "street")
    private String street;
    @Column(name = "price")
    private BigDecimal price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(PropertyStatus propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propertyStatus=" + propertyStatus +
                ", propertyType=" + propertyType +
                ", numberOfRooms=" + numberOfRooms +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", suburb='" + suburb + '\'' +
                ", street='" + street + '\'' +
                ", price=" + price +
                ", dateCreated=" + dateCreated +
                ", dateLastUpdated=" + dateLastUpdated +
                ", user=" + user +
                '}';
    }
    @PrePersist
    private void init(){
        if (id == null || id == 0){
            id = KeyGen.getUniqueId();
        }
        if (dateCreated == null){
            dateCreated = new Date();
        }
        if (dateLastUpdated == null){
            setDateLastUpdated(new Date());
        }
    }

    @PreUpdate
    private void reload(){
        if (dateLastUpdated == null){
            setDateLastUpdated(new Date());
        }
    }
}
