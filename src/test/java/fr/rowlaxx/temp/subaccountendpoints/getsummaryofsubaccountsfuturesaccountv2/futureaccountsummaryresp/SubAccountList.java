package fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv2.futureaccountsummaryresp;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccountList extends JSavONObject {
	private static final long serialVersionUID = 5799744505998589988L;
	
	//Variables
	private String asset;
	private String email;
	private double totalInitialMargin;
	private double totalMaintenanceMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public SubAccountList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final double getTotalInitialMargin() {
		return this.totalInitialMargin;
	}
	
	public final double getTotalMaintenanceMargin() {
		return this.totalMaintenanceMargin;
	}
	
	public final double getTotalMarginBalance() {
		return this.totalMarginBalance;
	}
	
	public final double getTotalOpenOrderInitialMargin() {
		return this.totalOpenOrderInitialMargin;
	}
	
	public final double getTotalPositionInitialMargin() {
		return this.totalPositionInitialMargin;
	}
	
	public final double getTotalUnrealizedProfit() {
		return this.totalUnrealizedProfit;
	}
	
	public final double getTotalWalletBalance() {
		return this.totalWalletBalance;
	}
}