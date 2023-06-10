package 单子69重写;


public class CaoCao extends Person {
    public CaoCao(String name, int step, int hp, int atk, int x) {
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
        boolean b = random.nextBoolean();
        if (b) {
            System.out.println("曹操触发奸雄技能，多跑两米");
            x += step;
        }
    }
}
