package edu.umss.storeservice.dto;

/**
 * @author: Miguel A. Quispe Santos
 */

public class ItemInstanceInput {

    private long version;
    private String identifier;
    private Double price;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
