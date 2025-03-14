package com.jfloresdev.apibibliotecav1.repository;

import com.jfloresdev.apibibliotecav1.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface LibroRepository extends JpaRepository<LibroEntity, Long> {



    //select * from libro where upper(titulo) like upper('%java');

    @Query("SELECT l FROM LibroEntity l" +
            " WHERE UPPER(l.titulo)" +
            " LIKE UPPER(CONCAT('%', :titulo, '%')) " +
            "AND l.estado = '1'" + "ORDER BY l.id ASC"
    )
    List<LibroEntity> findByName(@Param("titulo") String titulo);


    @Transactional
    @Modifying
    @Query(value = "update libro set estado = '0' where id = :id", nativeQuery = true)
    void udpateEstadoById(@Param("id") Long id);
}
