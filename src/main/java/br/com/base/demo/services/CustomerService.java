package br.com.base.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.base.demo.model.Customer;

@Service
public class CustomerService {

  private List<Customer> customers;

    // Love Java 8
  public List<Customer> findByUserNameOrEmail(String username) {

    List<Customer> result = customers.stream().filter(x -> x.getUsername().equalsIgnoreCase(username))
        .collect(Collectors.toList());

        return result;

    }
  /*
   * public List<Customer> findByUserNameOrEmail(String username, String email)
   * {
   * 
   * List<Customer> result = new ArrayList<Customer>();
   * 
   * for (Customer Customer : users) {
   * 
   * if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {
   * 
   * if (username.equals(Customer.getUsername()) &&
   * email.equals(Customer.getEmail())) { result.add(Customer); continue; } else
   * { continue; }
   * 
   * } if (!StringUtils.isEmpty(username)) { if
   * (username.equals(Customer.getUsername())) { result.add(Customer); continue;
   * } }
   * 
   * if (!StringUtils.isEmpty(email)) { if (email.equals(Customer.getEmail())) {
   * result.add(Customer); continue; } }
   * 
   * }
   * 
   * return result;
   * 
   * }
   */

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

    customers = new ArrayList<Customer>();

    Customer user1 = new Customer(1, "mkyong", "password111", "mkyong@yahoo.com");
    Customer user2 = new Customer(2, "yflow", "password222", "yflow@yahoo.com");
    Customer user3 = new Customer(3, "laplap", "password333", "mkyong@yahoo.com");

    customers.add(user1);
    customers.add(user2);
    customers.add(user3);

    }

}
