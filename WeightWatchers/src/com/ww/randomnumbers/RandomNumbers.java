package com.ww.randomnumbers;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
	
	public static void main(String[] args) {
		int[] numbers = new int[500];
		Random rand = new Random();
		int nthNum;
		for(int i=0; i<500;i++) {
			numbers[i] = rand.nextInt(550);
		}
		
		//sort the array.
		Arrays.sort(numbers); 
		nthNum = rand.nextInt(550);
	/*	do{
			System.out.println("Please enter a number between 1 to 500 :");
			Scanner sc = new Scanner(System.in);
			nthNum = sc.nextInt();
		}while (nthNum <1 || nthNum >500);
	*/	
		// Printing the generated Random numbers.
		System.out.println(" The generated random numbers are :: ");
		System.out.println(Arrays.toString(numbers));
		
		//Printing the find nth smallest number.
		System.out.println("The nth Smallest number is .."+findNthSmallestNumber(nthNum, numbers));
	}
	
	public static int findNthSmallestNumber(int n, int[] numbers) {
		return numbers[n-1];
	}


}
