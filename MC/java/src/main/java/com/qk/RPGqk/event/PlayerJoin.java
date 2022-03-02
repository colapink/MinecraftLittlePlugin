package com.qk.RPGqk.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener{
    private List<String> playerNameList =new ArrayList<String>();


    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        String player = event.getPlayer().getName();
        Player p =event.getPlayer();
        event.setJoinMessage(ChatColor.YELLOW + player +"加入服务器");

        if(!playerNameList.contains(event.getPlayer().getName())) {
            p.sendMessage(ChatColor.YELLOW +"欢迎加入本服务器，请输入/job选择自己的职业");
            playerNameList.add(event.getPlayer().getName());

        }
    }
}
