package com.crump.kareli;

import com.crump.kareli.PlayerBot;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class TwoPlayerBot extends PlayerBot {

   private static List twoPlayerModes = new ArrayList();
   private static boolean currentMode = false;


   public static boolean inTwoPlayerMode() {
      return currentMode;
   }

   public TwoPlayerBot() {
      this(1, 1, 1, -2);
   }

   public TwoPlayerBot(int x, int y, int dir, int beep) {
      super(x, y, dir, beep);
      twoPlayerModes.add(this);
      if(twoPlayerModes.size() >= 2) {
         currentMode = true;
      }

   }

   public static List currentPlayers() {
      return twoPlayerModes;
   }
}
