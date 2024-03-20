import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class PlaySound {

    public static void afspilLydfil(String lydfilSti) {
        try {
            URL lydURL = PlaySound.class.getResource(lydfilSti);
            if (lydURL == null) {
                System.out.println("Filen blev ikke fundet: " + lydfilSti);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(lydURL);

            Clip lydClip = AudioSystem.getClip();
            lydClip.open(audioInputStream);

            lydClip.start();
            Thread.sleep(lydClip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
