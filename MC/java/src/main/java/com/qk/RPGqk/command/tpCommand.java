package com.qk.RPGqk.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpCommand implements CommandExecutor {
    @Override
    //传送指令,用于传送玩家
    public boolean onCommand (CommandSender commandSender, Command command, String s, String[] strings) {
        //要确定是玩家输入
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            //要确定指令格式正确
            if (strings.length != 1){
                player.sendMessage("指令输入错误");
            }
            else {
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                //如果这个玩家不在线
                if (target == null) {
                    player.sendMessage("该玩家不在线");
                }else {
                    //获得传送目标的位置
                    Location location = player.getLocation();

                    try {
                        player.sendMessage(ChatColor.GREEN+"请等待，传送需要三秒");
                        player.playEffect(location,Effect.MOBSPAWNER_FLAMES, 0);
                        player.playSound(location, Sound.ENTITY_CREEPER_PRIMED,30f,12f);
                        Thread.sleep(1000);
                        player.sendMessage(ChatColor.GREEN+"还剩两秒");
                        player.playEffect(location,Effect.MOBSPAWNER_FLAMES, 0);
                        player.playSound(location, Sound.ENTITY_CREEPER_PRIMED,30f,15f);
                        Thread.sleep(1000);
                        player.sendMessage(ChatColor.GREEN+"还剩一秒");
                        player.playEffect(location,Effect.MOBSPAWNER_FLAMES, 0);
                        player.playSound(location, Sound.ENTITY_CREEPER_PRIMED,30f,20f);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    player.teleport(target);
                    player.playSound(location,Sound.BLOCK_NOTE_BLOCK_BELL,20f,20f);
                    player.sendMessage(ChatColor.YELLOW+"传送完毕！");
                }
            }
        }
        return false;
    }
}
