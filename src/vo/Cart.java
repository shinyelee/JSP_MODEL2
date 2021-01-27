package vo;

import java.net.URLEncoder;

// 장바구니 항목 하나의 정보를 저장하는 클래스.
public class Cart {

	private String image; // 상품이미지
	private String item;  // 상품명
	private int price;	  // 가격
	private int qty;	  // 수량
	private String encodingItem;
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getEncodingItem() {
		try {
			encodingItem = URLEncoder.encode(item, "UTF-8");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return encodingItem;
	}
	
	public void setEncodingItem(String encodingItem) {
		this.encodingItem = encodingItem;
	}

}
