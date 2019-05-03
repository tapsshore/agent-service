package com.shoshore.agentservice.utils.messages.external;

import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.enums.PropertyType;

import java.math.BigDecimal;
import java.util.Date;

public class PropertyDto {

    private Long id;
    private PropertyStatus propertyStatus;
    private PropertyType propertyType;
    private Integer numberOfRooms;
    private String description;
    private String city;
    private String country;
    private String suburb;
    private String street;
    private BigDecimal price;
    private Date dateCreated;
    private Date dateLastUpdated;

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

    @Override
    public String toString() {
        return "PropertyDto{" +
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
                '}';
    }
}
