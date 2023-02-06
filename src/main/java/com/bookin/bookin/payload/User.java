package com.bookin.bookin.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    @Override
    public String toString(){
        return "User{"+
                "id="+ id +
                ",name='" + name +'\''+
                '}';
    }
}
