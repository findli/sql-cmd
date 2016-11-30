package om;

public class Language {

    private int id = -1;
    private String name = null;
    private boolean delete = false;

    public Language(int id, String name, boolean delete) {
        this.id = id;
        this.name = name;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
