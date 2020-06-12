package quanlysanpham.service;
import org.springframework.stereotype.Service;
import quanlysanpham.model.Product;
import quanlysanpham.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceIplm implements ProductService {

    private static Map<Integer, Product> products;

    static {

        products = new HashMap<Integer, Product>();
        products.put(1, new Product(1, "Iphone7", 15000000, "Điện thoại tán gái", "Apple"));
        products.put(2, new Product(2, "Sam Sung G7", 12000000, "Điện thoại này xài ổn", "Sam Sung"));
        products.put(3, new Product(3, "Oppo O4", 10000000, "Sản phẩm mới chưa ra mắt", "Oppo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());

    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
