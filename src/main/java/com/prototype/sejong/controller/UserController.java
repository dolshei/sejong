package com.prototype.sejong.controller;

import com.prototype.sejong.entity.User;
import com.prototype.sejong.global.error.UserNotFoundException;
import com.prototype.sejong.model.response.CommonResult;
import com.prototype.sejong.model.response.ListResult;
import com.prototype.sejong.model.response.SingleResult;
import com.prototype.sejong.repository.UserJpaRepository;
import com.prototype.sejong.model.response.ResponseMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1, User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class UserController {
    private final UserJpaRepository userJpaRepository;
    private final ResponseMethod responseMethod;

    @ApiOperation(value = "회원 단건 검색", notes = "userId로 회원을 조회합니다.")
    @GetMapping("/user/id/{userId}")
    public SingleResult<User> findUserByKey(@ApiParam(value = "회원 ID", required = true) @PathVariable Long userId) {
        return responseMethod.getSingleResult(userJpaRepository.findById(userId).orElseThrow(UserNotFoundException::new));
    }

    @ApiOperation(value = "회원 검색 (이름)", notes = "이름으로 회원을 검색합니다.")
    @GetMapping("/user/name/{name}")
    public ListResult<User> findUserByName(@ApiParam(value = "회원 이름", required = true) @PathVariable String name) {
        List<User> user = userJpaRepository.findByName(name);
        if (user.isEmpty()) throw new UserNotFoundException();
        return responseMethod.getListResult(user);
    }

    @ApiOperation(value = "회원 검색 (이메일)", notes = "이메일로 회원을 검색합니다.")
    @GetMapping("/user/email/{email}")
    public SingleResult<User> findUserByEmail(@ApiParam(value = "회원 이메일", required = true) @PathVariable String email) {
        User user = userJpaRepository.findByEmail(email);
        if (user.getEmail().isEmpty()) throw new UserNotFoundException();
        return responseMethod.getSingleResult(user);
    }

    @ApiOperation(value = "회원 목록 조회", notes = "모든 회원을 조회합니다.")
    @GetMapping("/users")
    public ListResult<User> findAllUser() {
        return responseMethod.getListResult(userJpaRepository.findAll());
    }

    @ApiOperation(value = "회원 등록", notes = "회원을 등록합니다.")
    @PostMapping("/user")
    public SingleResult<User> save(@ApiParam(value = "회원 이메일", required = true) @RequestParam String email,
                                    @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {

        User user = User.builder()
                .email(email)
                .name(name)
                .build();

        return responseMethod.getSingleResult(userJpaRepository.save(user));
    }

    @ApiOperation(value = "회원 수정", notes = "회원 정보를 수정합니다.")
    @PutMapping("/user")
    public SingleResult<User> modify(@ApiParam(value = "회원 아이디", required = true) @RequestParam Long userId,
                                     @ApiParam(value = "회원 이메일", required = true) @RequestParam String email,
                                     @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .build();

        return responseMethod.getSingleResult(userJpaRepository.save(user));
    }

    @ApiOperation(value = "회원 삭제", notes = "회원을 삭제합니다.")
    @DeleteMapping("/user/{userId}")
    public CommonResult delete(@ApiParam(value = "회원 아이디", required = true) @PathVariable Long userId) {
        userJpaRepository.deleteById(userId);
        return responseMethod.getSuccessResult();
    }
}
