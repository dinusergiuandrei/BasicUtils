package progress;

public class TimeKeeper {
    Long startTime = System.currentTimeMillis();

    public Long tic(){
        startTime = System.currentTimeMillis();
        return startTime;
    }

    public Long tic(String message){
        System.out.println(message);
        startTime = System.currentTimeMillis();
        return startTime;
    }

    public Long toc(){
        return (System.currentTimeMillis() - startTime);
    }

    public Long toc(String message){
        Long time = System.currentTimeMillis() - startTime;
        System.out.println(message + " ( " + time / 1000.0 + " seconds )");
        return time;
    }
}
