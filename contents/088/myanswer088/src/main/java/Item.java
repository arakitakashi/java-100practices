import java.util.UUID;

public class Item {
    private final UUID id;
    private Long age;
    private String name;
    private String description;

    public Item() {
        //　仮実装:　DBによるID採番を正式実装する。
        this.id = UUID.randomUUID();
    }

    private Item(Long age, String name, String description) {
        validateAge(age);

        //　仮実装:　DBによるID採番を正式実装する。
        this.id = UUID.randomUUID();
        this.age = age;
        this.name = name;
        this.description = description;
    }

    public static Item newInstance(Long age, String name) {
        return new Item(age, name, "-");
    }

    public static Item newInstanceWithDescription(Long age, String name, String description) {
        return new Item(age, name, description);
    }

    public void setAge(Long age) {
        validateAge(age);
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void validateAge(Long age) {
        if (age < 0) {
            throw new IllegalArgumentException("ageの値が不正です。");
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
