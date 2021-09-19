package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.general.margin.CrossMarginPair;
import fr.rowlaxx.binanceapi.core.general.margin.MarginAsset;
import fr.rowlaxx.binanceapi.core.margin.CrossMarginTransferRecord;
import fr.rowlaxx.binanceapi.core.margin.ForceLiquidationRecord;
import fr.rowlaxx.binanceapi.core.margin.BNBBurnStatus;
import fr.rowlaxx.binanceapi.core.margin.InterestRecord;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginAccountInfo;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginTransferRecord;
import fr.rowlaxx.binanceapi.core.margin.LoanRecord;
import fr.rowlaxx.binanceapi.core.margin.MarginAccountTrade;
import fr.rowlaxx.binanceapi.core.margin.MarginUserAsset;
import fr.rowlaxx.binanceapi.core.margin.MaxBorrow;
import fr.rowlaxx.binanceapi.core.margin.EnabledIsolatedMarginAccountLimit;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginSymbol;
import fr.rowlaxx.binanceapi.core.margin.MarginInterestRateRecord;
import fr.rowlaxx.binanceapi.core.margin.CrossMarginAccountDetails;
import fr.rowlaxx.binanceapi.core.margin.RepayRecord;
import fr.rowlaxx.binanceapi.core.market.margin.MarginPriceIndex;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOCOOrder;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOrder;
import fr.rowlaxx.binanceapi.core.order.margin.MarginOrderRequest;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface MarginAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long crossMarginAccountTransfer(String asset, double amount, int type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long marginAccountBorrow(String asset, Boolean isIsolated, String symbol, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long marginAccountRepay(String asset, Boolean isIsolated, String symbol, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public MarginAsset getMarginAsset(String asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CrossMarginPair getCrossMarginPair(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allAssets",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "assetName")
	public Map<String, MarginAsset> getMarginAssets();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CrossMarginPair> getGetAllCrossMarginPairs();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/priceIndex",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public MarginPriceIndex getMarginPriceIndex(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.side, Parameters.type, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.stopPrice, Parameters.newClientOrderId, Parameters.icebergQty, Parameters.newOrderRespType, Parameters.sideEffectType, Parameters.timeInForce},
			mandatory = {true, false, true, true, false, false, false, false, false, false, false, false, false}
	)
	public MarginOrder postOrder(MarginOrderRequest request);
	
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginOrder cancelOrder(String symbol, Boolean isIsolated, Long orderId, String origClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {true, false}
	)
	public List<MarginOrder> cancelAllOrders(String symbol, Boolean isIsolated);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<CrossMarginTransferRecord> getCrossMarginTransferHistory(String asset, String type, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<LoanRecord> getLoanRecords(String asset, String isolatedSymbol, Long txId, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<RepayRecord> getRepayRecords(String asset, String isolatedSymbol, Long txId, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	public List<InterestRecord> getInterestHistory(String asset, String isolatedSymbol, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/forceLiquidationRec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.isolatedSymbol, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false, false}
	)
	public List<ForceLiquidationRecord> getForceLiquidationRecords(Long startTime, Long endTime, String isolatedSymbol, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossMarginAccountDetails getQueryCrossMarginAccountDetails();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false, false}
	)
	public MarginOrder getOrder(String symbol, Boolean isIsolated, String orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {false, false}
	)
	public List<MarginOrder> getOpenOrders(String symbol, Boolean isIsolated);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<MarginOrder> getAllOrders(String symbol, Boolean isIsolated, Long orderId, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order/oco",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType, Parameters.sideEffectType},
			mandatory = {true, false, false, true, true, false, true, false, false, true, false, false, false, false, false}
	)
	public MarginOCOOrder postOCOOrder(MarginOCOOrderRequest request);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginOCOOrder cancelOCOOrder(String symbol, Boolean isIsolated, Long orderListId, String listClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.orderListId, Parameters.origClientOrderId},
			mandatory = {false, false, false, false}
	)
	public MarginOCOOrder getOCOOrder(Boolean isIsolated, String symbol, Long orderListId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<MarginOCOOrder> getAllOCOOrders(Boolean isIsolated, String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol},
			mandatory = {false, false}
	)
	public List<MarginOCOOrder> getOpenOCOOrders(Boolean isIsolated, String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/myTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<MarginAccountTrade> getTradeList(String symbol, Boolean isIsolated, Long startTime, Long endTime, Long fromId, Integer limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxBorrowable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	public MaxBorrow getMaxBorrow(String asset, String isolatedSymbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxTransferable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "amount")
	public double getMaxTransferOutAmount(String asset, String isolatedSymbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.amount},
			mandatory = {true, true, true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long isolatedMarginAccountTransfer(String asset, String symbol, String transFrom, String transTo, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false, false}
	)
	public List<IsolatedMarginTransferRecord> getIsolatedMarginTransferHistory(String asset, String symbol, String transFrom, String transTo, Long startTime, Long endTime, Long current, Long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	@RedirectResponse(path = "assets")
	public MarginUserAsset getIsolatedMarginAccountInfo(String symbols);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public IsolatedMarginAccountInfo getIsolatedMarginAccountInfos();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "success")
	public boolean disableIsolatedMarginAccount(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "success")
	public boolean enableIsolatedMarginAccount(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/accountLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public EnabledIsolatedMarginAccountLimit getEnabledIsolatedMarginAccountLimit();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public IsolatedMarginSymbol getIsolatedMarginSymbol(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, IsolatedMarginSymbol> getAllIsolatedMarginSymbol();

	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.spotBNBBurn, Parameters.interestBNBBurn},
			mandatory = {false, false}
	)
	public BNBBurnStatus toggleBNBBurn(Boolean spotBNBBurn, Boolean interestBNBBurn);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public BNBBurnStatus getBNBBurnStatus();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestRateHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.vipLevel, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<MarginInterestRateRecord> getMarginInterestRateHistory(String asset, Integer vipLevel, Long startTime, Long endTime, Integer limit);
}