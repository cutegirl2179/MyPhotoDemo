package com.wyn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDemo {
    public static void main(String[] args) {
        InsrtPicToDB();
    }

    public static void InsrtPicToDB(){

        //连接数据库
        Connection conn = null;
        PreparedStatement pst = null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //获取数据库的连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "123456");

            //定义SQL语句
            String sql = "insert into photo(name,photo) values (?,?)";

            //照片所在文件的路径
            String filepath = "H:\\img";
            File file = new File(filepath);
            String [] filelist = file.list();

            //执行SQL语句
            pst = conn.prepareStatement(sql);

            int m = 0;
            for(int i=0;i<filelist.length;i++) {//循环遍历文件的目录
                File reaFile = new File(filepath + "\\" + filelist[i]);
                FileInputStream fis = new FileInputStream(reaFile);
                String photoName = "";
                photoName = filelist[i].substring(0, 6); //保存文件名当做一个字段的值
                photoName = filelist[i];
                pst.setString(1, photoName);
                pst.setBinaryStream(2, fis, (int) reaFile.length());
                m++;
                int n = pst.executeUpdate();
                System.out.println(n + "条记录已经插入");
            }
            System.out.println("本次一共导入" + m + "条");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if(pst != null){
                    pst.close();
                }
                if(conn != null){
                    conn.close();
                }
                System.out.println("数据库关闭666");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
