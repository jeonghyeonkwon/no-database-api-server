package com.jeonghyeon.nodatabaseapi.dto;

import lombok.Data;

@Data
public class BoardEntity {
    private Long id;
    private String uuid;
    private String title;
    private String content;


    public BoardEntity(Long id, String uuid, String title, String content) {
        this.id = id;
        this.uuid = uuid;
        this.title = title;
        this.content = content;
    }
}
