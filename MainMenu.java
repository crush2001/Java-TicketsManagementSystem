package ticketsmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainMenu { //主菜单MainMenu类
    public static final java.util.List<Train> list=new ArrayList<Train>(); //运用泛型，建立集合对象
    public void mainMenu() { //显示主菜单方法mainMenu()
        JFrame jFrame=new JFrame("主菜单"); //新建标题为"主菜单"的窗口
        jFrame.setSize(500,500); //设置窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置"X"按钮为直接关闭该程序

        JMenuBar menuBar=new JMenuBar(); //创建一个菜单栏
        JMenu manageMenu=new JMenu("操作"); //创建名为"操作"的一级菜单
        menuBar.add(manageMenu); //将"操作"一级菜单添加到菜单栏
        JMenuItem aboutItem=new JMenuItem("关于"); //创建"操作"一级菜单的子菜单"关于"
        JMenuItem exitItem=new JMenuItem("退出"); //创建"操作"一级菜单的子菜单"退出"
        manageMenu.add(aboutItem); //将"关于"子菜单添加到"操作"一级菜单中
        manageMenu.add(exitItem); //将"退出"子菜单添加到"操作"一级菜单中
        aboutItem.addActionListener(new ActionListener() { //设置"退出"子菜单被点击的监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                //以下代码构建"关于本程序"窗口
                JFrame aboutFrame=new JFrame("关于该程序"); //新建标题为"关于该程序"的窗口
                aboutFrame.setSize(500,500); //设置窗口的大小
                aboutFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
                aboutFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //点击关闭"X"按钮，关闭（释放）"关于该程序"窗口

                JLabel aboutLabel1=new JLabel("该程序是一个车票管理系统");
                JLabel aboutLabel2=new JLabel("可实现车次信息和车票信息的增、删、改、查等基本功能");
                JLabel aboutLabel3=new JLabel("作者：闽南师范大学 计算机学院 19计科2班 翁辰龙");
                aboutLabel1.setFont(new Font(null,Font.PLAIN,15));
                aboutLabel2.setFont(new Font(null,Font.PLAIN,15));
                aboutLabel3.setFont(new Font(null,Font.PLAIN,15));

                JPanel aboutPanel1=new JPanel();
                JPanel aboutPanel2=new JPanel();
                JPanel aboutPanel3=new JPanel();
                aboutPanel1.add(aboutLabel1);
                aboutPanel2.add(aboutLabel2);
                aboutPanel3.add(aboutLabel3);

                Box box=Box.createVerticalBox(); //创建一个垂直箱容器
                box.add(aboutPanel1);
                box.add(aboutPanel2);
                box.add(aboutPanel3); //把上面3个JPanel串起来作为内容面板添加到箱容器

                aboutFrame.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
                aboutFrame.pack(); //依据放置的组件设定窗口的大小
                aboutFrame.setVisible(true); //窗口可见性置为true（可见）
            }
        });
        exitItem.addActionListener(new ActionListener() { //设置"退出"子菜单被点击的监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            } //点击后直接退出系统，结束程序执行
        });
        jFrame.setJMenuBar(menuBar); //把菜单栏设置到窗口

        GridLayout layout=new GridLayout(3,4); //定义layout为3行4列的网格布局（GridLayout）
        JPanel panel=new JPanel(layout); //设置JPanel类对象panel的布局为layout
        JPanel first=new JPanel(new FlowLayout(FlowLayout.CENTER)); //设置JPanel类对象first的布局为流式布局（FlowLayout）且设置为居中对齐（FlowLayout.CENTER）
        JPanel second=new JPanel(new FlowLayout(FlowLayout.CENTER)); //设置JPanel类对象second的布局为流式布局（FlowLayout）且设置为居中对齐（FlowLayout.CENTER）
        //以下为窗口构建，使用各种窗口控件构建窗口
        JLabel label=new JLabel("欢迎进入车票管理系统！");
        label.setFont(new Font(null,Font.BOLD,20));
        JLabel logo=new JLabel();
        logo.setIcon(new ImageIcon("logo.jpg"));
        JButton button1=new JButton("录入车次信息");
        button1.setFont(new Font(null,Font.BOLD,15));
        JButton button2=new JButton("修改车次信息");
        button2.setFont(new Font(null,Font.BOLD,15));
        JButton button3=new JButton("删除车次信息");
        button3.setFont(new Font(null,Font.BOLD,15));
        JButton button4=new JButton("浏览车次信息");
        button4.setFont(new Font(null,Font.BOLD,15));
        JButton button5=new JButton("查询车次信息");
        button5.setFont(new Font(null,Font.BOLD,15));
        JButton button6=new JButton("车票售票系统");
        button6.setFont(new Font(null,Font.BOLD,15));
        JButton button7=new JButton("车票退票系统");
        button7.setFont(new Font(null,Font.BOLD,15));
        JButton button8=new JButton("余票查询系统");
        button8.setFont(new Font(null,Font.BOLD,15));
        JButton button9=new JButton("生成备份文件");
        button9.setFont(new Font(null,Font.BOLD,15));
        JButton button10=new JButton("读取备份文件");
        button10.setFont(new Font(null,Font.BOLD,15));
        JButton button11=new JButton("退出登录状态");
        button11.setFont(new Font(null,Font.BOLD,15));

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        first.add(label);
        second.add(logo);
        //运用JPanel类的add()方法将窗口组件添加到相应的JPanel类对象中

        Box box=Box.createVerticalBox(); //创建一个垂直箱容器
        box.add(first);
        box.add(second);
        box.add(panel);

        jFrame.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
        jFrame.pack(); //依据放置的组件设定窗口的大小
        jFrame.setVisible(true); //窗口可见性置为true（可见）

        //以下代码设置button1到button11各按钮的点击事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputTrainInfo iti=new InputTrainInfo();
                iti.inputTrainInfo();
                jFrame.dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeTrainInfo cti=new ChangeTrainInfo();
                cti.changeTrainInfo();
                jFrame.dispose();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTrainInfo dti=new DeleteTrainInfo();
                dti.deleteTrainInfo();
                jFrame.dispose();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrowseTrainInfo bti=new BrowseTrainInfo();
                bti.browseTrainInfo();
                jFrame.dispose();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchTrainInfo sti=new SearchTrainInfo();
                sti.searchTrainInfo();
                jFrame.dispose();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellTicket st=new SellTicket();
                st.sellTicket();
                jFrame.dispose();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawTicket wt=new WithdrawTicket();
                wt.withdrawTicket();
                jFrame.dispose();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchRemainTickets srt=new SearchRemainTickets();
                srt.searchRemainTickets();
                jFrame.dispose();
            }
        });
        //以上button1到button8，实例化相关对象并调用对象的相关方法显示窗口，并关闭（释放）主菜单
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog( //弹出确认对话框，询问用户是否确认生成备份文件（设置result记录对话框按钮点击后的返回值）
                        jFrame,
                        "确认生成备份文件吗？",
                        "生成备份文件确认",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if(result==0){ //当点击对话框中的"是"按钮时（对话框按钮点击后的返回值为0）
                    File file=new File("data.dat"); //新建名为data.dat的文件，用于存储列车及车票信息数据
                    if(file.exists()) {
                        file.delete(); //如果data.dat文件存在，则删除该文件
                    }
                    for(Iterator<Train> iterator = MainMenu.list.listIterator(); iterator.hasNext();) {  //设置迭代器iterator，遍历list
                        Train t = iterator.next(); //运用迭代器获取下一个元素
                        WriteToFile.writeToFile("data.dat", t.getTrainNum(), t.getStartTime(), t.getStartStation(), t.getSumTime(), t.getEndStation(), t.getEndTime(), t.getSumPassenger(), t.getTicketsSold());
                        //调用WriteToFile类的writeToFile()方法，向data.dat文件中写入列车及车票数据
                    }
                    JOptionPane.showMessageDialog(jFrame,"备份文件生成成功！"); //写入完成后，显示消息对话框，提示备份文件生成成功
                }
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog( //弹出确认对话框，询问用户是否确认读取备份文件（设置result记录对话框按钮点击后的返回值）
                        jFrame,
                        "确认读取备份文件吗？",
                        "读取备份文件确认",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if(result==0){ //当点击对话框中的"是"按钮时（对话框按钮点击后的返回值为0）
                    try {
                        ReadFromFile.readFromFile(); //调用ReadFromFile类的readFromFile()方法，从data.dat文件中读取列车及车票数据，并写入list中
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(jFrame,"备份文件读取成功！"); //读取、写入list操作完成后，显示消息对话框，提示备份文件读取成功
                }
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog( //弹出确认对话框，询问用户是否退出登录并返回主菜单（设置result记录对话框按钮点击后的返回值）
                        jFrame,
                        "确认退出登录吗？",
                        "退出登录确认",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if(result==0){ //当点击对话框中的"是"按钮时（对话框按钮点击后的返回值为0）
                    Login login=new Login(); //实例化Login对象
                    login.login(); //调用Login对象的login()方法，显示登录窗口
                    jFrame.dispose(); //将当前窗口（"主菜单"窗口）关闭（释放）
                }
            }
        });
    }
}