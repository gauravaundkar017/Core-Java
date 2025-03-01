package tester;

import static utils.ShopUtils.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class TestShop {

	public static void main(String[] args) {
		System.out.println("Products in the shop : using List");
		List<Product> productList = populateProductList();
		Category cat = Category.BISCUITS;
//		productList.removeIf(p -> p.getProductCategory() == cat);

		// display the products from the Map
//		Map<Integer, Product> productMap = populateProductMap(productList);
		// Objective : Display product id n product name n price from the product map
		// (using functional prog )

//		System.out.println("Products in the shop : using Map");
//		productMap
//				.forEach((k, v) -> System.out.println("PID " + k + " Name " + v.getName() + " Price " + v.getPrice()));

		Map<Integer, Product> mapList = populateProductMap(productList);
		mapList.forEach((i, p) -> System.out.println(p));
		System.out.println("");
//		mapList.values().removeIf(p -> p.getProductCategory() == cat);
		Comparator<Product> compPro = (p1, p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate());
		Collections.sort(productList, compPro);
		productList.forEach(p -> System.out.println(p));

	}

}
