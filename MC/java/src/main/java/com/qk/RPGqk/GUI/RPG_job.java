package com.qk.RPGqk.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

//职业常量
//五个职业

class ConstantClassFiled{
    private static final String Job1="战士";
    private static final String Job2="弓手";
    private static final String Job3="刺客";
    private static final String Job4="法师";
    private static final String Job5="医生";
    public static String getJob1(){
        return Job1;
    }
    public static String getJob2(){
        return Job2;
    }
    public static String getJob3(){
        return Job3;
    }
    public static String getJob4(){
        return Job4;
    }
    public static String getJob5(){
        return Job5;
    }
}


//通过/Job指令弹出RPG职业选择GUI界面
public class RPG_job implements CommandExecutor {
    private List<String> playerJobList =new ArrayList<String>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(!playerJobList.contains(player.getName())){


        Inventory gui = Bukkit.createInventory(null, 9, ChatColor.RED + "请选择你的职业");

        ItemStack job1 = new ItemStack(Material.IRON_SWORD);
        ItemStack job2 = new ItemStack(Material.BOW);
        ItemStack job3 = new ItemStack(Material.IRON_PICKAXE);
        ItemStack job4 = new ItemStack(Material.BLAZE_ROD);
        ItemStack job5 = new ItemStack(Material.GHAST_TEAR);

        ItemMeta job_name1 = job1.getItemMeta();
        job_name1.setDisplayName(ChatColor.GREEN + ConstantClassFiled.getJob1());
        job1.setItemMeta(job_name1);
        ItemMeta job_name2 = job2.getItemMeta();
        job_name2.setDisplayName(ChatColor.GREEN + ConstantClassFiled.getJob2());
        job2.setItemMeta(job_name2);
        ItemMeta job_name3 = job3.getItemMeta();
        job_name3.setDisplayName(ChatColor.GREEN + ConstantClassFiled.getJob3());
        job3.setItemMeta(job_name3);
        ItemMeta job_name4 = job4.getItemMeta();
        job_name4.setDisplayName(ChatColor.GREEN + ConstantClassFiled.getJob4());
        job4.setItemMeta(job_name4);
        ItemMeta job_name5 = job5.getItemMeta();
        job_name5.setDisplayName(ChatColor.GREEN + ConstantClassFiled.getJob5());
        job5.setItemMeta(job_name5);


        gui.setItem(2 , job1);
        gui.setItem(3 , job2);
        gui.setItem(4 , job3);
        gui.setItem(5 , job4);
        gui.setItem(6 , job5);
        player.openInventory(gui);
        playerJobList.add(commandSender.getName());
        }
        else{
            commandSender.sendMessage(ChatColor.AQUA + "你已经选择了职业，不能再次更改");
        }
        return false;
    }
}