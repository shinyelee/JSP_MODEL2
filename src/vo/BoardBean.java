package vo;

import java.sql.Date;

public class BoardBean { // �Խ��Ǳ� �ϳ��� ������ �����ϴ� Ŭ����.
	
	private int board_num; // �� ��ȣ.
	private String board_name; // �� �ۼ���.
	private String board_pass; // �� ��й�ȣ.
	private String board_subject; // �� ����.
	private String board_content; // �� ����.
	private String board_file; // ÷�� ����.
	private int board_re_ref; // ���ñ� ��ȣ.
	private int board_re_lev; // ��� ����.
	private int board_step; // ���ñ� �� ��� ����.
	private int board_readcount; // ��ȸ��.
	private Date board_date; // �ۼ���.
	// alt+shift+s -> r(Generate Getters and Setters) -> (Select All) -> OK.
	public int getBoard_num() {
		return board_num;
	}
	
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	
	public String getBoard_name() {
		return board_name;
	}
	
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	
	public String getBoard_pass() {
		return board_pass;
	}
	
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	
	public String getBoard_subject() {
		return board_subject;
	}
	
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	
	public String getBoard_content() {
		return board_content;
	}
	
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	public String getBoard_file() {
		return board_file;
	}
	
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	
	public int getBoard_re_ref() {
		return board_re_ref;
	}
	
	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	
	public int getBoard_re_lev() {
		return board_re_lev;
	}
	
	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	
	public int getBoard_step() {
		return board_step;
	}
	
	public void setBoard_step(int board_step) {
		this.board_step = board_step;
	}
	
	public int getBoard_readcount() {
		return board_readcount;
	}
	
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	
	public Date getBoard_date() {
		return board_date;
	}
	
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
}
