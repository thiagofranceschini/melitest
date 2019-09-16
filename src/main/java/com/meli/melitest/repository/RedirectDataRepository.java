package com.meli.melitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.melitest.domain.RedirectData;

public interface RedirectDataRepository extends JpaRepository<RedirectData, Long> {

}
