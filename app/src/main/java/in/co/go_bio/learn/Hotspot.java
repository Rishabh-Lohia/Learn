package in.co.go_bio.learn;


/**
 * Created by rishabh on 2/6/16.
 */
public class Hotspot {
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(int image_uri) {
        this.image_uri = image_uri;
    }

    private float x,y;
    private long duration;
    private int image_uri;

    public Hotspot(float x, float y, long duration){
        this.x=x;
        this.y=y;
        this.duration=duration;
        this.image_uri=R.raw.boo3;
    }
    public Hotspot(float x, float y, long duration, int image_uri){
        this.x=x;
        this.y=y;
        this.duration=duration;
        this.image_uri = image_uri;
    }

}
