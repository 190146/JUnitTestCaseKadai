package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest{
	static Calc calc = null;
	
	@BeforeAll
	static void テスト前処理() {
	    calc = new Calc();
	}
	@Test
	void addテスト_正常() {
	    assertEquals(calc.add(1, 3), 4);
	    assertThat(calc.add(1, 3)).isEqualTo(4);
	}
	@Test
	void subTest() {
		assertEquals(calc.sub(12, 3), 9);
	    assertThat(calc.sub(12, 3)).isEqualTo(9);
	}
	@Test
	void multTest() {
		assertEquals(calc.mul(5, 3), 15);
	    assertThat(calc.mul(5, 3)).isEqualTo(15);
	}
	@Test
	void divTest() {
		assertEquals(calc.div(16, 4), 4);
	    assertThat(calc.div(16, 4)).isEqualTo(4);
	}
	
	@Test
	// 課題2: ゼロ除算時の扱いテスト
	void divZeroTest() {
		// when
		Throwable thrown = catchThrowable(() -> {
		    calc.div(13, 0);
		});
		// then
		assertThat(thrown)
		.isInstanceOf(ArithmeticException.class)
		.hasMessageContaining("/ by zero");
	}
	@AfterAll
	static void テスト後処理() {
	    calc = null;
	}


}