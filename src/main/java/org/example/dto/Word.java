package org.example.dto;

public class Word {
    private  Integer id ;
    private  String nameUz ;
    private  String nameEn ;
    private  String spellingEn ;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNameUz() {
        return nameUz;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getSpellingEn() {
        return spellingEn;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setSpellingEn(String spellingEn) {
        this.spellingEn = spellingEn;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", nameUz='" + nameUz + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", spellingEn='" + spellingEn + '\'' +
                "}\n";
    }
}

