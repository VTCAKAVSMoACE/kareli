package com.crump.kareli;

import com.crump.kareli.Controllable;

public class PlayerBot extends Controllable {

   static PlayerBot current = null;
   private static boolean currentIsMult;


   public PlayerBot() {
      this(1, 1, 1, -2);
   }

   public PlayerBot(int x, int y, int dir, int beep) {
      super(x, y, dir, beep);
   }

   public void inputAccepter() {
      current = this;
   }

   public static void setCurrentMult() {
      currentIsMult = !currentIsMult;
   }

   public static boolean getCurrentMult() {
      return currentIsMult;
   }

   protected static PlayerBot getCurrent() {
      return current;
   }

   protected static void endCurrent() {
      current = null;
   }
}
