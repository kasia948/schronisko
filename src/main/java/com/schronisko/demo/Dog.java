package com.schronisko.demo;

public class Dog {
    private Long id;
    private String name;
    private String opis;
    private String img;

    public Dog() {
    }

    public Dog(Long id, String name, String opis, String img) {
        this.id = id;
        this.name = name;
        this.opis = opis;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
