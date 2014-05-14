
import Core.GridGame.Observers.Observable;
import Core.TetrisGame.TetrisCore;
import UI.MainFrame;
import java.awt.Color;




/**
 * class for debugging Project
 * @author Antoine
 */
public class TetrisTest extends Observable {

    public TetrisTest() {
        super();
    }
    
    public static void main(String[] args) {
        MainFrame tetrisScreen=new MainFrame();
        TetrisCore test=new TetrisCore();
        
        test.getGrid().addGridObserver(tetrisScreen);
        test.getInfo().addScoreBoardObserver(tetrisScreen.getScoreBoard());
        /*
        Color[][] tab=new Color[20][10];
        for(int i=0;i<20;i++){
            for(int j=0;j<10;j++){
                tab[i][j]=Color.white;
            }
        }
        test.getGrid().fireUpdatedGrid(tab);*/
        tetrisScreen.setVisible(true);
        
        test.initGame();
    }
}
