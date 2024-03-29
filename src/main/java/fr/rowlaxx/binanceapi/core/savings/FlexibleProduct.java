package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FlexibleProduct extends JsavonObject {
	private static final long serialVersionUID = 8342258680470277251L;
	
	//Variables
	private String asset;
	private double avgAnnualInterestRate;
	private boolean canPurchase;
	private boolean canRedeem;
	private double dailyInterestPerThousand;
	private boolean featured;
	private double minPurchaseAmount;
	private String productId;
	private double purchasedAmount;
	private String status;
	private double upLimit;
	private double upLimitPerUser;
	
	//Constructeurs
	public FlexibleProduct(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getAvgAnnualInterestRate() {
		return this.avgAnnualInterestRate;
	}
	
	public final boolean isCanPurchase() {
		return this.canPurchase;
	}
	
	public final boolean isCanRedeem() {
		return this.canRedeem;
	}
	
	public final double getDailyInterestPerThousand() {
		return this.dailyInterestPerThousand;
	}
	
	public final boolean isFeatured() {
		return this.featured;
	}
	
	public final double getMinPurchaseAmount() {
		return this.minPurchaseAmount;
	}
	
	public final String getProductId() {
		return this.productId;
	}
	
	public final double getPurchasedAmount() {
		return this.purchasedAmount;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final double getUpLimit() {
		return this.upLimit;
	}
	
	public final double getUpLimitPerUser() {
		return this.upLimitPerUser;
	}
}