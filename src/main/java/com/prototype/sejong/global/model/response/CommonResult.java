package com.prototype.sejong.global.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "응답 성공 여부 : True/False")
    private boolean success;

    @ApiModelProperty(value = "응답 코드: >= 0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;
}
