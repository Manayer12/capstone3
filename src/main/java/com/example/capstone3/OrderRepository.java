package com.example.capstone3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    Orders findOrderById(Integer id);
    Orders findOrdersByUserId(Integer user_id);
}
