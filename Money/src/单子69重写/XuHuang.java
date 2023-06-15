package 单子69重写;

/**
 * @ClassName XuHuang
 * @Description TODO
 * @Author 何
 * @Date 2023-06-10 12:51
 * @Version 1.0
 */
public class XuHuang extends Person {
    public XuHuang(String name, int step, int hp, int atk, int x) {
        super(name, step, hp, atk, x);
    }

    @Override
    public void run() {
        if (!isDead) {
            x += step;

        }
    }

    @Override
    public void jineng(Person person) {
        if (isDead) return;
        int i = random.nextInt(10);
        if (i < 3) {
            System.out.println("徐晃触发护主技能，曹操多跑一米");
            person.x++;
        }
    }
}
