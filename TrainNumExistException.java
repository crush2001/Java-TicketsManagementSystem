package ticketsmanagementsystem;

public class TrainNumExistException extends Exception { //车次已存在异常TrainNumExistException，为自定义异常类，在添加车次信息时输入车次信息重复时抛出
    public TrainNumExistException(){
    } //无参构造方法
    public TrainNumExistException(String msg){
        super(msg);
    } //有参构造方法，参数为String（字符串）类型
}
