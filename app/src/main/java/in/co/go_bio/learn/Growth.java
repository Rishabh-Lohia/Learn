package in.co.go_bio.learn;

/**
 * Created by rishabh on 9/6/16.
 */
public class Growth {
    private int duration;

    public int getImg_uri() {
        return img_uri;
    }

    public void setImg_uri(int img_uri) {
        this.img_uri = img_uri;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int img_uri;

    public Growth(int duration) {
        this.duration = duration;
        this.img_uri = R.raw.boo3;
    }

    public Growth(int duration, int img_uri) {
        this.duration = duration;
        this.img_uri = img_uri;
    }
}

