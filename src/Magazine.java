import java.util.Scanner;

import weapon.*;

public class Magazine
{
    //метод закупки
    public static boolean bueing(Player now_player)
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println();
        }
        //вывод меню закупки
        System.out.println("Your balance = " + now_player.getBalance());
        System.out.println("Enter 1 for buy gun");
        System.out.println("Enter 2 for buy pistol");
        System.out.println("Enter 3 for buy tommy-gun");
        System.out.println("Enter 'esc' to exit");

        Scanner in = new Scanner(System.in);
        //переменная для диалога
        String input;


        input = in.nextLine();

        //закупка винтовок
        if (input.equals("1"))
        {
            //отступ
            for (int i = 0; i < 3; i++)
            {
                System.out.println();
            }
            //вывод прайса
            System.out.println("Your balance = " + now_player.getBalance());
            System.out.println("(1) - ak47 - 2700");
            System.out.println("(2) - m4A1 - 3100");
            System.out.println("Enter 'back' to come back to first menu");
            //получение инструкций
            input = in.nextLine();

            if (!input.equals("back"))
            {
                buy_gun(now_player, (String)"gun", Integer.parseInt(input));
            }

            return false;
        }

        //закупка пистолетов
        if (input.equals("2"))
        {
            //отступ
            for (int i = 0; i < 3; i++)
            {
                System.out.println();
            }
            //вывод прайса
            System.out.println("Your balance = " + now_player.getBalance());
            System.out.println("(1) - Desert Digle - 700");
            System.out.println("(2) - USP - 200");
            System.out.println("Enter 'back' to come back to first menu");
            //получение инструкций
            input = in.nextLine();

            if (!input.equals("back"))
            {
                buy_gun(now_player, (String)"pistol", Integer.parseInt(input));
            }

            return false;
        }

        //Закупка ПП
        if (input.equals("3"))
        {
            //отступ
            for (int i = 0; i < 3; i++)
            {
                System.out.println();
            }
            //вывод прайса
            System.out.println("Your balance = " + now_player.getBalance());
            System.out.println("(1) - P90 - 2250");
            System.out.println("Enter 'back' to come back to first menu");
            //получение инструкций
            input = in.nextLine();

            if (!input.equals("back"))
            {
                buy_gun(now_player, (String)"tommy-gun", Integer.parseInt(input));
            }

            return false;
        }

        //выход из меню закупки
        if (input.equals("esc"))
        {
            return true;
        }

        return false;
    }

    private static void buy_gun(Player now_player, String type_weapon, int num_weapon)
    {
        if (type_weapon.equals("gun")) {
            switch (num_weapon) {
                case 1:
                    if (now_player.getBalance() - Ak47.getPrice() < 0)
                    {
                        System.out.println("You have not enough money");
                        return;
                    }
                    now_player.setWeapon1("ak47");
                    now_player.setBalance(-1*Ak47.getPrice());

                    System.out.println("You buy ak47");

                    break;
                case 2:
                    if (now_player.getBalance() - M4A4.getPrice() < 0)
                    {
                        System.out.println("You have not enough money");
                        return;
                    }
                    now_player.setWeapon1("M4A1");
                    now_player.setBalance(-1*M4A4.getPrice());

                    System.out.println("You buy M4A1");

                    break;
                default:
                    System.out.println("Weapon not found");

            }
        }
        else if (type_weapon.equals("pistol"))
        {
            switch (num_weapon) {
                case 1:
                    if (now_player.getBalance() - DesertDigle.getPrice() < 0)
                    {
                        System.out.println("You have not enough money");
                        return;
                    }
                    now_player.setWeapon2("Desert Digle");
                    now_player.setBalance(-1*DesertDigle.getPrice());

                    System.out.println("You buy Desert Digle");

                    break;
                case 2:
                    if (now_player.getBalance() - USP.getPrice() < 0)
                    {
                        System.out.println("You have not enough money");
                        return;
                    }
                    now_player.setWeapon2("USP");
                    now_player.setBalance(-1*USP.getPrice());

                    System.out.println("You buy USP");

                    break;
                default:
                    System.out.println("Weapon not found");
            }
        }
        else if (type_weapon.equals("tommy-gun"))
        {
            switch (num_weapon) {
                case 1:
                    if (now_player.getBalance() - P90.getPrice() < 0)
                    {
                        System.out.println("You have not enough money");
                        return;
                    }
                    now_player.setWeapon1("P90");
                    now_player.setBalance(-1*P90.getPrice());

                    System.out.println("You buy P90");

                    break;
                default:
                    System.out.println("Weapon not found");
            }
        }

    }


}
