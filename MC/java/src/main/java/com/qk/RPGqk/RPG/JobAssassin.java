package com.qk.RPGqk.RPG;

import com.qk.RPGqk.entity.JobItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JobAssassin extends JobItem {
    //刺客
    public void readTXT() {//读txt文件内容，修改职业信息
        //1.读文件内容
        File file = new File("F:\\MC\\java\\txt\\jobAssassin.txt");
        String item[] = new String[12];
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            int i = 0;
            while ((str = in.readLine()) != null) {
                Pattern pattern = Pattern.compile("(\\D*)(:)(\\S*)");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    String point = matcher.group(3);
                    point = new String(point.getBytes("GBK"), "UTF-8");
                    item[i] = point;
                } else {
                    System.out.println("NO MATCH");
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.为类赋值
        setIdNum(Integer.parseInt(item[0]));
        setName(item[1]);
        setDefaultHP(Double.valueOf(item[2]));
        setUpHP(Double.valueOf(item[3]));
        setAttack(Double.valueOf(item[4]));
        setUpAttack(Double.valueOf(item[5]));
        setEquip(Boolean.valueOf(item[6]));
        setEquipment(item[7]);
        setMelee(Boolean.valueOf(item[8]));
        setRange(Boolean.valueOf(item[9]));
        setUpMelee(Double.valueOf(item[10]));
        setUpRange(Double.valueOf(item[11]));
    }
}
