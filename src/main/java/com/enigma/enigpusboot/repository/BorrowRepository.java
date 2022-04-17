package com.enigma.enigpusboot.repository;

import com.enigma.enigpusboot.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,String> {
    Borrow findBorrowByMemberId(String id);
//    Borrow findBorrowByStatus(@Param(String status));

}
