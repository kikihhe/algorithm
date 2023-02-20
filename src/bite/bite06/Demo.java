package bite.bite06;



public class Demo{
    public static void main(String[] args) {
//        System.out.println(test(10));

    }
public static int test(int b){
    try
    {
        b += 10;
        return b;
    }
    catch(RuntimeException e){
    }
    catch(Exception e2){
    }
    finally{
    b += 10;return b;}
    }
}
