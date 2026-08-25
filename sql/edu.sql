-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: edu
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `edu`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `edu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `edu`;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `province` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '市',
  `town` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '县/区',
  `mobile` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '手机',
  `street` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '详细地址',
  `contact` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系人',
  `is_default` bit(1) DEFAULT b'0' COMMENT '是否是默认 1默认 0否',
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '备注',
  `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (59,2,'北京','北京','朝阳区','13900112222','金燕龙办公楼','Rose',_binary '',NULL,_binary '\0'),(60,1,'北京','北京','朝阳区','13700221122','修正大厦','Jack',_binary '\0',NULL,_binary '\0'),(61,1,'上海','上海','浦东新区','13301212233','航头镇航头路','Jack',_binary '',NULL,_binary '\0'),(63,2,'广东','佛山','永春','13301212233','永春武馆','Rose',_binary '\0',NULL,_binary '\0'),(64,3,'浙江','杭州','拱墅区','13567809102','浙江大学','Hope',_binary '',NULL,_binary '\0'),(65,3,'浙江','杭州','拱墅区','13967589201','左岸花园','Hope',_binary '\0',NULL,_binary '\0'),(66,4,'湖北','武汉','汉口','13967519202','天天花园','Thomas',_binary '',NULL,_binary '\0'),(67,3,'浙江','杭州','拱墅区','13967589201','左岸花园','Hopey',_binary '\0',NULL,_binary '\0'),(68,4,'湖北','武汉','汉口','13967519202','天天花园','Thomas',_binary '',NULL,_binary '\0'),(69,3,'浙江','杭州','拱墅区','13967589201','左岸花园','Hopey',_binary '\0',NULL,_binary '\0'),(70,4,'湖北','武汉','汉口','13967519202','天天花园','Thomas',_binary '',NULL,_binary '\0');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(30) NOT NULL COMMENT '班级名称',
  `room` varchar(20) DEFAULT NULL COMMENT '班级教室',
  `begin_date` date NOT NULL COMMENT '开课时间',
  `end_date` date NOT NULL COMMENT '结课时间',
  `master_id` int unsigned DEFAULT NULL COMMENT '班主任ID, 关联员工表ID',
  `subject` tinyint unsigned NOT NULL COMMENT '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'JavaEE就业163期','212','2024-04-30','2024-06-29',10,1,'2024-06-01 17:08:23','2024-06-01 17:39:58'),(2,'前端就业90期','210','2024-07-10','2024-01-20',3,2,'2024-06-01 17:45:12','2024-06-01 17:45:12'),(3,'JavaEE就业165期','108','2024-06-15','2024-12-25',6,1,'2024-06-01 17:45:40','2024-06-01 17:45:40'),(4,'JavaEE就业166期','110','2023-06-01','2024-01-25',9,1,'2024-06-01 17:46:10','2026-06-20 15:57:01'),(5,'大数据就业58期','209','2024-08-01','2024-02-15',7,3,'2024-06-01 17:51:21','2024-06-01 17:51:21'),(6,'JavaEE就业167期','325','2024-11-20','2024-05-10',36,1,'2024-11-15 11:35:46','2024-12-13 14:31:24'),(9,'wmmy','211','2026-06-01','2026-07-11',16,1,'2026-06-20 16:04:26','2026-06-20 16:04:26');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'财务部','2023-09-25 09:47:40','2026-05-28 23:00:25'),(2,'教研部','2023-09-25 09:47:40','2024-08-09 15:17:04'),(3,'咨询部','2023-09-25 09:47:40','2024-07-30 21:26:24'),(4,'就业部','2023-09-25 09:47:40','2024-07-25 09:47:40'),(5,'技术部','2026-05-28 22:11:14','2026-05-28 22:11:14'),(6,'学工部','2026-05-28 22:11:23','2026-05-28 23:00:39');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 1:男, 2:女',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
  `salary` int unsigned DEFAULT NULL COMMENT '薪资',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int unsigned DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'shinaian','123456','施耐庵',1,'13309090001',4,15000,'https://api.dicebear.com/7.x/avataaars/svg?seed=shinaian','2000-01-01',2,'2023-10-20 16:35:33','2023-11-16 16:11:26'),(2,'songjiang','123456','宋江',1,'13309090002',2,8600,'https://api.dicebear.com/7.x/avataaars/svg?seed=songjiang','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:37'),(3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'https://api.dicebear.com/7.x/avataaars/svg?seed=lujunyi','2008-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:39'),(4,'wuyong','123456','吴用',1,'13309090004',2,9200,'https://api.dicebear.com/7.x/avataaars/svg?seed=wuyong','2007-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:41'),(5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'https://api.dicebear.com/7.x/avataaars/svg?seed=gongsunsheng','2012-12-05',2,'2023-10-20 16:35:33','2023-10-20 16:35:43'),(6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'https://api.dicebear.com/7.x/avataaars/svg?seed=huosanniang','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:45'),(7,'chaijin','123456','柴进',1,'13309090007',1,4700,'https://api.dicebear.com/7.x/avataaars/svg?seed=chaijin','2005-08-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:47'),(8,'likui','123456','李逵',1,'13309090008',1,4800,'https://api.dicebear.com/7.x/avataaars/svg?seed=likui','2014-11-09',1,'2023-10-20 16:35:33','2023-10-20 16:35:49'),(9,'wusong','123456','武松',1,'13309090009',1,4900,'https://api.dicebear.com/7.x/avataaars/svg?seed=wusong','2011-03-11',1,'2023-10-20 16:35:33','2023-10-20 16:35:51'),(10,'linchong','123456','林冲',1,'13309090010',1,5000,'https://api.dicebear.com/7.x/avataaars/svg?seed=linchong','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:53'),(11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'https://api.dicebear.com/7.x/avataaars/svg?seed=huyanzhuo','2007-02-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:55'),(12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'https://api.dicebear.com/7.x/avataaars/svg?seed=xiaoliguang','2008-08-18',2,'2023-10-20 16:35:33','2023-10-20 16:35:57'),(13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'https://api.dicebear.com/7.x/avataaars/svg?seed=yangzhi','2012-11-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:59'),(14,'shijin','123456','史进',1,'13309090014',2,10600,'https://api.dicebear.com/7.x/avataaars/svg?seed=shijin','2002-08-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:01'),(15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'https://api.dicebear.com/7.x/avataaars/svg?seed=sunerniang','2011-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:03'),(16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'https://api.dicebear.com/7.x/avataaars/svg?seed=luzhishen','2010-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:05'),(17,'liying','12345678','李应',1,'13309090017',1,5800,'https://api.dicebear.com/7.x/avataaars/svg?seed=liying','2015-03-21',1,'2023-10-20 16:35:33','2023-10-20 16:36:07'),(18,'shiqian','123456','时迁',1,'13309090018',2,10200,'https://api.dicebear.com/7.x/avataaars/svg?seed=shiqian','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:09'),(19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'https://api.dicebear.com/7.x/avataaars/svg?seed=gudasao','2008-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:11'),(20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'https://api.dicebear.com/7.x/avataaars/svg?seed=ruanxiaoer','2018-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:13'),(21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'https://api.dicebear.com/7.x/avataaars/svg?seed=ruanxiaowu','2015-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:15'),(22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'https://api.dicebear.com/7.x/avataaars/svg?seed=ruanxiaoqi','2016-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:17'),(23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'https://api.dicebear.com/7.x/avataaars/svg?seed=ruanji','2012-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:19'),(24,'tongwei','123456','童威',1,'13309090024',5,5000,'https://api.dicebear.com/7.x/avataaars/svg?seed=tongwei','2006-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:21'),(25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'https://api.dicebear.com/7.x/avataaars/svg?seed=tongmeng','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:23'),(26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'https://api.dicebear.com/7.x/avataaars/svg?seed=yanshun','2011-01-01',3,'2023-10-20 16:35:33','2023-11-08 22:12:46'),(27,'lijun','123456','李俊',1,'13309090027',2,6600,'https://api.dicebear.com/7.x/avataaars/svg?seed=lijun','2004-01-01',2,'2023-10-20 16:35:33','2023-11-16 17:56:59'),(28,'lizhong','123456','李忠',1,'13309090028',5,5000,'https://api.dicebear.com/7.x/avataaars/svg?seed=lizhong','2007-01-01',3,'2023-10-20 16:35:33','2023-11-17 16:34:22'),(30,'liyun','123456','李云',1,'13309090030',6,NULL,'https://api.dicebear.com/7.x/avataaars/svg?seed=liyun','2020-03-01',NULL,'2023-10-20 16:35:33','2023-10-20 16:36:31'),(36,'linghuchong','123456','令狐冲',1,'18809091212',2,6800,'https://api.dicebear.com/7.x/avataaars/svg?seed=linghuchong','2023-10-19',2,'2023-10-20 20:44:54','2023-11-09 09:41:04'),(56,'wmm','123456','王林',1,'19853352518',2,265959,'','2026-06-01',17,'2026-06-07 12:27:04','2026-06-07 12:27:04'),(60,'悉一全','123456','计奕辰',2,'19853352514',1,55555,'https://wmmya.oss-cn-beijing.aliyuncs.com/2026/06/14d32358-9f5f-4ea1-93b4-b2c50e939b46.jpg','2026-06-09',19,'2026-06-07 15:31:32','2026-06-08 17:29:53');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `emp_id` int unsigned DEFAULT NULL COMMENT '员工ID',
  `begin` date DEFAULT NULL COMMENT '开始时间',
  `end` date DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` VALUES (1,37,'2023-10-19','2023-10-19','上海字节跳动科技有限公司','Java开发工程师'),(2,37,'2023-10-19','2023-10-19','上海字节跳动科技有限公司','Java开发工程师'),(3,37,'2023-10-19','2023-10-19','上海字节跳动科技有限公司','Java开发工程师');
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_log`
--

