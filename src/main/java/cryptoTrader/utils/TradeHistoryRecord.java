/*This use Singleton*/
package cryptoTrader.utils;

import java.util.ArrayList;

import cryptoTrader.analysis.TradeResult;

/**
 * @author Daiying Erica Zhu
 *
 */

public class TradeHistoryRecord {
	
	private static TradeHistoryRecord recordTable = null;
	private ArrayList<TradeResult> record;
	
	
	
	private TradeHistoryRecord(){
		record = new ArrayList<TradeResult>();
	}
	
	
	
	
	public static void updateRecord(ArrayList<TradeResult> newRecords) {
		
		if (recordTable == null) {
			recordTable = new TradeHistoryRecord();
		}
		newRecords.addAll(recordTable.record);
		recordTable.record=newRecords;
		
	}
	
	

	public static ArrayList<TradeResult> getRecord() {

		return recordTable.record;
		
	}
	
	

}
