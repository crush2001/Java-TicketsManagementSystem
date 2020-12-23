package ticketsmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class BrowseTrainInfo implements ActionListener { //浏览车次信息BrowseTrainInfo类，实现接口ActionListener
    JFrame jFrame; //新建JFrame类对象jFrame
    JButton button1; //新建JButton类对象button1
    public void browseTrainInfo() { //browseTrainInfo()方法，构建"浏览车次信息"窗口，并实现功能
        jFrame=new JFrame("浏览车次信息"); //新建标题为"浏览车次信息"的窗口
        jFrame.addWindowListener(new WindowAdapter() { //在窗口添加一个Windows事件消息
            @Override
            public void windowClosing(WindowEvent e) { //当关闭窗口时（即点击"X"按钮时）
                jFrame.dispose(); //关闭（释放）当前窗口（即"浏览车次信息"窗口）
                MainMenu mainMenu=new MainMenu(); //实例化MainMenu类对象
                mainMenu.mainMenu(); //调用对象的mainMenu()方法，显示主菜单
                //即当点击"X"时，关闭（释放）"浏览车次信息"窗口，显示主菜单
            }
        });

        JPanel panel=new JPanel(new BorderLayout()); //新建布局方式为BorderLayout（边界布局）的名为panel的JPanel对象

        JTable table = new JTable() {
            public boolean isCellEditable(int rowIndex, int vColIndex) { //重写isCellEditable函数
                return false; //设置JTable单元格不可编辑
            }
        }; //创建一个名为table的JTable对象
        String[] columnNames = new String[]{"列车车次","发车时刻","始发站点","行车时间","终到站点","到达时刻","列车定员","已售车票"}; //设置表格的表头（列名）
        DefaultTableModel dtm = (DefaultTableModel)table.getModel(); //定义一个DefaultTableModel类的对象dtm
        dtm.setColumnIdentifiers(columnNames); //用setColumnIdentifiers替换列（即设置列名）

        for(Iterator<Train> iterator=MainMenu.list.listIterator(); iterator.hasNext();) { //设置迭代器，遍历list
            Train t = iterator.next(); //运用迭代器获取下一个元素
            Object[] rowData=new Object[]{t.getTrainNum(),t.getStartTime(),t.getStartStation(),t.getSumTime(),t.getEndStation(),t.getEndTime(),t.getSumPassenger(),t.getTicketsSold()};
            //将各项信息以数组形式存储
            dtm.addRow(rowData); //用addRow()方法逐行添加数据
        }

        BrowseTrainInfo.Error error=new Error();
        error.judge();

        table.setPreferredScrollableViewportSize(new Dimension(400, 300)); //设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        JScrollPane scrollPane = new JScrollPane(table); //创建滚动面板，把表格放到滚动面板中（表头将自动添加到滚动面板顶部）
        panel.add(scrollPane); //添加滚动面板到内容面板
        button1=new JButton("退出");
        button1.setFont(new Font(null,Font.PLAIN,15)); //创建“退出”按钮并设置其属性

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

        RowSorter<TableModel> rowSorter=new TableRowSorter<TableModel>(dtm); //使用表格模型创建行排序器（TableRowSorter实现了RowSorter）
        table.setRowSorter(rowSorter); //给表格设置行排序器

        panel.add(table.getTableHeader(),BorderLayout.NORTH);
        panel.add(table,BorderLayout.CENTER);
        panel.add(button1,BorderLayout.SOUTH); //将表头、表格主体和退出按钮按照边界布局方式添加至panel面板

        jFrame.setContentPane(panel); //将panel作为窗体jFrame的内容面板
        jFrame.pack(); //依据放置的组件设定窗口的大小
        jFrame.setLocationRelativeTo(null); //将窗口置于屏幕的中央
        jFrame.setVisible(true); //窗口可见性置为true（可见）

        button1.addActionListener(this); //为按钮button1添加监听器
    }
    public void actionPerformed(ActionEvent e) { //重写ActionListener接口中的actionPerformed(ActionEvent e)方法
        if (e.getSource()==button1) { //当点击button1时
            exit(); //调用exit()方法，退出到主菜单
        }
    }
    public void exit() { //exit()方法，退出到主菜单
        MainMenu mainMenu=new MainMenu(); //实例化MainMenu对象
        mainMenu.mainMenu(); //调用MainMenu对象的mainMenu()方法，显示主菜单
        jFrame.dispose(); //将当前窗口（"浏览车次信息"窗口）关闭（释放）
    }
    class Error extends BrowseTrainInfo {
        public void judge() {
            if(MainMenu.list.size()==0) {
                JOptionPane.showMessageDialog(jFrame,"列表为空","空列表",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}