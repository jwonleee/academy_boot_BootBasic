package com.example.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidVO {
	
	/*
	 * @NotNull - null값만 허용하지 않음, 공백으로 주면 에러 안남 (wrapper의Integer, Long, String 등)
	 * @NotBlank - null값과 공백 허용하지 않음 (String에만 적용)
	 * @NotEmpty - null값을 허용하지 않음 (Array, list 적용)
	 * @Pattern - 정규표현식에 맞는 문자열을 정의할 수 있음 (String에만 적용)
	 * 
	 * @Email - 이메일 형식 검증 (공백은 통과)
	 * @Min - 최소값
	 * @Max - 최대값
	 */
	
	@NotBlank(message = "이름은 필수 입니다")
	private String name;
	
	//숫자, 실수형의 원시타입은 기본값이 0이라서 공백 맵핑이 불가능하기 때문에 래퍼타입으로 선언하는 편이 좋습니다.
	@NotNull(message = "급여는 필수 입니다")
	private Integer salary; //int는 null을 가질 수 없음
	//원시타입으로 하면 기본값 0, wrapper타입으로 하면 기본값 null
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000 입니다")
	private String phone;
	
	@NotBlank //동시에 적용
	@Email(message = "email 형식이어야 합니다") //email 형식 이어야 함, 단 공백은 통과
	private String email;

}
