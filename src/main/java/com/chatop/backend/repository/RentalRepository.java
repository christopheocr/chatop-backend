package com.chatop.backend.repository;


import com.chatop.backend.entity.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends CrudRepository<Rental,Integer> {
}
