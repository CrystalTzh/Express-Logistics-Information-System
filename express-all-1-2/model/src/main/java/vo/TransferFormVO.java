package vo;

import java.io.*;
import java.util.ArrayList;

import state.FormState;
import state.Transport;
import state.Zone;

public class TransferFormVO implements Serializable {
	
	String putOnCarDate; //装车日期
	String relayFormNumber;//中转单编号
	String startingpoint; //出发地
	String destination; //到达地
	String loadingMember; //监装员
	Transport transport; //运输方式
	Zone zone;
	int line;
	int shelf;
	int tag; //区号排号架号位号
	ArrayList<String> allIDs; // 所有订单号
	double transCharge; //运费
	FormState formstate;//单据的状态
	
	public String getPutOnCarDate() {
		return putOnCarDate;
	}
	public String getStartingpoint() {
		return startingpoint;
	}
	public String getDestination() {
		return destination;
	}
	public String getLoadingMember() {
		return loadingMember;
	}
	public Zone getZone() {
		return zone;
	}
	public int getLine() {
		return line;
	}
	public int getShelf() {
		return shelf;
	}
	public int getTag() {
		return tag;
	}
	public ArrayList<String> getAllIDs() {
		return allIDs;
	}
	public double getTransCharge() {
		return transCharge;
	}
	public void setPutOnCarDate(String putOnCarDate) {
		this.putOnCarDate = putOnCarDate;
	}
	public void setStartingpoint(String startingpoint) {
		this.startingpoint = startingpoint;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setLoadingMember(String loadingMember) {
		this.loadingMember = loadingMember;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public void setAllIDs(ArrayList<String> allIDs) {
		this.allIDs = allIDs;
	}
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}

	public String getRelayFormNumber() {
		return relayFormNumber;
	}

	public Transport getTransport() {
		return transport;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setRelayFormNumber(String relayFormNumber) {
		this.relayFormNumber = relayFormNumber;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
