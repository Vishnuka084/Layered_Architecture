package lk.ijse.pos.view.tdm;

public class VehicaleTM implements Comparable<VehicaleTM>{
    private String vid;
    private String name;
    private String colour;

    public VehicaleTM() {
    }

    public VehicaleTM(String vid, String name, String colour) {
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
        return "VehicaleTM{" +
                "vid='" + vid + '\'' +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public int compareTo(VehicaleTM o) {
        return vid.compareTo(o.getVid());
    }
}
