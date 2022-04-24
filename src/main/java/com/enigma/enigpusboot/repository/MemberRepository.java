package com.enigma.enigpusboot.repository;

import com.enigma.enigpusboot.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    Page<Member> findAll(Specification<Member> memberSpecification, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update mst_member set isblock = true where member_id = ?1", nativeQuery = true)
    void blockMemberById(String id);
    @Transactional
    @Modifying
    @Query(value = "update mst_member set isblock = false where member_id = ?1", nativeQuery = true)
    void unblockMemberById(String id);
    Member findByUserName(String userName);
    @Query(value = "select * from mst_member where member_id = ?1", nativeQuery = true)
    Member searchMemberById(@Param("member_id") String id);
    @Transactional
    @Modifying
    @Query(value = "delete from mst_member where member_id = ?1", nativeQuery = true)
    void deleteMemberById(@Param("member_id") String id);
}
