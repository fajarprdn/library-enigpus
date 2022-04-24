package com.enigma.enigpusboot.repository;

import com.enigma.enigpusboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    Page<Book> findAll(Specification<Book> bookSpecification, Pageable pageable);
    @Query(value = "select * from mst_book where book_id = ?1", nativeQuery = true)
    Book searchBookById(@Param("book_id") String id);

}
