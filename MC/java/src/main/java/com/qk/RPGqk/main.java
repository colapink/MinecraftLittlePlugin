package com.qk.RPGqk;

import com.qk.RPGqk.GUI.ClickGUI;
import com.qk.RPGqk.GUI.RPG_job;
import com.qk.RPGqk.event.PlayerAttack;
import com.qk.RPGqk.event.PlayerJoin;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {
    @Override  //这里是java的一种注解，用来检测下面onEnable是否被重写
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);//玩家加入
        getServer().getPluginManager().registerEvents(new ClickGUI(), this);//RPG职业选择GUI
        getServer().getPluginManager().registerEvents(new PlayerAttack(),this);//玩家攻击更改伤害

        getCommand("job").setExecutor(new RPG_job());//职业选择指令
        getCommand("tpa").setExecutor(new tpCommand());//传送指令
        
        System.out.println("[RPG]插件已加载成功");
        System.out.println("[RPG]作者：可乐加品客 QK");

        // 插件载入时要执行的代码（略）
    }

    @Override
    public void onDisable() {
        System.out.println("[RPG]插件已成功卸载");
        System.out.println("[RPG]作者：可乐加品客 QK");
        // 插件卸载时要执行的代码（略）
    }


}
