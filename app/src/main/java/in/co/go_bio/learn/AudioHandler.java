package in.co.go_bio.learn;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Process;

import java.io.IOException;

/**
 * Created by rishabh on 3/6/16.
 */
public class AudioHandler implements Runnable {
    tab3 m;
    public AudioHandler(tab3 m){
        this.m=m;
    }

    public void startaudio(){
        try {
            m.rooty.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //Toast.makeText(this,"start",1000);
    }

    public void stopaudio() throws IOException {
        m.rooty.stop();
        m.rooty.reset();
        run();
        try {
            m.rooty.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        //Toast.makeText(this,"stop",1000);
    }

    @Override
    public void run() {

        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        m.rooty= MediaPlayer.create(m.getContext(),R.raw.boo3);
        m.rooty.setVolume(100f,100f);
        m.rooty.setAudioStreamType(AudioManager.STREAM_MUSIC);
        m.rooty.setLooping(false);
    }

}
