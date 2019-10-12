package semicolons.dashgame.backend;

import android.util.Log;

import java.util.ArrayList;

public class ObstacleContainer {
    ArrayList<SingleObstacle> data;

    public ObstacleContainer(){
        data = new ArrayList<>();
        for( int i = 0; i < 20; i++){
            data.add( new SingleObstacle( 0));
        }
    }

    public void addObstacle( int currentScore){
        data.add(0, new SingleObstacle( currentScore));
        data.remove( 20);
        Log.d("ABCD", "sizeeee " + data.size());
    }

    public int getSize(){
        return data.size();
    }

    public ArrayList<SingleObstacle> getData() {
        return data;
    }
}
