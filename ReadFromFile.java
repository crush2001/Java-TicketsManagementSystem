package ticketsmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromFile { //从文件中读取ReadFromFile类
    public static void readFromFile() throws IOException {
        FileReader fr=null; //初始化读文件器
        int i;
        fr=new FileReader("data.dat"); //自文件名为data.dat的文件中读取数据
        BufferedReader br=new BufferedReader(fr); //创建一个缓冲字符输入流
        String line=br.readLine(); //逐行读取数据
        while(line!=null) { //当该行存在时
            if(line.equals("")) { //当该行存在但为空时
                line=br.readLine(); //逐行读取数据
                continue; //结束本次循环
            }
            Train t=new Train(); //新建Train类对象t
            String[] tmp=line.split("\\s"); //创建tmp数组
            for(i=0;i<tmp.length;i++) {
                switch (i) { //switch-case，调用相关set方法
                    case 0:
                        t.setTrainNum(tmp[i]);
                        break;
                    case 1:
                        t.setStartTime(tmp[i]);
                        break;
                    case 2:
                        t.setStartStation(tmp[i]);
                        break;
                    case 3:
                        t.setSumTime(tmp[i]);
                        break;
                    case 4:
                        t.setEndStation(tmp[i]);
                        break;
                    case 5:
                        t.setEndTime(tmp[i]);
                        break;
                    case 6:
                        t.setSumPassenger(tmp[i]);
                        break;
                    case 7:
                        t.setTicketsSold(tmp[i]);
                        break;
                }
            }
            boolean isHave=true; //设置boolean类型变量isHave，判断读取到的车次信息是否已存在
            for(Iterator<Train> iterator = MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器，遍历list
                Train train = iterator.next(); //运用迭代器获取下一个元素
                if(train.getTrainNum().equals(tmp[0])) { //如果读取到的车次信息与list中的车次信息重复
                    isHave=false; //isHave置为false
                }
            }
            if(isHave) { //当isHave为true时，即读取到的车次信息不在list中时
                MainMenu.list.add(t); //往list中添加该数据
            }
            line=br.readLine(); //逐行读取数据
        }
        fr.close(); //关闭读文件器
    }

}
