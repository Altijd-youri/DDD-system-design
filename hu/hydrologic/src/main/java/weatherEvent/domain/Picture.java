package weatherEvent.domain;

public class Picture {
    private final String description;
    private final Byte[] image;

    public Picture(Byte[] image, String description) {
        this.description = description;
        this.image = image;
    }
}
