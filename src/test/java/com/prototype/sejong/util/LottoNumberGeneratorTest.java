package com.prototype.sejong.util;

import com.prototype.sejong.global.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("로또 번호 생성 테스트")
class LottoNumberGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given(준비) : 어떠한 데이터가 준비 되었을 때
        final int price = 1000;

        // when(실행) : 어떠한 함수를 실행하면
        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then(검증) : 어떠한 결과가 나와야 한다.
        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void lottoNumberRangeTest() {
        // given(준비) : 어떠한 데이터가 준비 되었을 때
        final int price = 1000;

        // when(실행) : 어떠한 함수를 실행하면
        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then(검증) : 어떠한 결과가 나와야 한다.
        assertThat(lottoNumber.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
    }

    @Test
    @DisplayName("잘못된 로또 금액 테스트")
    void lottoNumberInvalidMoneyTest() {
        // given(준비) : 어떠한 데이터가 준비 되었을 때
        final int price = 2000;

        // when(실행) : 어떠한 함수를 실행하면
        final RuntimeException exception = assertThrows(RuntimeException.class, () -> lottoNumberGenerator.generate(price));

        // then(검증) : 어떠한 결과가 나와야 한다.
        assertThat(exception.getMessage()).isEqualTo("올바른 금액이 아닙니다.");
    }
}