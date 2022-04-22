package Login;

public class LoginVO {
	//객체값을 저장, Value object
	String M_MemCode; //회원코드
	String M_Name; // 회원 이름
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
}
