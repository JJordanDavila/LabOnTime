package pe.edu.upc.labontime.models;


public class Analysis {
    int id;
    String name;
    String active;

    public Analysis() {
    }

    public Analysis(int id, String name, String active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public Analysis setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Analysis setName(String name) {
        this.name = name;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Analysis setActive(String active) {
        this.active = active;
        return this;
    }
}
