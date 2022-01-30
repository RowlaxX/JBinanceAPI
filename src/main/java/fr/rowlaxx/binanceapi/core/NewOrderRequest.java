package fr.rowlaxx.binanceapi.core;

import fr.rowlaxx.binanceapi.core.margin.MarginOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.margin.MarginOrderRequest;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrderRequest;
import fr.rowlaxx.binanceapi.core2.order.future.FutureOrderRequest;
import fr.rowlaxx.binanceapi.core2.order.options.OptionsOrderRequest;

public final class NewOrderRequest {
	
	public static SpotOrderRequest.Builder spot(){
		return SpotOrderRequest.newSpotBuilder();
	}

	public static MarginOrderRequest.Builder margin(){
		return MarginOrderRequest.newMarginBuilder();
	}
	
	public static SpotOCOOrderRequest.Builder spotOCO(){
		return SpotOCOOrderRequest.newSpotBuilder();
	}
	
	public static MarginOCOOrderRequest.Builder marginOCO(){
		return MarginOCOOrderRequest.newMarginBuilder();
	}
	
	public static FutureOrderRequest.Builder futures(){
		return FutureOrderRequest.newBuilder();
	}
	
	public static OptionsOrderRequest.Builder options() {
		return OptionsOrderRequest.newBuilder();
	}	
}