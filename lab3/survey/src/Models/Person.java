package Models;

import java.util.ArrayList;


public class Person {
    private String name = null;
    private String email = null;
    private Integer age = null;
    private String sex = null;
    private String education = null;
    private Integer height = null;
    private Integer chest = null;
    private Integer breast = null;
    private Integer belly = null;
    private String cupSize = null;
    private Integer waist = null;
    private Integer hips = null;
    private String q1 = null;
    private String q2 = null;
    private String[] q3 = null;
    private String[] q4 = null;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.chest = null;
        this.breast = null;
        this.belly = null;
        this.cupSize = null;
        this.waist = null;
        this.hips = null;
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBreast() {
        return breast;
    }

    public void setBreast(Integer breast) {
        this.breast = breast;
    }

    public Integer getChest() {
        return chest;
    }

    public void setChest(Integer chest) {
        this.chest = chest;
    }

    public Integer getBelly() {
        return belly;
    }

    public void setBelly(Integer belly) {
        this.belly = belly;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHips() {
        return hips;
    }

    public void setHips(Integer hips) {
        this.hips = hips;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String[] getQ3() {
        return q3;
    }

    public void setQ3(String[] q3) {
        this.q3 = q3;
    }

    public String[] getQ4() {
        return q4;
    }

    public void setQ4(String[] q4) {
        this.q4 = q4;
    }
}
