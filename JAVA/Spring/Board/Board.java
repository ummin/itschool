package com.naver.sdu0920.entities;

public class Board {
	private String b_seq;
	private String b_id;
	private String b_name;
	private String b_passowrd;
	private String b_email;
	private String b_title;
	private String b_content;
	private String b_date;
	private String b_ip;
	private int    b_ref;
	private String b_no;
	
	public String getB_no() {
		return b_no;
	}
	public void setB_no(String b_no) {
		this.b_no = b_no;
	}
	public String getB_seq() {
		return b_seq;
	}
	public void setB_seq(String b_seq) {
		this.b_seq = b_seq;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_passowrd() {
		return b_passowrd;
	}
	public void setB_passowrd(String b_passowrd) {
		this.b_passowrd = b_passowrd;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_ip() {
		return b_ip;
	}
	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}
	public int getB_ref() {
		return b_ref;
	}
	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getB_level() {
		return b_level;
	}
	public void setB_level(int b_level) {
		this.b_level = b_level;
	}
	private int b_step;
	private int b_hit;
	public String getB_attach() {
		return b_attach;
	}
	public void setB_attach(String b_attach) {
		this.b_attach = b_attach;
	}
	private int b_level;
	private String b_attach;
}
