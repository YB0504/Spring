package sample11.service;

import sample11.dao.ProductDao;
import sample11.model.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd;

	// Products pd = new ProductsDaoImpl();
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	// 부모 클래스인 DAO객체에게 name값인 라면 전달
	public Product getProduct() {
		return pd.getProduct("라면");
	}
}