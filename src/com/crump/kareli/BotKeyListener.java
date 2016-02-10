package com.crump.kareli;

import com.crump.kareli.Controllable;
import com.crump.kareli.KeyHandlerSuperclass;
import com.crump.kareli.PlayerBot;
import com.crump.kareli.SoundHandler;
import com.crump.kareli.TwoPlayerBot;
import edu.fcps.karel2.WorldBackend;
import edu.fcps.karel2.WorldFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("all")
public class BotKeyListener extends WorldFrame implements KeyListener {

   private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
   private PrintWriter out = null;
   private boolean isCommandDown;
   private static Calendar cal = Calendar.getInstance();
   private boolean isStillWritingArray = false;
   private boolean isW = true;
   private boolean isA = true;
   private boolean isS = true;
   private boolean isD = true;


   public static void calUpdt() {
      cal = Calendar.getInstance();
   }

   private void fileWriter() {
      try {
         this.out = new PrintWriter(new BufferedWriter(new FileWriter("moveCount.txt", true)));
      } catch (IOException var2) {
         ;
      }

   }

   public boolean isW() {
      return this.isW;
   }

   public boolean isA() {
      return this.isA;
   }

   public boolean isS() {
      return this.isS;
   }

   public boolean isD() {
      return this.isD;
   }

   public static Calendar calCall() {
      return cal;
   }

   public static SimpleDateFormat callSDF() {
      return sdf;
   }

   public static synchronized void bzzt() {
      new SoundHandler("/resources/bzzt.wav");
   }

   public BotKeyListener(WorldBackend wb) {
      super(wb);
      this.addKeyListener(this);
      new SoundHandler("/resources/bzzt.wav", true);
   }

   @Override
public void keyTyped(KeyEvent ke) {}

   @Override
public void keyPressed(KeyEvent ke) {
      switch(ke.getKeyCode()) {
      case 27:
         if(!PlayerBot.getCurrentMult()) {
            if(PlayerBot.getCurrent() != null) {
               this.fileWriter();
               calUpdt();
               System.out.println("[" + sdf.format(cal.getTime()) + "] The robot being controlled stopped listening!");
               if(Controllable.getIsWriting()) {
                  Controllable.addMoveCount();
                  this.out.println("// End of control, move #" + Controllable.getMoveCount());
                  this.out.close();
               }

               PlayerBot.endCurrent();
            }
         } else {
            System.out.println("To escape from the robot array control, please press semicolon.");
         }
         break;
      case 37:
         KeyHandlerSuperclass.leftHandler();
         break;
      case 38:
         KeyHandlerSuperclass.upHandler();
         break;
      case 39:
         KeyHandlerSuperclass.rightHandler();
         break;
      case 40:
         KeyHandlerSuperclass.downHandler();
         break;
      case 48:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.zeroHandler();
         }
         break;
      case 49:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.oneHandler();
         }
         break;
      case 50:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.twoHandler();
         }
         break;
      case 51:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.threeHandler();
         }
         break;
      case 52:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.fourHandler();
         }
         break;
      case 53:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.fiveHandler();
         }
         break;
      case 54:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.sixHandler();
         }
         break;
      case 55:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.sevenHandler();
         }
         break;
      case 56:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.eightHandler();
         }
         break;
      case 57:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.nineHandler();
         }
         break;
      case 59:
         if(!TwoPlayerBot.inTwoPlayerMode() || Controllable.currAllKareliInt() == 1 || PlayerBot.getCurrent() == null) {
            PlayerBot.setCurrentMult();
            if(this.isStillWritingArray) {
               this.fileWriter();
               this.out.println("}");
               this.out.close();
               this.isStillWritingArray = false;
            } else if(!this.isStillWritingArray) {
               this.fileWriter();
               this.isStillWritingArray = true;
               this.out.println("for (int k = 0; k < Controllable.currAllKareliInt(); k++) {");
               this.out.close();
            }
         }
         break;
      case 65:
         if(!PlayerBot.getCurrentMult()) {
            try {
				KeyHandlerSuperclass.aHandler();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         } else {
            KeyHandlerSuperclass.aMultiHandler();
         }
         break;
      case 66:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.bHandler();
         } else {
            KeyHandlerSuperclass.bMultiHandler();
         }
         break;
      case 67:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.cHandler();
         } else {
            KeyHandlerSuperclass.cMultiHandler();
         }
         break;
      case 68:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.dHandler();
         } else {
            KeyHandlerSuperclass.dMultiHandler();
         }
         break;
      case 69:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.eHandler();
         } else {
            KeyHandlerSuperclass.eMultiHandler();
         }
         break;
      case 70:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.fHandler();
         } else {
            KeyHandlerSuperclass.fMultiHandler();
         }
         break;
      case 71:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.gHandler();
         } else {
            KeyHandlerSuperclass.gMultiHandler();
         }
         break;
      case 72:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.hHandler();
         } else {
            KeyHandlerSuperclass.hMultiHandler();
         }
         break;
      case 73:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.iHandler();
         } else {
            KeyHandlerSuperclass.iMultiHandler();
         }
         break;
      case 74:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.jHandler();
         } else {
            KeyHandlerSuperclass.jMultiHandler();
         }
         break;
      case 75:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.kHandler();
         } else {
            KeyHandlerSuperclass.kMultiHandler();
         }
         break;
      case 76:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.lHandler();
         } else {
            KeyHandlerSuperclass.lMultiHandler();
         }
         break;
      case 77:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.mHandler();
         } else {
            KeyHandlerSuperclass.mMultiHandler();
         }
         break;
      case 78:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.nHandler();
         } else {
            KeyHandlerSuperclass.nMultiHandler();
         }
         break;
      case 79:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.oHandler();
         } else {
            KeyHandlerSuperclass.oMultiHandler();
         }
         break;
      case 80:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.pHandler();
         } else {
            KeyHandlerSuperclass.pMultiHandler();
         }
         break;
      case 81:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.qHandler();
         } else {
            KeyHandlerSuperclass.qMultiHandler();
         }
         break;
      case 82:
         KeyHandlerSuperclass.rHandler();
         break;
      case 83:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.sHandler();
         } else {
            KeyHandlerSuperclass.sMultiHandler();
         }
         break;
      case 84:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.tHandler();
         } else {
            KeyHandlerSuperclass.tMultiHandler();
         }
         break;
      case 85:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.uHandler();
         } else {
            KeyHandlerSuperclass.uMultiHandler();
         }
         break;
      case 86:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.vHandler();
         } else {
            KeyHandlerSuperclass.vMultiHandler();
         }
         break;
      case 87:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.wHandler();
         } else {
            KeyHandlerSuperclass.wMultiHandler();
         }
         break;
      case 88:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.xHandler();
         } else {
            KeyHandlerSuperclass.xMultiHandler();
         }
         break;
      case 89:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.yHandler();
         } else {
            KeyHandlerSuperclass.yMultiHandler();
         }
         break;
      case 90:
         if(!PlayerBot.getCurrentMult()) {
            KeyHandlerSuperclass.zHandler();
         } else {
            KeyHandlerSuperclass.zMultiHandler();
         }
         break;
      case 157:
         this.isCommandDown = true;
      }

      if(!this.isCommandDown) {
         bzzt();
      }

   }

   @Override
public void keyReleased(KeyEvent ke) {
      if(ke.getKeyCode() == 157) {
         this.isCommandDown = false;
      }

   }
}
