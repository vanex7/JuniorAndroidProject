package vanex7.com.firstapp;

public class TestItem {
    private int icon;
    private String says;
    private String name;

    public TestItem(String name, String says, int icon) {
        this.name = name;
        this.says = says;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
