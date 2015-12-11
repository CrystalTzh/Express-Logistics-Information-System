package vo;

import java.io.Serializable;

import state.FormState;
import state.Zone;

public class StorageInFormVO implements  Serializable{
		String NO;
		String date;
		String expressNumber;
		String destination;
		Zone zone;//区号
		String line;//排号
		String shelf;//架号
		String tag;//位号
		FormState formstate;//单据的状态
		
		
		
		public String getLine() {
			return line;
		}
		public void setLine(String line) {
			this.line = line;
		}
		public String getShelf() {
			return shelf;
		}
		public void setShelf(String shelf) {
			this.shelf = shelf;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getNO() {
			return NO;
		}
		public void setNO(String NO) {
			this.NO = NO;
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
		public Zone getZone(){
			return zone;
		}
		public void setZone(Zone zone){
			this.zone=zone;
		}
		public FormState getFormstate() {
			return formstate;
		}
		public void setFormstate(FormState formstate) {
			this.formstate = formstate;
		}
		
		
		
}
