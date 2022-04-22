package StudyRoom;

import java.sql.Date;

public class StudyRoomVO {
	private String StudyCode; //스터디 번호
	private String M_MemCode;
	private String M_Name;
	private String Title; // 스터디 제목
	private String content; // 스터디 내용
	private int count; // 조회수
	private String Area; // 지역
	private String LanName; // 언어명
	private String Level; //언어 레벨
	private String Week; // 스터디 희망 요일(평일or주말)
	private String PartTime; //스터디 시간
	private String ChatLink; // 채팅수단(오픈채팅방 링크, 개인 카카오톡 ID)
	private String DeletYN; //스터티 룸 삭제 여부
	private Date WriteDay; // 스터디 작성일자
	private String StartDay; // 시작일자
	private String EndDay; // 종료 일자
	public String getStudyCode() {
		return StudyCode;
	}
	public void setStudyCode(String studyCode) {
		StudyCode = studyCode;
	}
	public String getM_MemCode() {
		return M_MemCode;
	}
	public void setM_MemCode(String m_MemCode) {
		M_MemCode = m_MemCode;
	}
	public String getM_Name() {
		return M_Name;
	}
	public void setM_Name(String m_Name) {
		M_Name = m_Name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getLanName() {
		return LanName;
	}
	public void setLanName(String lanName) {
		LanName = lanName;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public String getWeek() {
		return Week;
	}
	public void setWeek(String week) {
		Week = week;
	}
	public String getPartTime() {
		return PartTime;
	}
	public void setPartTime(String partTime) {
		PartTime = partTime;
	}
	public String getChatLink() {
		return ChatLink;
	}
	public void setChatLink(String chatLink) {
		ChatLink = chatLink;
	}
	public String getDeletYN() {
		return DeletYN;
	}
	public void setDeletYN(String deletYN) {
		DeletYN = deletYN;
	}
	public Date getWriteDay() {
		return WriteDay;
	}
	public void setWriteDay(Date writeDay) {
		WriteDay = writeDay;
	}
	public String getStartDay() {
		return StartDay;
	}
	public void setStartDay(String startDay) {
		StartDay = startDay;
	}
	public String getEndDay() {
		return EndDay;
	}
	public void setEndDay(String endDay) {
		EndDay = endDay;
	}

}
