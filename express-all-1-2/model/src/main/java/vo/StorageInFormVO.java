package vo;

import java.io.Serializable;

import state.FormState;
import state.Line;
import state.Shelf;
import state.Tag;
import state.Zone;
/**
 * 入库单持久化对象
 */
public class StorageInFormVO implements  Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String NO;
		String date;
		String expressNumber;
		String destination;
		Zone zone;//区号
		Line line;//排号
		Shelf shelf;//架号
		Tag tag;//位号
		FormState formstate;//单据的状态
		
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
		public Shelf getShelf(){
			return shelf;
		}
		public void setShelf(Shelf shelf){
			this.shelf=shelf;
		}
		public Tag getTag(){
			return tag;
		}
		public void setTag(Tag tag){
			this.tag=tag;
		}
		public Line getLine(){
			return line;
		}
		public void setLine(Line lines){
			this.line=lines;
		}
		public FormState getFormstate() {
			return formstate;
		}
		public void setFormstate(FormState formstate) {
			this.formstate = formstate;
		}
		
		
		
}
