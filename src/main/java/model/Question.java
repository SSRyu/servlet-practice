package model;

//import dao.QuestionDao;

public class Question {
//	public static void main (String [ ] argus ) {
//		QuestionDao dao = new QuestionDao();
//		/*dao.getquestionSelectByNameAge( "taro","10","otoko","haru","nasi").forEach(System.out::println);*/
//	}
	private String name;
	private int age;
	private String sex;
	private String season;
	private String memo;
	
	//コンストラクタ
	// new Question("taro", 123, "kaseijin", "kasei", "kaseihasamui");
	public Question(String name, int age, String sex, String season, String memo) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.season = season;
		this.memo = memo;
	}

	public Question(String name, int age) {
		this.name = name;
		this.age = age;
		this.sex = "男性";
		this.season = "";
		this.memo = "?";
	}

	//コンストラクタ
	// new Question()
	public Question() {
		this.name = "?";
		this.age = -1;
		this.sex = "?";
		this.season = "?";
		this.memo = "?";
	}

	//入力内容を返す
	//名前
	public String getName( ) {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	//年齢
	public int getAge( ) {
		return age;
	}
	public void setAge( int age ) {
		this.age = age;
	}
	//性別
	public String getSex( ) {
		return sex;
	}
	public void setSex( String sex ) {
		this.sex = sex;
	}
	//季節
	public String getSeason( ) {
		return season;
	}
	public void setSeason( String season ) {
		this.season = season;
	}
	//その他
	public String getMemo( ) {
		return memo;
	}
	public void setMemo( String memo ) {
		this.memo = memo;
	}
}
