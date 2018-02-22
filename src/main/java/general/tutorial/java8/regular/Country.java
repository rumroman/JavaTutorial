package general.tutorial.java8.regular;

import com.fasterxml.jackson.annotation.JsonProperty;




public class Country {

    private String id;
    private String code;
    private String name;
    private String languageId;
    private String currencyId;
    private String currencyCode;
    private String currencyName;
    private String currencySymbol;
    private String languageCode;
    private String languageName;
    private String countryGroupId;
    private String countryGroup;
    private String phoneCode;
    private String phoneLength;
    private String mcc;
    private String nameTranslate;
    private String weekdayStart;

    public Country(String id, String code, String name, String languageId,
                   String currencyId, String currencyCode, String currencyName,
                   String currencySymbol, String languageCode, String languageName,
                   String countryGroupId, String countryGroup, String phoneCode,
                   String phoneLength, String mcc, String nameTranslate, String weekdayStart) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.languageId = languageId;
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.languageCode = languageCode;
        this.languageName = languageName;
        this.countryGroupId = countryGroupId;
        this.countryGroup = countryGroup;
        this.phoneCode = phoneCode;
        this.phoneLength = phoneLength;
        this.mcc = mcc;
        this.nameTranslate = nameTranslate;
        this.weekdayStart = weekdayStart;
    }

    public Country(){

    }

    public String getWeekdayStart() {
        return weekdayStart;
    }

    public void setWeekdayStart(String weekdayStart) {
        this.weekdayStart = weekdayStart;
    }

    public String getNameTranslate() {
        return nameTranslate;
    }

    public void setNameTranslate(String nameTranslate) {
        this.nameTranslate = nameTranslate;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getPhoneLength() {
        return phoneLength;
    }

    public void setPhoneLength(String phoneLength) {
        this.phoneLength = phoneLength;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCountryGroup() {
        return countryGroup;
    }

    public void setCountryGroup(String countryGroup) {
        this.countryGroup = countryGroup;
    }

    public String getcountryGroupId() {
        return countryGroupId;
    }

    public void setcountryGroupId(String countryGroupId) {
        this.countryGroupId = countryGroupId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getcurrencyId() {
        return currencyId;
    }

    public void setcurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getlanguageId() {
        return languageId;
    }

    public void setlanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
