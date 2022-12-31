/*
SQLyog Ultimate v10.00 Beta1
MySQL - 8.0.22 : Database - hospital3119009062liulong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hospital3119009062liulong` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `hospital3119009062liulong`;

/*Table structure for table `bed3119009062liulong` */

DROP TABLE IF EXISTS `bed3119009062liulong`;

CREATE TABLE `bed3119009062liulong` (
  `id` char(15) NOT NULL,
  `pat_id` char(20) DEFAULT NULL,
  `location` char(20) DEFAULT NULL,
  `is_free` tinyint(1) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `start_use` date DEFAULT NULL,
  `illumination` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_5` (`pat_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`pat_id`) REFERENCES `patient3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `bed3119009062liulong` */

/*Table structure for table `cure3119009062liulong` */

DROP TABLE IF EXISTS `cure3119009062liulong`;

CREATE TABLE `cure3119009062liulong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `time` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `department` char(12) DEFAULT NULL,
  `total` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `doctor_id` char(11) DEFAULT NULL,
  `number` int DEFAULT '0',
  `state` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `cure3119009062liulong_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `cure3119009062liulong` */

insert  into `cure3119009062liulong`(`id`,`date`,`time`,`department`,`total`,`price`,`doctor_id`,`number`,`state`) values (3,'2022-12-11','上午8：30到11：30','内科',40,12,'2112340780',3,1),(4,'2022-12-23','上午8：30到11：30','内科',40,12,'2112340780',3,1),(5,'2022-12-26','上午8：30到11：30','外科',20,100,'2112340782',4,1),(6,'2022-12-28','上午8：30到11：30','内科',40,12,'2112340780',3,1),(7,'2022-12-29','上午8：30到11：30','内科',40,12,'2112340780',4,1),(8,'2022-12-23','上午8：30到11：30','外科',40,50,'2112340782',40,0),(9,'2022-12-28','上午8：30到11：30','泌尿外科',20,100,'2112340782',4,1),(10,'2023-01-01','上午8：30到11：30','泌尿外科',20,100,'2112340782',4,1);

/*Table structure for table `department3119009062liulong` */

DROP TABLE IF EXISTS `department3119009062liulong`;

CREATE TABLE `department3119009062liulong` (
  `id` char(20) NOT NULL,
  `name` char(20) DEFAULT NULL,
  `location` char(20) DEFAULT NULL,
  `founded` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `department3119009062liulong` */

insert  into `department3119009062liulong`(`id`,`name`,`location`,`founded`) values ('12340','内科','东5 234','1989-12-01'),('12341','泌尿外科','东5 324','1989-12-01'),('12342','肝病科','东4 234','1989-12-01'),('12343','肾病科','东4 235','1989-12-01'),('12344','癌症科','东4 543','1989-12-01'),('12345','外科','东5 123','1989-12-01'),('12346','眼科','东5 345','1989-12-01'),('12347','骨科','东4 456','1989-12-01'),('12348','心脏内科','东4 223','1989-12-01');

/*Table structure for table `doctor3119009062liulong` */

DROP TABLE IF EXISTS `doctor3119009062liulong`;

CREATE TABLE `doctor3119009062liulong` (
  `id` char(15) NOT NULL,
  `dep_id` char(20) DEFAULT NULL,
  `name` char(15) DEFAULT NULL,
  `password` char(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `telephone` char(11) DEFAULT NULL,
  `title` char(20) DEFAULT NULL,
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `start_work` date DEFAULT NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `degree` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `feature` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_compound13119009062liulong` (`dep_id`),
  CONSTRAINT `FK_compound13119009062liulong` FOREIGN KEY (`dep_id`) REFERENCES `department3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `doctor3119009062liulong` */

insert  into `doctor3119009062liulong`(`id`,`dep_id`,`name`,`password`,`birthday`,`sex`,`telephone`,`title`,`id_number`,`start_work`,`address`,`degree`,`description`,`feature`,`age`) values ('2112340780','12340','马保国','123456','1962-12-23','男','19860205976','主任医师','340826198012258967','2010-10-11','北京朝阳区阳光大道899','博士','全国名老中医、广东省名中医、中国针灸学会荣誉理事，广东省针灸学会终身名誉会长。','痹证（包括关节、肌肉疾患，如颈、腰、肩及四肢关节、神经痛等），面瘫、中风后遗症，神经官能症，神经衰弱、痛经等。',52),('2112340781','12340','马保村','123456','1962-12-24','男','19860205977','主任医师','341826198012258967','2010-10-12','北京朝阳区阳光大道299','博士','全国名老中医、广东省名中医、中国针灸学会荣誉理事，广东省针灸学会终身名誉会长。','痹证（包括关节、肌肉疾患，如颈、腰、肩及四肢关节、神经痛等），面瘫、中风后遗症，神经官能症，神经衰弱、痛经等。',52),('2112340782','12340','马保乡','123456','1962-12-24','男','19860205978','主任医师','341826198012258963','2010-10-12','北京朝阳区阳光大道299','博士','全国名老中医、广东省名中医、中国针灸学会荣誉理事，广东省针灸学会终身名誉会长。','痹证（包括关节、肌肉疾患，如颈、腰、肩及四肢关节、神经痛等），面瘫、中风后遗症，神经官能症，神经衰弱、痛经等。',52),('2112340783','12340','马保家','123456','1962-12-24','男','19860205979','主任医师','341826198012258964','2010-10-12','北京朝阳区阳光大道299','博士','全国名老中医、广东省名中医、中国针灸学会荣誉理事，广东省针灸学会终身名誉会长。','痹证（包括关节、肌肉疾患，如颈、腰、肩及四肢关节、神经痛等），面瘫、中风后遗症，神经官能症，神经衰弱、痛经等。',52),('2112344370','12344','赵小海','123456','1991-02-28','男','19860205912','副主任医师','342826198012250010','2010-10-12','广州市白云区云城东路234号','博士','现任广东省抗癌协会大肠癌专业委员会副主委，广东省医师协会微创外科医师工作委员会副主委，广东省健康管理学会胃肠病专业委员会副主委，广东省医学会胃肠外科学分常委，广东省抗癌协会胃癌专业委员会常委。 中山大学胃肠外科博士毕业，师从原全国胃肠外科学组组长王吉普教授，为国内最早一批胃肠外科博士之一，曾到美国、澳洲、欧洲多地学术访问，是国内胃肠肿瘤学界的顶尖专家，广东省中医院胃肠外科的创办者和奠基人。','能解决胃肠外科领域的复杂、重症、疑难问题，对胃肠肿瘤的手术近期效果及远期疗效处于国内先进水平。对胃肠肿瘤的发病、诊断及治疗有自己独特的见解，在行内产生较大影响，每年被邀请到外院会诊、演示手术超过100例次。擅长胃肠肿瘤及腹部良性疾病以手术为主的综合诊断与治疗、包括胃癌、贲门癌、结直肠癌、胃肠道间质瘤等疾病的微创和开腹手术治疗，食管裂孔疝、反流性食管炎、贲门失驰缓症的微创外科治疗，胃肠道恶性肿瘤的新辅助和辅助放化疗等',30),('2112344371','12344','赵大海','123456','1991-02-28','男','19860205913','副主任医师','342826198012250011','2010-10-12','广州市白云区云城东路234号','博士','现任广东省抗癌协会大肠癌专业委员会副主委，广东省医师协会微创外科医师工作委员会副主委，广东省健康管理学会胃肠病专业委员会副主委，广东省医学会胃肠外科学分常委，广东省抗癌协会胃癌专业委员会常委。 中山大学胃肠外科博士毕业，师从原全国胃肠外科学组组长王吉普教授，为国内最早一批胃肠外科博士之一，曾到美国、澳洲、欧洲多地学术访问，是国内胃肠肿瘤学界的顶尖专家，广东省中医院胃肠外科的创办者和奠基人。','能解决胃肠外科领域的复杂、重症、疑难问题，对胃肠肿瘤的手术近期效果及远期疗效处于国内先进水平。对胃肠肿瘤的发病、诊断及治疗有自己独特的见解，在行内产生较大影响，每年被邀请到外院会诊、演示手术超过100例次。擅长胃肠肿瘤及腹部良性疾病以手术为主的综合诊断与治疗、包括胃癌、贲门癌、结直肠癌、胃肠道间质瘤等疾病的微创和开腹手术治疗，食管裂孔疝、反流性食管炎、贲门失驰缓症的微创外科治疗，胃肠道恶性肿瘤的新辅助和辅助放化疗等',30),('2112344372','12344','赵大河','123456','1991-02-28','女','19860205914','副主任医师','342826198012250014','2010-10-12','广州市白云区云城东路234号','博士','现任广东省抗癌协会大肠癌专业委员会副主委，广东省医师协会微创外科医师工作委员会副主委，广东省健康管理学会胃肠病专业委员会副主委，广东省医学会胃肠外科学分常委，广东省抗癌协会胃癌专业委员会常委。 中山大学胃肠外科博士毕业，师从原全国胃肠外科学组组长王吉普教授，为国内最早一批胃肠外科博士之一，曾到美国、澳洲、欧洲多地学术访问，是国内胃肠肿瘤学界的顶尖专家，广东省中医院胃肠外科的创办者和奠基人。','能解决胃肠外科领域的复杂、重症、疑难问题，对胃肠肿瘤的手术近期效果及远期疗效处于国内先进水平。对胃肠肿瘤的发病、诊断及治疗有自己独特的见解，在行内产生较大影响，每年被邀请到外院会诊、演示手术超过100例次。擅长胃肠肿瘤及腹部良性疾病以手术为主的综合诊断与治疗、包括胃癌、贲门癌、结直肠癌、胃肠道间质瘤等疾病的微创和开腹手术治疗，食管裂孔疝、反流性食管炎、贲门失驰缓症的微创外科治疗，胃肠道恶性肿瘤的新辅助和辅助放化疗等',30),('2112344378','12344','赵小堂','123456','1991-02-28','男','19860205915','副主任医师','340826198012250010','2010-10-12','广州市白云区云城东路234号','博士','现任广东省抗癌协会大肠癌专业委员会副主委，广东省医师协会微创外科医师工作委员会副主委，广东省健康管理学会胃肠病专业委员会副主委，广东省医学会胃肠外科学分常委，广东省抗癌协会胃癌专业委员会常委。 中山大学胃肠外科博士毕业，师从原全国胃肠外科学组组长王吉普教授，为国内最早一批胃肠外科博士之一，曾到美国、澳洲、欧洲多地学术访问，是国内胃肠肿瘤学界的顶尖专家，广东省中医院胃肠外科的创办者和奠基人。','能解决胃肠外科领域的复杂、重症、疑难问题，对胃肠肿瘤的手术近期效果及远期疗效处于国内先进水平。对胃肠肿瘤的发病、诊断及治疗有自己独特的见解，在行内产生较大影响，每年被邀请到外院会诊、演示手术超过100例次。擅长胃肠肿瘤及腹部良性疾病以手术为主的综合诊断与治疗、包括胃癌、贲门癌、结直肠癌、胃肠道间质瘤等疾病的微创和开腹手术治疗，食管裂孔疝、反流性食管炎、贲门失驰缓症的微创外科治疗，胃肠道恶性肿瘤的新辅助和辅助放化疗等',30),('2112345045','12345','刘华强','123456','1991-02-28','女','19860205916','住院医师','340826198012250006','2010-10-12','广州市白云区白云大道南10号','研究生','胸、心外科常见疾病的诊治，熟悉肺部、食道、纵隔肿瘤、冠心病、心脏瓣膜病、先天性心脏病的外科治疗。','胸、心外科常见疾病的诊治，熟悉肺部、食道、纵隔肿瘤、冠心病、心脏瓣膜病、先天性心脏病的外科治疗。',27),('2112345650','12342','白天齐','123456','1981-12-24','男','19860205917','主任医师','340826198012250002','2010-10-12','北京朝阳区阳光大道899','博士','主任医师，硕士生导师，大学城医院泌尿科主任。广东省中医药学会外科专委会主任委员、泌尿外科专业委员会副主委、省中西医结合学会男科学专业委员会副主委','前列腺疾病、泌尿系肿瘤、泌尿系结石、男性不育症、女性尿失禁及排尿功能障碍等疾病的诊断及中西医结合治疗，尤其擅长于前列腺癌、肾癌、膀胱癌以及肾上腺肿瘤等泌尿系肿瘤的微创手术治疗，围手术期中医药调理及术后康复治疗。',40),('2112345651','12342','白天黑','123456','1981-12-24','男','19860205918','主任医师','340827198012250002','2010-10-12','北京朝阳区阳光大道897','博士','主任医师，硕士生导师，大学城医院泌尿科主任。广东省中医药学会外科专委会主任委员、泌尿外科专业委员会副主委、省中西医结合学会男科学专业委员会副主委','前列腺疾病、泌尿系肿瘤、泌尿系结石、男性不育症、女性尿失禁及排尿功能障碍等疾病的诊断及中西医结合治疗，尤其擅长于前列腺癌、肾癌、膀胱癌以及肾上腺肿瘤等泌尿系肿瘤的微创手术治疗，围手术期中医药调理及术后康复治疗。',40),('2112345804','12343','韦世豪','123456','1991-12-24','男','19860205919','主任医师','340826198012250001','2010-10-12','北京朝阳区阳光大道899','研究生','主任医师，主任导师，博士生导师。广东省名中医，第三、四 批全国老中医药专家学术经验继承工作指导老师，岭南疡科流派代表性传承人，广东省保健行业协会第一届岭南养生文化研究促进会首席顾问，广东省基层医药学会中西医结合胃肠外科专业委员会学术顾问，广东省基层医药学会中西医结合肝胆外科专业委员会学术顾问等','动脉硬化闭塞症、糖尿病足、下肢静脉曲张等周围血管病，甲 状腺、肝胆结石、肝胆肿瘤等肝胆胰外科和胃肠外科等普通外科常见 病、疑难病的中西医结合诊治。尤其擅长外科围手术期的中医辨证治 疗、外科术后的中医康复调养',30),('2112345938','12345','吴击歌','123456','1991-02-28','男','19860205920','副主任医师','340826198012250007','2010-10-12','广东省广州市增城区下车路与118省道交叉口北500米','博士','呼吸大科主任，博士研究生导师，联合国教科文组织“首届中国青年女科学家奖”获得者，全国名老中医周仲瑛、刘伟胜教授学术经验继承人，广东省中医药学会呼吸病专业委员会主任委员，世界中医药学会联合会呼吸专业委员会副会长， 中国中西医结合学会呼吸病专业委员会副主任委员，广东省中医药学会常务理事。','慢性咳嗽、慢性阻塞性肺疾病、支气管哮喘、肺心病、呼吸衰竭、肺部感染、支气管扩张、胸腔积液、肺间质纤维化、肺癌等呼吸系统疾病及亚健康状态、失眠、胃肠功能紊乱等内科疑难杂症，擅长中医健康调养。',27),('2112346821','12346','赵子龙','123456','1991-02-28','男','19860205921','主任医师','340826198012250009','2010-10-12','广州市白云区云城东路1998号','博士','全国名老中医学术经验继承人。师从著名国医大师唐由之教授。','各类白内障、青光眼手术、眼表手术；义眼台植入手术；眼科急、重疑难疾病的诊治，特别是眼底病的中西结合治疗；擅长针刺治疗视疲劳、假性近视、视网膜色素变性等。',30),('2112347824','12347','李小李','123456','1981-03-08','男','19860205922','主任医师','340826198012250005','2010-10-12','广州市白云区白云大道南1033号','博士','广东省名中医，教授，主任医师，博士生导师，亚太人工关节学会中国分会理事、华裔骨科学会关节外科分会理事、中国中西医结合学会委员。','股骨头坏死、人工关节置换、翻修、创伤、颈肩腰腿痛、骨关节病、骨感染、骨结核、骨关节肿瘤、老年性骨质疏松等疾病的诊治。',40),('2212344172','12344','张小张','123456','1991-03-08','女','19860205923','主任医师','340826198012250004','2010-10-12','广东省广州市白云区百顺北路51号','博士','副主任中医师，中西医结合专业医学硕士，香港仁济医院暨香港浸会大学临床教研中心访问学者。','肺癌、肝癌、乳腺癌、卵巢癌、鼻咽癌、食道癌、胃肠癌、淋巴瘤等各种常见肿瘤的中西医结合治疗，尤其对肿瘤术后复发转移、放化疗的减毒增效及中晚期患者的减症抑瘤及癌性疼痛，骨转移痛的治疗有丰富的临床经验。',30);

/*Table structure for table `login_location` */

DROP TABLE IF EXISTS `login_location`;

CREATE TABLE `login_location` (
  `user_id` bigint DEFAULT NULL,
  `location` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `login_location` */

insert  into `login_location`(`user_id`,`location`) values (3119825704,'0:0:0:0:0:0:0:1');

/*Table structure for table `make3119009062liulong` */

DROP TABLE IF EXISTS `make3119009062liulong`;

CREATE TABLE `make3119009062liulong` (
  `pri_id` int DEFAULT NULL,
  `doc_id` char(15) DEFAULT NULL,
  `id` int NOT NULL,
  `patient_id` char(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pri_id` (`pri_id`),
  KEY `FK_make3119009062liulong` (`doc_id`),
  CONSTRAINT `FK_make3119009062liulong` FOREIGN KEY (`doc_id`) REFERENCES `doctor3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `make3119009062liulong_ibfk_1` FOREIGN KEY (`pri_id`) REFERENCES `priscribe3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `make3119009062liulong` */

