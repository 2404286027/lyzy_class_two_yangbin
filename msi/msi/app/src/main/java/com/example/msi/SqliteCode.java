package com.example.msi;

public class SqliteCode {
    /**
     * SQLite数据库命令
     *
     * 配置环境变量
     *
     * 1、   adb shell -- 链接到数据库
     *
     * 2、   su -- 获取超级管理员权限
     *
     * 3、   cd /data/data/com.example.msi/databases -- 进入到对应数据库
     *
     * 4、   sqlite3 BookStore.db -- 使用数据库
     *
     * 5、   .table -- 查看表
     *
     * 6、   .schema -- 查看建表语句
     *
     *
     * 对于表的操作：CRUD（create、Retrieve/select、update、delete）
     * insert into Book(author,price,pages,name) values ("xx",99.98,520,"Android")
     *
     *
     * APP -- 小黄书
     * 1、用户注册、登录--database
     *  1.1、登录成功--跳转到书目列表
     *  1.2、登录失败--提醒重新登录将错误信息清空
     *
     * 2、书目列表
     *  2.1、展示所有的书列表（书名、出版社、价格、页码、作者）
     *  2.2、CURD增删改查书目列表
     *
     * 3、提交的方式
     *      github项目地址汇总给班长
     * 4、提交时间：
     *      2019/5/29
     *
     */
}
