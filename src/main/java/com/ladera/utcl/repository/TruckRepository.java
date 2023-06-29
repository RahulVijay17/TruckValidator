package com.ladera.utcl.repository;

import com.ladera.utcl.model.TruckModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<TruckModel,Long> {
}
