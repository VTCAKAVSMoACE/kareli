package com.crump.kareli;

import com.crump.kareli.BotKeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.DataLine.Info;

@SuppressWarnings("all")
class SoundHandler {

   private Thread t;
   ExecutorService pool = Executors.newCachedThreadPool();


   protected SoundHandler(String filename) {
      this.t = new Thread(new Runnable() {

         private final int EXTERNAL_BUFFER_SIZE = 524288;
         private URL soundFile = BotKeyListener.class.getResource("/resources/bzzt.wav");

         @Override
		public void run() {
            try {
               this.soundFile.openConnection().connect();
               this.soundFile.openStream().close();
            } catch (Exception var20) {
               return;
            }

            AudioInputStream audioInputStream = null;

            try {
               audioInputStream = AudioSystem.getAudioInputStream(this.soundFile);
            } catch (UnsupportedAudioFileException var18) {
               return;
            } catch (IOException var19) {
               return;
            }

            AudioFormat format = audioInputStream.getFormat();
            SourceDataLine auline = null;
            Info info = new Info(SourceDataLine.class, format);

            try {
               auline = (SourceDataLine)AudioSystem.getLine(info);
               auline.open(format);
            } catch (LineUnavailableException var16) {
               return;
            } catch (Exception var17) {
               return;
            }

            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[524288];

            try {
               while(nBytesRead != -1) {
                  nBytesRead = audioInputStream.read(abData, 0, abData.length);
                  if(nBytesRead >= 0) {
                     auline.write(abData, 0, nBytesRead);
                  }
               }

               return;
            } catch (IOException var21) {
               ;
            } finally {
               auline.drain();
               auline.close();
            }

         }
      });
      this.t.start();
   }

   protected SoundHandler(String filename, boolean x) {
      this.t = new Thread(new Runnable() {

         private final int EXTERNAL_BUFFER_SIZE = 524288;
         private URL soundFile = BotKeyListener.class.getResource("/resources/bzzt.wav");

         @Override
		public void run() {
            try {
               this.soundFile.openConnection().connect();
               this.soundFile.openStream().close();
            } catch (Exception var20) {
               return;
            }

            AudioInputStream audioInputStream = null;

            try {
               audioInputStream = AudioSystem.getAudioInputStream(this.soundFile);
            } catch (UnsupportedAudioFileException var18) {
               return;
            } catch (IOException var19) {
               return;
            }

            AudioFormat format = audioInputStream.getFormat();
            SourceDataLine auline = null;
            Info info = new Info(SourceDataLine.class, format);

            try {
               auline = (SourceDataLine)AudioSystem.getLine(info);
               auline.open(format);
            } catch (LineUnavailableException var16) {
               return;
            } catch (Exception var17) {
               return;
            }

            int nBytesRead = 0;
            byte[] abData = new byte[524288];

            try {
               while(nBytesRead != -1) {
                  nBytesRead = audioInputStream.read(abData, 0, abData.length);
                  if(nBytesRead >= 0) {
                     auline.write(abData, 0, nBytesRead);
                  }
               }

               return;
            } catch (IOException var21) {
               ;
            } finally {
               auline.drain();
               auline.close();
            }

         }
      });
      this.t.start();
   }

   protected void shutdown() {
      this.pool.shutdown();
   }
}
