package com.example.validation.controller;

import com.example.validation.model.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import com.example.validation.model.UserRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserApiController {


    @PostMapping("")
    public Api<UserRegisterRequest> register(@Valid @RequestBody Api<UserRegisterRequest> userRegisterRequest) {

        log.info("init! : {}", userRegisterRequest);
        UserRegisterRequest data = userRegisterRequest.getData();

        return Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(data)
                .build();
    }


}
