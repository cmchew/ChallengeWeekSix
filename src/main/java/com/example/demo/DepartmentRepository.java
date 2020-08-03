package com.example.demo;

import org.springframework.data.repository.CrudRepository;


import java.util.Iterator;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}