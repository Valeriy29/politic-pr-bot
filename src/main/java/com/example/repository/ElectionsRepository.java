package com.example.repository;

import com.example.entity.ElectionsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionsRepository extends CrudRepository<ElectionsEntity, Long> {

    @Query("SELECT e FROM ElectionsEntity e WHERE e.year LIKE :year AND lower(e.region) LIKE lower(concat('%', :keyword, '%')) OR lower(e.city) LIKE lower(concat('%', :keyword, '%'))" +
            " OR lower(e.alternative_name) LIKE lower(concat('%', :keyword, '%'))")
    List<ElectionsEntity> findElectionsEntityByKeyword(@Param("keyword") String regionKeyword, @Param("year") String year);

}
