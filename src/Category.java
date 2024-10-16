public enum Category {

    DRAMA("Drama"),
    SCIENCEFICTION("Sci-Fi"),
    HORROR("Horror"),
    FANTASY("Fantasy"),
    ROMANCE("Romance"),
    CRIMEFICTION("Crime fiction");

    private final String displayName;


    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }


}

