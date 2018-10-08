package Problem_2;
/**
 *   Date    : 2017/5/10
 *   Author  : Hsiang-Chun Tsai
 */

interface iAaa
{
	public void show();
}

class Cbbb
{
	public int num = 10;
	
	public void set(int n)
	{
		num = n;
	}
}

class Cccc extends Cbbb implements iAaa
{
	public void show()
	{
		System.out.println("num="+num);
	}
}

public class Problem_2
{

	public static void main(String[] args)
	{
		Cccc cc = new Cccc();
		cc.set(5);
		cc.show();
	}

}
