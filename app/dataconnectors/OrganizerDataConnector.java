package dataconnectors;

import models.Organizer;

import java.util.HashMap;
import java.util.Map;

// should switch to database interactions after this is working
public enum OrganizerDataConnector {
    INSTANCE;

    private Map<String, Organizer> catalog;

    public boolean registerOrganizer(Organizer organizer) {
        if (catalog == null) {
            catalog = new HashMap<>();
        }
        catalog.put(organizer.getId(), organizer);
        return true;
    }

    public Map<String, Organizer> getAllOrganizers() {
        return catalog;
    }

    public Organizer getOrganizer(Organizer organizer) {
        return catalog.get(organizer.getId());
    }

    public Organizer getOrganizer(String id) {
        return catalog.get(id);
    }
}
