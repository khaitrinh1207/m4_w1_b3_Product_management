package DAO;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"laptop",1000,"new 100%"));
        products.add(new Product(2,"table",25,"mới 100%"));
        products.add(new Product(3,"mobile",300,"new 100%"));
        products.add(new Product(4,"tivi",350,"new 100%"));
        products.add(new Product(5,"microway",500,"new 100%"));
        products.add(new Product(6,"bag",10,"new 100%"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ProductDAO().products;
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if(id == products.get(i).getId()){
                product = products.get(i);
            }
        }
        return product;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> listSearch= new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if(name.equalsIgnoreCase(products.get(i).getName())){
                listSearch.add(products.get(i));
            }
        }
        return listSearch;
    }


    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if(id == products.get(i).getId()){
                products.set(i,product);
            }
        }
    }
}
