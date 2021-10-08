package weatherEvent.domain;

public class Picture {
    private final String description;
    private final Byte[] image;

    public Picture(String description, Byte[] image) {
        this.description = description;
        this.image = image;
    }
}
