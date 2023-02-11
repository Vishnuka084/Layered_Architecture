package dto;

import java.io.Serializable;

public class VehicaleDTO implements Serializable {
    private String vid;
    private String name;
    private String colour;

    public VehicaleDTO() {
    }

    public VehicaleDTO(String vid, String name, String colour) {
        this.vid = vid;
        this.name = name;
        this.colour = colour;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "VehicaleDTO{" +
                "vid='" + vid + '\'' +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
