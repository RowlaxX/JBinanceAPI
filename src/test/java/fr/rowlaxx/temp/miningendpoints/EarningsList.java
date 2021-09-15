package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.earningslist.Data;

import org.json.JSONObject;

public class EarningsList extends JSavONObject {
	private static final long serialVersionUID = -2496982061910121756L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public EarningsList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final Data getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}