package Beans;

import Models.Person;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="Survey")
@SessionScoped
public class SurveyBean {
    private Person person = new Person();
    private Boolean secondPhase = false;
    private Boolean thirdPhase = false;
    private Integer clicks = 0;

    public void validateHeight(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer height = (Integer) value;
        String msg = "wrong height";
        String sex = this.person.getSex();
        if (height == null) {
            msg = "Height cant be empty";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
        if (sex == null) return;
        if (sex.equals("w") && (height < 150 || height> 185)){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
        if (sex.equals("m") && (height < 165 || height> 200)){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
        return;
    }

    public String submit(){
        if (this.secondPhase){
            return "lol";
        }
        this.secondPhase = true;
        return null;
    }

    public Boolean isMan(){
        String sex = this.person.getSex();
        return sex != null && sex.equals("m");
    }

    public Boolean isWoman(){
        String sex = this.person.getSex();
        return sex != null && sex.equals("w");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getSecondPhase() {
        return secondPhase;
    }

    public void setSecondPhase(Boolean secondPhase) {
        this.secondPhase = secondPhase;
    }

    public String join(String sep, String[] array){
        return String.join(sep,array);
    }
    public String chooseImage(){
        if (Math.random() > 0.3)
            return "http://www.fillmurray.com/300/200";
        return "http://www.fillmurray.com/400/300";

    }
    public void click(){
        System.out.println("Click");
        this.clicks += 1;
        return;
    }

    public Integer getClicks() {
        return clicks;
    }
}
