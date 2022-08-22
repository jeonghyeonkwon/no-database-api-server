package com.jeonghyeon.nodatabaseapi.service;

import com.jeonghyeon.nodatabaseapi.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CommonService {
    private static final String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnaXZlamVvbmciLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY2MDg4MjIyNn0.rM7CmQvyCD4lttjmNDbiQU2hhFZDEghI2tTPFJ_dq0FU7Owt6e0ALnmNT2e7EKEWhIjcWRG_Vbf44I_YSAnohw";
    private static List<UserEntity> userList = new ArrayList<>();
    private List<BoardEntity> boardList = new ArrayList();
    public ResponseEntity register(RegisterRequest dto) {
        System.out.println(dto);
        Optional<UserEntity> first = userList.stream().filter(obj -> obj.getUsername().equals(dto.getUsername())).findFirst();


        if(first.isPresent()){
            UserEntity userEntity1 = first.get();
            System.out.println(userEntity1);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


        UserEntity userEntity = new UserEntity((long)userList.size()+1,UUID.randomUUID().toString(),dto.getUsername(), dto.getPassword());

        userList.add(userEntity);
        System.out.println(userList);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    public ResponseEntity login(LoginRequest dto) {
        System.out.println(dto);
        Optional<UserEntity> first = userList.stream().filter(obj -> obj.getUsername().equals(dto.getUsername()) ).findFirst();

        if(first.isEmpty()) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        UserEntity userEntity = first.get();
        if(userEntity.getPassword().equals(dto.getPassword())){

            return new ResponseEntity(token,HttpStatus.OK);
        }
        else{

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity writeBoard(String header, BoardRequest dto) {
        if(!header.equals(token)) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        BoardEntity boardEntity = new BoardEntity((long) boardList.size()+1, UUID.randomUUID().toString(),dto.getTitle(),dto.getContent());
        boardList.add(boardEntity);
        return new ResponseEntity(HttpStatus.OK);
    }


    public ResponseEntity userList() {
        System.out.println(userList);
        return new ResponseEntity(userList,HttpStatus.OK);
    }

    public ResponseEntity bordList() {
        return new ResponseEntity(boardList,HttpStatus.OK);
    }
}
