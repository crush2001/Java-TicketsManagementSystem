package ticketsmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SellTicket extends NumberJudgement implements ActionListener,Common { //车票售票SellTicket类，继承抽象类NumberJudgement，实现接口ActionListener和Common
    JFrame jFrame; //新建JFrame类对象jFrame
    JTextField textField1,textField2; //新建JTextField类对象textField1,textField2
    JButton button1,button2,button3; //新建JButton类对象button1,button2,button3

    public void sellTicket() { //sellTicket()方法，构建"车票售票系统"窗口
        jFrame=new JFrame("车票售票系统"); //新建标题为"车票售票系统"的窗口
        jFrame.setSize(500,500); //设置窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.addWindowListener(new WindowAdapter() { //在窗口添加一个Windows事件消息
            @Override
            public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                jFrame.dispose(); //关闭（释放）当前窗口（即"车票售票系统"窗口）
                MainMenu mainMenu=new MainMenu(); //实例化MainMenu类对象
                mainMenu.mainMenu(); //调用对象的mainMenu方法，显示主菜单
                //即当点击"X"时，关闭（释放）"车票售票系统"窗口，显示主菜单
            }
        });
        //以下为窗口构建，使用各种窗口控件构建窗口
        JLabel label1=new JLabel("车票售票系统");
        label1.setFont(new Font(null,Font.BOLD,20));
        JLabel label2=new JLabel("所选车次");
        label2.setFont(new Font(null,Font.PLAIN,15));
        JLabel label3=new JLabel("购票张数");
        label3.setFont(new Font(null,Font.PLAIN,15));

        button1=new JButton("确认购票");
        button1.setFont(new Font(null,Font.PLAIN,15));
        button2=new JButton("重新输入");
        button2.setFont(new Font(null,Font.PLAIN,15));
        button3=new JButton("退出");
        button3.setFont(new Font(null,Font.PLAIN,15));

        textField1=new JTextField(10);
        textField1.setFont(new Font(null,Font.PLAIN,15));
        textField2=new JTextField(10);
        textField2.setFont(new Font(null,Font.PLAIN,15));

        JPanel jPanel1=new JPanel();
        jPanel1.add(label1);

        JPanel jPanel2=new JPanel();
        jPanel2.add(label2);
        jPanel2.add(textField1);

        JPanel jPanel3=new JPanel();
        jPanel3.add(label3);
        jPanel3.add(textField2);

        JPanel jPanel4=new JPanel(new FlowLayout(FlowLayout.CENTER)); //设置JPanel类对象jPanel4的布局为流式布局（FlowLayout）且设置为居中对齐（FlowLayout.CENTER）
        jPanel4.add(button1);
        jPanel4.add(button2);
        jPanel4.add(button3);
        //以上代码，新建若干个JPanel对象，并将各种界面元素添加到JPanel中

        Box box=Box.createVerticalBox(); //创建一个垂直箱容器
        box.add(jPanel1);
        box.add(jPanel2);
        box.add(jPanel3);
        box.add(jPanel4); //把上面4个JPanel串起来作为内容面板添加到箱容器

        jFrame.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
        jFrame.pack(); //依据放置的组件设定窗口的大小
        jFrame.setVisible(true); //窗口可见性置为true（可见）

        button1.addActionListener(this); //为按钮button1添加监听器
        button2.addActionListener(this); //为按钮button2添加监听器
        button3.addActionListener(this); //为按钮button3添加监听器
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) { //当点击button1时
            ticketSell(); //调用ticketSell()方法，实现售票功能
        }
        if (e.getSource()==button2) { //当点击button2时
            clearForm(); //调用clearForm()方法，清空所有文本框内容
        }
        if (e.getSource()==button3) { //当点击button3时
            exit(); //调用exit()方法，退出到主菜单
        }
    }
    private String sellTrainNum;
    private String sellTicketNum;
    private void ticketSell() { //ticketSell()方法，实现车票售票功能
        sellTrainNum =textField1.getText();
        sellTicketNum =textField2.getText(); //调用JTextField类对象的getText()方法，获得输入框中输入的字符串并赋值给相应变量
        boolean flag=true; //预先设置boolean类标识变量flag，其值置为true
        if(sellTrainNum.length()==0 || sellTicketNum.length()==0) { //如果输入的所选车次或购票张数内容长度为0（即输入内容为空）
            try {
                throw new EmptyInfoException("输入内容不完整"); //输入的所选车次或购票张数内容为空，抛出空信息异常EmptyInfoException
            } catch (EmptyInfoException e) {
                JOptionPane.showMessageDialog(jFrame,"输入内容不完整，请重新输入！","错误",JOptionPane.ERROR_MESSAGE); //捕获空信息异常EmptyInfoException，显示消息对话框，提示用户输入内容不完整
            }
        }else if(!isNumber(sellTicketNum)){ //调用isNumber()方法判断输入的购票张数是不是数字
            JOptionPane.showMessageDialog(jFrame,"输入的购票张数不是数字！","错误",JOptionPane.ERROR_MESSAGE); //若不是，弹出消息对话框，提示用户输入的购票张数不是数字
            textField2.setText(""); //清空购票张数文本框，等待用户重新输入
        }else{
            for(Iterator<Train> iterator = MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器iterator，遍历list
                Train t = iterator.next(); //运用迭代器获取下一个元素
                if(t.getTrainNum().equals(sellTrainNum)) { //如果输入的需要购买车票的车次与list中已有的车次匹配
                    flag=false; //标识变量置为false
                    if((Integer.valueOf(t.getTicketsSold())+Integer.valueOf(sellTicketNum))<=Integer.valueOf(t.getSumPassenger())) { //如果已售车票数+售票数<=列车定员数（售票数合法）
                        int a=Integer.valueOf(t.getTicketsSold()); //将已售车票数赋值给a
                        int result=a+Integer.valueOf(sellTicketNum); //将(已售车票数+售票数)赋值给result
                        String re=String.valueOf(result); //将int型数据result转换为字符串并赋值给re
                        t.setTicketsSold(re); //调用setTicketsSold()方法，将re设置为该车次对应的已售车票数
                        JOptionPane.showMessageDialog(null,"售票成功！"); //弹出消息对话框，提示用户售票成功
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }else{
                        try {
                            throw new TicketsUnableToSellException("购票数量超出该车次定员数"); //所选车次购票数量超出该车次定员数，抛出车票无法出售异常TicketsUnableToSellException
                        } catch (TicketsUnableToSellException e) {
                            JOptionPane.showMessageDialog(jFrame,"购票数量超出该车次定员数，请选择其他车次！","错误",JOptionPane.ERROR_MESSAGE); //捕获车票无法出售异常TicketsUnableToSellException，显示消息对话框，提示用户购票数量超出该车次定员数
                        }
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                }
            }
            if(flag) { //如果标识变量为真（不合法售票，售票车次不存在）
                try {
                    throw new TrainNumNotExistException("车次不存在"); //需要购买车票的车次不存在，抛出车次不存在异常TrainNumNotExistException
                } catch (TrainNumNotExistException e) {
                    JOptionPane.showMessageDialog(jFrame,"该车次不存在，请重新输入！","错误",JOptionPane.ERROR_MESSAGE); //捕获车次不存在异常TrainNumNotExistException，显示消息对话框，提示用户需要购买车票的车次不存在
                }
                clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
            }
        }
    }
    @Override //重写Common接口中的clearForm()方法
    public void clearForm() { //清空所有文本框方法clearForm()
        textField1.setText("");
        textField2.setText("");
    }
    @Override //重写Common接口中的exit()方法
    public void exit() { //exit()方法，退出到主菜单
        MainMenu mainMenu=new MainMenu(); //实例化MainMenu对象
        mainMenu.mainMenu(); //调用MainMenu对象的mainMenu()方法，显示主菜单
        jFrame.dispose(); //将当前窗口（"车票售票系统"窗口）关闭（释放）
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
