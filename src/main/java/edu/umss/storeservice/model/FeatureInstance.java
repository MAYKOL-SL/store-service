/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class FeatureInstance extends ModelBase {
    private String value;
    @ManyToOne
    private Feature feature;

    @ManyToOne
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
