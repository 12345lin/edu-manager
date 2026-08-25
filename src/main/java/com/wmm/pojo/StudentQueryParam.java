package com.wmm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentQueryParam {
    private Integer page = 1;
    private Integer pageSize = 5;
    private String name;
    private Integer degree;
    private Integer clazzId;
}
//sk-1b21eed3cefd4f053b8d1f759d8768e5ce8f8b366908975908077e80e4187b04