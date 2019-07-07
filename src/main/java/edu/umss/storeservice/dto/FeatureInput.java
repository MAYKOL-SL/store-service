package edu.umss.storeservice.dto;

/**
 * @author: Miguel A. Quispe Santos
 */

public class FeatureInput {

    private String name;
    private String value;
    private long version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
