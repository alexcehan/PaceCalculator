public class Calculator {

    String runningPace;
    //int runningPaceInSeconds;

    String pace1KM;
    String pace5KM;
    String pace10KM;
    String HalfMarathon;
    String FullMarathon;

    public Calculator(String runningPace) {
        this.runningPace = runningPace;
        calculateRaceTime(runningPace);

    }

    private int convertPaceToSeconds(String runningPace) {

        int secondsPace = 0;
        String[] split = runningPace.split(":");
        secondsPace = ((Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]));

        return secondsPace;
    }

    private void calculateRaceTime(String runningPace) {
        int runningPaceInSeconds = convertPaceToSeconds(runningPace);

       // pace1KM = ((runningPaceInSeconds / 3600) +":"+(runningPaceInSeconds % 3600 / 60) +":"+(runningPaceInSeconds % 3600 % 60));
        pace1KM = formatRaceTimes(1, runningPaceInSeconds);
        pace5KM = formatRaceTimes(5, runningPaceInSeconds);
        pace10KM = formatRaceTimes(10, runningPaceInSeconds);
        HalfMarathon = formatRaceTimes(21.0975, runningPaceInSeconds);
        FullMarathon = formatRaceTimes(42.195, runningPaceInSeconds);

    }

    public   void printRunningTimes() {
        System.out.println("Time for 1 KM will be : " + pace1KM);
        System.out.println("Time for 5 KM will be : " + pace5KM);
        System.out.println("Time for 10 KM will be : " + pace10KM);
        System.out.println("Time for HalfMarathon will be : " + HalfMarathon);
        System.out.println("Time for FullMarathon will be : " + FullMarathon);
    }

    private String formatRaceTimes(double distance, int runningPaceInSeconds) {

        int hours = (int)(distance * runningPaceInSeconds / 3600) ;
        int minutes = (int)(distance * runningPaceInSeconds % 3600) / 60;
        int seconds = (int)(distance * runningPaceInSeconds % 3600) % 60;

        String formatedTime = ((hours > 9) ? ("" + hours) : ("0" + hours)) + ":" +
                 ((minutes > 9) ? ("" + minutes) : ("0" + minutes)) + ":" +
                ((seconds > 9) ? ("" + seconds) : ("0" + seconds));

        return formatedTime;

    }





}
