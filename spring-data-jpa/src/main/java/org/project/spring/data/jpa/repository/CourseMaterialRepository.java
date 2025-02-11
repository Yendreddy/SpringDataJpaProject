package org.project.spring.data.jpa.repository;

import org.project.spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, UUID> {
}
