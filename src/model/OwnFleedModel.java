package model;

import main.GameContext;

import java.util.Arrays;

/**
 * Created by an unknown Java student on 11/3/14.
 */
public class OwnFleedModel extends AbstractFleedModel
{

   public OwnFleedModel()
   {
      super(null);
   }

   @Override
   public void updateModel()
   {

   }

   public void placeNewFleed()
   {
      while (createFleet() < NUMBER_OF_SHIPS) ;
      //listener.updateView(this);
      GameContext.myFleedView.updateView(this);
   }

   private int createFleet()
   {
      int i = 0, k = 0;
      int[] shipTypes = {5, 2, 3, 4, 2, 4, 2, 3, 2, 3};

      reset();

      while (i < NUMBER_OF_SHIPS && k++ < 10000) {
         int si = 1 + (int) (DIM * Math.random());
         int sj = 1 + (int) (DIM * Math.random());

         if (checkAndPlaceShip(i + 1, si, sj, shipTypes[i], si % 2)) {
            ships[i] = new Ship(i + 1, si, sj, shipTypes[i], si % 2);
            i++;
         }
      }

      return i;
   }

   private boolean checkAndPlaceShip(int n, int si, int sj, int size, int dir)
   {
      int ci1 = si - 1;
      int cj1 = sj - 1;
      int ci2 = (dir == 0) ? si + size : si + 1;
      int cj2 = (dir == 1) ? sj + size : sj + 1;

      if (ci2 > DIM + 1 || cj2 > DIM + 1) {
         return false;
      }

      for (int j = cj1; j < cj2 + 1; j++) {
         for (int i = ci1; i < ci2 + 1; i++) {
            if (seaGrid[i][j] != 0)
               return false;
         }
      }

      for (int k = 0, i = si, j = sj; k < size; k++) {
         seaGrid[i][j] = n;
         i += (dir == 0) ? 1 : 0;
         j += (dir != 0) ? 1 : 0;
      }

      return true;
   }

}