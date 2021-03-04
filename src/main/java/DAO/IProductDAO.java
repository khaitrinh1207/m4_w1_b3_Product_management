package DAO;

import model.Product;

import java.util.List;

public interface IProductDAO<T> {

    List<T> findAll();
    Product findById(int id);
    void save(Product product);
    List<Product> search(String name);
    void delete(int id);
    void update(int id , Product product);
}
