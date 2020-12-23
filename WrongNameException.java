package ticketsmanagementsystem;

public class WrongNameException extends Exception { //用户名错误异常WrongNameException，为自定义异常类，在登录输入用户名错误时抛出
    public WrongNameException(){
    } //无参构造方法
    public WrongNameException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
