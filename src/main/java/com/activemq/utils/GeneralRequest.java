package com.activemq.utils;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GeneralRequest<T> {
    public String token;
    public T payload;
}
