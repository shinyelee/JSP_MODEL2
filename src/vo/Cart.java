package vo;

// ��ٱ��� �׸� �ϳ��� ������ �����ϴ� Ŭ����.
public class Cart {

	private String image; // ��ǰ �̹���.
	private String name; // ��ǰ��.
	private int price; // ��ǰ ����.
	private int qty; // ��ǰ ����.
	
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
