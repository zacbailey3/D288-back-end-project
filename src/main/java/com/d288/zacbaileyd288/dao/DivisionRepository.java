package com.d288.zacbaileyd288.dao;

import com.d288.zacbaileyd288.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "divisions", path = "divisions")
@CrossOrigin("http://localhost:4200/")
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
