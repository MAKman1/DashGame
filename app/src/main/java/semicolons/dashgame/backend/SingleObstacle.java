package semicolons.dashgame.backend;

public class SingleObstacle {
    boolean isObstacle;
    int currentScore;

    public SingleObstacle( int currentScore){
        this.currentScore = currentScore;
        isObstacle = calculateObstacle();
    }
    public boolean isObstacle(){
        return isObstacle;
    }

    private boolean calculateObstacle(){
        //calculate the percentage
        int percentage = (int) (Math.random() * 100) + 1;


        if( currentScore < 2500){
            if( percentage > 50){
                return true;
            }
            else
                return false;
        }
        else{
            if( percentage > 30){
                return true;
            }
            else
                return false;
        }
    }
}
