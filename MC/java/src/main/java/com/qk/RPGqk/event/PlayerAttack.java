package com.qk.RPGqk.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.sql.*;

//伤害判断
public class PlayerAttack implements Listener{
    public static final String URL = "jdbc:mysql://localhost:3306/minecraft";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    @EventHandler
    public void PlayerAttack(EntityDamageByEntityEvent event){
        Entity entity = event.getDamager();
        int jobId = 0;//职业ID数字
        double damage = 0;//伤害量
        //确认是否是玩家造成伤害
        if(entity instanceof Player){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                //查找数据库中的职业ID以及攻击力数值
                String sql = "SELECT jobNum,attack FROM playerattribute WHERE playerName=?";
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1,entity.getName());
                ResultSet rs = ptmt.executeQuery();
                //读取玩家攻击力，修改伤害数值
                while (rs.next()){
                    jobId = rs.getInt("jobNum");
                    damage = rs.getDouble("attack");
                }
                //以下需要对玩家是否近战或者远程攻击进行判断，判断职业是否能够进行该种攻击
                //如果对应则保持原攻击力，如果不对应则置0
                event.setDamage(damage);

                entity.sendMessage("你对"+event.getEntity().getName()+"造成伤害为"+damage);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
