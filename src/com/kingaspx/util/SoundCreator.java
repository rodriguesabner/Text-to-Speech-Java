package com.kingaspx.util;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundCreator {

    String API_KEY = "YOUR_API_KEY";
    String URL = "YOUR_URL";
    String final_filename;

    Clip oClip;

    public static void main(String[] args) {
//        new SoundCreator().create_audio("Abner");
//        new SoundCreator().list_voices();
    }

    public void list_voices() {
        IamOptions options = new IamOptions.Builder()
                .apiKey(API_KEY)
                .build();

        TextToSpeech textToSpeech = new TextToSpeech(options);
        textToSpeech.setEndPoint(URL);

        Voices voices = textToSpeech.listVoices().execute().getResult();
        System.out.println(voices);
    }

    public void create_audio(String text, String voice) {
        IamOptions options = new IamOptions.Builder().apiKey(API_KEY).build();

        TextToSpeech textTo = new TextToSpeech(options);
        textTo.setEndPoint(URL);

        try {
            SynthesizeOptions syntOptions = new SynthesizeOptions.Builder()
                    .text(text) //message audio
                    .accept("audio/wav")
                    .voice(voice)
                    //                    .voice("en-US_MichaelV2Voice")
                    //                    .voice("pt-BR_IsabelaVoice")
                    .build();

            InputStream is = textTo.synthesize(syntOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(is);

            String filename = "our_voice";
            final_filename = filename + ".wav";

            OutputStream out = new FileOutputStream(final_filename);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            is.close();

            play_audio();
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void play_audio() {
        try {
            File file = new File(final_filename);

            oClip = AudioSystem.getClip();
            AudioInputStream oStream = AudioSystem.getAudioInputStream(file);
            oClip.open(oStream);
            oClip.loop(0);
//            oClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        } finally {
            try {
                oClip.flush();
            } catch (NullPointerException e) {
            }
        }
    }

}
