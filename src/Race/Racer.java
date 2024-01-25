package Race;

public class Racer implements Runnable {
    private static int globalId=1;
    private int id;
    private int speed;
    private Track track;

    public static void setGlobalId(int globalId) {
        Racer.globalId = globalId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpeed(int speed) {
        if(speed>=1||speed<=10){
            this.speed = speed;
        }
        else {
            this.speed = 0;
            System.out.print("invalid input speed has been setted to 1,please choose a value between 1 to 10.");
        }
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public static int getGlobalId() {
        return globalId;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public Track getTrack() {
        return track;
    }
    public Racer(int speed,Track track){
        setSpeed(speed);
        setTrack(track);
        this.id=globalId;
        globalId++;

    }
    public void go(){
        Thread thread=new Thread(this);
        thread.setPriority(this.getSpeed());
        for(int i=0;i<=100;i++){
            System.out.println("runner"+" "+this.getId()+" "+"ran"+" "+i+" "+"meters");
            if(i==100){
                System.out.println("Runner"+" "+getId()+" "+"finished 100 meters!");
                track.setFinishedRacers(1);
                System.out.println("Runner"+this.getId()+" "+"finished"+" "+track.getFinishedRacers()+"st!" );
            }
        }


    }

    @Override
    public void run() {
    go();
    }
}
