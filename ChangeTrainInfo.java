package ticketsmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class ChangeTrainInfo extends JFrame implements ActionListener,Common { //修改车次信息ChangeTrainInfo类，继承JFrame类，实现接口ActionListener和Common
    JTextField textField1; //新建JTextField类对象textField1
    JButton button1,button2,button3; //新建JButton类对象button1,button2,button3
    JFrame jFrame; //新建JFrame类对象jFrame
    public void changeTrainInfo() { //changeTrainInfo()方法，构建"修改车次信息"窗口
        jFrame=new JFrame("修改车次信息"); //新建标题为"修改车次信息"的窗口
        jFrame.setSize(500,500); //设置窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.addWindowListener(new WindowAdapter() { //在窗口添加一个Windows事件消息
            @Override
            public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                jFrame.dispose(); //关闭（释放）当前窗口（即"修改车次信息"窗口）
                MainMenu mainMenu=new MainMenu(); //实例化MainMenu类对象
                mainMenu.mainMenu(); //调用对象的mainMenu()方法，显示主菜单
                //即当点击"X"时，关闭（释放）"修改车次信息"窗口，显示主菜单
            }
        });

        //以下为窗口构建，使用各种窗口控件构建窗口
        JLabel label1=new JLabel("车次信息修改");
        label1.setFont(new Font(null,Font.BOLD,20));
        JLabel label2=new JLabel("请输入要修改的车次         ");
        label2.setFont(new Font(null,Font.PLAIN,15));
        textField1=new JTextField(10);
        textField1.setFont(new Font(null,Font.PLAIN,15));

        button1=new JButton("修改所选车次信息");
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

        JPanel jPanel3=new JPanel(new FlowLayout(FlowLayout.CENTER)); //设置JPanel类对象jPanel3的布局为流式布局（FlowLayout）且设置为居中对齐（FlowLayout.CENTER）
        jPanel3.add(button1);
        jPanel3.add(button2);
        jPanel3.add(button3);
        //以上代码，新建若干个JPanel对象，并将各种界面元素添加到JPanel中

        Box box=Box.createVerticalBox(); //创建一个垂直箱容器
        box.add(jPanel1);
        box.add(jPanel2);
        box.add(jPanel3); //把上面3个JPanel串起来作为内容面板添加到箱容器

        jFrame.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
        jFrame.pack(); //依据放置的组件设定窗口的大小
        jFrame.setVisible(true); //窗口可见性置为true（可见）

        button1.addActionListener(this); //为按钮button1添加监听器
        button2.addActionListener(this); //为按钮button2添加监听器
        button3.addActionListener(this); //为按钮button3添加监听器
    }
    public void actionPerformed(ActionEvent e) { //重写ActionListener接口中的actionPerformed(ActionEvent e)方法
        if (e.getSource()==button1) { //当点击button1时
            changeInfo(); //调用changeInfo()方法，显示修改窗口，实现列车信息修改功能
        }
        if (e.getSource()==button2) { //当点击button2时
            clearForm(); //调用clearForm()方法，清空所有文本框内容
        }
        if (e.getSource()==button3) { //当点击button3时
            exit(); //调用exit()方法，退出到主菜单
        }
    }
    private String change;
    private void changeInfo() { //changeInfo()方法，实现修改车次信息功能
        change=textField1.getText(); //调用JTextField类对象的getText()方法，获得输入框中输入的字符串并赋值给相应变量
        boolean flag=true; //预先设置boolean类标识变量flag，其值置为true
        if(change.length()==0) { //如果输入的需要修改车次的内容长度为0（即输入内容为空）
            try {
                throw new EmptyInfoException("输入内容为空"); //输入修改车次内容为空，抛出空信息异常EmptyInfoException
            } catch (EmptyInfoException e) {
                JOptionPane.showMessageDialog(this,"输入车次为空，请重新输入！","错误",JOptionPane.ERROR_MESSAGE); //捕获空信息异常EmptyInfoException，显示消息对话框，提示用户输入车次为空
            }
        }else{
            for(Iterator<Train> iterator = MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器iterator，遍历list
                Train t=iterator.next(); //运用迭代器获取下一个元素
                if(t.getTrainNum().equals(change)) { //如果输入的需要修改的车次与list中已有的车次匹配
                    flag=false; //标识变量置为false
                    Object[] selectionValues=new Object[]{"发车时刻","始发站点","行车时间","终到站点","到达时刻","列车定员"};
                    Object inputContent=JOptionPane.showInputDialog( //弹出输入对话框（下拉框选择），询问用户需要修改的项目（设置inputContent记录用户选择的修改项目）
                            this,
                            "选择要修改的项目",
                            "修改项目选择",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            selectionValues,
                            selectionValues[0] //默认选择第一个修改项目（即发车时刻startTime）
                    );
                    if(inputContent==null) { //点击"取消"按钮，输入对话框（下拉框选择）返回值为null，不执行任何操作
                    }
                    //以下代码，针对用户选择的不同修改项目，调用相关set方法，将相应项目设置为修改后的值
                    else if(inputContent.equals("发车时刻")) {
                        String changeStartTime=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的发车时刻",
                                ""
                        );
                        t.setStartTime(changeStartTime);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                    else if(inputContent.equals("始发站点")) {
                        String changeStartStation=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的始发站点",
                                ""
                        );
                        t.setStartStation(changeStartStation);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                    else if(inputContent.equals("行车时间")) {
                        String changeSumTime=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的行车时间",
                                ""
                        );
                        t.setSumTime(changeSumTime);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                    else if(inputContent.equals("终到站点")) {
                        String changeEndStation=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的终到站点",
                                ""
                        );
                        t.setEndStation(changeEndStation);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                    else if(inputContent.equals("到达时刻")) {
                        String changeEndTime=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的到达时刻",
                                ""
                        );
                        t.setEndTime(changeEndTime);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                    else if(inputContent.equals("列车定员")) {
                        String changeSumPassenger=JOptionPane.showInputDialog(
                                this,
                                "输入修改后的列车定员",
                                ""
                        );
                        t.setSumPassenger(changeSumPassenger);
                        clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
                    }
                }
            }
            if(flag) { //如果标识变量为真（未经修改）
                try {
                    throw new TrainNumNotExistException("车次不存在"); //需要删除的车次信息不存在，抛出车次不存在异常TrainNumNotExistException
                } catch (TrainNumNotExistException e) {
                    JOptionPane.showMessageDialog(this,"修改车次信息不存在！","错误",JOptionPane.ERROR_MESSAGE); //捕获车次不存在异常TrainNumNotExistException，显示消息对话框，提示用户删除的车次信息不存在
                }
                clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
            }
        }
    }
    @Override //重写Common接口中的clearForm()方法
    public void clearForm() { //清空所有文本框方法clearForm()
        textField1.setText("");
    }
    @Override //重写Common接口中的exit()方法
    public void exit() { //exit()方法，退出到主菜单
        MainMenu mainMenu=new MainMenu(); //实例化MainMenu对象
        mainMenu.mainMenu(); //调用MainMenu对象的mainMenu()方法，显示主菜单
        jFrame.dispose(); //将当前窗口（"修改车次信息"窗口）关闭（释放）
    }
}
