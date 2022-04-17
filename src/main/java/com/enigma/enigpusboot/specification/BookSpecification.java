package com.enigma.enigpusboot.specification;

import com.enigma.enigpusboot.dto.BookSearchDTO;
import com.enigma.enigpusboot.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification {
    public static Specification getBookSpecification(BookSearchDTO bookSearchDTO){
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!(bookSearchDTO.getSearchBookByTitle() == null)){
                    Predicate bookTitlePredicate = criteriaBuilder.like(root.get("title"),"%"+bookSearchDTO.getSearchBookByTitle().toLowerCase()+"%");
                    predicates.add(bookTitlePredicate);
                }
                if(!(bookSearchDTO.getSearchBookByPublisher() == null)){
                    Predicate bookTitlePredicate = criteriaBuilder.like(root.get("publisher"),"%"+bookSearchDTO.getSearchBookByPublisher().toLowerCase()+"%");
                    predicates.add(bookTitlePredicate);
                }
                if(!(bookSearchDTO.getSearchBookByAuthor() == null)){
                    Predicate bookTitlePredicate = criteriaBuilder.like(root.get("author"),"%"+bookSearchDTO.getSearchBookByAuthor().toLowerCase()+"%");
                    predicates.add(bookTitlePredicate);
                }


                Predicate [] arrayPredicateBookTitle = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicateBookTitle);
            }
        };
    }
}
