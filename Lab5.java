import java.util.Scanner;


class Lab5
{
	public static void main(String[] args)
	{
		int[][] wektor=new int[2][];
		String[] wektory=new String[2];
		Scanner scanner=new Scanner(System.in);
		System.out.println("Podaj pierwszy wektor(liczby odziel ','):");
		wektory[0]=scanner.nextLine();
		System.out.println("Podaj drugi wektor:");
		wektory[1]=scanner.nextLine();
		wektor[0]=stringNaInt(wektory[0]);
		wektor[1]=stringNaInt(wektory[1]);
		System.out.println("Wektor 1: "+ wektorDoWyswietlenia(wektor[0]));
		System.out.println("Wektor 2: "+ wektorDoWyswietlenia(wektor[1]));
		try
		{
			//if(wektor[0].length!=wektor[1].length) throw new WektorRoznejDlugosciException("Wektory różnej długosci.");
			if(wektor[0].length!=wektor[1].length) throw new Exception("Wektory różnej długosci.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	private static int[] stringNaInt(String wektor)
	{
		int[] returnValue=new int[0];
		int lastInt=0;
		String[] splitedWektor=wektor.split(",");	
		for(int i=0;i<splitedWektor.length;i++)
		{
			int[] temp=new int[lastInt+1];
			for(int j=0;j<returnValue.length;j++)
				temp[j]=returnValue[j];
			try
			{
				temp[lastInt]=Integer.parseInt(splitedWektor[i]);
				lastInt++;
				returnValue=temp;
				
			}catch(Exception e){};
			
		}
		return returnValue;
	}

	private static String wektorDoWyswietlenia(int[] wektor)
	{
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("[ ");
		for(int i=0;i<wektor.length;i++)
			stringBuilder.append(wektor[i]+" ");
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
