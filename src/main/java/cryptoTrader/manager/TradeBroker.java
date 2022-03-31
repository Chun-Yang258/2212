package cryptoTrader.manager;

import java.util.ArrayList;
import java.util.HashMap;
import cryptoTrader.analysis.TradeResult;

/**
 * @author Daiying Erica Zhu
 *
 */

public class TradeBroker {
	
	private String Name;
	private Strategy strategyType;
	private HashMap<String,Double> coinPriceList;
	private ArrayList<String> coinList;
	
	public TradeBroker(String name, Strategy thisS,ArrayList<String> requestedCoin) {
		Name = name;
		strategyType = thisS;
		int coinNum = requestedCoin.size();
		coinList = requestedCoin;
		coinPriceList = new HashMap<String,Double>();
		}	
		

	
	public String getName() {
		return Name;
	}
	
	public ArrayList<String> getCoinList() {
		return coinList;
	}
	
	public HashMap<String,Double> getPriceList() {
		return coinPriceList;
	}
	
	public void notifyPrice(HashMap<String,Double> coinPrices) {
		coinPriceList = coinPrices;
		
	}
	
	
	public Strategy getStrategyType() {
		return strategyType;
		
	}
	
	public TradeResult performStrategy() {
		return strategyType.evaluate(coinPriceList);
		
	}

}