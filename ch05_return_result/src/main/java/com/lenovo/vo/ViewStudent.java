package com.lenovo.vo;

public class ViewStudent {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ViewStudent{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
