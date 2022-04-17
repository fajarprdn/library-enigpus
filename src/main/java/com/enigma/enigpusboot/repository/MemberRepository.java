package com.enigma.enigpusboot.repository;

import com.enigma.enigpusboot.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    Page<Member> findAll(Specification<Member> memberSpecification, Pageable pageable);
    Member findByUserName(String userName);
}
