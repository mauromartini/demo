package br.com.base.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.base.demo.model.AjaxResponseBody;
import br.com.base.demo.model.Customer;
import br.com.base.demo.model.SearchCriteria;
import br.com.base.demo.services.CustomerService;

@RestController
public class SearchController {

  CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/api/search")
  public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

    AjaxResponseBody result = new AjaxResponseBody();

    // If error, just return a 400 bad request, along with the error message
    if (errors.hasErrors()) {

      result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
      return ResponseEntity.badRequest().body(result);

    }

    List<Customer> users = customerService.findByUserNameOrEmail(search.getUsername());
    if (users.isEmpty()) {
      result.setMsg("no user found!");
    } else {
      result.setMsg("success");
    }
    result.setResult(users);

    return ResponseEntity.ok(result);

  }

}
