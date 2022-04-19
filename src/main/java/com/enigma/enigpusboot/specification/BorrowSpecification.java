package com.enigma.enigpusboot.specification;

import com.enigma.enigpusboot.dto.BorrowSearchDTO;
import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Borrow;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BorrowSpecification {
    public static Specification getBorrowSpecification(BorrowSearchDTO borrowSearchDTO, MemberSearchDTO memberSearchDTO){
        return new Specification<Borrow>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!(borrowSearchDTO.getSearchBorrowById()==null)){
                    Predicate borrowSearchPredicate = criteriaBuilder.like(root.get("id"),"%"+borrowSearchDTO.getSearchBorrowById().toLowerCase()+"%");
                    predicates.add(borrowSearchPredicate);
                }

                if(!(memberSearchDTO.getSearchMemberUserName()==null)){
                    Predicate userNameBorrowSearchPredicate = criteriaBuilder.like(root.get("userName"),"%"+memberSearchDTO.getSearchMemberUserName()+"%");
                    predicates.add(userNameBorrowSearchPredicate);
                }
//                if(!(borrowSearchDTO.getSearchBorrowByStatus()=="INACTIVE"){
//                    Predicate borrowStatusPredicate = criteriaBuilder.like(root.get("status"),"%"+)
//                }
                Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
