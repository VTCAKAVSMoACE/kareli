package com.crump.kareli;

import com.crump.kareli.ListenerDisplay;
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Item;
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.WorldBackend;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@SuppressWarnings("all")
public abstract class Controllable extends Robot {

   private static List allKareli = new ArrayList();
   private int z;
   private boolean isWallPhasing;
   private static boolean isBeepMoving = false;
   private static boolean isWriting = false;
   private static String currentObj = "";
   private static int moveCount = 0;
   private Field xold1;
   private Field yold1;
   private Field beepold;
   private Field dirchange;


   public Controllable() {
      this(1, 1, 1, -2);
   }

   public Controllable(int x, int y, int dir, int beep) {
      super(x, y, dir, beep);
      this.z = 0;
      this.isWallPhasing = false;
      this.xold1 = null;
      this.yold1 = null;
      this.beepold = null;
      this.dirchange = null;
      this.fieldgetter();
      allKareli.add(this);
   }

   private void fieldgetter() {
      try {
         this.xold1 = Item.class.getDeclaredField("x");
         this.yold1 = Item.class.getDeclaredField("y");
         this.beepold = Robot.class.getDeclaredField("beepers");
         this.dirchange = Robot.class.getDeclaredField("direction");
         this.xold1.setAccessible(true);
         this.yold1.setAccessible(true);
         this.beepold.setAccessible(true);
         this.dirchange.setAccessible(true);
      } catch (SecurityException var2) {
         ;
      } catch (NoSuchFieldException var3) {
         ;
      } catch (NullPointerException var4) {
         ;
      }

   }

   private void coordsetter(int x, int y, Controllable arg) {
      try {
         this.xold1.setInt(arg, x);
         this.yold1.setInt(arg, y);
      } catch (SecurityException var5) {
         ;
      } catch (IllegalArgumentException var6) {
         ;
      } catch (IllegalAccessException var7) {
         ;
      } catch (NullPointerException var8) {
         ;
      }

   }

   private void beepsetter(int x, Controllable arg) {
      try {
         this.beepold.setInt(arg, arg.getBeepers() + x);
      } catch (SecurityException var4) {
         ;
      } catch (IllegalArgumentException var5) {
         ;
      } catch (IllegalAccessException var6) {
         ;
      } catch (NullPointerException var7) {
         ;
      }

   }

   public void teleport() {
      String s = JOptionPane.showInputDialog("What x coordinate?");
      String t = JOptionPane.showInputDialog("What y coordinate?");
      if(!s.equals((Object)null) && !t.equals((Object)null)) {
         this.teleport(Integer.parseInt(s), Integer.parseInt(t));
      } else {
         System.out.println("Not all teleport coordinates were input, stopping...");
      }

   }

   public void teleport(int x, int y) {
      this.coordsetter(x, y, this);
      ListenerDisplay.step();
   }

   public void giveBeeper() {
      String s = JOptionPane.showInputDialog("How many beepers to give?");
      if(s.equals((Object)null)) {
         System.out.println("No detectible integer input, stopping giveBeeper() process...");
      } else if(this.getBeepers() == -2) {
         System.out.println("You already have infinite beepers!");
      } else {
         this.beepsetter(Integer.parseInt(s), this);
      }

   }

   public void turnRight() {
      if(!Display.isDead()) {
         try {
            this.dirchange.setInt(this, (new Integer(Display.validateDirection(this.getDirection() - 1))).intValue());
         } catch (IllegalArgumentException var2) {
            ;
         } catch (IllegalAccessException var3) {
            ;
         } catch (NullPointerException var4) {
            ;
         }

         ListenerDisplay.step();
      }
   }

   public void turnAround() {
      if(!Display.isDead()) {
         try {
            this.dirchange.setInt(this, (new Integer(Display.validateDirection(this.getDirection() - 2))).intValue());
         } catch (IllegalArgumentException var2) {
            ;
         } catch (IllegalAccessException var3) {
            ;
         } catch (NullPointerException var4) {
            ;
         }

         ListenerDisplay.step();
      }
   }

