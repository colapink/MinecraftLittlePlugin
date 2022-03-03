package com.qk.RPGqk.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

//聊天文明发言系统
public class ChatEvent implements Listener {
    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){

        if (event.getMessage().contains("你妈")){
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.YELLOW +"请文明用语");
            event.setMessage("***");
        }
        if(event.getMessage().contains("nmsl")){
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.YELLOW +"请文明用语");
            event.setMessage("***");
        }
    }

}
