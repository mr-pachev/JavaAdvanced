package _06_Exercise_Google;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String toString() {
        return String.format("%s %s", this.childName, this.childBirthday);
    }
}
