package fr.rowlaxx.binanceapi.core.order;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class SimpleOrder extends JSavONObject {
	private static final long serialVersionUID = 1492707707138253457L;
	
	//Variables
	private String symbol;
	@JOValue(key = { "orderId", "id" })
	private long orderId;
	private String clientOrderId;

	//Constructeurs
	public SimpleOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return clientOrderId;
	}
	
	public final long getOrderId() {
		return orderId;
	}
	
	public final String getSymbol() {
		return symbol;
	}
}