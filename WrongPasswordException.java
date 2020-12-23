package ticketsmanagementsystem;

public class WrongPasswordException extends Exception { //密码错误异常WrongPasswordException，为自定义异常类，在登录输入密码错误时抛出
    public WrongPasswordException(){
    } //无参构造方法
    public WrongPasswordException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
