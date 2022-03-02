package com.qk.RPGqk.GUI;

import com.qk.RPGqk.RPG.*;
import com.qk.RPGqk.entity.PlayerAttribute;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.*;

//监听器，用于监听RPG选择职业的GUI活动
//点击GUI内物品即可选择职业
public class ClickGUI implements Listener {
    //数据库登录信息
    public static final String URL = "jdbc:mysql://localhost:3306/minecraft";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    @EventHandler
    public void ClickGUI(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int num = e.getSlot();//获取玩家点击的物品栏框是哪个

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "请选择你的职业")){
            e.setCancelled(true);
            p.closeInventory();
            String str = e.getCurrentItem().getItemMeta().getDisplayName();

            p.sendMessage(ChatColor.GREEN + "你选择了" + str + "作为你的职业");

            //*************这里选择职业后对玩家生命值、职业名称进行修改并存储，攻击力也进行存储，需配合JDBC
            //这里是判断鼠标点击的GUI中哪个位置，来判断是选择哪个职业
            //我建议修改
            if(num == 2){
                //如果是战士
                JobWarrior jobWarrior =new JobWarrior();
                PlayerAttribute player = new PlayerAttribute();
                jobWarrior.readTXT();
                //读取职业的默认血量等级等赋值，为注册玩家存储信息
                player.setPlayerName(p.getName());
                player.setAttack(jobWarrior.getAttack(),jobWarrior.getUpAttack(),jobWarrior.getUpMelee(),1);
                player.setHP(jobWarrior.getDefaultHP(),jobWarrior.getUpHP(),1);
                player.setJobName(jobWarrior.getName());
                player.setJobNum(jobWarrior.getIdNum());
                player.setLevel(1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    //sql语句，传六个参数
                    String sql = "INSERT INTO playerattribute VALUES (?,?,?,?,?,?)";
                    PreparedStatement ptmt = conn.prepareStatement(sql);
                    ptmt.setString(1,player.getPlayerName());
                    ptmt.setInt(2,player.getJobNum());
                    ptmt.setString(3,player.getJobName());
                    ptmt.setDouble(4,player.getHP());
                    ptmt.setDouble(5,player.getAttack());
                    ptmt.setInt(6,player.getLevel());
                    ptmt.execute();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if (num == 3){
                //如果是弓箭手
                JobArcher jobArcher =new JobArcher();
                PlayerAttribute player = new PlayerAttribute();
                jobArcher.readTXT();
                //读取职业的默认血量等级等赋值，为注册玩家存储信息
                player.setPlayerName(p.getName());
                player.setAttack(jobArcher.getAttack(),jobArcher.getUpAttack(),jobArcher.getUpMelee(),1);
                player.setHP(jobArcher.getDefaultHP(),jobArcher.getUpHP(),1);
                player.setJobName(jobArcher.getName());
                player.setJobNum(jobArcher.getIdNum());
                player.setLevel(1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    //sql语句，传六个参数
                    String sql = "INSERT INTO playerattribute VALUES (?,?,?,?,?,?)";
                    PreparedStatement ptmt = conn.prepareStatement(sql);
                    ptmt.setString(1,player.getPlayerName());
                    ptmt.setInt(2,player.getJobNum());
                    ptmt.setString(3,player.getJobName());
                    ptmt.setDouble(4,player.getHP());
                    ptmt.setDouble(5,player.getAttack());
                    ptmt.setInt(6,player.getLevel());
                    ptmt.execute();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if (num == 4){
                //如果是刺客
                JobAssassin jobAssassin = new JobAssassin();
                PlayerAttribute player = new PlayerAttribute();
                jobAssassin.readTXT();
                //读取职业的默认血量等级等赋值，为注册玩家存储信息
                player.setPlayerName(p.getName());
                player.setAttack(jobAssassin.getAttack(),jobAssassin.getUpAttack(),jobAssassin.getUpMelee(),1);
                player.setHP(jobAssassin.getDefaultHP(),jobAssassin.getUpHP(),1);
                player.setJobName(jobAssassin.getName());
                player.setJobNum(jobAssassin.getIdNum());
                player.setLevel(1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    //sql语句，传六个参数
                    String sql = "INSERT INTO playerattribute VALUES (?,?,?,?,?,?)";
                    PreparedStatement ptmt = conn.prepareStatement(sql);
                    ptmt.setString(1,player.getPlayerName());
                    ptmt.setInt(2,player.getJobNum());
                    ptmt.setString(3,player.getJobName());
                    ptmt.setDouble(4,player.getHP());
                    ptmt.setDouble(5,player.getAttack());
                    ptmt.setInt(6,player.getLevel());
                    ptmt.execute();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if(num == 5){
                //如果是法师
                JobMaster jobMaster = new JobMaster();
                PlayerAttribute player = new PlayerAttribute();
                jobMaster.readTXT();
                //读取职业的默认血量等级等赋值，为注册玩家存储信息
                player.setPlayerName(p.getName());
                player.setAttack(jobMaster.getAttack(),jobMaster.getUpAttack(),jobMaster.getUpMelee(),1);
                player.setHP(jobMaster.getDefaultHP(),jobMaster.getUpHP(),1);
                player.setJobName(jobMaster.getName());
                player.setJobNum(jobMaster.getIdNum());
                player.setLevel(1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    //sql语句，传六个参数
                    String sql = "INSERT INTO playerattribute VALUES (?,?,?,?,?,?)";
                    PreparedStatement ptmt = conn.prepareStatement(sql);
                    ptmt.setString(1,player.getPlayerName());
                    ptmt.setInt(2,player.getJobNum());
                    ptmt.setString(3,player.getJobName());
                    ptmt.setDouble(4,player.getHP());
                    ptmt.setDouble(5,player.getAttack());
                    ptmt.setInt(6,player.getLevel());
                    ptmt.execute();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if(num == 6){
                //如果是医生
                JobDoctor jobDoctor = new JobDoctor();
                PlayerAttribute player = new PlayerAttribute();
                jobDoctor.readTXT();
                //读取职业的默认血量等级等赋值，为注册玩家存储信息
                player.setPlayerName(p.getName());
                player.setAttack(jobDoctor.getAttack(),jobDoctor.getUpAttack(),jobDoctor.getUpMelee(),1);
                player.setHP(jobDoctor.getDefaultHP(),jobDoctor.getUpHP(),1);
                player.setJobName(jobDoctor.getName());
                player.setJobNum(jobDoctor.getIdNum());
                player.setLevel(1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    //sql语句，传六个参数
                    String sql = "INSERT INTO playerattribute VALUES (?,?,?,?,?,?)";
                    PreparedStatement ptmt = conn.prepareStatement(sql);
                    ptmt.setString(1,player.getPlayerName());
                    ptmt.setInt(2,player.getJobNum());
                    ptmt.setString(3,player.getJobName());
                    ptmt.setDouble(4,player.getHP());
                    ptmt.setDouble(5,player.getAttack());
                    ptmt.setInt(6,player.getLevel());
                    ptmt.execute();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else{
                p.sendMessage("你点错了！ ");
            }

        }

    }
}
