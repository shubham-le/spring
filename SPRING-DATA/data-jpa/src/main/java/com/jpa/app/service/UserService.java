package com.jpa.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.app.entity.UserMaster;

import jakarta.transaction.Transactional;

@Repository @Transactional
public interface UserService extends JpaRepository<UserMaster, Integer> {

}
