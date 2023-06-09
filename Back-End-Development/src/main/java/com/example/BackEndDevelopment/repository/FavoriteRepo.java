package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepo extends CrudRepository<Favorite,Integer> {
    Favorite findById(int id);
}
