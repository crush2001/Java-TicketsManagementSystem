package ticketsmanagementsystem;

public class TicketOverSumException extends Exception { //车票售票数超限异常TicketOverSumException，为自定义异常类，在售票系统已售车票数大于列车定员数时抛出
    public TicketOverSumException(){
    } //无参构造方法
    public TicketOverSumException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
