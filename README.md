### 介绍
java毕业设计，助农平台
### 3000多套系统，需要联系
抠：3565014707 微：a13424421017

#### 软件架构
##### 整体架构模式
这是一个典型的 电商与扶贫商品销售平台，采用 前后端分离架构，包含以下模块：

管理后台（client_admin）：基于 Vue.js + ElementUI 的 SPA 应用，供平台管理员和商家管理商品、订单、用户等。

用户端（client_home）：基于 Vue.js 的电商前端，面向消费者提供商品浏览、购物车、支付功能，并集成扶贫商品专区。

后端服务（server）：基于 Spring Boot + MyBatis 的 Java 服务，提供 RESTful API 和核心业务逻辑。

##### 分层架构设计
后端分层：

Controller层：controller 包（如 AccessTokenController）处理 HTTP 请求，返回 JSON 数据。

Service层：service 包（如 AccessTokenService）实现业务逻辑（如订单生成、权限验证）。

DAO层：dao 包（如 AccessTokenMapper）通过 MyBatis XML 文件（AccessTokenMapper.xml）操作数据库。

实体与数据模型：

entity 包定义数据库实体（如 AccessToken 用于权限管理）；

BaseEntity 提供公共字段（如 create_time、update_time）。

前端分层：

管理后台（Vue.js）：

视图层：views/modules 定义页面（如 after_sales_information 售后管理页）。

组件层：components 封装可复用组件（如 bar_chart.vue 数据图表）。

状态管理：通过 Vuex（store/index.js）管理全局状态（如用户权限、商品库存）。

用户端（Vue.js）：

动态交互：通过 router/index.js 实现页面路由，支持商品详情（goods/details.vue）、购物车（cart/list.vue）等功能。

##### 关键技术特性
权限控制：

后端通过 LoginInterceptor 拦截器校验 Token，AccessToken 实体管理用户会话；

前端管理后台通过路由守卫限制页面访问权限（如仅管理员可访问 user_group 模块）。

支付与物流：

集成支付宝/微信支付（pay/details.vue 页面处理支付逻辑）；

logistics_information 模块对接第三方物流 API，实时更新订单配送状态。

扶贫商品专区：

poverty_alleviation_commodities 模块标记扶贫商品，支持单独的商品展示和销售统计。

#### 核心功能模块解析
##### 商品管理模块
商品分类与展示：

goods_type 维护商品分类（如“扶贫特产”“日用品”）；

goods/details.vue 展示商品详情（图片、价格、扶贫故事），支持多规格选择。

库存与上下架：

商家通过管理后台（goods/table.vue）调整库存和上下架状态。

##### 订单与交易模块
购物车与订单生成：

用户端 cart/list.vue 管理购物车商品，点击结算生成订单（order/details.vue）；

后端 OrderService 处理库存扣减和订单状态流转（待支付→已发货→已完成）。

售后与评价：

after_sales_information 处理退款申请，comment/table.vue 管理用户评价。

##### 用户与权限模块
多角色体系：

ordinary_users（普通用户）：浏览商品、下单；

seller（商家）：管理自有商品；

user_group（用户组）：定义管理员权限范围。

地址管理：

receiving_information 维护用户收货地址，支持设置默认地址。

##### 扶贫专区模块
精准扶贫标识：

扶贫商品在 poverty_alleviation_commodities/details.vue 页面展示扶贫认证标识和帮扶故事；

销售数据单独统计，生成扶贫报告（通过 bar_chart.vue 可视化）。

##### 内容与社区模块
公告与资讯：

notice/table.vue 发布平台公告（如扶贫政策解读）；

article/table.vue 管理商品推广文章。

用户互动：

media/image.vue 支持用户上传商品使用实拍图，增强社区互动。
