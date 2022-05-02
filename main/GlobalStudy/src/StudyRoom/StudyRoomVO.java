package StudyRoom;

import java.sql.Date;
import java.sql.Timestamp;

public class StudyRoomVO {
	private int studyCode; //�뒪�꽣�뵒 踰덊샇
	private String memCode;
	private String name;
	private String title; // �뒪�꽣�뵒 �젣紐�
	private String content; // �뒪�꽣�뵒 �궡�슜
	private int count; // 議고쉶�닔
	private String area; // 吏��뿭
	private String lanName; // �뼵�뼱紐�
	private String level; //�뼵�뼱 �젅踰�
	private String week; // �뒪�꽣�뵒 �씗留� �슂�씪(�룊�씪or二쇰쭚)
	private String partTime; //�뒪�꽣�뵒 �떆媛�
	private String chatLink; // 梨꾪똿�닔�떒(�삤�뵂梨꾪똿諛� 留곹겕, 媛쒖씤 移댁뭅�삤�넚 ID)
	private String deletYN; //�뒪�꽣�떚 猷� �궘�젣 �뿬遺�
	private Date writeDay; // �뒪�꽣�뵒 �옉�꽦�씪�옄
	private String startDay; // �떆�옉�씪�옄
	private String endDay; // 醫낅즺 �씪�옄
	
	//조인 테이블 변수
	private String joincode; // 신청 코드
	private String submit; // 수락 여부 (Y,N);
	private Timestamp sj_JOINDAY;
	private String sj_NAME;
	private String sjcontent; // 신청 코드
	private String sjtitle;
	
	
	public String getSjtitle() {
		return sjtitle;
	}
	public void setSjtitle(String sjtitle) {
		this.sjtitle = sjtitle;
	}
	public String getSjcontent() {
		return sjcontent;
	}
	public void setSjcontent(String sjcontent) {
		this.sjcontent = sjcontent;
	}

	
	//끝
	public String getMemCode() {
		return memCode;
	}
	public Timestamp getSj_JOINDAY() {
		return sj_JOINDAY;
	}
	public void setSj_JOINDAY(Timestamp sj_JOINDAY) {
		this.sj_JOINDAY = sj_JOINDAY;
	}
	public String getSj_NAME() {
		return sj_NAME;
	}
	public void setSj_NAME(String sj_NAME) {
		this.sj_NAME = sj_NAME;
	}
	public int getStudyCode() {
		return studyCode;
	}
	public void setStudyCode(int studyCode) {
		this.studyCode = studyCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLanName() {
		return lanName;
	}
	public void setLanName(String lanName) {
		this.lanName = lanName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getPartTime() {
		return partTime;
	}
	public void setPartTime(String partTime) {
		this.partTime = partTime;
	}
	public String getChatLink() {
		return chatLink;
	}
	public void setChatLink(String chatLink) {
		this.chatLink = chatLink;
	}
	public String getDeletYN() {
		return deletYN;
	}
	public void setDeletYN(String deletYN) {
		this.deletYN = deletYN;
	}
	public Date getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	//조인테이블
	public String getJoincode() {
		return joincode;
	}
	public void setJoincode(String joincode) {
		this.joincode = joincode;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	//
	

}
