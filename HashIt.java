package SPOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class HashIt {
	private static int keys[];
	private static String value[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int test = sc.nextInt();
			keys = new int[101];
			value =  new String[101];
			String input[] = new String[test];
			for(int i=0;i<test;i++){
				input[i] = sc.next();
			}
			
			for(int i=0;i<input.length;i++){
				String keyop = input[i].split(":")[0];
				String valueop = input[i].split(":")[1];
				
				switch(keyop){
				case "ADD":
					addToTable(valueop);
					break;
					
				case "DEL":
					deleteFromTable(valueop);
					break;
				}
			}
			
			ArrayList<String> output = new ArrayList<String>();
			for(int j=0;j<101;j++){
				if(value[j]!=null){
					output.add(keys[j]+":"+value[j]); 
				}
			}
			
			System.out.println(output.size());
			for(int k=0;k<output.size();k++){
				System.out.println(output.get(k));
			}
			
		}
	/*	int testCase [] = new int[tc];
		String operations [][] = new String[tc][1000];
		for(int i=0;i<tc;i++){
			testCase[i] = sc.nextInt();
			for(int j=0;j<testCase[i];j++){
				operations[i][j] = sc.next(); 
			}
		}
		
		
		for(int i=0;i<tc;i++){
			keys = new int[101];
			value = new String[101];
			for(int j=0;j<testCase[i];j++){
				String keyop = operations[i][j].split(":")[0];
				String valueop = operations[i][j].split(":")[1];
				
				switch(keyop){
				case "ADD":
					addToTable(valueop);
					break;
					
				case "DEL":
					deleteFromTable(valueop);
					break;
				}
			}
			
			ArrayList<String> output = new ArrayList<String>();
			for(int j=0;j<101;j++){
				if(value[j]!=null){
					output.add(keys[j]+":"+value[j]); 
				}
			}
			
			System.out.println(output.size());
			for(int k=0;k<output.size();k++){
				System.out.println(output.get(k));
			}
		}*/
	}
	
	private static int hash(String key){
		int hash = 0;
		for(int i=1;i<=key.length();i++){
			hash += (int)key.charAt(i-1)*i;
		}
		return (hash*19)%101;
	}
	
	
	private static void deleteFromTable(String key) {
		int k = hash(key);
		if(!key.equals(value[k])){
			for(int j=1;j<=19;j++){
				int newkey = (k + j*j + 23*j)%101;
				if(key.equals(value[newkey])){
					value[newkey] = null;
					break;
				}
			}
		}
		else{
			value[k]=null;
		}
	}

	private static void addToTable(String key) {
		int k = hash(key);
		if(key.equals(value[k])){
			return;
		}
		if(value[k]==null){
			keys[k] = k;
			value[k] = key;
		}
		else{
			for(int j=1;j<=19;j++){
				int newkey = (k + (j*j) + (23*j))%101;
				if(value[newkey]==null){
					keys[newkey] = newkey;
					value[newkey] = key;
					break;
				}
			}
		}
}
}
