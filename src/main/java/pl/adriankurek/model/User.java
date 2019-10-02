package pl.adriankurek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
    @GeneratedValue
    private long id;
    private String name;
    private String city;

    public User() {}

    public User(long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "[NAME] = " + name + ", [CITY] = " + city;
    }
}