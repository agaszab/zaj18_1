package pl.javastart.zaj18_1;

public class Cat {
   private String name;
   private int age;
   private String text;
   private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public Cat(String name, int age, String text, String img) {
        this.name = name;
        this.age = age;
        this.text = text;
        this.img = img;
    }

    public Cat(String name, int age, String text) {
        this.name = name;
        this.age = age;
        this.text = text;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", text='" + text + '\'' +
                '}';
    }
}
