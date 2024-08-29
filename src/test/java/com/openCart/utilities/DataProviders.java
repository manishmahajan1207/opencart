package com.openCart.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".//TestData//Opencart_LoginData.xlsx";
		
		ExcelUtility excel = new ExcelUtility(path);
		
		int rowCount = excel.getRowCount("sheet1");
		int cellCount = excel.getCellCount("sheet1",1);
		
		String loginData[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				
				loginData[i-1][j] = excel.getCellData("sheet1", i, j);
			}
		}
		
		return loginData;
		
		
		
		
	}
	

}
