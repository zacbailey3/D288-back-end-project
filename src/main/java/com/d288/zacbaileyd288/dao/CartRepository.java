package com.d288.zacbaileyd288.dao;

import com.d288.zacbaileyd288.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
@CrossOrigin("http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Long> {
}
