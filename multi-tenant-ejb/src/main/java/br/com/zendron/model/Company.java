package br.com.zendron.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 18/08/13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

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
}
