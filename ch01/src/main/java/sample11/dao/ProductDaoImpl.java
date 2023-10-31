package sample11.dao;

import sample11.model.Product;

public class ProductDaoImpl implements ProductDao {
	// 자식클래스인 Service 클래스에게 name값 라면을 받아서 DTO에 2000과 함께 저장
	public Product getProduct(String name) {
		return new Product(name, 2000);
	}
}