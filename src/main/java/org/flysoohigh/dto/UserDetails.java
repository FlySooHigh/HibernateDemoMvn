package org.flysoohigh.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
//    @Transient
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name="HOME_CITY_NAME")),
            @AttributeOverride(name = "street", column = @Column(name="HOME_STREET_NAME")),
            @AttributeOverride(name = "state", column = @Column(name="HOME_STATE_NAME")),
            @AttributeOverride(name = "zipcode", column = @Column(name="HOME_ZIP_CODE_NAME"))})
    private Address homeAddress;
//    @Embedded
    private Address officeAddress;
//    @Lob
    private String description;

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinDate=" + joinDate +
                ", homeAddress=" + homeAddress +
                ", officeAddress=" + officeAddress +
                ", description='" + description + '\'' +
                '}';
    }
}
