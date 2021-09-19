package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.margin.UserAsset;

public class MarginBaseQuoteAsset extends UserAsset {
	private static final long serialVersionUID = 7826057242384643028L;
	
	//Variables
	private boolean borrowEnabled;
	private double netAssetOfBtc;
	private boolean repayEnabled;
	private double totalAsset;
	
	//Constructeurs
	public MarginBaseQuoteAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getNetAssetOfBtc() {
		return netAssetOfBtc;
	}
	
	public final double getTotalAsset() {
		return totalAsset;
	}
	
	public final boolean isBorrowEnabled() {
		return borrowEnabled;
	}
	
	public final boolean isRepayEnabled() {
		return repayEnabled;
	}
}
