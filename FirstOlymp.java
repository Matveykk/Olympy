package Olymp;

import java.util.Scanner;

public class FirstOlymp {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func(){
        Scanner sc = new Scanner(System.in);
        int HourInMinutes = sc.nextInt() * 60;
        int Minutes = sc.nextInt();
        int BusDelayA = sc.nextInt();
        int BusDelayB = sc.nextInt();

        int BusDelayAtemp = BusDelayA;
        int BusDelayBtemp = BusDelayB;

        int resA = 0;
        int resB = 0;

        int lastTimeA = 8 * 60;
        int lastTimeB = 8 * 60;

        while(lastTimeA < 22*60){
            lastTimeA += BusDelayA;
        }

        while(lastTimeB < 22*60){
            lastTimeB += BusDelayB;
        }

        if(HourInMinutes + Minutes > lastTimeA && HourInMinutes + Minutes > lastTimeB){
            return -1;
        }

        if(HourInMinutes + Minutes == 8 * 60){
            return 0;
        }

        while(resA == 0){
            if(HourInMinutes + Minutes <= (8 * 60 + BusDelayAtemp)){
                resA = 8 * 60 + BusDelayAtemp - (HourInMinutes + Minutes);
                break;
            }
            BusDelayAtemp += BusDelayA;
        }
        while (resB == 0){
            if(HourInMinutes + Minutes <= (8 * 60 + BusDelayBtemp)){
                resB = 8 * 60 + BusDelayBtemp - (HourInMinutes + Minutes);
                break;
            }
            BusDelayBtemp += BusDelayB;
        }
        return resA > resB ? resB : resA;
    }
}
