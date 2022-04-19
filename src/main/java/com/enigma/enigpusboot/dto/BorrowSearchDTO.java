package com.enigma.enigpusboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowSearchDTO {
    private String searchBorrowById;
    private String searchBorrowByStatus;
    private String searchBorrowByUserName;
//    private String searchBorrowByUserName;
}
