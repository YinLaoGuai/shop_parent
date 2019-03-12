package com.czxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 音老怪 on 2019/2/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="user")
public class User {
    @Id
    private Integer id;
    private String name;
    private String Fname;
    private String Email;
    private String tel;
    private Integer password;
    private Integer password2;



}
