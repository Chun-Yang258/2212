package cryptoTrader.manager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;



public class BrokerManager {
	
	/**
	 * @author Daiying Erica Zhu
	 *
	 */
	
	private ArrayList<TradeBroker> brokers;
	private HashMap<String, Double> allPrices;
	
	
	

	public BrokerManager() {
		brokers = new ArrayList<TradeBroker>();
		allPrices = new HashMap<String, Double>();
		
	//	Remove bottom
		 ArrayList<String> coins = new ArrayList<String>();
		 coins.add("XRP");
		 coins.add("BitCoin");
		 coins.add("b");
		 Strategy thisS = new Strategy();
		 TradeBroker one = new TradeBroker("John A",thisS,coins);
		 brokers.add(one);
		 ArrayList<String> coins2 = new ArrayList<String>();
		 coins2.add("CrP");
		 
		 TradeBroker two = new TradeBroker("Amy",thisS,coins2);
		 brokers.add(two);
	}


	
	public void fetchPrices() {
		ArrayList<String> allCoins = getAllRequestedCoin();
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String date = formatter.format(date1);
		AvailableCryptoList list = AvailableCryptoList.getInstance();
		DataFetcher fetcher = new DataFetcher();
		int numAllCoin = allCoins.size();
		for (int i = 0; i < numAllCoin; i++) {
			String coin  = allCoins.get(i);
			String id =  list.getCryptoID(coin);
			if (id != null) {
				double price = fetcher.getPriceForCoin(id, date);
		
				allPrices.put(coin, price);
				
			}
			else {
				continue;
			}			
			
		}
		
		
	}
	
	private ArrayList<String> getAllRequestedCoin(){
		ArrayList<String> allCoins = new ArrayList<String>();
		int numBroker = brokers.size();
		for(int i = 0; i<numBroker;i++) {
			TradeBroker broker = brokers.get(i);
			ArrayList<String> coins = broker.getCoinList();
			int numCoin = coins.size();
			for (int j = 0; j < numCoin; j++) {
				String coin = (coins.get(j)).toLowerCase();
				if (allCoins.contains(coin)) {
					continue;
				}
				else {
					allCoins.add(coin);
				}
			}
			
		}
		return allCoins;
	}

	public void notifyPricesToAll() {
		int numBroker = brokers.size();
		for (int i = 0; i<numBroker; i++) {
			TradeBroker broker = brokers.get(i);
			ArrayList<String> coinList = broker.getCoinList();
			HashMap<String,Double> coinPriceList = new HashMap<String,Double>();
			int coinNum = coinList.size();
			for (int j = 0; j < coinNum; j++) {
				String coin = (coinList.get(j)).toLowerCase();
				if (allPrices.containsKey(coin)) {
					Double price = allPrices.get(coin);
					coinPriceList.put(coin, price);
					
				}
				
			}
			broker.notifyPrice(coinPriceList);
			HashMap<String,Double> list =  broker.getPriceList();
			System.out.println(Arrays.asList(list));
		}
		
		
	}

	
	
	public ArrayList<TradeBroker> getBrokers(){
		return brokers;
		
	}

	public static void main(String[] args) {
		
		
		 BrokerManager newbro =  new BrokerManager();
		 newbro.fetchPrices();
		 newbro.notifyPricesToAll();
		 
		 
	
	}
	
}