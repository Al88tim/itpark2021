package main.java.LessonForteen;

import java.io.Serializable;


class Record implements Serializable,Cloneable {
    final long id;
    private String phone;
    private String name;
    private String adress;

    Record(long id, String phone, String name, String adress) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return name + " : " + phone + " , " + adress;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if ((this.phone == null) ? (other.phone != null) : !this.phone.equals(other.phone)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.adress == null) ? (other.adress != null) : !this.adress.equals(other.adress)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        hash = 61 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 61 * hash + (this.adress != null ? this.adress.hashCode() : 0);
        return hash;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }


}






