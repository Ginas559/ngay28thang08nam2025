package vn.iotstar.model;

// class model category
public class Category {
    private int id;       // cate_id
    private String name;  // cate_name
    private String icon;  // icons
    private int userId;   // foreign key toi user

    // constructor rong
    public Category() {}

    // constructor day du
    public Category(int id, String name, String icon, int userId) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.userId = userId;
    }

    // constructor khong co id (insert)
    public Category(String name, String icon, int userId) {
        this.name = name;
        this.icon = icon;
        this.userId = userId;
    }

    // getter setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
