package reports;

public class BasicColumn {
    private String title;

    private Class classType;

    public BasicColumn(String title) {
        this.title = title;
        this.classType = String.class;
    }

    public BasicColumn(String title, Class classType) {
        this.title = title;
        this.classType = classType;
    }

    public String getTitle() {
        return title;
    }

    public Class getClassType() {
        return classType;
    }
}
