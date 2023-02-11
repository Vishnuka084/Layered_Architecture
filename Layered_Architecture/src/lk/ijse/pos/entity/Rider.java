package lk.ijse.pos.entity;

public class Rider {
    private String rid;
    private String name;
    private String address;

    public Rider(String rid) {
        this.rid = rid;
    }

    public Rider(String rid, String name, String address) {
        this.rid = rid;
        this.name = name;
        this.address = address;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
