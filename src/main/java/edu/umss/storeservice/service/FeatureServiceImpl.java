/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.FeatureInput;
import edu.umss.storeservice.model.Feature;
import edu.umss.storeservice.model.FeatureInstance;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.repository.FeatureInstanceRepository;
import edu.umss.storeservice.repository.FeatureRepository;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureServiceImpl extends GenericServiceImpl<Feature> implements FeatureService {
    private final FeatureRepository featureRepository;
    private final FeatureInstanceRepository featureInstanceRepository;
    private final ItemRepository itemRepository;

    public FeatureServiceImpl(FeatureRepository repository,
                              FeatureInstanceRepository featureInstanceRepository,
                              ItemRepository itemRepository) {
        this.featureRepository = repository;
        this.featureInstanceRepository = featureInstanceRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    protected GenericRepository<Feature> getRepository() {
        return featureRepository;
    }

    public FeatureInstance uploadFeature(Long id, FeatureInput instance) {
        Optional<Item> item = itemRepository.findById(id);
        FeatureInstance featureInstance = featureInstanceRepository.findFeatureInstance(item);
        Feature feature = featureRepository.findFeature(featureInstance.getFeature().getId());

        featureInstance.setValue(instance.getValue());
        featureInstance.setVersion(instance.getVersion());

        featureInstanceRepository.save(featureInstance);

        feature.setName(instance.getName());
        feature.setVersion(instance.getVersion());

        featureRepository.save(feature);

        return featureInstance;
    }
}
