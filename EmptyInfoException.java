package ticketsmanagementsystem;

public class EmptyInfoException extends Exception { //---------------------------------------------------------------------------------------------------------，为自定义异常类，在表单信息不完整时抛出
    public EmptyInfoException(){
    } //无参构造方法
    public EmptyInfoException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