   @Override
public void turnLeft() {
      if(!Display.isDead()) {
         try {
            this.dirchange.setInt(this, (new Integer(Display.validateDirection(this.getDirection() + 1))).intValue());
         } catch (IllegalArgumentException var2) {
            ;
         } catch (IllegalAccessException var3) {
            ;
         } catch (NullPointerException var4) {
            ;
         }

         ListenerDisplay.step();
      }
   }

   public void wallPhaseActive() {
      this.isWallPhasing = !this.isWallPhasing;
   }

   protected boolean getWallPhaseActive() {
      return this.isWallPhasing;
   }

   @Override
public void move() {
      boolean clear = this.frontIsClear();
      if(!clear && this.isWallPhasing) {
         System.out.println("Phasing through wall, please wait...");
         this.wallBreak();
      } else if(!clear) {
         System.out.println("Cannot continue in this direction, there is a wall! (wall phasing is currently inactive)");
      } else {
         switch(this.getDirection()) {
         case 0:
            this.teleport(this.getX() + 1, this.getY());
            break;
         case 1:
            this.teleport(this.getX(), this.getY() + 1);
            break;
         case 2:
            this.teleport(this.getX() - 1, this.getY());
            break;
         case 3:
            this.teleport(this.getX(), this.getY() - 1);
         }

         ListenerDisplay.step();
      }

   }

   public void advMove(int x) {
      while(this.z < x) {
         super.move();
         ++this.z;
      }

      this.z = 0;
   }

   public void beepMove() {
      super.putBeeper();
      super.move();
   }

   public void advBeepMove(int x) {
      while(this.z < x) {
         super.putBeeper();
         super.move();
         ++this.z;
      }

      this.z = 0;
   }

   @Override
public void putBeeper() {
      if(this.hasBeepers()) {
         if(this.getBeepers() != -2) {
            try {
               this.beepold.setInt(this, this.getBeepers() - 1);
            } catch (SecurityException var2) {
               ;
            } catch (IllegalArgumentException var3) {
               ;
            } catch (IllegalAccessException var4) {
               ;
            } catch (NullPointerException var5) {
               ;
            }
         }

         WorldBackend.getCurrent().putBeepers(this.x, this.y, 1);
         ListenerDisplay.step();
      } else {
         System.err.println("No beepers to place!");
      }

   }

   @Override
public void pickBeeper() {
      if(this.nextToABeeper()) {
         if(this.getBeepers() != -2) {
            try {
               this.beepold.setInt(this, this.getBeepers() + 1);
            } catch (SecurityException var2) {
               ;
            } catch (IllegalArgumentException var3) {
               ;
            } catch (IllegalAccessException var4) {
               ;
            } catch (NullPointerException var5) {
               ;
            }
         }

         WorldBackend.getCurrent().putBeepers(this.x, this.y, -1);
         ListenerDisplay.step();
      } else {
         System.err.println("No beepers to pick!");
      }

   }

   private void wallBreak() {
      switch(this.getDirection()) {
      case 0:
         this.teleport(this.getX() + 1, this.getY());
         break;
      case 1:
         this.teleport(this.getX(), this.getY() + 1);
         break;
      case 2:
         this.teleport(this.getX() - 1, this.getY());
         break;
      case 3:
         this.teleport(this.getX(), this.getY() - 1);
      }

      ListenerDisplay.step();
   }

   public static boolean getIsWriting() {
      return isWriting;
   }

   public static void setIsWriting(boolean setIsWriting, String name) {
      isWriting = setIsWriting;
      currentObj = name;
      File f = new File("moveCount.txt");
      if(f.exists()) {
         f.delete();
      }

   }

   public static int getMoveCount() {
      return moveCount;
   }

   public static void addMoveCount() {
      ++moveCount;
   }

   public static String getCurrObj() {
      return currentObj;
   }

   public boolean getIsBeepMoving() {
      return isBeepMoving;
   }

   public void setBeepMoving() {
      isBeepMoving = !isBeepMoving;
   }

   public static Controllable currMultiKareli(int x) {
      return (Controllable)allKareli.get(x);
   }

   public static int currAllKareliInt() {
      return allKareli.size();
   }
}
