# Linux

#### 1.操作文件及目录
- 1.切换目录
    - cd /home
- 2.显示当前目录
    - pwd
- 3.创建文件
    - touch demo.txt
- 4.创建一个新目录
    - mkdir testDir
- 5.复制文件到home文件目录下
    - cp 1.txt /home
- 6.移动文件或者目录/文件或者目录修改名称
    - mv dir/dir1
- 7.删除空目录
    - rmdir dir1             
- 8.展示文本内容
    - cat1.txt  
- 9.查看日志命令 more  可以展示百分比，回车可以向下一行， 空格可以向下一页，q可以退出查看
    - more aaa.log
- 10.查看日志命令 less home.log,j 下一行,k 上一行,f 向上滚动一屏,b 向下滚动一屏,g 定位到文档的头部,G 定位到文档的尾部         
    - less bbb.log
- 11.查看文本开头部分        
    - head 1.txt   
- 12.tail-10 查看最后10 行日志,Ctrl+C结束               
    - tail ccc.log
- 13.统计文本的行数，字数，字符        
    -  wc ssm.log  
- 14.全局查看某个文件 
    - find / -name settings.xml
- 15.列出当前目录下和子目录所有文件和文件
    - find . 
- 16.在/home 目录下查找以 .txt 结尾的文件名 find /home -name “* .txt”,同上，
     但忽略大小写: find /home -iname "*.txt"                       
     
 
#### 2.系统常用命令
- 1.展示系统中耗费资源，最多的进程
    - top
- 2.展示系统当前时间
    - date
- 3.展示所有进程，环境变量                
    - ps -e  
- 4.全部格式展示  
    - ps -ef                        
- 5.展示所有用户的所有进程（包括其他永固）                      
    - ps -a 
- 6.强制杀死一个进程    
    - kill -9 pid                 
- 7.以人类可读的方式展示 kb mb GB   
    - df -h               
- 8.展示指定目录及其子目录已经使用的磁盘综合
    - du                  
- 9.展示指定目录总和，*表示当前目录下表示所有  
    - du -s *        
- 10.以人类可度的方式展示 kb Mb GB                        
    - du -sh * 
- 11.现实当前内存和交换空间的使用情况               
    - free
- 12.查看网卡和联通性                  
    - ifconfig                     
- 13.ping网站，测试网络的联通性                        
    - ping                  
- 14.查看主机名称                      
    - hostname         
- 15.先关机后重启
    shutdown -f             
- 16.关机后不重启                 
    shutdown -h 
- 17.关机后关闭电源
     halt             
- 18.重新启动，相当于shutdown -f
    - reboot                 
- 19.查看Java项目的进程
    - jps -l                   
               
   
#### 3.压缩和解压
- 1.压缩后面文件和文件夹 
    - gzip 1.txt 
- 2. 解压后面的压缩文件             
    - gzip -d 1.txt          
- 3.解压文件    
    - tar -zxvf              
     
                                      
#### 4.文件权限操作      
- 1.-rwxrw-r--
    1.r 表示可读权限，w可写权限，x可执行权限（也可以用二进制表示 111 110 100 --> 764）     
    其中 r表示 read
        w表示 write
    
- 2.chmod
    1.chmod u+r 1.txt         修改文件或者目录的权限，u表示当前用户，g表示同组用户，o表示其他用户，a表示所有用户
                              r表示可读，w表示可读，x表示可执行
    2.chmod -R u+r dir        修改指定目录及其子目录所有文件权限
        
    3.三位数字 chmod 764 1.sh   直接指定文件权限：7表示可读可写可执行，4+2+1
                                             6表示可读可写       4+2
                                               
                                          
    


