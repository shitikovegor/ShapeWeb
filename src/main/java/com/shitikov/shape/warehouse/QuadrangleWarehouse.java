package com.shitikov.shape.warehouse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QuadrangleWarehouse {
    private static Map<Long, QuadrangleProperty> properties;
    private static QuadrangleWarehouse instance;
    private static Logger logger = LogManager.getLogger();

    private QuadrangleWarehouse() {
        properties = new HashMap<>();
    }

    public static QuadrangleWarehouse getInstance() {
        if (instance == null) {
            instance = new QuadrangleWarehouse();
        }
        return instance;
    }

    public boolean put(long id, QuadrangleProperty property) {
        if (id > 0 && property != null) {
            properties.put(id, property);
            return true;
        } else {
            logger.log(Level.INFO, "id = 0 or property is null: id - {}; property - {}.", id, property);
            return false;
        }
    }

    public boolean removeById(long id) {
        if (properties.containsKey(id)) {
            properties.remove(id);
            return true;
        } else {
            logger.log(Level.INFO, "Warehouse doesn't contain id - {}", id);
            return false;
        }
    }

    public Optional<QuadrangleProperty> getProperty(long id) {
        Optional<QuadrangleProperty> propertyOptional = Optional.empty();
        if (properties.containsKey(id)) {
            propertyOptional = Optional.of(properties.get(id));
        }
        return propertyOptional;
    }

    public Map<Long, QuadrangleProperty> getProperties() {
        return Collections.unmodifiableMap(properties);
    }
}
