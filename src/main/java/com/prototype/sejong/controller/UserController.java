package com.prototype.sejong.controller;

import com.prototype.sejong.domain.dto.UserRequestDto;
import com.prototype.sejong.domain.dto.UserResponseDto;
import com.prototype.sejong.model.response.CommonResult;
import com.prototype.sejong.model.response.ListResult;
import com.prototype.sejong.model.response.ResponseMethod;
import com.prototype.sejong.model.response.SingleResult;
import com.prototype.sejong.service.UserService;
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
    private final UserService userService;
    private final ResponseMethod responseMethod;

    @ApiOperation(value = "회원 단건 검색", notes = "userId로 회원을 조회합니다.")
    @GetMapping("/user/id/{userId}")
    public SingleResult<UserResponseDto> findUserById(@ApiParam(value = "회원 ID", required = true) @PathVariable Long userId,
                                                      @ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        return responseMethod.getSingleResult(userService.findById(userId));
    }

    @ApiOperation(value = "회원 검색 (이름)", notes = "이름으로 회원을 검색합니다.")
    @GetMapping("/user/name/{name}")
    public ListResult<UserResponseDto> findUserByName(@ApiParam(value = "회원 이름", required = true) @PathVariable String name,
                                                      @ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        List<UserResponseDto> user = userService.findByName(name);

        return responseMethod.getListResult(user);
    }

    @ApiOperation(value = "회원 검색 (이메일)", notes = "이메일로 회원을 검색합니다.")
    @GetMapping("/user/email/{email}")
    public SingleResult<UserResponseDto> findUserByEmail(@ApiParam(value = "회원 이메일", required = true) @PathVariable String email,
                                                         @ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        UserResponseDto userResponseDto = userService.findByEmail(email);

        return responseMethod.getSingleResult(userResponseDto);
    }

    @ApiOperation(value = "회원 목록 조회", notes = "모든 회원을 조회합니다.")
    @GetMapping("/users")
    public ListResult<UserResponseDto> findAllUser() {
        return responseMethod.getListResult(userService.findAllUser());
    }

    @ApiOperation(value = "회원 등록", notes = "회원을 등록합니다.")
    @PostMapping("/user")
    public SingleResult<Long> save(@ApiParam(value = "회원 이메일", required = true) @RequestParam String email,
                                    @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .email(email)
                .name(name)
                .build();

        return responseMethod.getSingleResult(userService.save(userRequestDto));
    }

    @ApiOperation(value = "회원 수정", notes = "회원 정보를 수정합니다.")
    @PutMapping("/user")
    public SingleResult<Long> update(@ApiParam(value = "회원 ID", required = true) @RequestParam Long userId,
                                     @ApiParam(value = "회원 이메일", required = true) @RequestParam String email,
                                     @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .email(email)
                .name(name)
                .build();

        return responseMethod.getSingleResult(userService.update(userId, userRequestDto));
    }

    @ApiOperation(value = "회원 삭제", notes = "회원을 삭제합니다.")
    @DeleteMapping("/user/{userId}")
    public CommonResult delete(@ApiParam(value = "회원 ID", required = true) @PathVariable Long userId) {
        userService.delete(userId);
        return responseMethod.getSuccessResult();
    }
}
