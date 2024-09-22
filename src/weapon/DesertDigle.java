package weapon;
import java.util.concurrent.TimeUnit;
import my_class.Randomize;

public class DesertDigle
{
    //урон
    static int damage = 80;
    //скорость стрельбы. Рассчитывается делением секунды на скорость атаки для Sleep
    static float speed_attack = 0.5f;
    //размер магазина
    static int size_weapon_magazine = 7;
    //время перезарядки
    static byte time_recharge = 2;
    //шанс промаха
    static float chance_lose = 0.4F;
    //цена
    static int price = 700;


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
