package quanlysanpham.service;

import quanlysanpham.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void update(int id,Product product);
    Product findById(int id);
    Product findByName(String name);
    void remove(int id);

}
