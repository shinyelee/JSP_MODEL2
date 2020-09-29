package vo;

// �� ��ǰ �ϳ��� ������ �����ϴ� Ŭ����.
public class Goods {
	
	private int id; // ��ǰ ���̵�.
	private String name; // ��ǰ��.
	private int price; // ��ǰ ����.
	private String image; // ��ǰ �̹���.
	private String category; // ��ǰ ��з�.
	private String category2; // ��ǰ �ߺз�.
	private int version; // ��ǰ ����.
	private String content; // ��ǰ ����.
	private int readcount; // ��ȸ��.
	
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
