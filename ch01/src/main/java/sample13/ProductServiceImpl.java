package sample13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
// @Component : 컴포넌트 스캔을 통해 빈으로 등록할 클래스를 표시하는데 사용
public class ProductServiceImpl implements ProductService {
	@Autowired
	// setter메소드로 DAO를 주입하지 않고 자동으로 @Autowired어노테이션을 통해서 주입한다.
	private ProductDao pd;

	public Product getProduct() {
		return pd.getProduct("짜장면");
	}
}