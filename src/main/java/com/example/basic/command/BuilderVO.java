package com.example.basic.command;

public class BuilderVO {
	//빌더 패턴의 모형 - 내부 클래스를 생성하고, 외부에서 호출시에 내부클래스 값을 지정
	//장점 - 객체의 불변성(값의 변경을 막고, 사용시 가독성이 좋다)

	//1.멤버변수
	private String name;
	private int age;

	//4. VO의 생성자
	private BuilderVO(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}

	//7.외부에서 객체 생성을 요구하면 내부에 있는 Builder클래스를 반환
	public static Builder builder() {
		return new Builder() {};
	}

	//8. toString 오버라이딩
	@Override
	   public String toString() {
	      return "Builder [name=" + name + ", age=" + age + "]";
	   }

	//2.내부클래스 생성 - 클래스 안에 클래스
	public static class Builder { //static으로 해서 외부에서 바로 접근 가능

		private String name;
		private int age;

		//3. 생성자 제한 - 생성자로 막으면 외부에서 직접 설정 어려움?
		private Builder() {}

		//5. 내부 클래스에 setter메서드 생성
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		//6. build 메서드를 생성 - 나 자신을 외부클래스에 저장하고 반환
		public BuilderVO build() {
			return new BuilderVO(this); //여기의 this는 4번의 BuilderVO
		}


	}

}
