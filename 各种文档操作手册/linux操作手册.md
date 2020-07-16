# Linux

#### 1.操作文件及目录
​    1.cd 
        cd/home             切换目录
     2.pwd                
                            现实当前工作目录
     3.touch 
          1.txt             创建空文件夹
     4.mkdir 
          testDir           创建一个新目录
     5.cp 
          1.txt             复制文件或者目录
     6.mv 
          dir/dir1          移动文件或者目录/文件或者目录修改名称
     7.rmdir 
          rmdir dir1        删除空目录
     8.cat 
          cat1.txt          展示文本文件内容
     9.more
         查看日志命令 more  可以展示百分比，回车可以向下一行， 空格可以向下一页，q可以退出查看
     10.less
        查看日志命令 less home.log,j 下一行,k 上一行,f 向上滚动一屏,b 向下滚动一屏,g 定位到文档的头部,G 定位到文档的尾部
     11.head
        head 1.txt          查看文本开头部分
     12.tail
        tail-10 查看最后10 行日志,Ctrl+C结束
     13.wc
        wc ssm.log          统计文本的行数，字数，字符
     14find
        全局查看某个文件 find / -name settings.xml,列出当前目录下和子目录所有文件和文件   find . 
        在/home 目录下查找以 .txt 结尾的文件名 find /home -name “* .txt”,同上，但忽略大小写: find /home -iname "*.txt"



#### 2.系统常用命令  

    1.top
        top                     展示系统中耗费资源，最多的进程
    2.date
        date                    展示系统当前时间
    3.ps
        ps -e                   展示所有进程，环境变量   
        ps -ef                  全部格式展示  
        ps -a                   展示所有用户的所有进程（包括其他永固）
    4.kill
        kill -9 pid             强制杀死一个进程
    5.df
        df -h                   以人类可读的方式展示 kb mb GB
    6.du
        du                      展示指定目录及其子目录已经使用的磁盘综合
        du -s *                 展示指定目录总和，*表示当前目录下表示所有
        du -sh *                以人类可度的方式展示 kb Mb GB
    7.free 
        free                    现实当前内存和交换空间的使用情况
    8.ifconfig                  
        ifconfig                查看网卡和联通性
    9.ping                      
        ping                    ping网站，测试网络的联通性
    10.hostname         
        hostname                查看主机名称
    11.shutdown                 
        shutdown -f             先关机后再重启
        shutdown -h             关机后不重启
    12.halt                 
        halt                    关机后关闭电源
    13.reboot
        reboot                  重新启动，相当于shutdown -f
        
   
#### 3.压缩和解压
    
    1.gzip 
        gzip 1.txt              压缩后面文件和文件夹
        gzip -d 1.txt           解压后面的压缩文件
    2tar    
        tar -zxvf               解压文件
     
                                      
#### 4.文件权限操作   
    
    -rwxrw-r--
    1.r 表示可读权限，w可写权限，x可执行权限（也可以用二进制表示 111 110 100 --> 764）     
    其中 r表示 read
        w表示 write
    
    2.chmod
        chmod u+r 1.txt         修改文件或者目录的权限，u表示当前用户，g表示同组用户，o表示其他用户，a表示所有用户
                                r表示可读，w表示可读，x表示可执行
        chmod -R u+r dir        修改指定目录及其子目录所有文件权限
        
        三位数字 chmod 764 1.sh   直接指定文件权限：7表示可读可写可执行，4+2+1
                                               6表示可读可写       4+2
                                               
                                          
    


