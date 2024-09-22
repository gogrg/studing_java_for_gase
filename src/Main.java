import weapon.DesertDigle;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Player first_player = new Player(16000);

        boolean flag_exit = false;

        while (!flag_exit == true)
        {
            flag_exit = Magazine.bueing(first_player);
        }

        System.out.println("You have " + first_player.getBalance());
        first_player.get_weapon_list();

        System.out.println("Do want fire?(yes/no)");

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println();

        if (input.equals("yes"))
        {
            flag_exit = false;

            while (flag_exit == false)
            {
                System.out.println("Select slot of weapon(1/2/3)");

                input = in.nextLine();

                if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3)
                {
                    continue;
                }
                first_player.change_slot_weapon(Integer.parseInt(input));

                System.out.println("You select " + first_player.selected_slot);

                System.out.println("How many shot you want do?");

                input = in.nextLine();

                for (int i = 0; i < Integer.parseInt(input); i++)
                {
                    first_player.shot(i + 1);


                }
            }
        }
        else
        {
            System.out.println("Good bye");
        }
    }


}
