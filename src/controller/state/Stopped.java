package controller.state;

import controller.GameEngine;
import net.NetController;
import sun.nio.ch.Net;

/**
 * Created by citizen4 on 04.11.2014.
 */
public class Stopped extends GameStateAdapter
{
   private GameEngine engine = null;

   public Stopped(final GameEngine engine)
   {
      this.engine = engine;
   }

   @Override
   public void startNetReveiver()
   {

   }

   @Override
   public void connectPeer()
   {

   }

   @Override
   public void disconnectPeer()
   {

   }

   @Override
   public void newGame()
   {

   }

   @Override
   public void abortGame()
   {

   }

   @Override
   public void stopNetReceiver()
   {

   }
}