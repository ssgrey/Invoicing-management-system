# Invoicing-management-system

### 基于java+mysql的进销存信息管理系统

##### 1.使用方式
   下载后，import到eclipse中，在项目中有文件backup-20170406.sql导入到mysql中用来建立数据库，然后在/bin/com/hui/Dao/jdbc.properties中
填写数据库的连接参数，然后运行即可，程序入口在com.hui.login/loginDialog.java中
##### 2.实现的功能
   登录功能，进货管理，销售管理，库存管理，信息查询，商品、客户、供应商的信息管理，数据库备份与恢复
##### 3.主要实现过程
   这个项目比较简单，界面使用的swing，主要也就用到JDBC的相关技术,用到了连接池技术dbcp，数据的增删改查都写在了Dao层，由于项目比较小，并没有一个表对应一个Dao，都写在一个Dao里，比较方便像一些insert（String sql）,update(String sql),findForResultSet(String sql),findForList(String sql)都可以让各个表对应的操作共用，各个表都有对应的javabean对象，增删改查主要是针对这些对象，体现了oo思想，具体实现查看Dao.java中代码.数据库的备份用到了mysql的mysqldump，调用了cmd命令执行mysqldump.exe
##### 3.图片
![](https://github.com/Little-Grey/Invoicing-management-system/raw/master/readmeIMG/01.png)
![](https://github.com/Little-Grey/Invoicing-management-system/raw/master/readmeIMG/07.png)
![](https://github.com/Little-Grey/Invoicing-management-system/raw/master/readmeIMG/08.png)
      
