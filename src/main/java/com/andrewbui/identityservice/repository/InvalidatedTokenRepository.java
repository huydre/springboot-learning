package com.andrewbui.identityservice.repository;

import com.andrewbui.identityservice.entity.InvalidateToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidateToken, String> {

}
