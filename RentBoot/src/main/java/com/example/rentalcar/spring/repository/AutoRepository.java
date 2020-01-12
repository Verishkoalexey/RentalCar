package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

	Page<Auto> findByMarkContainingIgnoreCaseOrModelContainingIgnoreCaseOrderByMark(String mark, String model, Pageable pageable);
	
	@Query("select new com.example.rentalcar.domain.Auto(a.id, a.mark, a.model, a.engine, a.volume, a.transmission, a.bodyType, a.driveType, a.image) from Auto a")
	Page<Auto> findAllWithoutContent(Pageable pageable);
	
    @Modifying(clearAutomatically = true)
    @Query("update Auto a set a.image=:image where a.id =:id")
    void updateImage(@Param("image") byte[] image, @Param("id") int id);
    
    @Query("select new com.example.rentalcar.domain.Auto(a.id, a.image) from Auto a")
    List<Auto> findTopAutos(Pageable pageable);
    
    @Query("select new com.example.rentalcar.domain.Auto(a.id, a.mark, a.model, a.engine, a.volume, a.transmission, a.bodyType, a.driveType, a.image) from Auto a where a.bodyType.id=:bodyTypeId")
    Page<Auto> findByBodyType(@Param("bodyTypeId") int bodyTypeId, Pageable pageable);

}
