package ticketsmanagementsystem;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile { //写入文件WriteToFile类
    public static void writeToFile(String fileName,String trainNum,String startTime,String startStation,String sumTime,String endStation,String endTime,String sumPassenger,String ticketsSold) {
        FileWriter fileWriter=null; //初始化写文件器
        try {
            fileWriter=new FileWriter(fileName,true); //向名为fileName的文件中追加写入数据
            fileWriter.write(trainNum+"\t");
            fileWriter.write(startTime+"\t");
            fileWriter.write(startStation+"\t");
            fileWriter.write(sumTime+"\t");
            fileWriter.write(endStation+"\t");
            fileWriter.write(endTime+"\t");
            fileWriter.write(sumPassenger+"\t");
            fileWriter.write(ticketsSold+"\r\n"); //写入各项数据
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!=null) {
                    fileWriter.close(); //关闭写文件器
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}