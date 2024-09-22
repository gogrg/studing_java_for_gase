package weapon;

import my_class.Randomize;

import java.util.concurrent.TimeUnit;

public class USP
{
    //урон
    static int damage = 20;
    //скорость стрельбы. Рассчитывается делением секунды на скорость атаки для Sleep
    static byte speed_attack = 2;
    //размер магазина
    static int size_weapon_magazine = 12;
    //время перезарядки
    static byte time_recharge = 2;
    //шанс промаха
    static float chance_lose = 0.1F;
    //цена
    static int price = 200;


    static public boolean attack()
    {
        long result_fire = Randomize.get_randomize_value((byte)1);

        if (result_fire > chance_lose * 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    static public int getPrice()
    {
        return price;
    }
    static public float get_speed_attack(){return speed_attack;}
    static public int getDamage(){return damage;}

    static public void reload()
    {
        //типо пауза после выстрела
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * time_recharge);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public int getSize_weapon_magazine(){return size_weapon_magazine;}

    static public int getTime_recharge(){return time_recharge;}
}
