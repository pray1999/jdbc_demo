package jdbc_demo;

    import java.sql.*;  
    public class my {  
      public static void main(String args[]) {  
        try {  
          Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������     
          //Class.forName("org.gjt.mm.mysql.Driver");  
         System.out.println("Success loading Mysql Driver!");  
        }  
        catch (Exception e) {  
          System.out.print("Error loading Mysql Driver!");  
          e.printStackTrace();  
        }  
        try {  
          Connection connect = DriverManager.getConnection(  
              "jdbc:mysql://localhost:3306/servlet?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","jesus");  
               //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������  
      //������һ��  ?useUnicode=true&characterEncoding=utf-8&useSSL=false 
// ���������У������죺Sun Nov 15 10:34:08 CST 2020 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
     
          System.out.println("Success connect Mysql server!");  
          Statement stmt = connect.createStatement();  
          ResultSet rs = stmt.executeQuery("select * from user");  
                                                                  //user Ϊ��������  
          while (rs.next()) {  
            System.out.println("username:"+rs.getString("name"));  
            System.out.println("password:"+rs.getString("password"));
          }  
        }  
        catch (Exception e) {  
          System.out.print("get data error!");  
          e.printStackTrace();  
        }  
      }  
    }