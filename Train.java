package ticketsmanagementsystem;

public class Train { //火车（Train）类
    private String trainNum;
    private String startTime;
    private String startStation;
    private String sumTime;
    private String endStation;
    private String endTime;
    private String sumPassenger;
    private String ticketsSold; //定义相关变量

    public Train() {
        super();
    } //无参构造方法
    public Train(String trainNum,String startTime,String startStation,String sumTime,String endStation,String endTime,String sumPassenger,String ticketsSold) {
        this.trainNum=trainNum;
        this.startTime=startTime;
        this.startStation=startStation;
        this.sumTime=sumTime;
        this.endStation=endStation;
        this.endTime=endTime;
        this.sumPassenger=sumPassenger;
        this.ticketsSold=ticketsSold;
    } //有参构造方法

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getSumTime() {
        return sumTime;
    }

    public void setSumTime(String sumTime) {
        this.sumTime = sumTime;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSumPassenger() {
        return sumPassenger;
    }

    public void setSumPassenger(String sumPassenger) {
        this.sumPassenger = sumPassenger;
    }

    public String getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(String ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    //设定针对各变量的相应的set-get方法
}
