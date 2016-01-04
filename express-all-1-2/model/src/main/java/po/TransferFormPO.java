package po;

import java.io.*;
import java.util.ArrayList;

import state.FormState;
import state.Line;
import state.Shelf;
import state.Tag;
import state.Transport;
import state.Zone;
/**
 * 中转单持久化对象
 */
public class TransferFormPO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String NO;
	String putOnCarDate; //装车日期
	String relayFormNumber;//中转单编号
	String startingpoint; //出发地
	String destination; //到达地
	String loadingMember; //监装员
	Transport transport; //运输方式
	Zone zone;
	Line line;
	Shelf shelf;
	Tag tag; //区号排号架号位号
	ArrayList<String> allIDs; // 所有订单号
	double transCharge; //运费
	FormState formstate;//单据的状态
	
	
	public FormState getFormstate() {
		return formstate;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		NO = nO;
	}
	public String getPutOnCarDate() {
		return putOnCarDate;
	}
	public void setPutOnCarDate(String putOnCarDate) {
		this.putOnCarDate = putOnCarDate;
	}
	public String getRelayFormNumber() {
		return relayFormNumber;
	}
	public void setRelayFormNumber(String relayFormNumber) {
		this.relayFormNumber = relayFormNumber;
	}
	public String getStartingpoint() {
		return startingpoint;
	}
	public void setStartingpoint(String startingpoint) {
		this.startingpoint = startingpoint;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getLoadingMember() {
		return loadingMember;
	}
	public void setLoadingMember(String loadingMember) {
		this.loadingMember = loadingMember;
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Shelf getShelf() {
		return shelf;
	}
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public ArrayList<String> getAllIDs() {
		return allIDs;
	}
	public void setAllIDs(ArrayList<String> allIDs) {
		this.allIDs = allIDs;
	}
	public double getTransCharge() {
		return transCharge;
	}
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}
	
	
	
	
}
