package vo;

import java.net.URLEncoder;

// ��ٱ��� �׸� �ϳ��� ������ �����ϴ� Ŭ����.
public class Cart {

	private String image; // ��ǰ�̹���
	private String item;  // ��ǰ��
	private int price;	  // ����
	private int qty;	  // ����
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
