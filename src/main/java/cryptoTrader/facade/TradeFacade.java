package cryptoTrader.facade;

import java.util.ArrayList;
import java.util.HashMap;

import cryptoTrader.analysis.AnalysisServer;
import cryptoTrader.analysis.TradeResult;
import cryptoTrader.manager.BrokerManager;
import cryptoTrader.utils.TradeHistoryRecord;

/**
 * @author Daiying Erica Zhu
 *
 */
public class TradeFacade {
	
	private BrokerManager manager;
	private AnalysisServer analyzer;
	
	
	public TradeFacade(BrokerManager manager) {
		this.manager = manager;
		
	}
	
	public void PerformTrade() {
		
		manager.fetchPrices();
		manager.notifyPricesToAll();
		analyzer.performTrade(manager.getBrokers());
		ArrayList<TradeResult> result =analyzer.getResult();
		TradeHistoryRecord.updateRecord(result);
		analyzer.displayErrorInfo();
		ArrayList<TradeResult> allRecord = TradeHistoryRecord.getRecord();
		//DisplayTradeAction displayer = new DiaplayTradeAction(allRecord);
		
		
		
		
		
		
	}



}
