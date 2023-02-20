package 传智杯第二题;

import java.io.*;

/**
 * @author hellowwor1
 * @create 2022__11__26__-15:50
 */
public class test2 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int a1 = 0;
        int b2 = 0;
        input.nextToken();
        int n = (int) input.nval;
        input.nextToken();
        int m = (int) input.nval;
        int[] arr2 = new int[m];
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++){
            input.nextToken();
            arr1[i] = (int) input.nval;
        }
        for(int j = 0; j < m; j++){
            input.nextToken();
            arr2[j] = (int) input.nval;
        }

        int max= Math.max(m,n);
        int min = max==m?n:m;
        int index1 = n - 1;//用于遍历
        int index2 = m - 1;//用于遍历
        int index = 0;//控制进制
        int t = 0;
        int[] answer = new int[max];
        int maxIndex = max-1;
        while(index1 >= 0 && index2 >= 0){
            int now = arr1[index1] + arr2[index2] + t;
            if(now >= index+2){
                answer[maxIndex]= now % (index+2);
                t=1;
            }else{
                answer[maxIndex]=now;
                t=0;
            }
            index++;
            index1--;
            index2--;
            maxIndex--;
        }
        while(index1 >= 0){
            int temp = arr1[index1]+t;
            if(temp>=index+2){
                answer[index1]=temp%(index+2);
                t=1;
            }else{
                answer[index1]=temp;
                t=0;
            }
            index1--;
            index++;
        }
        while(index2>=0){
            int temp=arr2[index2]+t;
            if(temp>=index+2){
                answer[index2]=temp%(index+2);
                t=1;
            }else{
                answer[index2]=temp;
                t=0;
            }
            index2--;
            index++;
        }

        if(t==1){
            output.print("1 ");
        }
        for(int j = 0; j < max; j++){
            output.print(answer[j] + " ");
        }
        output.flush();

    }
}
