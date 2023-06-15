package 单子69重写;

/**
 * @ClassName ZhangLiao
 * @Description TODO
 * @Author 何
 * @Date 2023-06-10 12:49
 * @Version 1.0
 */
public class ZhangLiao extends Person{
    public ZhangLiao(String name, int step, int hp, int atk, int x) {
        super(name, step, hp, atk, x);
    }

    @Override
    public void run() {
        if (!isDead) {
            x += step;
        }
    }

    /**
     * 张辽的技能针对关羽
     * @param person 关羽
     */
    @Override
    public void jineng(Person person) {
        if(isDead) return;
        int i = random.nextInt(10);
        if (i < 3) {
            person.x--;
            System.out.println("张辽触发忠臣技能，关羽被击退一米");
        }
    }
}
