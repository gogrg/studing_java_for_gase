package my_class;

import java.time.LocalTime;

public class Randomize{

    public static long get_randomize_value(byte wanted_len_value)
    {
        //проверка на ненулевую длину
        if (wanted_len_value == 0)
        {
            wanted_len_value++;
        }

        LocalTime time = LocalTime.now();

        int start_position = 0;
        start_position += time.getHour() + time.getMinute() + time.getSecond() + time.getNano();

        StringBuilder str_position = new StringBuilder(String.valueOf(start_position));

        String result = "";

        int first_number;
        int second_number;

        for (byte i = 0; i < wanted_len_value; i++)
        {
            //получение последнего символа текущей последовательности в качестве числа
            first_number = Integer.parseInt(String.valueOf(str_position.charAt(str_position.length() - 1)));
            //получение предпоследнего символа текущей последовательности в качестве числа
            second_number = Integer.parseInt(String.valueOf(str_position.charAt(str_position.length() - 2)));

            //прибавление их суммы результату
            result += String.valueOf((first_number + second_number)%10);

            //смещение всех символов строки чисел на один индекс вперёд
            for (int j = str_position.length() - 1; j > 0; j--)
            {
                str_position.setCharAt(j, str_position.charAt(j - 1));
            }

            //присвоение нового первого символа
            str_position.setCharAt(0, String.valueOf((first_number + second_number)%10).charAt(0));
        }

        return Long.parseLong(result);
    }

}
