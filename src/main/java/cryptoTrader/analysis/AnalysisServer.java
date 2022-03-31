package cryptoTrader.analysis;

import java.util.ArrayList;

import cryptoTrader.gui.ErrorMessageUI;
import cryptoTrader.manager.TradeBroker;


/**
 * @author Daiying Erica Zhu
 *
 */

public class AnalysisServer {
	
	private ArrayList<TradeResult> tradeRecord;
	private ArrayList<String> ErrorInfo;
	
	
	public AnalysisServer() {
		tradeRecord = new ArrayList<TradeResult>();
		ErrorInfo = new ArrayList<String>();
		

	}
	
	public void performTrade(ArrayList<TradeBroker> brokers) {
		int numBroker = brokers.size();
		for(int i = 0; i < numBroker; i++) {
			TradeResult result = (brokers.get(i)).performStrategy();
			tradeRecord.add(result);
			if (result.TradeSucceeded()==false) {
				ErrorInfo.add(result.getBrokerName());
			}
		}
	}
	
	public void displayErrorInfo() {
		if (ErrorInfo.isEmpty()){
			return;
		}
		else {
			ErrorMessageUI errorMes = new ErrorMessageUI(ErrorInfo);
		}
	}
	
	public ArrayList<TradeResult> getResult(){
		return tradeRecord;
	}

}
