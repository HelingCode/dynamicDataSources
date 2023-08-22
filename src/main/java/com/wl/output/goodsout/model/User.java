package com.wl.output.goodsout.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private Integer age;
    private String address;
}
