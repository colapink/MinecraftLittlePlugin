package com.qk.RPGqk.entity;

//该类用于存储接收数据库内容，数据库内存储的即这些内容
public class PlayerAttribute {
    private String playerName;//玩家名字
    private int jobNum;//职业代号
    private String jobName;//职业名称
    private double HP;//玩家血量
    private double attack;//玩家攻击力
    private int level;//玩家等级
    private double exp;//玩家经验值



    public int getJobNum() {
        return jobNum;
    }

    public void setJobNum(int jobNum) {
        this.jobNum = jobNum;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getHP() {
        return HP;
    }
    //包括默认生命值加上升级生命值*等级
    public void setHP(double defaultHP,double upHP,double level){
        this.HP = defaultHP + upHP * (level - 1);
    }

    public double getAttack() {
        return attack;
    }
    //默认攻击力加上升级加成攻击力*等级，再加上近战or远程加成攻击力
    public void setAttack(double attack,double upAttack,double Melee_Range,double level) {
        this.attack = attack + upAttack * (level-1) + Melee_Range;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }
}
