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
		this.kinds.add("���");
		this.kinds.add("����");
		this.kinds.add("�Ա�");
		this.kinds.add("רҵ���༶");
		this.kinds.add("���ڻ��㵳ί");
		this.kinds.add("����֧��");
		this.key = this.kinds.size(); // ���֤������±�Ϊkey
		this.kinds.add("���֤����");
		this.kinds.add("��ʽ/Ԥ��");
		this.kinds.add("��ҵ��λ");
		this.kinds.add("������֯��ϵ�ĵ���֯");
		this.kinds.add("���յ�Ա��֯��ϵ����֯��ϵ��ַ");
		this.kinds.add("������̧ͷ");
		this.kinds.add("����ȥ�������㵳ί/��֧����");
		this.kinds.add("�ֻ�����");
		this.kinds.add("�����ű��");
		this.dateid = this.kinds.size();
		this.kinds.add("ת��ʱ��");
		// this.kinds.add("��Աǩ��");
		this.sz = kinds.size();
	}

	StudentInfo(List<String> str) {
		this.str = str;
		this.kinds.add("���");
		this.kinds.add("����");
		this.kinds.add("�Ա�");
		this.kinds.add("רҵ���༶");
		this.kinds.add("���ڻ��㵳ί");
		this.kinds.add("����֧��");
		this.key = this.kinds.size(); // ���֤������±�Ϊkey
		this.kinds.add("���֤����");
		this.kinds.add("��ʽ/Ԥ��");
		this.kinds.add("��ҵ��λ");
		this.kinds.add("������֯��ϵ�ĵ���֯");
		this.kinds.add("���յ�Ա��֯��ϵ����֯��ϵ��ַ");
		this.kinds.add("������̧ͷ");
		this.kinds.add("����ȥ�������㵳ί/��֧����");
		this.kinds.add("�ֻ�����");
		this.kinds.add("�����ű��");
		this.dateid = this.kinds.size();
		this.kinds.add("ת��ʱ��");
		// this.kinds.add("��Աǩ��");
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
