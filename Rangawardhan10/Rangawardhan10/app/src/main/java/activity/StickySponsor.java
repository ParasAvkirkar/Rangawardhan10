package activity;

import java.io.Serializable;

/**
 * Created by Rohit on 22/11/2015.
 */
public class StickySponsor implements Serializable {
    private int imageId;
    private int position;

    public StickySponsor(int imageId, int position) {
        this.imageId = imageId;
        this.position = position;
    }

    public int getImageId() {
        return this.imageId;
    }

    public int getPosition() {
        return this.position;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
