package gui;

import model.AbstractFleedModel;

/**
 * Created by an unknown Java student on 11/3/14.
 */
public class EnemyFleedView extends AbstractFleedView
{
   public EnemyFleedView(final GridButtonHandler gridButtonHandler)
   {
      super(gridButtonHandler);
   }

   @Override
   public void updateView(AbstractFleedModel fleedModel)
   {
      for (int j = 0; j < DIM; j++) {
         for (int i = 0; i < DIM; i++) {

            int gridValue = fleedModel.getSeaGrid()[i + 1][j + 1];

            /*
            if (gridValue > 0) {
               gridButtons[i][j].setBackground(new Color(0, 0, 0));
               gridButtons[i][j].setBorder(Const.SHIP_BORDER);
               gridButtons[i][j].setText("" + ship.getSize());
            } else {
               gridButtons[i][j].setBackground(Const.EMPTY_COLOR);
               gridButtons[i][j].setBorder(Const.WATER_BORDER);
               gridButtons[i][j].setText("");
            }*/

         }
      }
   }
}
