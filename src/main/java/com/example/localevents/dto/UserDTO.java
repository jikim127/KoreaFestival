package com.example.localevents.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {

    private Long idNo;
    private String email;
    private String password;

}
