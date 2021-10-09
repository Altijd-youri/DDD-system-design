package account.domain;

public class SavedLocation {
    private String name;
    private SavedLocationID savedLocationID;
    private Coordinates coordinates;

    public SavedLocation(String name, String langitude, String longitude) {
        this.name = name;
        this.savedLocationID = new SavedLocationID("id");
        this.coordinates = new Coordinates( Double.parseDouble(longitude), Double.parseDouble(langitude));


    }
}
