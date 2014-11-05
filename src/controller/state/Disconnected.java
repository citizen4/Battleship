package controller.state;

import controller.GameEngine;
import gui.Dialogs;
import net.NetController;
import net.protocol.Message;
import org.pmw.tinylog.Logger;

/**
 * Created by citizen4 on 04.11.2014.
 */
public class Disconnected extends GameStateAdapter
{

   private GameEngine engine = null;

   public Disconnected(final GameEngine engine)
   {
      this.engine = engine;
   }

   @Override
   public void startNetReveiver()
   {
      Logger.warn("Net Receiver already up and running");
   }

   @Override
   public void connectPeer()
   {
      String peerIp = null;
      if ((peerIp = Dialogs.requestPeerIp()) != null) {
         Message connectMsg = new Message();
         connectMsg.SUB_TYPE = Message.CONNECT;
         engine.getNetController().sendMessage(connectMsg, peerIp);
         engine.setState(new Connecting(engine));
      }
   }

   @Override
   public void disconnectPeer()
   {
      Dialogs.showInfo("No Player connected!");
   }

   @Override
   public void newGame()
   {
      Dialogs.showInfo("No Player connected!");
   }

   @Override
   public void abortGame()
   {
      Dialogs.showInfo("No Game running!");
   }

   @Override
   public void stopNetReceiver()
   {
      engine.getNetController().stopReceiverThread();
      engine.setState(new Stopped(engine));
   }

}