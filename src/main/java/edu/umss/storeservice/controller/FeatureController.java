package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.FeatureDto;
import edu.umss.storeservice.dto.FeatureInput;
import edu.umss.storeservice.model.Feature;
import edu.umss.storeservice.model.FeatureInstance;
import edu.umss.storeservice.service.FeatureService;
import edu.umss.storeservice.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author: Miguel A. Quispe Santos
 */

@RestController
@RequestMapping("/feature")
public class FeatureController extends GenericController<Feature, FeatureDto> {
    private FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @PutMapping(value = "/update/{id}")
    public FeatureInstance updateFeature(@PathVariable("id") Long id, @RequestBody FeatureInput input) throws IOException {
        return service.uploadFeature(id, input);
    }

    @GetMapping(value = "/getFeature/{id}")
    public FeatureInstance getFeature(@PathVariable("id") Long id) throws IOException {
        return service.getFeature(id);
    }
}