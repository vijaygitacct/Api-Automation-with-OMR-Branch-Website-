package com.pojo.product;
/**
 * @description request body  for serachProduct endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class SearchProductInput {
	private String text;

	public SearchProductInput(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
