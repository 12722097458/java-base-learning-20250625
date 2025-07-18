package com.ityj.springmvc.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class User {
    private String username;
    private List<String> hobby;
}
