package com.wmm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzsQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private String room;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_date;
    private Integer status;
}
