package ra.service;

import ra.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IGenericService<Customer,Integer>{
    private List<Customer> customers ;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        if(findById(customer.getId())==null){
            // them moi
            customers.add(customer);
        }else{
            // sua
            customers.set(customers.indexOf(findById(customer.getId())), customer);
        }
    }

    @Override
    public Customer findById(Integer integer) {
        for (Customer c:customers) {
            if(c.getId()==(integer)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        customers.remove(findById(integer));
    }
    public int getNewId() {
        int max =0;
        for (Customer c: customers) {
            if(c.getId()>=max) {
                max = c.getId();
            }
        }
        return max+1;
    }

}
