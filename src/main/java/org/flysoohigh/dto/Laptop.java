package org.flysoohigh.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lid;
    @Column(name = "Laptop_name")
    private String lname;
    @ManyToOne
    private Alien owner;

    public Laptop() {
    }

    public Alien getOwner() {
        return owner;
    }

    public void setOwner(Alien owner) {
        this.owner = owner;
    }

    public Laptop(String lname) {
        this.lname = lname;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", owner=" + owner +
                '}';
    }
}
