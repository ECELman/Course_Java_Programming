import java.util.Scanner;

public class A1045516_Problem_2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("請使用者輸入5個數字 : ");
		int num,sum=0;
		for(int i=0;i<5;i++)
		{
			num=in.nextInt();
			sum+=num;
		}
		System.out.println("這5個數字的總合 = " + sum);
		
		in.close();

	}

}
