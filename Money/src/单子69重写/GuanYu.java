package 单子69重写;

/**
 * @ClassName GuanYu
 * @Description TODO
 * @Author 何
 * @Date 2023-06-10 12:48
 * @Version 1.0
 */
public class GuanYu extends Person {
    public GuanYu(String name, int step, int hp, int atk, int x) {
        super(name, step, hp, atk, x);
    }

    @Override
    public void run() {
        x += step;
    }

    @Override
    public void jineng(Person person) {
        // 关羽没有技能
    }


}
