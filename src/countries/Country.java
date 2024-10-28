package countries;

import static countries.TypeCountry.*;

public enum Country {
    RUSSIA(THIS),
    BELARUS(FRIENDLY),
    USA(HOSTILE),
    EGYPT(NEUTRAL);

    private final TypeCountry typeCountry;

    Country(TypeCountry typeCountry) {
        this.typeCountry = typeCountry;
    }

    public TypeCountry getTypeCountry() {return this.typeCountry;}
}
