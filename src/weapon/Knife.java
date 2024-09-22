
package weapon;

import my_class.Randomize;

public class Knife {

    //урон
    static int damage = 100;
    //скорость стрельбы. Рассчитывается делением секунды на скорость атаки для Sleep
    static float speed_attack = 4f;

    //шанс промаха
    static float chance_lose = 0.05F;


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

    static public float get_speed_attack(){return speed_attack;}
    static public int getDamage(){return damage;}
}
