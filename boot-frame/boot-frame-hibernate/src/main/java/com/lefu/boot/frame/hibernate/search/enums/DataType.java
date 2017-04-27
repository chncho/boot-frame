package com.frame..boot.frame.hibernate.search.enums;


/**
 * 数据类别
 * @author duancq
 * 2016年4月24日 下午2:15:33
 */
public enum DataType {

	INTEGER("INTEGER", "整形"),
	LONG("LONG", "长整形"),
	FLOAT("FLOAT", "单精度浮点型"),
	DOUBLE("DOUBLE", "双精度浮点型"),
	STRING("STRING", "字符串"),
	DATE("DATE", "日期");

	private String name;
	private String text;
	private DataType(String name, String text) {
		this.name = name;
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}