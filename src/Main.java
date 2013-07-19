
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static class Factorization{		

	private int input;
	
	private HashMap<String, Integer> primeFactorLists = new HashMap<String, Integer>();
	private long[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101}; 
	
	private void takeInput(){
		
		try{
		Scanner in = new Scanner(System.in);
		do{
			input = in.nextInt();
			if(input != 0){
			primeFactorLists.clear();
			
			getPrimeFactors(input);	
			showOutput();
			}
		}
		while(input !=0 );
		
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
	
	private void getPrimeFactors(int input){
		
		for(int i = 0; prime[i]<=input ; i++){
			
			long calculatingFactor = prime[i];
			int numberOfFactor = 0;
			
			while(input/calculatingFactor >= 1){
				
				numberOfFactor += input/calculatingFactor;
				calculatingFactor *= prime[i];			
			}
			
			primeFactorLists.put(String.valueOf(prime[i]), numberOfFactor);
		}// end for loop
				
	}
	
	
	private void showOutput(){
		
		System.out.print(input + "! =");
		
		for(int i = 0, j = 0; i < primeFactorLists.size(); i++, j++){		
			
			if(j == 15){
				System.out.print("\n");
				j = 0;
			}
			
		System.out.print(primeFactorLists.get(String.valueOf(prime[i])) + " ");				
						
		}//end for loop
	}
	
}
	
	
public static void main(String[] args){
	
	Factorization factors = new Factorization();
	factors.takeInput();
}
}
