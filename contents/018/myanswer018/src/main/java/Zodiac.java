public enum Zodiac {
    NE("NE", 1),
    USHI("USHI", 2),
    TORA("TORA", 3),
    U("U", 4),
    TATSU("TATSU", 5);

    private final String name;
    private final Integer id;

    Zodiac(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public static Zodiac getByName(String name){
        for (Zodiac z : values()) {
            if(z.getName().equalsIgnoreCase(name)) {
                return z;
            }
        }
        return null;
    }

    public static Zodiac getById(Integer id){
        for (Zodiac z : values()) {
            if(z.getId().equals(id)){
                return z;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Zodiac zodiac1 = Zodiac.getById(1);
        System.out.println(zodiac1.getName());

        Zodiac zodiac2 = Zodiac.getByName("TATSU");
        System.out.println(zodiac2.getId());
    }
}
