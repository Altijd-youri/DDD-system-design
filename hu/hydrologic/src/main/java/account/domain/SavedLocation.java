package account.domain;

public class SavedLocation {
    private String name;
    private SavedLocationID savedLocationID;
    private Coordinates coordinates;

    public SavedLocation(String name, SavedLocationID savedLocationID, Coordinates coordinates) {
        this.name = name;
        this.savedLocationID = savedLocationID;
        this.coordinates = coordinates;


    }
}
