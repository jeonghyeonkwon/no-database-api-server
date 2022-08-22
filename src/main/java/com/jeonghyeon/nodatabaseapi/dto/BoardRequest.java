package com.jeonghyeon.nodatabaseapi.dto;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    private String content;
}
