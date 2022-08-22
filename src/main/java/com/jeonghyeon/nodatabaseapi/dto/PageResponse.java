package com.jeonghyeon.nodatabaseapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse <T> {

    private int currentPage;
    private int totalPage;
    private int totalElement;
    private T dataList;

    public PageResponse(List<BoardEntity> dto,int page, int size){
        this.totalPage = (dto.size()) / size;
        this.currentPage = page;

    }
}
