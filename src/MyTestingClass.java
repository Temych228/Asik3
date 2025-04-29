public class MyTestingClass implements Comparable<MyTestingClass> {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass other)) return false;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    // ← implement Comparable so BST can compare keys
    @Override
    public int compareTo(MyTestingClass other) {
        // first compare by id
        int cmp = Integer.compare(this.id, other.id);
        if (cmp != 0) return cmp;
        // if ids equal, compare by name
        return this.name.compareTo(other.name);
    }
}
