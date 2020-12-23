package ticketsmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends SystemStateManagement implements ActionListener { //登录Login类，继承抽象类SystemStateManagement，实现接口ActionListener
    JFrame jf; //定义JFrame类型对象jf
    JTextField textField1; //定义JTextField类型（文本输入框）对象textField1
    JPasswordField passwordField1; //定义JPasswordField类型（密码输入框）对象passwordField1
    JButton button1,button2; //定义JButton类型（按钮）对象button1和button2
    static final String adminName="Admin"; //定义管理员账号（字符串）为"Admin"
    static final String adminPassword="admin"; //定义管理员密码（字符串）为"admin"
    @Override
    public void login() { //重写抽象类SystemStateManagement中的login()方法
        jf=new JFrame("车票管理系统"); //新建标题为"车票管理系统"的窗口
        jf.setSize(500,500); //设置窗口的大小
        jf.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置"X"按钮为直接关闭该程序

        // 以下代码为设置窗口中各组件的各项属性，构建出登录界面
        JLabel label1=new JLabel("欢迎使用车票管理系统 Ver 2.10！");
        label1.setFont(new Font(null,Font.BOLD,20));
        JLabel label2=new JLabel("请使用管理员账号及密码登录该系统");
        label2.setFont(new Font(null,Font.ITALIC,15));
        JLabel logo=new JLabel();
        logo.setIcon(new ImageIcon("logo.jpg"));
        JLabel label3=new JLabel("管理员账号");
        label3.setFont(new Font(null,Font.PLAIN,20));
        JLabel label4=new JLabel("管理员密码");
        label4.setFont(new Font(null,Font.PLAIN,20));
        JLabel label5=new JLabel("作者：1908170232 翁辰龙");
        label5.setFont(new Font(null,Font.PLAIN,15)); //登录界面JLabel元素

        button1=new JButton("登录系统");
        button1.setFont(new Font(null,Font.PLAIN,20));
        jf.getRootPane().setDefaultButton(button1); //设置默认按钮为button1（即"登录系统"按钮）
        button2=new JButton("退出系统");
        button2.setFont(new Font(null,Font.PLAIN,20)); //登录界面JButton元素

        textField1=new JTextField(10);
        textField1.setFont(new Font(null,Font.PLAIN,20)); //登录界面JTextField元素
        passwordField1=new JPasswordField(10);
        passwordField1.setFont(new Font(null,Font.PLAIN,20)); //登录界面JPasswordField元素

        JPanel jPanel1=new JPanel();
        jPanel1.add(label1);

        JPanel jPanel2=new JPanel();
        jPanel2.add(label2);

        JPanel logoPanel=new JPanel();
        logoPanel.add(logo);

        JPanel jPanel3=new JPanel();
        jPanel3.add(label3);
        jPanel3.add(textField1);

        JPanel jPanel4=new JPanel();
        jPanel4.add(label4);
        jPanel4.add(passwordField1);

        JPanel jPanel5=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel5.add(button1);
        jPanel5.add(button2);

        JPanel jPanel6=new JPanel();
        jPanel6.add(label5);
        //以上代码，新建若干个JPanel对象，并将各种界面元素添加到JPanel中

        Box box=Box.createVerticalBox(); //创建一个垂直箱容器
        box.add(jPanel1);
        box.add(jPanel2);
        box.add(logoPanel);
        box.add(jPanel3);
        box.add(jPanel4);
        box.add(jPanel5);
        box.add(jPanel6); //把上面7个JPanel串起来作为内容面板添加到箱容器

        jf.setContentPane(box); //把垂直箱容器作为内容面板设置到窗口
        jf.pack(); //依据放置的组件设定窗口的大小
        jf.setVisible(true); //窗口可见性置为true（可见）

        button1.addActionListener(this); //为按钮button1添加监听器
        button2.addActionListener(this); //为按钮button2添加监听器
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) { //当点击button1时
            loginSystem(); //调用loginSystem()方法，登录系统
        }
        if (e.getSource()==button2) { //当点击button2时
            exitSystem(); //调用exitSystem()方法，退出系统
        }
    }
    @Override
    public void loginSystem() { //重写抽象类SystemStateManagement中的loginSystem()方法
        String inputName=textField1.getText(); //获取textField1中输入的字符串并赋值给inputName，作为输入的账号
        String inputPassword= String.valueOf(passwordField1.getPassword()); //获取passwordField1中输入的字符串并赋值给inputPassword，作为的输入密码
        if(inputName.equals(adminName) && inputPassword.equals(adminPassword)) { //如果输入的账号密码与预设的账号密码相同
            jf.setVisible(false); //设置登陆界面不显示（false）
            MainMenu mainMenu = new MainMenu(); //创建MainMenu类的对象mainMenu
            mainMenu.mainMenu(); //调用MainMenu()方法显示主菜单
        }
        else if(inputName.equals("") || inputPassword.equals("")) { //如果输入的账号或密码或二者均为空
            try {
                throw new EmptyInfoException("账号或密码为空"); //抛出EmptyInfoException异常
            } catch (EmptyInfoException e) { //捕获EmptyInfoException异常
                JOptionPane.showMessageDialog( //弹出警告对话框提示账号或密码为空
                        jf,
                        "账号或密码为空，请重新输入！",
                        "账号或密码为空",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            textField1.setText(""); //将textField1置空
            passwordField1.setText(""); //将passwordField1置空
        }
        else if(!inputName.equals(adminName)) { //如果输入的账号与预设的管理员账号不符
            try {
                throw new WrongNameException("账号错误"); //抛出WrongNameException异常
            } catch (WrongNameException e) { //捕获WrongNameException异常
                JOptionPane.showMessageDialog( //弹出警告对话框提示账号错误
                        jf,
                        "您输入的账号错误，请重新输入！",
                        "账号错误",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            textField1.setText(""); //将textField1置空
            passwordField1.setText(""); //将passwordField1置空
        }
        else if(inputName.equals(adminName) && !inputPassword.equals(adminPassword)) { //如果输入的账号正确，但输入的密码与预设的管理员密码不符
            try {
                throw new WrongPasswordException("密码错误"); //抛出WrongPasswordException异常
            } catch (WrongPasswordException e) { //捕获WrongPasswordException异常
                JOptionPane.showMessageDialog( //弹出警告对话框提示密码错误
                        jf,
                        "您输入的密码错误，请重新输入！",
                        "密码错误",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            passwordField1.setText(""); //将passwordField1置空
        }
    }
    @Override
    public void exitSystem() {
        System.exit(0);
    } //重写抽象类SystemStateManagement中的exitSystem()方法，退出系统
}