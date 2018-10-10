package com.utilities;

import java.io.IOException;
import java.util.List;

public class Environment {
	public static ReadGoogleSpreadSheet readGoogleSpreadSheet = new ReadGoogleSpreadSheet();
	public static List<List<Object>> values = null;
	public static String flag=null;
	public static String ReadExcelData(String SheetName, int RowNumber, int CellNumber) {

		try {
			values = readGoogleSpreadSheet.readSpreadSheet(SheetName);
		} catch (IOException e) {

			e.printStackTrace();
		}
		flag=values.get(RowNumber).get(CellNumber).toString();
		return flag;
	}
}