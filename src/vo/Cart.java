package vo;

// 장바구니 항목 하나의 정보를 저장하는 클래스.
public class Cart {

	private String image; // 상품 이미지.
	private String name; // 상품명.
	private int price; // 상품 가격.
	private int qty; // 상품 수량.
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

}
