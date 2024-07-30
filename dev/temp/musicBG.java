import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class musicBG extends JFrame {

    private Clip clip;

    public musicBG() {
        // Set up the JFrame
        setTitle("Background Music Player");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add a label
        JLabel label = new JLabel("Playing Background Music", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // Load and play the background music
        loadAndPlayMusic("C:/Users/admin/Downloads/Celt-Flute_-might-delete-later-_ad.wav");
    }

    private void loadAndPlayMusic(String musicFilePath) {
        try {
            File musicFile = new File(musicFilePath);
            if (musicFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
                System.out.println("Music file not found: " + musicFilePath);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            musicBG app = new musicBG();
            app.setVisible(true);
        });
    }
}
