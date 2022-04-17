package com.enigma.enigpusboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSearchDTO {
    private String searchMemberFirstName;
    private String searchMemberLastName;
    private String searchMemberUserName;

}
