## webtemplate
webtemplate เป็น template สำหรับพัฒนา web application โดยใช้ Spring MVC โดย webtemplate เป็น project ที่สร้างหน้า login ให้ผู้ใช้ใสค่า username และ password จากนั้นเชื่อมต่อกับ database เพื่อดูว่ามี user นี้ในฐานข้อมูลหรือไม่ และมี API ที่คืนค่าเป็น JSON

## การเริ่มทำงาน
สามารถเริ่มใช้งานได้โดยใช้ git clone https://github.com/chaluemwut/webtemplate.git
สิ่งที่ต้องมี
+ลง mongo db
+eclipse
+jdk 8
+tomcat 8

# Model
webtemplate สามารถต่อกับ MongoDB โดยใช้ Spring Data โดยมีขั้นตอนดังนี้

1. Config database ได้ที่
[dispatcher-servlet.xml](src/main/webapp/WEB-INF/dispatcher-servlet.xml)
<bean id="mongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate">
	<constructor-arg name="mongo" ref="mongo" />
	<constructor-arg name="databaseName" value="webtemplate" />
</bean>
2. สร้าง POJO โดย POJO เป็นตัวแทนของ database ซึ่งเขียนเป็น Java Bean ตัวอย่างดูได้ที่
[Users.java](src/main/java/com/nsc/webtemplate/model/Users.java)
3. สร้าง Repository
เป็น class ที่ทำ Operation เกี่ยวกับ database เช่น insert, query ซึ่งจะต้องไปเรียก POJO จากข้อ 2. โดย class นี้เป็น interface class ตัวอย่างดูได้ที่
[UsersRepository.java](src/main/java/com/nsc/webtemplate/model/UsersRepository.java)

Repository จะถูกเรียกใช้จาก Controller เช่น
Users user = repository.findByUserNameAndPassWord(userName, passWord);

# Controller
+ เป็นส่วนควบคุมการทำงานของ web application โดย Controller ดึงข้อมูลจาก model และนำไปแสดงในหน้า web
ตัวอย่างการแสดงหน้า login.jsp ของ controller โดย file JSP จะเก็บไว้ที่ WEB-INF/views ตาม config ของ [dispatcher-servlet.xml](src/main/webapp/WEB-INF/dispatcher-servlet.xml)

	@RequestMapping("/")
	public ModelAndView mainPage() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", "Welcome to Spring MVC!");
		return mv;
	}

โดยหน้า JSP สามารถแสดงข้อความ message ได้โดย
<html>
	<body>
	${message}
	</body>
</html>

+ การให้ controller เรียก model ทำได้โดย เพื่อให้ spring สร้าง repository ให้

	@Autowired
	private UsersRepository repository;

จากนั้นก็สามารถค้นหาข้อมูลได้จาก

	Users user = repository.findByUserNameAndPassWord(userName, passWord);
	
สามารถดูตัวอย่างทั้งหมดได้จาก [LoginController.java](src/main/java/com/nsc/webtemplate/controller/LoginController.java)

#API
API จะถูกเรียกจากส่วน mobile จะคืนค่าเป็น JSON สามารถดูตัวอย่างได้ใน folder api
[LoginAPI.java](src/main/java/com/nsc/webtemplate/api/LoginAPI.java)