DROP TABLE IF EXISTS `emp_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `info` varchar(2000) DEFAULT NULL COMMENT '日志信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_log`
--

LOCK TABLES `emp_log` WRITE;
/*!40000 ALTER TABLE `emp_log` DISABLE KEYS */;
INSERT INTO `emp_log` VALUES (1,'2026-06-05 12:17:14','添加员工数据：Emp(id=54, username=wmmuy, password=null, name=王木木, gender=1, phone=19848458952, job=1, salary=59898, image=, entryDate=2026-06-01, deptId=1, createTime=2026-06-05T12:17:14.081899, updateTime=2026-06-05T12:17:14.081899, deptName=null, exprList=[EmpExpr(id=null, empId=54, begin=2026-06-23, end=2026-06-23, company=dwad, job=dwad)])'),(2,'2026-06-07 10:45:47','添加员工数据：Emp(id=55, username=dwada, password=null, name=等我, gender=1, phone=15165558777, job=2, salary=49491, image=https://wmmya.oss-cn-beijing.aliyuncs.com/2026/06/3a8e135f-4041-41da-89e1-4ba7393b9d2e.jpg, entryDate=2026-06-22, deptId=18, createTime=2026-06-07T10:45:47.311433800, updateTime=2026-06-07T10:45:47.311433800, deptName=null, exprList=[EmpExpr(id=null, empId=55, begin=2026-06-25, end=2026-07-02, company=dy, job=CEO)])'),(3,'2026-06-07 12:25:12','删除员工数据：[39, 41, 42, 43, 44, 45]'),(4,'2026-06-07 12:25:51','删除员工数据：[53, 54]'),(5,'2026-06-07 12:27:04','添加员工数据：Emp(id=56, username=wmm, password=null, name=王林, gender=1, phone=19853352518, job=2, salary=265959, image=, entryDate=2026-06-01, deptId=17, createTime=2026-06-07T12:27:04.368125600, updateTime=2026-06-07T12:27:04.368125600, deptName=null, exprList=[])'),(6,'2026-06-07 12:28:13','删除员工数据：[38]'),(7,'2026-06-07 12:28:43','添加员工数据：Emp(id=57, username=wm, password=null, name=打我的, gender=2, phone=19854456888, job=3, salary=1215, image=, entryDate=2026-06-02, deptId=1, createTime=2026-06-07T12:28:42.984093700, updateTime=2026-06-07T12:28:42.984093700, deptName=null, exprList=[EmpExpr(id=null, empId=57, begin=2026-06-06, end=2026-06-06, company=dwad, job=带娃)])'),(8,'2026-06-07 12:28:47','删除员工数据：[57]'),(9,'2026-06-07 15:08:05','删除员工数据：[55]'),(10,'2026-06-07 15:31:05','添加员工数据：Emp(id=null, username=wmm, password=null, name=王林, gender=1, phone=19853352514, job=1, salary=6666666, image=https://wmmya.oss-cn-beijing.aliyuncs.com/2026/06/14d32358-9f5f-4ea1-93b4-b2c50e939b46.jpg, entryDate=2026-06-09, deptId=19, createTime=2026-06-07T15:31:04.606121900, updateTime=2026-06-07T15:31:04.606121900, deptName=null, exprList=[EmpExpr(id=null, empId=null, begin=2026-06-04, end=2026-07-08, company=dy, job=CEO), EmpExpr(id=null, empId=null, begin=2026-06-18, end=2026-06-19, company=dy, job=YYDS)])'),(11,'2026-06-07 15:31:07','添加员工数据：Emp(id=null, username=wmm, password=null, name=王林, gender=1, phone=19853352514, job=1, salary=6666666, image=https://wmmya.oss-cn-beijing.aliyuncs.com/2026/06/14d32358-9f5f-4ea1-93b4-b2c50e939b46.jpg, entryDate=2026-06-09, deptId=19, createTime=2026-06-07T15:31:06.596901600, updateTime=2026-06-07T15:31:06.596901600, deptName=null, exprList=[EmpExpr(id=null, empId=null, begin=2026-06-04, end=2026-07-08, company=dy, job=CEO), EmpExpr(id=null, empId=null, begin=2026-06-18, end=2026-06-19, company=dy, job=YYDS)])'),(12,'2026-06-07 15:31:32','添加员工数据：Emp(id=60, username=wll, password=null, name=王林, gender=1, phone=19853352514, job=1, salary=6666666, image=https://wmmya.oss-cn-beijing.aliyuncs.com/2026/06/14d32358-9f5f-4ea1-93b4-b2c50e939b46.jpg, entryDate=2026-06-09, deptId=19, createTime=2026-06-07T15:31:32.168851400, updateTime=2026-06-07T15:31:32.168851400, deptName=null, exprList=[EmpExpr(id=null, empId=60, begin=2026-06-04, end=2026-07-08, company=dy, job=CEO), EmpExpr(id=null, empId=60, begin=2026-06-18, end=2026-06-19, company=dy, job=YYDS)])');
/*!40000 ALTER TABLE `emp_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_emp_id` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(2000) DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint unsigned DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
INSERT INTO `operate_log` VALUES (1,0,'2026-06-29 17:02:34','com.wmm.controller.StudentController','update','[Student(id=21, name=阿木木, no=2024010801, gender=1, phone=15909091235, idCard=159090912351590909, isCollege=1, address=昌平回龙观, degree=4, graduationDate=2024-01-01, clazzId=9, violationCount=1, violationScore=3, createTime=2026-06-20T18:04:58, updateTime=2026-06-29T17:02:34.242362500, clazzName=wmmy)]','{\"code\":1,\"msg\":\"success\"}',38),(2,2,'2026-06-29 17:38:38','com.wmm.controller.StudentController','update','[Student(id=22, name=王木木, no=2024010821, gender=1, phone=15909191235, idCard=159090912361590909, isCollege=1, address=昌平回龙观, degree=2, graduationDate=2024-01-01, clazzId=9, violationCount=1, violationScore=2, createTime=2026-06-21T10:33:34, updateTime=2026-06-29T17:38:37.907044900, clazzName=wmmy)]','{\"code\":1,\"msg\":\"success\"}',37),(3,0,'2026-07-19 19:48:06','com.wmm.controller.DeptController','add','[Dept(id=null, name=wmmy, createTime=2026-07-19T19:48:05.997841200, updateTime=2026-07-19T19:48:05.997841200)]','{\"code\":1,\"msg\":\"success\"}',53),(4,0,'2026-07-19 19:55:35','com.wmm.controller.DeptController','add','[Dept(id=null, name=研发一部, createTime=2026-07-19T19:55:35.381271400, updateTime=2026-07-19T19:55:35.381271400)]','{\"code\":1,\"msg\":\"success\"}',10),(5,0,'2026-07-19 20:22:48','com.wmm.controller.DeptController','add','[Dept(id=null, name=12, createTime=2026-07-19T20:22:48.184658, updateTime=2026-07-19T20:22:48.184658)]','{\"code\":1,\"msg\":\"success\"}',11),(6,0,'2026-07-19 20:28:07','com.wmm.controller.DeptController','add','[Dept(id=null, name=123, createTime=2026-07-19T20:28:06.710901100, updateTime=2026-07-19T20:28:06.710901100)]','{\"code\":1,\"msg\":\"success\"}',6),(7,0,'2026-07-19 21:49:16','com.wmm.controller.DeptController','update','[Dept(id=27, name=1234, createTime=2026-07-19T20:28:07, updateTime=2026-07-19T21:49:15.553823500)]','{\"code\":1,\"msg\":\"success\"}',33),(8,0,'2026-07-19 21:49:21','com.wmm.controller.DeptController','update','[Dept(id=27, name=12345, createTime=2026-07-19T20:28:07, updateTime=2026-07-19T21:49:21.484717100)]','{\"code\":1,\"msg\":\"success\"}',5),(9,0,'2026-07-19 22:06:07','com.wmm.controller.DeptController','deleteById','[27]','{\"code\":1,\"msg\":\"success\"}',16),(10,0,'2026-07-19 22:06:36','com.wmm.controller.DeptController','deleteById','[25]','{\"code\":1,\"msg\":\"success\"}',8),(11,0,'2026-07-19 22:06:39','com.wmm.controller.DeptController','deleteById','[24]','{\"code\":1,\"msg\":\"success\"}',4),(12,0,'2026-07-19 22:06:40','com.wmm.controller.DeptController','deleteById','[23]','{\"code\":1,\"msg\":\"success\"}',4),(13,0,'2026-07-19 22:08:42','com.wmm.controller.DeptController','update','[Dept(id=7, name=123, createTime=2026-05-28T23:00:52, updateTime=2026-07-19T22:08:41.566215200)]','{\"code\":1,\"msg\":\"success\"}',6),(14,0,'2026-07-19 22:12:46','com.wmm.controller.DeptController','deleteById','[7]','{\"code\":1,\"msg\":\"success\"}',5);
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `no` char(10) NOT NULL COMMENT '学号',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 1: 男, 2: 女',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `id_card` char(18) NOT NULL COMMENT '身份证号',
  `is_college` tinyint unsigned NOT NULL COMMENT '是否来自于院校, 1:是, 0:否',
  `address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `degree` tinyint unsigned DEFAULT NULL COMMENT '最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士',
  `graduation_date` date DEFAULT NULL COMMENT '毕业时间',
  `clazz_id` int unsigned NOT NULL COMMENT '班级ID, 关联班级表ID',
  `violation_count` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪次数',
  `violation_score` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪扣分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'段誉','2022000001',1,'18800000001','110120000300200001',1,'北京市昌平区建材城西路1号',1,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:20:59'),(2,'萧峰','2022000002',1,'18800210003','110120000300200002',1,'北京市昌平区建材城西路2号',2,'2022-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(3,'虚竹','2022000003',1,'18800013001','110120000300200003',1,'北京市昌平区建材城西路3号',2,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(4,'萧远山','2022000004',1,'18800003211','110120000300200004',1,'北京市昌平区建材城西路4号',3,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(5,'阿朱','2022000005',2,'18800160002','110120000300200005',1,'北京市昌平区建材城西路5号',4,'2020-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(6,'阿紫','2022000006',2,'18800000034','110120000300200006',1,'北京市昌平区建材城西路6号',4,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(7,'游坦之','2022000007',1,'18800000067','110120000300200007',1,'北京市昌平区建材城西路7号',4,'2022-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(8,'康敏','2022000008',2,'18800000077','110120000300200008',1,'北京市昌平区建材城西路8号',5,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(9,'徐长老','2022000009',1,'18800000341','110120000300200009',1,'北京市昌平区建材城西路9号',3,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(10,'云中鹤','2022000010',1,'18800006571','110120000300200010',1,'北京市昌平区建材城西路10号',2,'2020-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(11,'钟万仇','2022000011',1,'18800000391','110120000300200011',1,'北京市昌平区建材城西路11号',4,'2021-07-01',1,1,6,'2024-11-14 21:22:19','2024-11-15 16:21:24'),(12,'崔百泉','2022000012',1,'18800000781','110120000300200018',1,'北京市昌平区建材城西路12号',4,'2022-07-05',3,6,17,'2024-11-14 21:22:19','2024-12-13 14:33:58'),(13,'耶律洪基','2022000013',1,'18800008901','110120000300200013',1,'北京市昌平区建材城西路13号',4,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:21'),(14,'天山童姥','2022000014',2,'18800009201','110120000300200014',1,'北京市昌平区建材城西路14号',4,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:17'),(15,'刘竹庄','2022000015',1,'18800009401','110120000300200015',1,'北京市昌平区建材城西路15号',3,'2020-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(16,'李春来','2022000016',1,'18800008501','110120000300200016',1,'北京市昌平区建材城西路16号',4,'2021-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(17,'王语嫣','2022000017',2,'18800007601','110120000300200017',1,'北京市昌平区建材城西路17号',2,'2022-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(18,'郑成功','2024001101',1,'13309092345','110110110110110110',0,'北京市昌平区回龙观街道88号',5,'2021-07-01',3,2,7,'2024-11-15 16:26:18','2024-11-15 16:40:10'),(21,'阿木木','2024010801',1,'15909091235','159090912351590909',1,'昌平回龙观',4,'2024-01-01',9,2,5,'2026-06-20 18:04:58','2026-06-20 18:04:58'),(22,'王木木','2024010821',1,'15909191235','159090912361590909',1,'昌平回龙观',2,'2024-01-01',9,1,2,'2026-06-21 10:33:34','2026-06-21 10:33:34');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-25 20:39:18
