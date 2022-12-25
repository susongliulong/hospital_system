# 需求分析
登录方式一：使用账号或者手机号+密码+验证码进行登录，其中一个手机号对应唯一的一个账号，验证码由后端随机生成，并且返回；其中验证码需要设置有效时间
登录方式二：使用手机号+验证码进行登录，其中验证码的生成方式和方式一相同
登录方式三：通过第三方软件进行登录，在第三方软件登录成功以后，登录成功

登录成功以后，在系统储存用户成功登录信息

登录方式一和登陆方式二逻辑
用户输入相关信息后，
首先查看此用户是否注册，未注册登录失败
其次进行密码或者验证码验证，验证失败，登录失败
检查用户状态，其中用户状态，用户被锁定时不允许登录，登录成功
用户在陌生环境下进行登录时，需要额外再验证一次验证码，验证码验证失败，登录失败；用户登录成功以后，如果用户信任此登录设备，将登录信息储存到数据库当中，下次不再询问

登陆成功，储存用户成功登录信息

# 设计
api接口
登录：/people/login；成功以后，跳转到index.html界面

/people/login/code：二次验证码登录验证

验证码：/code/code 请求服务器发送验证码

/code/get：用户进行手机号密码登录时，在用户输入完手机号以后，发送请求，服务端验证手机号是否存在



数据库
user表：uuid，账号名称，手机号码，密码，状态
login_location表：用户id+登录位置

后端逻辑
springboot+mybatisplus
UserController:处理用户逻辑
CodeController：处理验证码发送逻辑
CodeUtil：生成随机的验证码

其他设计
提供两种环境：（通过相应的配置文件实现）

1. 开发环境
2. 测试环境

关于使用阿里云服务的regionId以及accessKeyId，secret的存储

在数据库里面新建表System，只有管理员root才能访问，在里面存储相应的配置信息

关于加密以及解密，在存入用户账号的密码时，需要使用相应的加密以及解密操作，这里使用Encrption进行加密和解密

使用redis暂时缓存验证码，同时设置验证码有效时间为60秒
