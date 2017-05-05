package br.com.base.demo.dao;


import java.util.List;

import br.com.base.demo.model.User;

public interface UserDao {

  User findByName(String name);

  List<User> findAll();

}