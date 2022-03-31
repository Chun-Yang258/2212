/**
 * 
 */
package cryptoTrader.analysis;

/**
 * @author Daiying Erica Zhu
 *
 */
public class TradeResult {

	private String name;
	private String strategyType;
	private String coinTraded;
	private String action;
	private String tradeAmount;
	private String tradePrice;
	private String date;
	private Boolean status;
	
	
	public TradeResult(String name, String strategyType,String coinTraded,String action, String tradeAmount, String tradePrice,String date) {
		this.name = name;
		this.strategyType = strategyType;
		this.coinTraded = coinTraded;
		this.action = action;
		this.tradeAmount = tradeAmount;
		this.tradePrice = tradePrice;
		this.date = date;
		if ((action.toLowerCase()).equals("fail")) {
			status = false;
		}
		else {
			status = true;
		}
		
	}
	
	public Boolean TradeSucceeded() {
		return status;
	}
	
	public String getBrokerName() {
		
		return name;
		

	}
	
	public Object[] returnResultObject() {
		Object[] output = new String[7];
		output[0] = name;
		output[1] = strategyType;
		output[2] = coinTraded;
		output[3] = action;
		output[4] = tradeAmount;
		output[5] = tradePrice;
		output[6] = date;
		return output;
		
		
	}
	

}
