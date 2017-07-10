package JavaBean;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {

	private List<String> str = new ArrayList<>();
	private List<String> kinds = new ArrayList<>();
	private int sz;
	private int key;
	private int dateid;

	public StudentInfo() {
		this.kinds.add("序号");
		this.kinds.add("姓名");
		this.kinds.add("性别");
		this.kinds.add("专业、班级");
		this.kinds.add("所在基层党委");
		this.kinds.add("所在支部");
		this.key = this.kinds.size(); // 身份证号码的下标为key
		this.kinds.add("身份证号码");
		this.kinds.add("正式/预备");
		this.kinds.add("就业单位");
		this.kinds.add("接收组织关系的党组织");
		this.kinds.add("接收党员组织关系党组织联系地址");
		this.kinds.add("介绍信抬头");
		this.kinds.add("具体去处（基层党委/党支部）");
		this.kinds.add("手机号码");
		this.kinds.add("介绍信编号");
		this.dateid = this.kinds.size();
		this.kinds.add("转出时间");
		// this.kinds.add("党员签名");
		this.sz = kinds.size();
	}

	StudentInfo(List<String> str) {
		this.str = str;
		this.kinds.add("序号");
		this.kinds.add("姓名");
		this.kinds.add("性别");
		this.kinds.add("专业、班级");
		this.kinds.add("所在基层党委");
		this.kinds.add("所在支部");
		this.key = this.kinds.size(); // 身份证号码的下标为key
		this.kinds.add("身份证号码");
		this.kinds.add("正式/预备");
		this.kinds.add("就业单位");
		this.kinds.add("接收组织关系的党组织");
		this.kinds.add("接收党员组织关系党组织联系地址");
		this.kinds.add("介绍信抬头");
		this.kinds.add("具体去处（基层党委/党支部）");
		this.kinds.add("手机号码");
		this.kinds.add("介绍信编号");
		this.dateid = this.kinds.size();
		this.kinds.add("转出时间");
		// this.kinds.add("党员签名");
		this.sz = kinds.size();
	}

	public void setlist(List<String> str) {
		this.str = str;
		this.sz = str.size();
	}

	public void setstr(String s) {
		this.str.add(s);
	}

	public List<String> getlist() {
		return this.str;
	}

	public String getstr(int index) {
		return this.str.get(index);
	}

	public String getkinds(int index) {
		return this.kinds.get(index);
	}

	public int getsz() {
		return this.sz;
	}

	public int getkey() {
		return this.key;
	}

	public int getdateid() {
		return this.dateid;
	}
}
