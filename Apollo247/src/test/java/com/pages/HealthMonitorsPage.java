

//package com.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import com.setup.BaseSteps;
//
//public class HealthMonitorsPage {
//
//    WebDriver driver;
//
//    public HealthMonitorsPage() {
//        this.driver = BaseSteps.driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div/div[1]/label/span[1]/div")
//    public WebElement brandsDropdown;
//
//    @FindBy(xpath = "//label[contains(text(),'Apollo Pharmacy')]")
//    public WebElement apolloPharmacyOption;
//
//    @FindBy(xpath = "//label[contains(text(),'Doctor’s Choice')]")
//    public WebElement doctorsChoiceOption;
//
//    public void clickBrands() {
//        brandsDropdown.click();
//    }
//
//    public void selectApolloPharmacy() {
//        apolloPharmacyOption.click();
//    }
//
//    public void selectDoctorsChoice() {
//        doctorsChoiceOption.click();
//    }
//
//    public void selectMultipleBrands() {
//        if (!apolloPharmacyOption.isSelected()) {
//            apolloPharmacyOption.click();
//        }
//        if (!doctorsChoiceOption.isSelected()) {
//            doctorsChoiceOption.click();
//        }
//    }
//}