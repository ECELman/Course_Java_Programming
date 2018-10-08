public class A1045516_Problem_3
{
	public static void main(String[] args)
	{
		String deck[] = new String[52];
		String suit[] = {"Spade","Heart","Diamond","Club"};
		String rank[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		System.out.println("The result of shuffling the cards : \n");
		for(int i=0;i<52;i++)
		{
			int suit_site = (int)(Math.random()*4);
			int rank_site = (int)(Math.random()*13);
			String deck_temp = suit[suit_site] + " " + rank[rank_site];
			
			for(int j=0;j<i;j++)
			{
				while(deck[j].equals(deck_temp))
				{
					suit_site = (int)(Math.random()*4);
					rank_site = (int)(Math.random()*13);
					deck_temp = suit[suit_site] + " " + rank[rank_site];
					
					j=0;
				}
			}
			
			deck[i] = deck_temp;
			System.out.println(deck[i]);
		}

		System.out.println("\nPick up the first five cards : \n");
		for(int i=0;i<5;i++) System.out.println(deck[i]);
	}
}
