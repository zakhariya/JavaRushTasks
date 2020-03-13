package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[] {
                (byte) (ip[0] & mask[0]),
                (byte) (ip[1] & mask[1]),
                (byte) (ip[2] & mask[2]),
                (byte) (ip[3] & mask[3])
        };
    }

    public static void print(byte[] bytes) {

        String s = "";

        for (int i = 0; i < bytes.length; i++) {
            /* b & 0xFF - обнуляем сташие биты от 32-х битного представления
              %8s - задаем размер в 8 символов, т. к. все ведущие нули будут отброшены
              заменяем пробелы на нули вначале */
            s += String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0");

            s += i + 1 < bytes.length ? " " : "";
        }

        System.out.println(s);
    }
}
