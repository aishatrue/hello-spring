package hellospring.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    //스프링이 setname을 호출해서 여기에 name값을 넣어줌.
    public void setName(String name) {
        this.name = name;
    }
}
