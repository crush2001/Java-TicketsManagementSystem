package ticketsmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTrainInfo extends NumberJudgement implements ActionListener,Common { //录入车次信息InputTrainInfo类，继承抽象类NumberJudgement，实现接口ActionListener和Common
    JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8;
    //新建JTextField类对象textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8
    JButton button1,button2,button3; //新建JButton类对象button1,button2,button3
    JFrame jFrame; //新建JFrame类对象jFrame
    public void inputTrainInfo() { //inputTrainInfo()方法，构建"录入车次信息"窗口
        jFrame=new JFrame("录入车次信息"); //新建标题为"录入车次信息"的窗口
        jFrame.setSize(500,500); //设置窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.addWindowListener(new WindowAdapter() { //在窗口添加一个Windows事件消息
            @Override
            public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                jFrame.dispose(); //关闭（释放）当前窗口（即"录入车次信息"窗口）
                MainMenu mainMenu=new MainMenu(); //实例化MainMenu类对象
                mainMenu.mainMenu(); //调用对象的mainMenu()方法，显示主菜单
                //即当点击"X"时，关闭（释放）"录入车次信息"窗口，显示主菜单
            }
        });
        //以下为窗口构建，使用各种窗口控件构建窗口
        JLabel label1=new JLabel("车次信息录入");
        label1.setFont(new Font(null,Font.BOLD,20));

        JLabel label2=new JLabel("列车车次         ");
        label2.setFont(new Font(null,Font.BOLD,15));
        textField1=new JTextField(10);
        textField1.setFont(new Font(null,Font.PLAIN,15));

        JLabel label3=new JLabel("发车时刻         ");
        label3.setFont(new Font(null,Font.BOLD,15));
        textField2=new JTextField(10);
        textField2.setFont(new Font(null,Font.PLAIN,15));

        JLabel label4=new JLabel("始发站点         ");
        label4.setFont(new Font(null,Font.BOLD,15));
        textField3=new JTextField(10);
        textField3.setFont(new Font(null,Font.PLAIN,15));

        JLabel label5=new JLabel("行车时间         ");
        label5.setFont(new Font(null,Font.BOLD,15));
        textField4=new JTextField(10);
        textField4.setFont(new Font(null,Font.PLAIN,15));

        JLabel label6=new JLabel("终到站点         ");
        label6.setFont(new Font(null,Font.BOLD,15));
        textField5=new JTextField(10);
        textField5.setFont(new Font(null,Font.PLAIN,15));

        JLabel label7=new JLabel("到达时刻         ");
        label7.setFont(new Font(null,Font.BOLD,15));
        textField6=new JTextField(10);
        textField6.setFont(new Font(null,Font.PLAIN,15));

        JLabel label8=new JLabel("列车定员         ");
        label8.setFont(new Font(null,Font.BOLD,15));
        textField7=new JTextField(10);
        textField7.setFont(new Font(null,Font.PLAIN,15));

        JLabel label9=new JLabel("已售车票         ");
        label9.setFont(new Font(null,Font.BOLD,15));
        textField8=new JTextField(10);
        textField8.setFont(new Font(null,Font.PLAIN,15));

        button1=new JButton("录入车次信息");
        button1.setFont(new Font(null,Font.PLAIN,15));
        button2=new JButton("重新输入");
        button2.setFont(new Font(null,Font.PLAIN,15));
        button3=new JButton("退出");
        button3.setFont(new Font(null,Font.PLAIN,15));

        JPanel jPanel1=new JPanel();
        jPanel1.add(label1);

        JPanel jPanel2=new JPanel();
        jPanel2.add(label2);
        jPanel2.add(textField1);

        JPanel jPanel3=new JPanel();
        jPanel3.add(label3);
        jPanel3.add(textField2);

        JPanel jPanel4=new JPanel();
        jPanel4.add(label4);
        jPanel4.add(textField3);

        JPanel jPanel5=new JPanel();
        jPanel5.add(label5);
        jPanel5.add(textField4);

        JPanel jPanel6=new JPanel();
        jPanel6.add(label6);
        jPanel6.add(textField5);

        JPanel jPanel7=new JPanel();
        jPanel7.add(label7);
        jPanel7.add(textField6);

        JPanel jPanel8=new JPanel();
        jPanel8.add(label8);
        jPanel8.add(textField7);

        JPanel jPanel9=new JPanel();
        jPanel9.add(label9);
        jPanel9.add(textField8);

        JPanel jPanel10=new JPanel(new FlowLayout(FlowLayout.CENTER)); //设置JPanel类对象jPanel10的布局为流式布局（FlowLayout）且设置为居中对齐（FlowLayout.CENTER）
        jPanel10.add(button1);
        jPanel10.add(button2);
        jPanel10.add(button3);
        //以上代码，新建若干个JPanel对象，并将各种界面元素添加到JPanel中

        Box box=Box.createVerticalBox(); //创建一个垂直箱容器
        box.add(jPanel1);
        box.add(jPanel2);
        box.add(jPanel3);
        box.add(jPanel4);
        box.add(jPanel5);
        box.add(jPanel6);
        box.add(jPanel7);
        box.add(jPanel8);
        box.add(jPanel9);
        box.add(jPanel10); //把上面10个JPanel串起来作为内容面板添加到箱容器

        jFrame.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
        jFrame.pack(); //依据放置的组件设定窗口的大小
        jFrame.setVisible(true); //窗口可见性置为true（可见）

        button1.addActionListener(this); //为按钮button1添加监听器
        button2.addActionListener(this); //为按钮button2添加监听器
        button3.addActionListener(this); //为按钮button3添加监听器
    }
    private String trainNum,startTime,startStation,sumTime,endStation,endTime,sumPassenger,ticketsSold;
    public void actionPerformed(ActionEvent e) { //重写ActionListener接口中的actionPerformed(ActionEvent e)方法
        if (e.getSource()==button1) { //当点击button1时
            addInfo(); //调用addInfo()方法，实现列车信息新增功能
        }
        if (e.getSource()==button2) { //当点击button2时
            clearForm(); //调用clearForm()方法，清空所有文本框内容
        }
        if (e.getSource()==button3) { //当点击button3时
            exit(); //调用exit()方法，退出到主菜单
        }
    }
    private void addInfo() { //addInfo()方法，实现新增车次信息功能
        trainNum=textField1.getText();
        startTime=textField2.getText();
        startStation=textField3.getText();
        sumTime=textField4.getText();
        endStation=textField5.getText();
        endTime=textField6.getText();
        sumPassenger=textField7.getText();
        ticketsSold=textField8.getText(); //调用JTextField类对象的getText()方法，获得输入框中输入的字符串并赋值给相应变量

        if(trainNum.length()==0 || startTime.length()==0 || startStation.length()==0 || sumTime.length()==0 || endStation.length()==0 || endTime.length()==0 || sumPassenger.length()==0 || ticketsSold.length()==0) {
            //若任一文本框输入值为空（字符串长度为0）
            try {
                throw new EmptyInfoException("信息不完整"); //输入信息不完整，抛出空信息异常EmptyInfoException
            } catch (EmptyInfoException e) {
                JOptionPane.showMessageDialog(jFrame,"信息不完整，请补全！","错误",JOptionPane.ERROR_MESSAGE); //捕获空信息异常EmptyInfoException，显示消息对话框，提示用户信息不完整
            }
        }else{
            if(!isNumber(sumPassenger) || !isNumber(ticketsSold)){ //调用isNumber()方法判断输入的列车定员数及已售车票数是不是数字
                JOptionPane.showMessageDialog(jFrame,"输入的列车定员数或已售车票数不是数字！","错误",JOptionPane.ERROR_MESSAGE); //若不是，弹出消息对话框，提示用户输入的列车定员数或已售车票数不是数字
                textField7.setText(""); //清空列车定员文本框，等待用户重新输入
                textField8.setText(""); //清空已售车票文本框，等待用户重新输入
            }
            else if(Integer.valueOf(ticketsSold)>Integer.valueOf(sumPassenger)) { //如果已售车票数大于列车定员数
                try {
                    throw new TicketOverSumException("已售车票数超出列车定员数"); //已售车票数超出列车定员数，抛出车票售票数超限异常TicketOverSumException
                } catch (TicketOverSumException e) {
                    JOptionPane.showMessageDialog(jFrame,"已售车票数不应大于列车定员数！","错误",JOptionPane.ERROR_MESSAGE); //捕获车票售票数超限异常TicketOverSumException，显示对话框，提示用户已售车票数超出列车定员数
                }
                textField7.setText(""); //清空列车定员文本框，等待用户重新输入
                textField8.setText(""); //清空已售车票文本框，等待用户重新输入
            }else{
                Train train=new Train(trainNum,startTime,startStation,sumTime,endStation,endTime,sumPassenger,ticketsSold); //新建Train类对象train
                boolean flag=true; //预先设置boolean类标识变量flag，其值置为true
                for(Iterator<Train> iterator=MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器iterator，遍历list
                    Train t=iterator.next(); //运用迭代器获取下一个元素
                    if(t.getTrainNum().equals(trainNum)) { //如果输入的需要新增的车次与list中已有的车次匹配
                        flag=false; //标识变量置为false
                        try {
                            throw new TrainNumExistException("车次信息已存在"); //需要新增的车次信息已存在，抛出车次已存在异常TrainNumExistException
                        } catch (TrainNumExistException e) {
                            JOptionPane.showMessageDialog(jFrame,"录入车次信息已存在！","错误",JOptionPane.ERROR_MESSAGE); //捕获车次已存在异常TrainNumExistException，显示消息对话框，提示用户录入的车次信息已存在
                        }
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                }
                if(flag) { //如果标识变量为真（合法新增，即输入的车次信息经判断可以新增）
                    MainMenu.list.add(train); //调用list的add()方法，新增车次信息
                    JOptionPane.showMessageDialog(jFrame,"车次信息录入成功！"); //弹出消息对话框，提示用户车次信息录入成功
                    clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                }
            }
        }
    }
    @Override //重写Common接口中的clearForm()方法
    public void clearForm() { //清空所有文本框方法clearForm()
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
    }
    @Override //重写Common接口中的exit()方法
    public void exit() { //exit()方法，退出到主菜单
        MainMenu mainMenu=new MainMenu(); //实例化MainMenu对象
        mainMenu.mainMenu(); //调用MainMenu对象的mainMenu()方法，显示主菜单
        jFrame.dispose(); //将当前窗口（"录入车次信息"窗口）关闭（释放）
    }
    @Override //重写抽象类抽象类NumberJudgement中的抽象方法isNumber(String str)
    public boolean isNumber(String str){ //判断字符串是否是数字方法isNumber(String str)，返回值为boolean类型
        Pattern pattern=Pattern.compile("[0-9]*"); //预编译正则表达式，匹配所有数字
        Matcher isNum=pattern.matcher(str); //判断字符串str是否匹配正则表达式
        if(!isNum.matches()){
            return false; //不匹配返回false
        }
        return true; //其他情况（匹配）返回true
    }
}
