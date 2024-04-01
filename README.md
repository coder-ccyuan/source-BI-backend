# source-BI-backend
BI 智能报表,自动生成图表和分析结论

## 功能
___
- 智能分析：用户输入目标和原始数据，自动生成图表和分析结论
- 图标管理
- 图标生成的异步化（消息队列）
- 对接 AI 的能力

## 技术栈
___
- SpringBoot
- Mybatis-Plus
- Swagger+knife4j
- RabbitMQ
- Easy-Excel
## 开发日志
___
### 4.1
- 实现后端初始化 :ok:
- 实现数据库表的设计 :ok:
  - ```sql
    create table user
    (
    id           bigint auto_increment comment 'id'
    primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    )
    comment '用户' collate = utf8mb4_unicode_ci;
    ```
  - ```sql
    create table chart
    (
    id           bigint auto_increment comment 'id'
    primary key,
    goal         text null comment '分析目标',
    charData     text  null comment '图表数据',
    charType     varchar(128) null comment '图标类型',
    genChart     text null comment '生成的图表数据',
    genResult    text null comment '生成的分析结论',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    )
    comment '图表信息' collate = utf8mb4_unicode_ci;
    ```
- 实现用户登录 :ok:
- 实现用户注册 :ok:
- 实现获取当前用户 :ok: