package 单子69重写;



/**
 * @ClassName Main
 * @Description TODO
 * @Author 何
 * @Date 2023-06-10 12:53
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {


        int i = 0;
        Person caocao = new CaoCao("曹操", 1, 100, 0, 10);

        Person xuhuang = new XuHuang("徐晃", 1, 10, 0, 10);
        Person zhangliao = new ZhangLiao("张辽", 1, 10, 0, 10);
        Person guanyu = new GuanYu("关羽", 2, 0, 100, 0);

        while (caocao.x > guanyu.x) {
            // 先跑
            guanyu.run();
            caocao.run();
            xuhuang.run();
            zhangliao.run();
            System.out.println("------------------------------");
            System.out.println("此时已经跑了" + (++i) + "轮，每个人的位置为: \n" +
                    "曹操: " + caocao.x + "米, 血量: " + caocao.hp + "\n" +
                    "徐晃: " + xuhuang.x + "米, 血量: " + xuhuang.hp + "\n" +
                    "张辽: " + zhangliao.x + "米, 血量: " + zhangliao.hp + "\n" +
                    "关羽: " + guanyu.x + "米, 攻击力: " + guanyu.atk
            );

            // 执行技能

            caocao.jineng(null);
            xuhuang.jineng(caocao);
            zhangliao.jineng(guanyu);
            if (guanyu.x >= xuhuang.x) {
                guanyu.kill(xuhuang);
            }
            if (guanyu.x >= zhangliao.x) {
                guanyu.kill(zhangliao);
            }
            if (guanyu.x >= caocao.x) {
                guanyu.kill(caocao);
                break;
            }
            if (caocao.x - guanyu.x >= 20) {
                System.out.println("曹操甩了关羽20米，逃跑成功!");
                break;
            }
            System.out.println("触发技能后的位置为: \n" +
                    "曹操: " + caocao.x + "米\n" +
                    "徐晃: " + xuhuang.x + "米\n" +
                    "张辽: " + zhangliao.x + "米\n" +
                    "关羽: " + guanyu.x + "米"
            );

            System.out.println("------------------------------");
        }
    }
}
