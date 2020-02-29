package testScripts;

import java.util.ArrayList;
import java.util.HashMap;

import keywordLib.KeywordLibrary;
import utilities.Excel;

public class TC002 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		HashMap<Integer, ArrayList<String>> map = Excel.readAllData("Amazon");
		System.out.println(map);
		
		for (Integer key : map.keySet()) {
			
			ArrayList<String> values = map.get(key);
			
			KeywordLibrary.controller(values.get(0), values.get(1), values.get(2),
					values.get(3));
		}
		
		
	}

}
