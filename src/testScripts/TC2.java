package testScripts;

import java.util.ArrayList;
import java.util.HashMap;

import keywordLib.KeywordLibrary;
import utilities.Excel;

public class TC2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int fail_count = 0;
		HashMap<Integer, ArrayList<String>> testCases = Excel.readAllData("TestCases");
		for (Integer testCase : testCases.keySet()) {
			ArrayList<String> testCaseInfo = testCases.get(testCase);
			//System.out.println(testCaseInfo);
			if(testCaseInfo.get(1).equals("run")) {
				HashMap<Integer, ArrayList<String>> map = 
						Excel.readAllData(testCaseInfo.get(0));
				//System.out.println(map);
				for (Integer key : map.keySet()) {
					ArrayList<String> values = map.get(key);
					try {
						System.out.println(values);
						KeywordLibrary.controller(values.get(0), 
							values.get(1), values.get(2), values.get(3));
						Excel.updateRow(testCaseInfo.get(0), key, "pass");
					} catch (Exception e) {
						System.out.println(values + " exception");
						e.printStackTrace();
						Excel.updateRow(testCaseInfo.get(0), key, "fail");
						fail_count++;
					}
				}
			} 
			else {
				System.out.println("Test case " + testCaseInfo.get(0) + ": skipped");
			}
			
			if (fail_count == 0 && testCaseInfo.get(1).equals("run")) {
				Excel.updateRow("TestCases", testCase, "pass");
			} else if(fail_count != 0 && testCaseInfo.get(1).equals("run")) {
				Excel.updateRow("TestCases", testCase, "fail");
			}
			else {
				Excel.updateRow("TestCases", testCase, "skipped");
			}
		}
		
	}
}
