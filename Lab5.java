import java.util.Scanner;
import java.io.FileWriter;

class WektorRoznejDlugosciException extends Exception
{
	int l1,l2;
	public WektorRoznejDlugosciException(int a,int b)
	{
		l1=a;
		l2=b;
	}
	public String getMessage()
	{
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("\nWektory różnej dłógości.\nWektor1.length=").append(l1).append("\nWektor2.length=").append(l2);
		return stringBuilder.toString(); 
	}
}
class Lab5
{
	public static void main(String[] args)
	{
		boolean success=false;
		int[][] wektor=new int[2][];
		String[] wektory=new String[2];
		Scanner scanner=new Scanner(System.in);
		do
		{
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
				if(wektor[0].length!=wektor[1].length) throw new WektorRoznejDlugosciException(wektor[0].length,wektor[1].length);
				//if(wektor[0].length!=wektor[1].length) throw new Exception("Wektory różnej długosci.");
				success=true;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			if(success)
			{
				int[] wektorDoZapisu=new int[wektor[0].length];
				for(int i=0;i<wektor[0].length;i++)
					wektorDoZapisu[i]=wektor[0][i]+wektor[1][i];
				try
				{
					FileWriter fileWriter=new FileWriter("odp.txt");
					fileWriter.write(wektorDoWyswietlenia(wektorDoZapisu));
					fileWriter.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}	
			}
		}while(!success);
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
