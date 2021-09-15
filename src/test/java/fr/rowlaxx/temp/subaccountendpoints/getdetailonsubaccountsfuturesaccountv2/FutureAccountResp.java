package fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv2;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv2.futureaccountresp.Assets;

import java.util.List;

import org.json.JSONObject;

public class FutureAccountResp extends JSavONObject {
	private static final long serialVersionUID = -410335082003916724L;
	
	//Variables
	private List<Assets> assets;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private String email;
	private int feeTier;
	private double maxWithdrawAmount;
	private double totalInitialMargin;
	private double totalMaintenanceMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	private long updateTime;
	
	//Constructeurs
	public FutureAccountResp(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Assets> getAssets() {
		return this.assets;
	}
	
	public final boolean isCanDeposit() {
		return this.canDeposit;
	}
	
	public final boolean isCanTrade() {
		return this.canTrade;
	}
	
	public final boolean isCanWithdraw() {
		return this.canWithdraw;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final int getFeeTier() {
		return this.feeTier;
	}
	
	public final double getMaxWithdrawAmount() {
		return this.maxWithdrawAmount;
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
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}