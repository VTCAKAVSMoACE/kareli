package com.crump.kareli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;

@SuppressWarnings("all")
public class KeyHandlerSuperclass {

   private static Class c = null;
   static PrintWriter out = null;


   public KeyHandlerSuperclass() {}

   public KeyHandlerSuperclass(KeyHandlerSuperclass k) {
      startHandling(k);
   }

   private static void fileWriter(String s) {
      try {
         out = new PrintWriter(new BufferedWriter(new FileWriter(s + ".java", true)));
      } catch (IOException var2) {
         ;
      }

   }

   public static void startHandling(KeyHandlerSuperclass k) {
      c = k.getClass();
   }

   public static void makeKeyHandlingTemplate() {
      String s = JOptionPane.showInputDialog("What do you want your file to be called?");
      File f = new File(s + ".java");
      if(f.exists()) {
         System.out.println("File " + s + ".java already exists, please use another name.");
         makeKeyHandlingTemplate();
      } else {
         String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "up", "right", "left", "down", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
         fileWriter(s);
         out.println("import com.crump.kareli.*;");
         out.println();
         out.println("public class " + s + " extends KeyHandlerSuperclass {");
         out.println("   /** Allows the superclass KeyHandler to respond to input of this subclass. Do not edit! */");
         out.println("   public " + s + "() {");
         out.println("      super();");
         out.println("      super.startHandling(this);");
         out.println("   }");

         for(int k = 0; k < alphabet.length; ++k) {
            out.println("   /** Handles the \'" + alphabet[k] + "\' keypress. */");
            out.println("   public static void " + alphabet[k] + "Handler() {}");
            out.println("   /** Handles the \'" + alphabet[k] + "\' keypress for multi-input. */");
            out.println("   public static void " + alphabet[k] + "MultiHandler() {}");
         }

         out.println("}");
         out.close();
      }

   }

   public static void aHandler() {
      try {
         Method m = c.getDeclaredMethod("aHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void aMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("aMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void bHandler() {
      try {
         Method m = c.getDeclaredMethod("bHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void bMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("bMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void cHandler() {
      try {
         Method m = c.getDeclaredMethod("cHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void cMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("cMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void dHandler() {
      try {
         Method m = c.getDeclaredMethod("dHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void dMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("dMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void eHandler() {
      try {
         Method m = c.getDeclaredMethod("eHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void eMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("eMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void fHandler() {
      try {
         Method m = c.getDeclaredMethod("fHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void fMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("fMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void gHandler() {
      try {
         Method m = c.getDeclaredMethod("gHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void gMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("gMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void hHandler() {
      try {
         Method m = c.getDeclaredMethod("hHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void hMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("hMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void iHandler() {
      try {
         Method m = c.getDeclaredMethod("iHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void iMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("iMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void jHandler() {
      try {
         Method m = c.getDeclaredMethod("jHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void jMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("jMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void kHandler() {
      try {
         Method m = c.getDeclaredMethod("kHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void kMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("kMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void lHandler() {
      try {
         Method m = c.getDeclaredMethod("lHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void lMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("lMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void mHandler() {
      try {
         Method m = c.getDeclaredMethod("mHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void mMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("mMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void nHandler() {
      try {
         Method m = c.getDeclaredMethod("nHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void nMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("nMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void oHandler() {
      try {
         Method m = c.getDeclaredMethod("oHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void oMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("oMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void pHandler() {
      try {
         Method m = c.getDeclaredMethod("pHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void pMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("pMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void qHandler() {
      try {
         Method m = c.getDeclaredMethod("qHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void qMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("qMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void rHandler() {
      try {
         Method m = c.getDeclaredMethod("rHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void rMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("rMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void sHandler() {
      try {
         Method m = c.getDeclaredMethod("sHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void sMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("sMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void tHandler() {
      try {
         Method m = c.getDeclaredMethod("tHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void tMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("tMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void uHandler() {
      try {
         Method m = c.getDeclaredMethod("uHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void uMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("uMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void vHandler() {
      try {
         Method m = c.getDeclaredMethod("vHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void vMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("vMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void wHandler() {
      try {
         Method m = c.getDeclaredMethod("wHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void wMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("wMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void xHandler() {
      try {
         Method m = c.getDeclaredMethod("xHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void xMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("xMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void yHandler() {
      try {
         Method m = c.getDeclaredMethod("yHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void yMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("yMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void zHandler() {
      try {
         Method m = c.getDeclaredMethod("zHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void zMultiHandler() {
      try {
         Method m = c.getDeclaredMethod("zMultiHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void upHandler() {
      try {
         Method m = c.getDeclaredMethod("upHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void leftHandler() {
      try {
         Method m = c.getDeclaredMethod("leftHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void rightHandler() {
      try {
         Method m = c.getDeclaredMethod("rightHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void downHandler() {
      try {
         Method m = c.getDeclaredMethod("downHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void oneHandler() {
      try {
         Method m = c.getDeclaredMethod("oneHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void twoHandler() {
      try {
         Method m = c.getDeclaredMethod("twoHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void threeHandler() {
      try {
         Method m = c.getDeclaredMethod("threeHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void fourHandler() {
      try {
         Method m = c.getDeclaredMethod("fourHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void fiveHandler() {
      try {
         Method m = c.getDeclaredMethod("fiveHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void sixHandler() {
      try {
         Method m = c.getDeclaredMethod("sixHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void sevenHandler() {
      try {
         Method m = c.getDeclaredMethod("sevenHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void eightHandler() {
      try {
         Method m = c.getDeclaredMethod("eightHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void nineHandler() {
      try {
         Method m = c.getDeclaredMethod("nineHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }

   public static void zeroHandler() {
      try {
         Method m = c.getDeclaredMethod("zeroHandler", new Class[0]);
         m.setAccessible(true);
         m.invoke((Object)null, new Object[0]);
      } catch (Exception var1) {
         ;
      }

   }
}
