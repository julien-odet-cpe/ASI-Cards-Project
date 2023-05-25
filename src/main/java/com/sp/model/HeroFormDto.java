package com.sp.model;

public class HeroFormDto {

    private String name;
    private String description;
    private String imgUrl;

    private int hp;

    private int attack;

    private int defense;

    private int energy;

    public HeroFormDto() {
        this.attack = 0;
        this.defense = 0;
        this.energy = 0;
        this.hp = 0;
        this.imgUrl = "";
        this.name = "";
        this.description = "";
    }

    public HeroFormDto(String name, String description, String imgUrl, int hp, int attack, int defense, int energy) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
