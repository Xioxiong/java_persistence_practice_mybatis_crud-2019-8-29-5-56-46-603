package tws.dto;

public class EmployeeDto {
    private String id;
    private String name;
    private String age;
    private String desc;

    public EmployeeDto() {
    }

    public EmployeeDto(String id, String name, String age, String desc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
