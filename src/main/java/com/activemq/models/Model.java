package com.activemq.models;


import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Model implements Serializable {
    private static final long serialVersionUID =-295422703255886286L;
    private String value1;
    private String value2;
}
