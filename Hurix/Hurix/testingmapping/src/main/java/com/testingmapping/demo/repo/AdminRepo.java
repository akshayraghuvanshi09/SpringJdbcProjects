package com.testingmapping.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testingmapping.demo.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{

}
