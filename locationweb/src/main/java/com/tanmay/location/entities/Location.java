package com.tanmay.location.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Tanmay
 * @date 30/11/19
 **/

@Entity
public class Location {
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Id
    private Integer id;
    private String code;
    private String name;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
