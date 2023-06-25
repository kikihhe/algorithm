package Money625;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Account {
    // 账号
    private String id;
    // 储户姓名
    private String name;
    // 开户时间
    private Date date;

    // 身份证号
    private String IDCard;

    private double money;

    private List<String> mingxi = new ArrayList<>();

    public Account openAccount(String name, String IDCard) {
        Random random = new Random();
        String id = (random.nextInt(10000) + 1000) + "";

        return new Account(id, name, new Date(), IDCard, 0.0);
    }
    public void addMoney(double money) {
        this.money += money;
        mingxi.add("存款: " + money);
    }
    public void withdrawal(double money) {
        this.money -= money;
        mingxi.add("取款: " + money);
    }
    public String find() {
        String s = "余额: " + money + "\t明细: ";
        for (int i = 0; i < mingxi.size(); i++) {
            s += mingxi.get(i);
        }
        return s;
    }
    public static void clear(Account account) {
        account = null;
    }

    public Account() {
    }

    public Account(String id, String name, Date date, String IDCard, double money) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.IDCard = IDCard;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
