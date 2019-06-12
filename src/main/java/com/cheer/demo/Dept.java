package com.cheer.demo;

import java.util.List;

public class Dept {

	private String loc;
	private String dname;
	private Integer deptno;
	private List<Emp> emps;


	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public String getLoc(){
		return loc;
	}
	public String getDname(){
		return dname;
	}
	public Integer getDeptno(){
		return deptno;
	}
	public void setLoc(String loc){
		this.loc=loc;
	}
	public void setDname(String dname){
		this.dname=dname;
	}
	public void setDeptno(Integer deptno){
		this.deptno=deptno;
	}

	public Dept() {
	}

	public Dept(String loc, String dname, Integer deptno) {
		this.loc = loc;
		this.dname = dname;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Dept{" +
				"loc='" + loc + '\'' +
				", dname='" + dname + '\'' +
				", deptno=" + deptno +
				'}';
	}
}
