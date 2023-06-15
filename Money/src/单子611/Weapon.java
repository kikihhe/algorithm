package 单子611;

import java.util.Random;

/**
 * @ClassName Weapon
 * @Description 武器类
 * @Author
 * @Date 2023-06-11 21:56
 * @Version 1.0
 */
public class Weapon {
    // 武器名
    public String name;

    // 武器类型
    public String type;

    // 初始攻击力
    public int ATK;


    // 最终攻击力
    public int EndATK;

    // 强化等级
    public int intensify;

    // 增幅等级
    public int amplification;

    public static Random random = new Random();

    public Weapon(String name, String type, int ATK) {
        this.name = name;
        this.type = type;
        this.ATK = ATK;
        this.amplification = 1;
        this.intensify = 1;
        this.EndATK = ATK;
    }

    // 显示武器的属性
    public void print() {
        System.out.print("武器名称: " + name + "\t\t\t");
        System.out.print("武器类型: " + type + "\t\t\t");
        System.out.print("攻击力: " + EndATK + "\t\t\t");
        System.out.print("强化等级: " + intensify + "\t\t\t");
        System.out.print("增幅等级: " + amplification + "\n");
    }
    public void attack(String guaiwu) {
        System.out.println(name + "攻击了" + guaiwu + ", 造成了" + EndATK + "点伤害");
    }

    // 强化
    public void addIntensify() {
        // 等级为1时必成功
        if (this.intensify <= 1) {
            this.intensify++;
            System.out.println(name + "强化成功!,现在的等级为: " + this.intensify);
        } else {
            boolean b = random.nextBoolean();
            if (b) {
                this.intensify++;
                System.out.println(name + "强化成功!,现在的等级为: " + this.intensify);
            } else {
                this.intensify--;
                System.out.println(name + "强化失败!,现在的等级为: " + this.intensify);
            }
        }
        // 每次强化后都计算最终攻击力
        check();

    }

    public void addAmplification() {
        // 等级为1时必成功
        if (this.amplification <= 1) {
            this.amplification++;
            System.out.println(name + "增幅成功!,现在的等级为: " + this.amplification);
        } else {
            int b = random.nextInt(10);
            if (b < 6) {
                this.amplification++;
                System.out.println(name + "增幅成功!,现在的等级为: " + this.amplification);
            } else {
                this.amplification--;
                System.out.println(name + "增幅失败!,现在的等级为: " + this.amplification);
            }
        }
        // 每次增幅后都计算最终攻击力
        check();
    }

    // 计算最终攻击力
    public void check() {
        this.EndATK = this.ATK + (this.intensify-1)*100 + (this.amplification-1)*50;
    }





    public int getIntensify() {
        return intensify;
    }

    public void setIntensify(int intensify) {
        this.intensify = intensify;
    }

    public int getAmplification() {
        return amplification;
    }

    public void setAmplification(int amplification) {
        this.amplification = amplification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }
}
