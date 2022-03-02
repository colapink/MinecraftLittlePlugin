package com.qk.RPGqk.entity;

public class JobItem{
    private int idNum;//职业代号
    private String name;//职业名称
    private double defaultHP;//职业默认血量
    private double upHP;//职业升级提升血量
    private double attack;//职业徒手默认攻击力
    private double upAttack;//职业升级提升攻击力
    private boolean equip;//新手是否发放新手装备
    private String equipment;//新手装备名称
    private boolean melee;//是否该角色可以近战
    private boolean range;//是否该角色可以远程
    private double upMelee;//近战攻击力加成
    private double upRange;//远程攻击力加成


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDefaultHP() {
        return defaultHP;
    }

    public void setDefaultHP(double defaultHP) {
        this.defaultHP = defaultHP;
    }

    public double getUpHP() {
        return upHP;
    }

    public void setUpHP(double upHP) {
        this.upHP = upHP;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getUpAttack() {
        return upAttack;
    }

    public void setUpAttack(double upAttack) {
        this.upAttack = upAttack;
    }

    public boolean isEquip() {
        return equip;
    }

    public void setEquip(boolean equip) {
        this.equip = equip;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public boolean isMelee() {
        return melee;
    }

    public void setMelee(boolean melee) {
        this.melee = melee;
    }

    public boolean isRange() {
        return range;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public double getUpMelee() {
        return upMelee;
    }

    public void setUpMelee(double upMelee) {
        this.upMelee = upMelee;
    }

    public double getUpRange() {
        return upRange;
    }

    public void setUpRange(double upRange) {
        this.upRange = upRange;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }
}

