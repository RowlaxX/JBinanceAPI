package fr.rowlaxx.binanceapi.core.order.margin;

import fr.rowlaxx.binanceapi.core.order.OcoOrder;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

import org.json.JSONObject;

public class MarginOCOOrder extends OcoOrder<MarginOrder> {
	private static final long serialVersionUID = -423159239247907955L;
	
	//Variables
	private boolean isIsolated;
	@JOValue(mandatory = false)
	private Double marginBuyBorrowAmount;
	@JOValue(mandatory = false)
	private String marginBuyBorrowAsset;
	
	//Constructeurs
	public MarginOCOOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final Double getMarginBuyBorrowAmount() {
		return this.marginBuyBorrowAmount;
	}
	
	public final String getMarginBuyBorrowAsset() {
		return this.marginBuyBorrowAsset;
	}
}