package com.crump.kareli;

import com.crump.kareli.BotKeyListener;
import com.crump.kareli.KeyHandler;
import com.crump.kareli.KeyHandlerSuperclass;
import edu.fcps.karel2.Display;
import edu.fcps.karel2.WorldBackend;
import edu.fcps.karel2.WorldPanel;

public class ListenerDisplay extends Display {

   public static void openWorld(String mapName, KeyHandlerSuperclass k) {
      new BotKeyListener(new WorldBackend(mapName));
      KeyHandlerSuperclass.startHandling(k);
   }

   public static void openDefaultWorld(KeyHandlerSuperclass k) {
      new BotKeyListener(new WorldBackend());
      KeyHandlerSuperclass.startHandling(k);
   }

   public static void openWorld(String mapName) {
      new BotKeyListener(new WorldBackend(mapName));
      KeyHandlerSuperclass.startHandling(new KeyHandler());
   }

   public static void openDefaultWorld() {
      new BotKeyListener(new WorldBackend());
      KeyHandlerSuperclass.startHandling(new KeyHandler());
   }

   public static void step() {
      WorldPanel.getCurrent().repaint();
   }
}
