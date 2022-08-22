package com.jeonghyeon.nodatabaseapi.controller;

import com.jeonghyeon.nodatabaseapi.dto.BoardRequest;
import com.jeonghyeon.nodatabaseapi.dto.LoginRequest;
import com.jeonghyeon.nodatabaseapi.dto.RegisterRequest;
import com.jeonghyeon.nodatabaseapi.service.CommonService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommonController {
    private final CommonService commonService;
    private static final String AUTHORIZATION = "Authorization";
    @PostMapping("/user/register")
    public ResponseEntity register(@RequestBody RegisterRequest dto){

        return commonService.register(dto);
    }
    @PostMapping("/user/login")
    public ResponseEntity login (@RequestBody LoginRequest dto){
        return commonService.login(dto);
    }
    @GetMapping("/user")
    public ResponseEntity userList(){
        return commonService.userList();
    }

    @GetMapping("/board")
    public ResponseEntity boardList(){

        return commonService.bordList();
    }
    @PostMapping("/board")
    public ResponseEntity writeBoard(@RequestHeader(AUTHORIZATION) String header, @RequestBody BoardRequest dto){

        return commonService.writeBoard(header,dto);
    }
}
