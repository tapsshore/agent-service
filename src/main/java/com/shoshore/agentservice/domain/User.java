package com.shoshore.agentservice.domain.entities;

import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.keygen.KeyGen;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "userStatus")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
     @Column(name = "home_address")
    private String homeAddress;
    @Column(name = "email_address")
    private String emailAddress;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @OneToMany(mappedBy = "user")
    private Set<Property> properties;
    @OneToMany(mappedBy = "user")
    private Set<Vehicle> vehicles;
    @OneToMany(mappedBy = "user")
    private Set<Job> jobs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idNumber='" + idNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", city='" + city + '\'' +
                ", userStatus=" + userStatus +
                ", homeAddress='" + homeAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateLastUpdated=" + dateLastUpdated +
                ", properties=" + properties +
                ", vehicles=" + vehicles +
                ", jobs=" + jobs +
                '}';
    }
}
