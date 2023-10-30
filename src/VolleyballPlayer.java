public class VolleyballPlayer implements Trainable, Restable {
    private String name;
    private int age;
    private String position;
    private short skills;
    private short conditions;

    public VolleyballPlayer(String name, int age, String position, short skills, short conditions) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skills = skills;
        this.conditions = conditions;
    }

    public VolleyballPlayer() {
        this.name = "Unnamed";
        this.age = 18;
        this.position = "unknown";
        this.skills = 1;
        this.conditions = 1;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public short getSkills() {
        return skills;
    }

    public void setSkills(short skills) {
        this.skills = skills;
    }

    public short getConditions() {
        return conditions;
    }

    public void setConditions(short conditions) {
        this.conditions = conditions;
    }

    @Override
    public void training() {
        if (getConditions() == 1) {
            System.out.println(getName() + " yours conditions is to low. You need to rest!");
        } else {
            setSkills((short) (getSkills() + 1));
            setConditions((short) (getConditions() - 1));
        }
    }

    @Override
    public void rest() {
        setConditions((short) (getConditions() + 1));
    }

    @Override
    public String toString() {
        return "VolleyballPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", skills=" + skills +
                ", conditions=" + conditions +
                '}';
    }
}
