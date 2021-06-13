package com.activemq.utils;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest implements Serializable {
    private static final long serialVersionUID =1L;
    public String username;
    public String password;
}
