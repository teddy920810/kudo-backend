package com.kudo.repository;

import com.kudo.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, String> {

}

