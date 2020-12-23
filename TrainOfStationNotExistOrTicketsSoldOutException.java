package ticketsmanagementsystem;

public class TrainOfStationNotExistOrTicketsSoldOutException extends Exception { //起始站对应车次不存在异常TrainOfStationNotExistException，为自定义异常类，在余票查询系统输入起始站所对应车次不存在时抛出
    public TrainOfStationNotExistOrTicketsSoldOutException(){
    } //无参构造方法
    public TrainOfStationNotExistOrTicketsSoldOutException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
