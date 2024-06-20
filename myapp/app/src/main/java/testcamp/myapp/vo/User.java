package testcamp.myapp.vo;

// User 명세
// VO -> 리터럴이라고 보면된다. 거의 변하지 않는 값 getter만 주로 쓴다.
// Read-Only 속성을 가진 값 오브젝트이다.
// DTO -> 인스턴스라고 보면된다. 값을 교환하기 위한 Java Bean을 의미한다.
// 로직을 가지지 않는 데이터 객체이며 getter, setter 메소드만 가진 클래스를 의미한다.

public class User {

    private String name;
    private String email;
    private String password;
    private String tel;
}
