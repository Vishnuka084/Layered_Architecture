package dto;

import java.io.Serializable;

public class RiderDTO implements Serializable {
    private String rid;
    private String name;
    private String address;

    public RiderDTO() {
    }

    public RiderDTO(String rid, String name, String address) {
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

    @Override
    public String toString() {
        return "RiderDTO{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
