package fr.rowlaxx.binanceapi.core.spot.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.TickerStatistics;

public class SpotTickerStatistics extends TickerStatistics {
	private static final long serialVersionUID = 2670087711525505652L;
	
	//Variables
	private double askPrice;
	private double askQty;
	private double bidPrice;
	private double bidQty;
	private double prevClosePrice;
	private double quoteVolume;
	
	//Constructeurs
	public SpotTickerStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
	}
	
	public final double getPrevClosePrice() {
		return this.prevClosePrice;
	}
	
	public final double getQuoteVolume() {
		return this.quoteVolume;
	}
	
	public final double getAskQty() {
		return this.askQty;
	}
	
	public final double getBidQty() {
		return this.bidQty;
	}
}