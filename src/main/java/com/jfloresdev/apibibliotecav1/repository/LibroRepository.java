package com.jfloresdev.apibibliotecav1.repository;

import com.jfloresdev.apibibliotecav1.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
}
