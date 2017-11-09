package dataconnectors;

import models.Address;
import models.Organizer;

import java.util.HashMap;
import java.util.Map;

// should switch to database interactions after this is working
public enum OrganizerDataConnector {
    INSTANCE;

    private Map<String, Organizer> catalog = new HashMap<>();

    public boolean registerOrganizer(Organizer organizer) {
        catalog.put(organizer.getId(), organizer);
        return true;
    }

    public Map<String, Organizer> getAllOrganizers() {
        if (catalog.isEmpty()) {
            Address sampleAddress = new Address("Street 1", "Street2", "City", "OH", 43065, "US");
            Organizer organizer = new Organizer("Sample", "Organizer", "sampleorganizer@email.com", "5555555555", sampleAddress);
            registerOrganizer(organizer);
        }
        return catalog;
    }

    public Organizer getOrganizer(Organizer organizer) {
        return catalog.get(organizer.getId());
    }

    public Organizer getOrganizer(String id) {
        return catalog.get(id);
    }
}
