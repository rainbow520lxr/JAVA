网络编程

windows常用命令

ipconfig查看IP地址

ping发送包，看是否能与其他IP地址联通，是否网络接通

tracert 119.75.26.30
查看路由所经过的哪些IP地址，每次都不一样，一般经过13个左右

netstat  -an 查看那些端口被监听

netstat -anb 
查看端口

IP地址 a,b,c,d,e

a类地址  0|7位网络号|主机号   1个字节的网络地址 ，3个字节的主机号  1.0.0.0至127.255.255.255 可以表示非常多的主机

b类地址 10|14位网络号|主机号   2个字节的网络地址，2个字节的主机号                            128.0.0.0至191.255.255.255

c类地址 110|21位网络号             3个字节的网络地址，1个字节的主机号                            192.0.0.0至223.255.255.255

广播地址
局域网广播 255.255.255.255

对于一个子网的广播，a类  网络号+255.255.255
                                b类  网络号+255.255
		c类   网络号+255

回路 127|任意值（出去全零全1） 本机地址，测试网卡是否损坏，是否能工作

端口：TCP/IP端口逻辑意义的端口非物理端口

端口分类65536个端口
1-1024是固定端口
有名端口，即被某些程序固定使用，一般程序员不能使用。
22：SSH远程登陆协议  23：telnet使用用  21:ftp使用
25：smtp服务使用     80：http使用  7：echo服务

1025-65535是动态端口
这些是动态端口，程序员可以随便使用
设置监听则改端口为打开

端口使用的注意事项：
服务器上能不开的端口，都禁止开，安全隐患
一个端口只能被一个程序监听

URL uni resoure locator统一资源定位符  网页地址
组成：
http://www.sina.com:8080/index.html
1.协议
2.ip地址32位
3.端口号(16位）0-65535
4.资源名称  文档，音频，图片

单工、半工、和全双工

单工通信：甲可以向乙发送数据，但乙不能向甲发送数据
半双工：传输数据在两个方向上传输，但是，在某一时刻，只允许数据在一个方向上传输，
		它实际上是一种切换方向的单工通信，就和对讲机（步话机）
全双工数据通信允许数据同时在两个方向上传输，因此，全双工通信时两个单工通信方式的结合，发送方和接受方都有独立的通信能力。







