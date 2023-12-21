package com.mire.biz.commodity;

public class CommodityVO {

	private int seq;
	private String item;
	private String prices;
	private String topics;
	private String subtopics;
	private String quantity;
	private String search;
	
	public int getSeq() {
		return seq;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public String getSubtopics() {
		return subtopics;
	}
	public void setSubtopics(String subtopics) {
		this.subtopics = subtopics;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CommodityVO [seq=" + seq + ", item=" + item + ", prices=" + prices + ", topics=" + topics
				+ ", subtopics=" + subtopics + ", quantity=" + quantity + ", search=" + search + "]";
	}
	
	
	
	
}
