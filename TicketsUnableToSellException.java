package ticketsmanagementsystem;

public class TicketsUnableToSellException extends Exception { //车票无法出售异常TicketSoldOutException，为自定义异常类，在售票系统输入要购买的车票数大于列车定员数时抛出
    public TicketsUnableToSellException(){
    } //无参构造方法
    public TicketsUnableToSellException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
