package fr.rowlaxx.binanceapi.core.general.future;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.SimpleSymbol;
import fr.rowlaxx.binanceapi.core.order.TimeInForce;
import fr.rowlaxx.binanceapi.core.order.future.FutureOrderTypes;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class FutureSymbol extends SimpleSymbol<FutureOrderTypes> {
	private static final long serialVersionUID = 4784472032259702080L;

	//Variables
	@JOValue private int quantityPrecision;
	@JOValue private int pricePrecision;
	@JOValue private double requiredMarginPercent;
	@JOValue private long onboardDate;
	@JOValue private String pair;
	@JOValue private double triggerProtect;
	@JOValue private String marginAsset;
	@JOValue private double liquidationFee;
	@JOValue private double maintMarginPercent;
	@JOValue private double marketTakeBound;
	@JOValue private long deliveryDate;
	@JOValue private FutureContractTypes contractType;
	@JOValue private UnderlyingTypes underlyingType;
	@JOValue private Set<UnderlyingSubTypes> underlyingSubType;
	@JOValue private Set<TimeInForce> timeInForce;
	@JOValue(key = {"status", "contractStatus"})
	private FutureContractStatus status;
	
	//Constructeurs
	public FutureSymbol(JSONObject response) {
		super(response);
	}
	
	//Getter
	public FutureContractTypes getContractType() {
		return contractType;
	}
	
	public long getDeliveryDate() {
		return deliveryDate;
	}
	
	public double getLiquidationFee() {
		return liquidationFee;
	}
	
	public double getMaintMarginPercent() {
		return maintMarginPercent;
	}
	
	public String getMarginAsset() {
		return marginAsset;
	}
	
	public double getMarketTakeBound() {
		return marketTakeBound;
	}
	
	public long getOnboardDate() {
		return onboardDate;
	}
	
	public String getPair() {
		return pair;
	}
	
	public int getPricePrecision() {
		return pricePrecision;
	}
	
	public int getQuantityPrecision() {
		return quantityPrecision;
	}
	
	public double getRequiredMarginPercent() {
		return requiredMarginPercent;
	}
	
	public FutureContractStatus getStatus() {
		return status;
	}
	
	public Set<TimeInForce> getTimeInForces() {
		return timeInForce;
	}
	
	public boolean hasTimeInForce(TimeInForce tif) {
		return timeInForce.contains(tif);
	}
	
	public double getTriggerProtect() {
		return triggerProtect;
	}
	
	public Set<UnderlyingSubTypes> getUnderlyingSubTypes() {
		return underlyingSubType;
	}
	
	public boolean hasUnderlyingSubType(UnderlyingSubTypes underlyingSubType) {
		return this.underlyingSubType.contains(underlyingSubType);
	}
	
	public UnderlyingTypes getUnderlyingType() {
		return underlyingType;
	}
}