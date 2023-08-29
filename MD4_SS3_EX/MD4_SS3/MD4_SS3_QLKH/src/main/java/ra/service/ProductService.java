package ra.service;

import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product,Integer>{
    List<Product> products ;

    public ProductService() {
       products =new ArrayList<>();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId())==null){
            products.add(product);
        }else{
            products.set(products.indexOf(findById(product.getId())),product);
        }
    }

    @Override
    public Product findById(Integer integer) {
        for (Product p:products) {
            if (p.getId()==integer){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        products.remove(findById(integer));
    }

    public int newId() {
        int max=0;
        for (Product p:products){
            if (p.getId()>max){
                max=p.getId();
            }
        }
        return max+1;
    }
}
