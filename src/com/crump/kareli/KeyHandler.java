package com.crump.kareli;

import com.crump.kareli.Controllable;
import com.crump.kareli.KeyHandlerSuperclass;
import com.crump.kareli.PlayerBot;
import com.crump.kareli.TwoPlayerBot;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("all")
public class KeyHandler extends KeyHandlerSuperclass {

   private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
   private static PrintWriter out = null;
   private static boolean isCommandDown;
   private static Calendar cal = Calendar.getInstance();
   private static boolean isStillWritingArray = false;


   public static void calUpdt() {
      cal = Calendar.getInstance();
   }

   private static void fileWriter() {
      try {
         out = new PrintWriter(new BufferedWriter(new FileWriter("moveCount.txt", true)));
      } catch (IOException var1) {
         ;
      }

   }

   public static void handleKeys() {
      new KeyHandler();
   }

   public static Calendar calCall() {
      return cal;
   }

   public static SimpleDateFormat callSDF() {
      return sdf;
   }

   public KeyHandler() {
      KeyHandlerSuperclass.startHandling(this);
   }

   public static void wHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode()) {
         if(!isCommandDown && PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            if(PlayerBot.getCurrent().getIsBeepMoving() && (PlayerBot.getCurrent().frontIsClear() || PlayerBot.getCurrent().getWallPhaseActive())) {
               if(Controllable.getIsWriting()) {
                  Controllable.addMoveCount();
                  if(!PlayerBot.getCurrent().hasBeepers()) {
                     out.println("// The following movement caused an error.");
                  }

                  out.println(Controllable.getCurrObj() + ".putBeeper(); // move #" + Controllable.getMoveCount());
                  out.close();
               }

               if(PlayerBot.getCurrent().hasBeepers()) {
                  PlayerBot.getCurrent().putBeeper();
               } else {
                  System.out.println("But had no beepers and did not carry out the function!");
               }
            } else {
               out.close();
            }

            fileWriter();
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled moved!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               if(!PlayerBot.getCurrent().frontIsClear() && !PlayerBot.getCurrent().getWallPhaseActive()) {
                  out.println("// The following movement caused an error.");
               }

               out.println(Controllable.getCurrObj() + ".move(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            PlayerBot.getCurrent().move();
         }
      } else {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(0)).move();
      }

   }

   public static void wMultiHandler() {
      for(int k = 0; k < Controllable.currAllKareliInt(); ++k) {
         if(!isCommandDown) {
            fileWriter();
            if(!Controllable.currMultiKareli(k).frontIsClear() && !Controllable.currMultiKareli(k).getWallPhaseActive()) {
               out.println("// The following movement caused an error.");
            }

            out.close();
            Controllable.currMultiKareli(k).move();
         } else {
            fileWriter();
            out.println("}");
            out.close();
            isStillWritingArray = false;
         }
      }

      if(!isCommandDown) {
         fileWriter();
         System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled moved!");
         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println("Controllable.currMultiKareli(k).move(); // move #" + Controllable.getMoveCount());
            out.close();
         }
      }

   }

   public static void aHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode()) {
         if(PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned left!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               out.println(Controllable.getCurrObj() + ".turnLeft(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            PlayerBot.getCurrent().turnLeft();
         }
      } else {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(0)).turnLeft();
      }

   }

   public static void aMultiHandler() {
      for(int k = 0; k < Controllable.currAllKareliInt(); ++k) {
         Controllable.currMultiKareli(k).turnLeft();
      }

      fileWriter();
      calUpdt();
      System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned left!");
      if(Controllable.getIsWriting()) {
         Controllable.addMoveCount();
         out.println("Controllable.currMultiKareli(k).turnLeft(); // move #" + Controllable.getMoveCount());
         out.close();
      }

   }

   public static void dHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode()) {
         if(PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned right!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               out.println(Controllable.getCurrObj() + ".turnRight(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            PlayerBot.getCurrent().turnRight();
         }
      } else {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(0)).turnRight();
      }

   }

   public static void dMultiHandler() {
      for(int k = 0; k < Controllable.currAllKareliInt(); ++k) {
         Controllable.currMultiKareli(k).turnRight();
      }

      fileWriter();
      calUpdt();
      System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned right!");
      if(Controllable.getIsWriting()) {
         Controllable.addMoveCount();
         out.println("Controllable.currMultiKareli(k).turnRight(); // move #" + Controllable.getMoveCount());
         out.close();
      }

   }

   public static void sHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode()) {
         if(PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned around!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               out.println(Controllable.getCurrObj() + ".turnAround(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            PlayerBot.getCurrent().turnAround();
         }
      } else {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(0)).turnLeft();
      }

   }

   public static void sMultiHandler() {
      for(int k = 0; k < Controllable.currAllKareliInt(); ++k) {
         fileWriter();
         calUpdt();
         System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled turned right!");
         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println("Controllable.currMultiKareli(k).turnAround(); // move #" + Controllable.getMoveCount());
            out.close();
         }

         Controllable.currMultiKareli(k).turnAround();
      }

   }

   public static void oneHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode() && PlayerBot.getCurrent() != null) {
         fileWriter();
         calUpdt();
         if(PlayerBot.getCurrent().getBeepers() == -2) {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled already has infinite beepers!");
         } else {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled tried to get bonus beepers!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               out.println(Controllable.getCurrObj() + ".giveBeeper(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            PlayerBot.getCurrent().giveBeeper();
         }
      }

   }

   public static void twoHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode() && !PlayerBot.getCurrentMult() && PlayerBot.getCurrent() != null) {
         fileWriter();
         calUpdt();
         System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled teleported!");
         PlayerBot.getCurrent().teleport();
         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println(Controllable.getCurrObj() + ".teleport(" + PlayerBot.getCurrent().getX() + ", " + PlayerBot.getCurrent().getY() + "); // move #" + Controllable.getMoveCount());
            out.close();
         }
      }

   }

   public static void threeHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode() && PlayerBot.getCurrent() != null) {
         fileWriter();
         calUpdt();
         if(!PlayerBot.getCurrent().getWallPhaseActive()) {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled initiated wall breaking!");
         } else {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled ended wall breaking!");
         }

         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println(Controllable.getCurrObj() + ".wallPhaseActive(); // move #" + Controllable.getMoveCount());
            out.close();
         }

         PlayerBot.getCurrent().wallPhaseActive();
      }

   }

   public static void threeMultiHandler() {
      for(int k = 0; k < Controllable.currAllKareliInt(); ++k) {
         fileWriter();
         calUpdt();
         if(!Controllable.currMultiKareli(k).getWallPhaseActive()) {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled initiated wall breaking!");
         } else {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled ended wall breaking!");
         }

         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println("Controllable.currMultiKareli(k).wallPhaseActive(); // move #" + Controllable.getMoveCount());
            out.close();
         }

         Controllable.currMultiKareli(k).wallPhaseActive();
      }

   }

   public static void fourHandler() {
      if(!TwoPlayerBot.inTwoPlayerMode() && !PlayerBot.getCurrentMult() && PlayerBot.getCurrent() != null) {
         fileWriter();
         calUpdt();
         if(!PlayerBot.getCurrent().getIsBeepMoving()) {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled initiated beep movement!");
         } else {
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled ended beep movement!");
         }

         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            out.println(Controllable.getCurrObj() + ".setBeepMoving(); // move #" + Controllable.getMoveCount());
            out.close();
         }

         PlayerBot.getCurrent().setBeepMoving();
      }

   }

   public static void bHandler() {}

   public static void bMultiHandler() {}

   public static void cHandler() {}

   public static void cMultiHandler() {}

   public static void eHandler() {
      if(!PlayerBot.getCurrentMult()) {
         if(PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled tried to pick up a beeper!");
            if(Controllable.getIsWriting()) {
               Controllable.addMoveCount();
               if(!PlayerBot.getCurrent().nextToABeeper()) {
                  out.println("// The following movement caused an error.");
               }

               out.println(Controllable.getCurrObj() + ".pickBeeper(); // move #" + Controllable.getMoveCount());
               out.close();
            }

            if(PlayerBot.getCurrent().nextToABeeper()) {
               PlayerBot.getCurrent().pickBeeper();
            } else {
               System.out.println("But was not next to beepers and did not carry out the function!");
            }
         }
      } else {
         System.out.println("To prevent errors, multiple robots cannot pick beepers simultaneously.");
      }

   }

   public static void eMultiHandler() {}

   public static void fHandler() {}

   public static void fMultiHandler() {}

   public static void gHandler() {}

   public static void gMultiHandler() {}

   public static void hHandler() {}

   public static void hMultiHandler() {}

   public static void iHandler() {}

   public static void iMultiHandler() {}

   public static void jHandler() {}

   public static void jMultiHandler() {}

   public static void kHandler() {}

   public static void kMultiHandler() {}

   public static void lHandler() {}

   public static void lMultiHandler() {}

   public static void mHandler() {}

   public static void mMultiHandler() {}

   public static void nHandler() {}

   public static void nMultiHandler() {}

   public static void oHandler() {}

   public static void oMultiHandler() {}

   public static void pHandler() {}

   public static void pMultiHandler() {}

   public static void qHandler() {
      if(!PlayerBot.getCurrentMult() && !isCommandDown && PlayerBot.getCurrent() != null) {
         fileWriter();
         calUpdt();
         System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled tried to put down a beeper!");
         if(Controllable.getIsWriting()) {
            Controllable.addMoveCount();
            if(!PlayerBot.getCurrent().hasBeepers()) {
               out.println("// The following movement caused an error.");
            }

            out.println(Controllable.getCurrObj() + ".putBeeper(); // move #" + Controllable.getMoveCount());
            out.close();
         }

         if(PlayerBot.getCurrent().hasBeepers()) {
            PlayerBot.getCurrent().putBeeper();
         } else {
            System.out.println("But had no beepers and did not carry out the function!");
         }
      }

   }

   public static void qMultiHandler() {
      if(PlayerBot.getCurrentMult()) {
         if(!isCommandDown) {
            System.out.println("To prevent errors, multiple robots cannot place beepers simultaneously.");
         } else {
            fileWriter();
            out.println("}");
            out.close();
            isStillWritingArray = false;
         }
      }

   }

   public static void rHandler() {
      if(!PlayerBot.getCurrentMult()) {
         if(PlayerBot.getCurrent() != null) {
            fileWriter();
            calUpdt();
            if(PlayerBot.getCurrent().getBeepers() == -2) {
               System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled has infinite beepers.");
            } else {
               System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled has " + PlayerBot.getCurrent().getBeepers() + " beepers.");
            }
         }
      } else {
         System.out.println("To prevent errors, multiple robots cannot be tested for beeper count simultaneously.");
      }

   }

   public static void rMultiHandler() {}

   public static void tHandler() {}

   public static void tMultiHandler() {}

   public static void uHandler() {}

   public static void uMultiHandler() {}

   public static void vHandler() {}

   public static void vMultiHandler() {}

   public static void xHandler() {}

   public static void xMultiHandler() {}

   public static void yHandler() {}

   public static void yMultiHandler() {}

   public static void zHandler() {}

   public static void zMultiHandler() {}

   public static void upHandler() {
      if(TwoPlayerBot.inTwoPlayerMode()) {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(1)).move();
      }

   }

   public static void leftHandler() {
      if(TwoPlayerBot.inTwoPlayerMode()) {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(1)).turnLeft();
      }

   }

   public static void rightHandler() {
      if(TwoPlayerBot.inTwoPlayerMode()) {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(1)).turnRight();
      }

   }

   public static void downHandler() {
      if(TwoPlayerBot.inTwoPlayerMode()) {
         ((TwoPlayerBot)TwoPlayerBot.currentPlayers().get(1)).turnAround();
      }

   }
}
