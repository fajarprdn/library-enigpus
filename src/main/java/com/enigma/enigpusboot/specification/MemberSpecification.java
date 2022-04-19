package com.enigma.enigpusboot.specification;

import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberSpecification {
    public static Specification getMemberSpecification(MemberSearchDTO memberSearchDTO){
        return new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(!(memberSearchDTO.getSearchMemberFirstName()==null)){
                    Predicate memberFirstNamePredicate = criteriaBuilder.like(root.get("firstName"),"%"+memberSearchDTO.getSearchMemberFirstName().toLowerCase()+"%");
                    predicates.add(memberFirstNamePredicate);
                }

                if(!(memberSearchDTO.getSearchMemberLastName()==null)){
                    Predicate memberLastNamePredicate = criteriaBuilder.like(root.get("lastName"),"%"+memberSearchDTO.getSearchMemberLastName()+"%");
                    predicates.add(memberLastNamePredicate);

                }

                if(!(memberSearchDTO.getSearchMemberUserName()==null)){
                    Predicate memberUserNamePredicate = criteriaBuilder.like(root.get("userName"),"%"+memberSearchDTO.getSearchMemberUserName()+"%");
                    predicates.add(memberUserNamePredicate);

                }
                Predicate [] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
