package 单子611;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Weapon sword = new Sword("朱雀剑");
        Weapon swordDragon = new SwordDragon("屠龙刀");
        Weapon xiaolifeidao = new HiddenWeapons("佛怒唐莲");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("您拥有的武器: ");
            sword.print();
            swordDragon.print();
            xiaolifeidao.print();

            System.out.println("请输入您的选择: ");
            System.out.println("0. 强化");
            System.out.println("1. 增幅");
            System.out.println("2. 打怪");
            System.out.println("其他. 退出");

            int choice = scanner.nextInt();

            switch(choice) {
                case 0:
                    sword.addIntensify();
                    swordDragon.addIntensify();
                    xiaolifeidao.addIntensify();
                    break;
                case 1:
                    sword.addAmplification();
                    swordDragon.addAmplification();
                    xiaolifeidao.addAmplification();
                    break;
                case 2:
                    sword.attack("奥特曼");
                    swordDragon.attack("古拉斯奥拓夫斯基");
                    xiaolifeidao.attack("比比东");
                    break;
                default:
                    System.out.println("结束喽~~~");
                    flag = false;
                    break;

            }

        }

    }
}
