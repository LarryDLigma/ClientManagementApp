package Entity;

import Manager.ClientIDMManager;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable {
    private int id;
    private String name;

    private String contactPerson;
    private String industry;
    private double revenue;

    @JsonCreator
    public Client(@JsonProperty("id") ClientIDMManager manager, @JsonProperty("name") String name,
                  @JsonProperty("industry") String industry,  @JsonProperty("contact person") String contactPerson,
                  @JsonProperty("revenue") double revenue) {
        this.id = manager.getNextID();
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
    }
    //Въвеждаме ID, понеже не мога да накарам AutoIncrement-a да работи :(

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


    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactPerson=" + contactPerson +
                ", industry='" + industry + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
