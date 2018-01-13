package com.medo.shopsv1.repositories;


import com.medo.shopsv1.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository  extends MongoRepository<Shop, String>{
}
