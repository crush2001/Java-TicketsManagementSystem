package ticketsmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class SearchTrainInfo extends JFrame implements ActionListener,Common { //搜索车次信息SearchTrainInfo类，继承JFrame类，实现接口ActionListener和Common
    JFrame jFrame; //新建JFrame类对象jFrame
    JButton button1,button2,button3; //新建JButton类对象button1,button2,button3
    JTextField textField; //新建JTextField类对象textField
    public void searchTrainInfo() { //searchTrainInfo()方法，构建"查询车次信息"窗口
        jFrame=new JFrame("查询车次信息"); //新建标题为"查询车次信息"的窗口
        jFrame.setSize(500,500); //设置窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                jFrame.dispose(); //关闭（释放）当前窗口（即"搜索车次信息"窗口）
                MainMenu mainMenu=new MainMenu(); //实例化MainMenu类对象
                mainMenu.mainMenu(); //调用对象的mainMenu()方法，显示主菜单
                //即当点击"X"时，关闭（释放）"搜索车次信息"窗口，显示主菜单
            }
        });

        //以下为窗口构建，使用各种窗口控件构建窗口
        JLabel label1=new JLabel("车次信息查询");
        label1.setFont(new Font(null,Font.BOLD,20));
        JLabel label2=new JLabel("请输入要查询的车次         ");
        label2.setFont(new Font(null,Font.PLAIN,15));
        textField=new JTextField(10);
        textField.setFont(new Font(null,Font.PLAIN,15));

        button1=new JButton("查找所选车次信息");
        button1.setFont(new Font(null,Font.PLAIN,15));
        button2=new JButton("重新输入");
        button2.setFont(new Font(null,Font.PLAIN,15));
        button3=new JButton("退出");
        button3.setFont(new Font(null,Font.PLAIN,15));

        JPanel jPanel1=new JPanel();
        jPanel1.add(label1);

        JPanel jPanel2=new JPanel();
        jPanel2.add(label2);
        jPanel2.add(textField);

        JPanel jPanel3=new JPanel();
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
            searchInfo(); //调用searchInfo()方法，显示查询车次信息窗口，实现车次信息查询功能
        }
        if (e.getSource()==button2) { //当点击button2时
            clearForm(); //调用clearForm()方法，清空所有文本框内容
        }
        if (e.getSource()==button3) { //当点击button3时
            exit(); //调用exit()方法，退出到主菜单
        }
    }
    private String search;
    private void searchInfo() { //searchInfo()方法，实现车次查询功能
        search=textField.getText(); //调用JTextField类对象的getText()方法，获得输入框中输入的字符串并赋值给相应变量
        boolean flag=true; //预先设置boolean类标识变量flag，其值置为true
        if(search.length()==0) { //如果输入的需要查询车次的内容长度为0（即输入内容为空）
            try {
                throw new EmptyInfoException("输入内容为空"); //输入要查询车次内容为空，抛出空信息异常EmptyInfoException
            } catch (EmptyInfoException e) {
                JOptionPane.showMessageDialog(this,"输入车次为空，请重新输入！","错误",JOptionPane.ERROR_MESSAGE); //捕获空信息异常EmptyInfoException，显示消息对话框，提示用户输入车次为空
            }
        }else{
            for(Iterator<Train> iterator = MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器iterator，遍历list
                Train t=iterator.next(); //运用迭代器获取下一个元素
                if(t.getTrainNum().equals(search)) { //如果输入的需要查询的车次与list中已有的车次匹配
                    flag=false; //标识变量置为false
                    jFrame.dispose(); //将查询车次信息窗口关闭（释放）
                    JFrame jFrame1=new JFrame("列车"+search+"的车次信息"); //新建名为"列车的车次信息"的窗口
                    jFrame1.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                            jFrame1.dispose(); //关闭（释放）当前窗口（即"列车的车次信息"窗口）
                            SearchTrainInfo searchTrainInfo=new SearchTrainInfo(); //实例化SearchTrainInfo类对象
                            searchTrainInfo.searchTrainInfo(); //调用对象的searchTrainInfo()方法，显示查询车次信息窗口
                        }
                    });

                    JPanel panel=new JPanel(new BorderLayout()); //新建布局方式为BorderLayout（边界布局）的名为panel的JPanel对象

                    JTable table = new JTable() {
                        public boolean isCellEditable(int rowIndex, int vColIndex) { //重写isCellEditable函数
                            return false;
                        }
                    }; //创建一个名为table的JTable对象
                    String[] columnNames = new String[]{"列车车次","发车时刻","始发站点","行车时间","终到站点","到达时刻","列车定员","已售车票"}; //设置表格的表头（列名）
                    DefaultTableModel dtm = (DefaultTableModel)table.getModel(); //定义一个DefaultTableModel类的对象dtm
                    dtm.setColumnIdentifiers(columnNames); //用setColumnIdentifiers替换列（即设置列名）
                    Object[] rowData=new Object[]{t.getTrainNum(),t.getStartTime(),t.getStartStation(),t.getSumTime(),t.getEndStation(),t.getEndTime(),t.getSumPassenger(),t.getTicketsSold()};
                    //将各项信息以数组形式存储
                    dtm.addRow(rowData); //用addRow()方法逐行添加数据

                    table.setPreferredScrollableViewportSize(new Dimension(400, 300)); //设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
                    JScrollPane scrollPane = new JScrollPane(table); //创建滚动面板，把表格放到滚动面板中（表头将自动添加到滚动面板顶部）
                    panel.add(scrollPane); //添加滚动面板到内容面板
                    JButton button4=new JButton("退出");
                    button4.setFont(new Font(null,Font.PLAIN,15)); //创建“退出”按钮并设置其属性

                    JTableHeader jTableHeader=table.getTableHeader(); //获取表头
                    jTableHeader.setFont(new Font(null,Font.BOLD,15)); //设置表头名称字体样式
                    jTableHeader.setForeground(Color.RED); //设置表头名称字体颜色为红色
                    jTableHeader.setResizingAllowed(false); //设置不允许手动改变列宽
                    jTableHeader.setReorderingAllowed(false); //设置不允许拖动重新排序各列

                    table.setForeground(Color.BLACK); //设置表格内容字体颜色为黑色
                    table.setFont(new Font(null,Font.PLAIN,15)); //设置表格内容字体样式
                    table.setSelectionForeground(Color.DARK_GRAY); //设置选中后字体颜色为深灰色
                    table.setSelectionBackground(Color.LIGHT_GRAY); //设置选中后字体背景颜色为浅灰色
                    table.setGridColor(Color.GRAY); //设置网格颜色为灰色

                    table.setRowHeight(30); //设置行高为30
                    table.getColumnModel().getColumn(1).setPreferredWidth(150); //第二列列宽设置为150
                    table.getColumnModel().getColumn(2).setPreferredWidth(100); //第三列列宽设置为100
                    table.getColumnModel().getColumn(4).setPreferredWidth(100); //第五列列宽设置为100
                    table.getColumnModel().getColumn(5).setPreferredWidth(150); //第六列列宽设置为150

                    panel.add(table.getTableHeader(),BorderLayout.NORTH);
                    panel.add(table,BorderLayout.CENTER);
                    panel.add(button4,BorderLayout.SOUTH); //将表头、表格主体和退出按钮按照边界布局方式添加至panel面板

                    jFrame1.setContentPane(panel); //将panel作为窗体jFrame1的内容面板
                    jFrame1.pack(); //依据放置的组件设定窗口的大小
                    jFrame1.setLocationRelativeTo(null); //将窗口置于屏幕的中央
                    jFrame1.setVisible(true); //窗口可见性置为true（可见）

                    button4.addActionListener(new ActionListener() { //设置退出按钮（button4）的监听器
                        @Override //重写ActionListener接口中的actionPerformed(ActionEvent e)方法
                        public void actionPerformed(ActionEvent e) {
                            SearchTrainInfo searchTrainInfo=new SearchTrainInfo(); //实例化SearchTrainInfo类对象
                            searchTrainInfo.searchTrainInfo(); //调用SearchTrainInfo类对象的searchTrainInfo()方法，显示"查询车次信息"窗口
                            jFrame1.dispose(); //将列车的车次信息窗口关闭（释放）
                        }
                    });
                }
            }
            if(flag) { //如果标识变量为真（搜索不到）
                try {
                    throw new TrainNumNotExistException("车次不存在"); //需要查询的车次信息不存在，抛出车次不存在异常TrainNumNotExistException
                } catch (TrainNumNotExistException e) {
                    JOptionPane.showMessageDialog(this,"查询的车次信息不存在！","错误",JOptionPane.ERROR_MESSAGE); //捕获车次不存在异常TrainNumNotExistException，显示消息对话框，提示用户查询的车次信息不存在
                }
                clearForm(); //调用clearForm()方法清空所有文本框，等待用户重新输入
            }
        }
    }
    @Override //重写Common接口中的clearForm()方法
    public void clearForm() {
        textField.setText("");
    } //清空所有文本框方法clearForm()
    @Override //重写Common接口中的exit()方法
    public void exit() { //exit()方法，退出到主菜单
        MainMenu mainMenu=new MainMenu(); //实例化MainMenu对象
        mainMenu.mainMenu(); //调用MainMenu对象的mainMenu()方法，显示主菜单
        jFrame.dispose(); //将当前窗口（"搜索车次信息"窗口）关闭（释放）
    }
}
