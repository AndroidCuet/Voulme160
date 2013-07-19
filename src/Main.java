
import java.util.HashMap;
import java.util.Scanner;


public class Main {
	
	static class Factorization{
		
	private long finalPermutation = 1;
	private int input;
	
	private HashMap<String, Integer> primeFactorLists = new HashMap<String, Integer>();
	private long[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101}; 
	private void takeInput(){
		
		try{
		Scanner in = new Scanner(System.in);
		do{
			input = in.nextInt();
			
			clearAllData();
			getFactorial(input);
			getPrimeFactors(finalPermutation);	
			showOutput();
		}
		while(input !=0 );
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
	
	private void clearAllData(){
		finalPermutation = 1;
		primeFactorLists.clear();
	}
	private void getFactorial(int currentFactor){
		
		if(currentFactor == 1){
			return;
		}else{
			finalPermutation = finalPermutation * currentFactor;
			getFactorial(currentFactor - 1);
		}				
	}
	
	private void getPrimeFactors(long value){
		if(value == 1){
			return;
		}
		
		if(value % 2 == 0){
			
			synchronized (primeFactorLists) {
				
			Integer count = primeFactorLists.get("2");
			primeFactorLists.put("2", count == null ? 1:count + 1);
			
			}
		
			getPrimeFactors(value / 2);
			
		}else{
			for(int i = 3; i<= value; i = i + 2){
			
				if(value % i == 0){
					synchronized (primeFactorLists) {
						
						Integer count = primeFactorLists.get(String.valueOf(i));
						primeFactorLists.put(String.valueOf(i), count == null ? 1:count + 1);
						getPrimeFactors(value / i);
						break;
					}						
				}
			}
			
		}
	}
	
	
	private void showOutput(){
	
		for(int i = 0, j = 0; i < primeFactorLists.size(); j++){
			
			if(primeFactorLists.get(String.valueOf(prime[j])) != null){
				System.out.print(primeFactorLists.get(String.valueOf(prime[j])) + " ");
				i += 1;
			}else{
				System.out.print("0" + " ");
			}
			
			if(j == 15){
				System.out.print("\n");
			}
		}
	}
	
}
	
	
public static void main(String[] args){
	
	Factorization factors = new Factorization();
	factors.takeInput();
}
}
