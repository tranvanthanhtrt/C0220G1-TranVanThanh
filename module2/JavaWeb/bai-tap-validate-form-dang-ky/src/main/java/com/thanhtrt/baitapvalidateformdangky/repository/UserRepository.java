package com.thanhtrt.baitapvalidateformdangky.repository;

import com.thanhtrt.baitapvalidateformdangky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