/*Table structure for table `mapping3119009062liulong` */

DROP TABLE IF EXISTS `mapping3119009062liulong`;

CREATE TABLE `mapping3119009062liulong` (
  `med_id` int DEFAULT NULL,
  `pri_id` int DEFAULT NULL,
  `number` int DEFAULT NULL,
  `id` char(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `med_id` (`med_id`),
  KEY `pri_id` (`pri_id`),
  CONSTRAINT `mapping3119009062liulong_ibfk_1` FOREIGN KEY (`med_id`) REFERENCES `medicine3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mapping3119009062liulong_ibfk_2` FOREIGN KEY (`pri_id`) REFERENCES `priscribe3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `mapping3119009062liulong` */

/*Table structure for table `medicine3119009062liulong` */

DROP TABLE IF EXISTS `medicine3119009062liulong`;

CREATE TABLE `medicine3119009062liulong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(30) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `day_usage` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `production_time` date DEFAULT NULL,
  `expire_time` date DEFAULT NULL,
  `attention` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `medicine3119009062liulong` */

insert  into `medicine3119009062liulong`(`id`,`name`,`price`,`number`,`day_usage`,`production_time`,`expire_time`,`attention`) values (1,'阿莫西林','20.00',400,'一日三次，每次4粒','2022-12-29','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(5,'阿莫北林','40.00',500,'一日三次，每次4粒','2022-12-29','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(6,'阿莫东林','25.00',400,'一日三次，每次4粒','2022-12-29','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(7,'阿莫南林','30.00',200,'一日三次，每次4粒','2022-12-29','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(9,'阿莫北林','40.00',500,'一日三次，每次4粒','2022-12-29','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(10,'莲花颗粒','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(11,'莲花颗粒碎片','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(12,'头孢克洛定','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(13,'布洛芬','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(14,'感冒灵','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等'),(15,'感冒清','30.00',15,'一日三次，每次4粒','2022-12-13','2024-06-12','解热镇痛药，用于发热、疼痛及类风湿关节炎等');

/*Table structure for table `nurse3119009062liulong` */

DROP TABLE IF EXISTS `nurse3119009062liulong`;

CREATE TABLE `nurse3119009062liulong` (
  `id` char(15) NOT NULL,
  `dep_id` char(20) DEFAULT NULL,
  `name` char(15) DEFAULT NULL,
  `password` char(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `telephone` char(11) DEFAULT NULL,
  `title` char(20) DEFAULT NULL,
  `idnumber` char(18) DEFAULT NULL,
  `start_work` date DEFAULT NULL,
  `address` char(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_compound3119009062liulong` (`dep_id`),
  CONSTRAINT `FK_compound3119009062liulong` FOREIGN KEY (`dep_id`) REFERENCES `department3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `nurse3119009062liulong` */

/*Table structure for table `patient3119009062liulong` */

DROP TABLE IF EXISTS `patient3119009062liulong`;

CREATE TABLE `patient3119009062liulong` (
  `id` char(20) NOT NULL,
  `name` char(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `password` char(11) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `telephone` char(11) DEFAULT NULL,
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `patient3119009062liulong` */

insert  into `patient3119009062liulong`(`id`,`name`,`birthday`,`password`,`sex`,`address`,`telephone`,`id_number`,`age`) values ('3119741725','张盒子','1974-03-03','123456','男','广州市越秀区瑶台西街欢欢幼儿园(前进大街)南侧约120米','19860205974','3408261000005674',48),('3119825704','奥里给','1982-03-04','123456','男','广东省广州市越秀区矿泉街瑶台向阳大街12号之二105门市','19860205976','3408261000001234',40),('3119928402','吴亦凡','1992-03-04','123456','男','北京朝阳区某不能透露姓名的公寓','19860205971','3408261000005690',30),('3120120196','奥特曼','2012-12-25','123456','男','北京朝阳区阳光大道123','19860205972','3408261000008967',12),('3120120598','liulong','2012-12-25','123456','男','北京朝阳区阳光大道123','19860205970','3409261000008967',12),('3120127527','张三','2012-12-25','123456','男','北京朝阳区阳光大道123','18860205976','3409261000000001',12),('3219985251','张三三','1998-03-03','123456','女','广东省广州市天河区中山大道中1242号M+Park漫广场F3','19860205973','3408261000008912',24);

/*Table structure for table `patient_record3119009062liulong` */

DROP TABLE IF EXISTS `patient_record3119009062liulong`;

CREATE TABLE `patient_record3119009062liulong` (
  `doc_id` char(15) DEFAULT NULL,
  `pat_id` char(20) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `id` char(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_7` (`pat_id`),
  KEY `FK_Relationship_9` (`doc_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`pat_id`) REFERENCES `patient3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`doc_id`) REFERENCES `doctor3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `patient_record3119009062liulong` */

/*Table structure for table `payment3119009062liulong` */

DROP TABLE IF EXISTS `payment3119009062liulong`;

CREATE TABLE `payment3119009062liulong` (
  `id` char(15) NOT NULL,
  `pat_id` char(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `is_finished` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_6` (`pat_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`pat_id`) REFERENCES `patient3119009062liulong` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `payment3119009062liulong` */

/*Table structure for table `priscribe3119009062liulong` */

DROP TABLE IF EXISTS `priscribe3119009062liulong`;

CREATE TABLE `priscribe3119009062liulong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(15) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `illumination` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `priscribe3119009062liulong` */

/*Table structure for table `register3119009062liulong` */

DROP TABLE IF EXISTS `register3119009062liulong`;

CREATE TABLE `register3119009062liulong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pat_id` char(20) DEFAULT NULL,
  `cure_id` int DEFAULT NULL,
  `is_finished` tinyint(1) DEFAULT '0',
  `is_succeed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `cure_id` (`cure_id`),
  KEY `FK_have23119009062liulong` (`pat_id`),
  CONSTRAINT `FK_have23119009062liulong` FOREIGN KEY (`pat_id`) REFERENCES `patient3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `register3119009062liulong_ibfk_1` FOREIGN KEY (`cure_id`) REFERENCES `cure3119009062liulong` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `register3119009062liulong` */

insert  into `register3119009062liulong`(`id`,`pat_id`,`cure_id`,`is_finished`,`is_succeed`) values (4,'3119825704',7,0,1),(5,'3119825704',5,0,1),(6,'3119825704',9,0,1),(7,'3119825704',10,0,1),(11,'3119741725',5,0,1),(12,'3119928402',5,0,1),(13,'3120127527',5,0,1),(14,'3219985251',5,0,1);

/*Table structure for table `systems` */

DROP TABLE IF EXISTS `systems`;

CREATE TABLE `systems` (
  `id` bigint DEFAULT NULL,
  `region_id` char(1) DEFAULT NULL,
  `access_key_id` char(1) DEFAULT NULL,
  `secret` char(1) DEFAULT NULL,
  `template_code` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `systems` */

insert  into `systems`(`id`,`region_id`,`access_key_id`,`secret`,`template_code`) values (1,'c','L','u','S');

/*Table structure for table `department_doctor_view` */

DROP TABLE IF EXISTS `department_doctor_view`;

/*!50001 DROP VIEW IF EXISTS `department_doctor_view` */;
/*!50001 DROP TABLE IF EXISTS `department_doctor_view` */;

/*!50001 CREATE TABLE  `department_doctor_view`(
 `department_name` char(20) ,
 `doctor_id` char(15) ,
 `doctor_name` char(15) 
)*/;

/*View structure for view department_doctor_view */

/*!50001 DROP TABLE IF EXISTS `department_doctor_view` */;
/*!50001 DROP VIEW IF EXISTS `department_doctor_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `department_doctor_view` (`department_name`,`doctor_id`,`doctor_name`) AS select `department`.`name` AS `name`,`doctor`.`id` AS `id`,`doctor`.`name` AS `name` from (`doctor3119009062liulong` `doctor` join `department3119009062liulong` `department`) where (`doctor`.`dep_id` = `department`.`id`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
