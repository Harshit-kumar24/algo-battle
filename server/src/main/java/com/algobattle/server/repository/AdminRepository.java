package com.algobattle.server.repository;

import com.algobattle.server.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository <Admin, UUID> {
}
