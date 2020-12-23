package ticketsmanagementsystem;

public class WdTicketOverSoldException extends Exception { //车票退票数超过已售车票数异常WdTicketOverSoldException，为自定义异常类，在退票系统输入退票数超过已售车票数时抛出
    public WdTicketOverSoldException(){
    } //无参构造方法
    public WdTicketOverSoldException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
