package vo;

import java.net.URLEncoder;

//상품 하나의 정보를 저장하는 클래스.
public class Md {
	
	private int mdid;		// 상품아이디
	private String item;	// 상품명
	private int price;		// 가격
	private String image;	// 상품이미지
	private String cate1;	// 대분류
	private String cate2;	// 중분류
	private String cate3;	// 소분류
	private String content; // 상품설명
	private int hit;		// 조회수
	
	// alt+shift+s -> o(Constructor using Fields) -> (Select All) -> OK.
	public Md(int mdid, String item, int price, String image, String cate1, String cate2, String cate3, String content,
			int hit) {
		super();
		this.mdid = mdid;
		this.item = item;
		this.price = price;
		this.image = image;
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.cate3 = cate3;
		this.content = content;
		this.hit = hit;
	}
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public int getmdid() {
		return mdid;
	}

	public void setmdid(int mdid) {
		this.mdid = mdid;
	}

	public String getitem() {
		return item;
	}

	public void setitem(String item) {
		this.item = item;
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

	public String getCate1() {
		return cate1;
	}

	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}

	public String getCate2() {
		return cate2;
	}

	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}

	public String getCate3() {
		return cate3;
	}

	public void setCate3(String cate3) {
		this.cate3 = cate3;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int gethit() {
		return hit;
	}

	public void sethit(int hit) {
		this.hit = hit;
	}

}
