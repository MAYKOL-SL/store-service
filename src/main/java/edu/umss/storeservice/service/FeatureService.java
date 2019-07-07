/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.FeatureInput;
import edu.umss.storeservice.model.Feature;
import edu.umss.storeservice.model.FeatureInstance;

public interface FeatureService extends GenericService<Feature> {
    FeatureInstance uploadFeature(Long id, FeatureInput instance);
}

    