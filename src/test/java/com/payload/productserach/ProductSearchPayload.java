package com.payload.productserach;

import com.pojo.product.SearchProductInput;
/**
 * @Description payLoad for search product endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class ProductSearchPayload {

	public SearchProductInput searchProduct(String text) {
		SearchProductInput searchProductInput = new SearchProductInput(text);
		return searchProductInput;

	}

}
