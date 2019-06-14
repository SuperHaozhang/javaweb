package com.cheer.demo;

public class User {
    private int uid;
    private String uname;
    private String pwd;
    private String sex;
    private String age;
    private String birth;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd
                + ", sex=" + sex + ", age=" + age + ", birth=" + birth + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age != other.age)
            return false;
        if (birth == null) {
            if (other.birth != null)
                return false;
        } else if (!birth.equals(other.birth))
            return false;
        if (pwd == null) {
            if (other.pwd != null)
                return false;
        } else if (!pwd.equals(other.pwd))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        if (uid != other.uid)
            return false;
        if (uname == null) {
            if (other.uname != null)
                return false;
        } else if (!uname.equals(other.uname))
            return false;
        return true;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(int uid, String uname, String pwd, String sex, String age,
                String birth) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }
}