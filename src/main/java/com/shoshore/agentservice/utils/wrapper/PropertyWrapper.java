package com.shoshore.agentservice.utils.wrapper;

import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.enums.PropertyType;

import java.math.BigDecimal;
import java.util.Date;

public class PropertyWrapper {

    private Long id;
    private String propertyStatus;
    private PropertyType propertyType;
    private Integer numberOfRooms;
    private String city;
    private String country;
    private String suburb;
    private String street;
    private BigDecimal price;
    private Date dateCreated;
    private Date dateLastUpdated;
    private Date fromDate;
    private Date toDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "PropertyWrapper{" +
                "id=" + id +
                ", propertyStatus='" + propertyStatus + '\'' +
                ", propertyType=" + propertyType +
                ", numberOfRooms=" + numberOfRooms +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", suburb='" + suburb + '\'' +
                ", street='" + street + '\'' +
                ", price=" + price +
                ", dateCreated=" + dateCreated +
                ", dateLastUpdated=" + dateLastUpdated +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
