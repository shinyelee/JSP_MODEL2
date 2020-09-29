package vo;

// 개 상품 하나의 정보를 저장하는 클래스.
public class Goods {
	
	private int id; // 상품 아이디.
	private String name; // 상품명.
	private int price; // 상품 가격.
	private String image; // 상품 이미지.
	private String category; // 상품 대분류.
	private String category2; // 상품 중분류.
	private int version; // 상품 버전.
	private String content; // 상품 설명.
	private int readcount; // 조회수.
	
	// alt+shift+s -> o(Constructor using Fields) -> (Select All) -> OK.
	public Goods(int id, String name, int price, String image, String category, 
				 String category2, int version, String content, int readcount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
		this.category2 = category2;
		this.version = version;
		this.content = content;
		this.readcount = readcount;
	}

	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory2() {
		return category2;
	}
	
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
}
