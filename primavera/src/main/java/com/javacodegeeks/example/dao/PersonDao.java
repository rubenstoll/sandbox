package com.javacodegeeks.example.dao;

import com.javacodegeeks.example.model.Person;

public interface PersonDao {

  public Person findById(Long id);

  public void create(Person person);

  public void update(Person person);

  public void delete(Long id);
}
