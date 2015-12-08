package po;

import java.io.Serializable;

import state.FormState;
import state.Zone;

public class StorageInFormPO implements  Serializable{
		String NO;
		String date;
		String expressNumber;
		String destination;
		Zone zone;
		int line;
		int shelf;
		int tag;
		
		FormState formstate;
		
		public StorageInFormPO(){
			NO = "001";
			date = null;
			expressNumber = "";
			destination ="";
			zone = Zone.NULL;
		}
	
		public  StorageInFormPO(String no,String da,String i,String de,
				Zone z,int l,int s,int t,FormState fs){
			NO = no;
			date=da;
			expressNumber=i;
			destination=de;
			zone = z;
			line = l;
			shelf = s;
			tag = t;
			formstate = fs;
		}

		public String getNO() {
			return NO;
		}

		public void setNO(String nO) {
			NO = nO;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getExpressNumber() {
			return expressNumber;
		}

		public void setExpressNumber(String expressNumber) {
			this.expressNumber = expressNumber;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public Zone getZone() {
			return zone;
		}

		public void setZone(Zone zone) {
			this.zone = zone;
		}

		public int getLine() {
			return line;
		}

		public void setLine(int line) {
			this.line = line;
		}

		public int getShelf() {
			return shelf;
		}

		public void setShelf(int shelf) {
			this.shelf = shelf;
		}

		public int getTag() {
			return tag;
		}

		public void setTag(int tag) {
			this.tag = tag;
		}

		public FormState getFormstate() {
			return formstate;
		}

		public void setFormstate(FormState formstate) {
			this.formstate = formstate;
		}
		
		
	
}
