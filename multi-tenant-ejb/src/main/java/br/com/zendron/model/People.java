package br.com.zendron.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 16/08/13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
