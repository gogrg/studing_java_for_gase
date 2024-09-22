import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import weapon.*;

public class Player {

    //первый слот оружия
    private String weapon1 = "";
    //второй слот оружия
    private String weapon2 = "";
    //нож
    private Knife knife;
    //начальный баланс для закупки
    private int balance;
    //выбранный слот
    int selected_slot;

    Player()
    {
        balance = 16000;
        selected_slot = 3;
    }

    Player(int balance)
    {
        this.balance = balance;
    }

    public void shot(int shot_number)
    {
        boolean flag_success = false;

        float speed_attack = 1;

        int damage = 0;

        int time_reload = 0;

        int size_weapon_magazin = 0;

        if (selected_slot == 1)
        {
            switch (weapon1)
            {
                case "ak47":

                    speed_attack = Ak47.get_speed_attack();
                    flag_success = Ak47.attack();
                    damage = Ak47.getDamage();
                    time_reload = Ak47.getTime_recharge();
                    size_weapon_magazin = Ak47.getSize_weapon_magazine();
                    break;
                case "M4A4":
                    speed_attack = M4A4.get_speed_attack();
                    flag_success = M4A4.attack();
                    damage = M4A4.getDamage();
                    time_reload = M4A4.getTime_recharge();
                    size_weapon_magazin = M4A4.getSize_weapon_magazine();
                    break;
                case "P90":
                    speed_attack = P90.get_speed_attack();
                    flag_success = P90.attack();
                    damage = P90.getDamage();
                    time_reload = P90.getTime_recharge();
                    size_weapon_magazin = P90.getSize_weapon_magazine();
                    break;
            }
        }
        else if (selected_slot == 2)
        {
            switch (weapon2)
            {
                case "Desert Digle":
                    speed_attack = DesertDigle.get_speed_attack();
                    flag_success = DesertDigle.attack();
                    damage = DesertDigle.getDamage();
                    time_reload = DesertDigle.getTime_recharge();
                    size_weapon_magazin = DesertDigle.getSize_weapon_magazine();
                    break;
                case "USP":
                    speed_attack = USP.get_speed_attack();
                    flag_success = USP.attack();
                    damage = USP.getDamage();
                    time_reload = USP.getTime_recharge();
                    size_weapon_magazin = USP.getSize_weapon_magazine();
                    break;
            }
        }

        else if (selected_slot == 3)
        {
            speed_attack = Knife.get_speed_attack();
            flag_success = Knife.attack();
            damage = Knife.getDamage();
        }

        if ((shot_number % (size_weapon_magazin+1)) == 0)
        {
            System.out.println("Reload");
            //пауза перезарядки
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * time_reload);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * time_reload);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * time_reload);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (flag_success)
        {
            System.out.println("Buff (" + damage + ")");
        }
        else
        {
            System.out.println("You missed");
        }

        //типо пауза после выстрела
        try {
            TimeUnit.MILLISECONDS.sleep((long)(1000 * (float)(1 / speed_attack)));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //изменение слота оружия
    public void change_slot_weapon(int new_slot)
    {
        selected_slot = new_slot;
    }

    //получение баланса
    public int getBalance()
    {
        return balance;
    }
    public void setBalance(int balance)
    {
        this.balance += balance;
    }

    //назначение оружия в первый слот
    public void setWeapon1(String new_weapon)
    {
        weapon1 = new_weapon;
    }
    //назначение оружия во второй слот
    public void setWeapon2(String new_weapon)
    {
        weapon2 = new_weapon;
    }

    public void get_weapon_list()
    {
        //отступ
        for (int i = 0; i < 3; i++)
        {
            System.out.println();
        }
        //вывод первого оружия
        if (weapon1.equals(""))
        {
            System.out.println("You don't have weapon in first slot");
        }
        else
        {
            System.out.println("In first slot you have " + weapon1);
        }
        //вывод второго оружия
        if (weapon2.equals(""))
        {
            System.out.println("You don't have weapon in first slot");
        }
        else {
            System.out.println("In second slot you have " + weapon2);
        }
        //выывод ножа
        System.out.println("You also have knife");

    }


}
