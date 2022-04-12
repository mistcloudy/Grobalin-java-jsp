package StudyMange;

import java.sql.Timestamp;

public class StudyMangeVO {
	private String S_JOINCODE;
	private String S_STUDYCODE;
	private String M_MEMCODE;
	private String SJ_SUBMITYN;
	private String SJ_TITLE;
	private String S_TITLE;
	private String SJ_CONTENT;
	private String SC_JOINDAY;
	private String SC_RESIGNDAY;
	
	
	public String getS_JOINCODE() {
		return S_JOINCODE;
	}
	public void setS_JOINCODE(String s_JOINCODE) {
		S_JOINCODE = s_JOINCODE;
	}
	public String getS_STUDYCODE() {
		return S_STUDYCODE;
	}
	public void setS_STUDYCODE(String s_STUDYCODE) {
		S_STUDYCODE = s_STUDYCODE;
	}
	public String getM_MEMCODE() {
		return M_MEMCODE;
	}
	public void setM_MEMCODE(String m_MEMCODE) {
		M_MEMCODE = m_MEMCODE;
	}
	public String getSJ_SUBMITYN() {
		return SJ_SUBMITYN;
	}
	public void setSJ_SUBMITYN(String sJ_SUBMITYN) {
		SJ_SUBMITYN = sJ_SUBMITYN;
	}
	public String getSJ_TITLE() {
		return SJ_TITLE;
	}
	public void setSJ_TITLE(String sJ_TITLE) {
		SJ_TITLE = sJ_TITLE;
	}
	public String getS_TITLE() {
		return S_TITLE;
	}
	public void setS_TITLE(String s_TITLE) {
		S_TITLE = s_TITLE;
	}
	public String getSJ_CONTENT() {
		return SJ_CONTENT;
	}
	public void setSJ_CONTENT(String sJ_CONTENT) {
		SJ_CONTENT = sJ_CONTENT;
	}
	public String getSC_JOINDAY() {
		return SC_JOINDAY;
	}
	public void setSC_JOINDAY(String sC_JOINDAY) {
		SC_JOINDAY = sC_JOINDAY;
	}
	public String getSC_RESIGNDAY() {
		return SC_RESIGNDAY;
	}
	public void setSC_RESIGNDAY(String sC_RESIGNDAY) {
		SC_RESIGNDAY = sC_RESIGNDAY;
	}
	public Timestamp getSJ_DATE() {
		return SJ_DATE;
	}
	public void setSJ_DATE(Timestamp sJ_DATE) {
		SJ_DATE = sJ_DATE;
	}
	private Timestamp SJ_DATE;
	
