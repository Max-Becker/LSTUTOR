package sample;

public class ControlCenter {

    private double[] correctAns = new double[4];
    private double[] incorrectAns = new double[4];
    private  int[] time = new int[4];
    private double correctState = 0;
    private double timeState = 0;
    private double state;
    static ControlCenter cc;

    protected  ControlCenter()
    { }

    public static ControlCenter getControl(){

        cc = new ControlCenter();
        return cc;
    }

    public double getState(int progress)
    {
        correctState = 0;
        timeState = 0;
        for (int i = 0; i <= progress-1; i++) {
            correctState += correctAns[i] / (correctAns[i] + incorrectAns[i]);
            timeState += (time[i]/120);
        }

        if (timeState > 1) {
            state = 100 * Math.floor(correctState * (1 - timeState));
        }
        else{
            state = correctState * 100;
        }
        state = state / progress;
        if (state > 75)
        {
            state = 3;
        }
        else if (state > 50)
        {
            state = 2;
        }
        else
        {
            state = 1;
        }
        return state;
    }

    public void setCorrect(int numberCorrect, int progress)
    {
        correctAns[progress-1] = (double)numberCorrect;
    }
    public void setTime(int time, int progress){
        this.time[progress-1] = time;
    }
    public void setIncorrectAns(int numberIncorrect, int progress)
    {        incorrectAns[progress-1] = (double)numberIncorrect;
    }

}
