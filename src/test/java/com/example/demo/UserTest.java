package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
	// 初期値として1を入れてインスタンス化していく
	User user = new User("1");
	//　正常系ユーザ管理コード登録参照
	@Test
	@DisplayName("ユーザ管理コードテスト")
	void TestA() {
		user.setCode("2");
		String expected = "2";
		String actual = user.getCode();
		assertEquals(expected, actual);
	}
	// 正常系名前登録参照
	@Test
	@DisplayName("名前テスト")
	void TestB() {
		user.setName("Tarou");
		String expected = "Tarou";
		String actual = user.getName();
		assertEquals(expected, actual);
	}
	// 正常系年齢登録参照
	@Test
	@DisplayName("年齢テスト")
	void TestC() {
		user.setAge(23);
		int expected = 23;
		int actual = user.getAge();
		assertEquals(expected, actual);
	}
	//　異常系範囲外年齢登録
	@Test
	@DisplayName("範囲外年齢テスト")
	void TestD() {
		user.setAge(300);
		int expected = -1;
		int actual = user.getAge();
		assertEquals(expected, actual);
	}
	//　異常系範囲外年齢登録2
	@Test
	@DisplayName("範囲外年齢2テスト")
	void TestE() {
		// user.ageの書き換えができない。
		user.setAge(12);
		user.setAge(300);
		int expected = -1;
		int actual = user.getAge();
		assertEquals(expected, actual);
	}
}
