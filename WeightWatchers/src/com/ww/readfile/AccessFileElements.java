package com.ww.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class AccessFileElements {

	
	public static void main(String[] args) throws Exception{
		File myFile = new File("C:\\Workspace_Aug4\\WeightWatchers\\dataFile.txt");
		
		if(myFile.exists()) {
			System.out.println("File exists");
		}else {
			System.out.println("File does not exists");
		}
		FileReader freader=new FileReader("C:\\Workspace_Aug4\\WeightWatchers\\dataFile.txt");
		BufferedReader br= new BufferedReader(freader);
		String x="";
		while ((x=br.readLine()) != null){
			System.out.println(x +"\n");
		}
		br.close();

}
}
