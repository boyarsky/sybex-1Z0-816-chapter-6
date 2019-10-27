package zoo.tours.hybrid;

import zoo.tours.api.*;

public class QuickTourImpl implements Tour {

    public String name() {
        return "Behind the Scenes";
    }
    public int length() {
        return 30;
    }
    public Souvenir getSouvenir() {
        Souvenir gift = new Souvenir();
        gift.setDescription("stuffed animal");
        return gift;
    }

}
