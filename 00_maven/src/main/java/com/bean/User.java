package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Data -> Getter, Setter, ToString 等複合註解
 * NoArgsConstructor -> 無參數建構式
 * AllArgsConstructor -> 所有欄位建構式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

	// Equals 比較是否相等，排除 id
	@EqualsAndHashCode.Exclude
	private Long id;

	private String name;

}
