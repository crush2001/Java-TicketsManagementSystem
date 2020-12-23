package ticketsmanagementsystem;

public class TrainNumNotExistException extends Exception { //车次不存在异常TrainNumNotExistException，为自定义异常类，在欲对列车号进行操作却找不到该列车号时抛出
    public TrainNumNotExistException(){
    } //无参构造方法
    public TrainNumNotExistException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
