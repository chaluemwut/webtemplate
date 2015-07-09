## webtemplate
เป็น template สำหรับพัฒนา web application โดยใช้ Spring MVC 

## การเริ่มทำงาน
สามารถเริ่มใช้งานได้โดยใช้ git clone https://github.com/chaluemwut/webtemplate.git

## องค์ประกอบของ

# model
webtemplate สามารถต่อกับ MongoDB โดยใช้ Spring Data โดยมีขั้นตอนดังนี้

1. Config database ได้ที่
[dispatcher-servlet.xml](src/main/webapp/WEB-INF/dispatcher-servlet.xml)

กำหนดค่า
<bean id="mongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate">
	<constructor-arg name="mongo" ref="mongo" />
	<constructor-arg name="databaseName" value="webtemplate" />
</bean>

2. สร้าง POJO
POJO เป็นตัวแทนของ database ซึ่งเขียนเป็น Java Bean ตัวอย่างดูได้ที่
[Users.java](src/main/java/com/nsc/webtemplate/model/Users.java)

3. สร้าง Repository
เป็น class ที่ทำ Operation เกี่ยวกับ database เช่น insert, query ซึ่งจะต้องไปเรียก POJO จากข้อ 2. โดย class นี้เป็น interface class ตัวอย่างดูได้ที่
[UsersRepository.java](src/main/java/com/nsc/webtemplate/model/UsersRepository.java)

Repository จะถูกเรียกใช้จาก Controller เช่น
Users user = repository.findByUserNameAndPassWord(userName, passWord);


# Controller
