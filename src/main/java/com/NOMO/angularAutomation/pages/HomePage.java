package com.NOMO.angularAutomation.pages;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.utils.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends MainPage {
    //invoke parent's constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Initialize web elements
    @FindBy(tagName = "small")
    WebElement welcomeMsg;

    @FindBy(xpath = "//button/span[contains(text(), 'Sign out')]")
    WebElement signOutBtn;

    @FindBy(xpath = "//span[text()='Venues']//ancestor::li")
    WebElement venuesLiDropdownMenu;

    @FindBy(xpath = "//span[text()='Venues']")
    WebElement venuesDropdownMenu;

    @FindBy(xpath = "//span[text()='Categories']")
    WebElement CategoriesDropdownMenu;
    @FindBy(xpath = "//a//span[text()='Events']")
    WebElement EventsDropdownMenu;

    @FindBy(xpath = "//span[text()='List Categories']")
    WebElement listCategories;

    @FindBy(xpath ="//button[@class = 'ml-4 blank Mmenu bgTransparent p-button p-component ng-star-inserted']")
    public WebElement OrdersMenu;

    @FindBy(xpath ="//img[@alt= 'Events']")
    public WebElement EventsPageLink;

    @FindBy(xpath = "//span[contains(text(),'Add new Category')]")
    WebElement addCategoryMenuItem;

    @FindBy(xpath = "//span[text()='List Venues']//ancestor::a")
    WebElement listVenueMenuItem;

    @FindBy(xpath = "//span[contains(text(),'Add new Venue')]")
    WebElement addVenueMenuItem;

    @FindBy(xpath = "//span[text()='Add new Event']")
    WebElement AddEventMenuItem;

    @FindBy(xpath = "//span[text()='List Events']")
    WebElement EventMenuItem;

    @FindBy(xpath = "//span[text()='Tickets Orders']//ancestor::li")
    WebElement ticketsOrderLiDropdownMenu;

    @FindBy(xpath = "//span[contains(text(),'Tickets Orders')]")
    WebElement ticketsOrderDropdownMenu;

    @FindBy(xpath = "//span[contains(text(),'Book Ticket')]")
    WebElement bookTicketMenuItem;

    @FindBy(xpath = "//span[contains(text(),'Reprint Ticket')]")
    WebElement reprintTicketMenuItem;

    @FindBy(xpath = "//*[@class='appicon']")
    WebElement appsIcon;

    @FindBy(xpath = " //p[contains(text(),'Events')]")
    WebElement eventsIcon;


    public void selectVenueMenu() {
        try {
            scrollIntoViewAndClick(OrdersMenu);
        } catch (InterruptedException e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }

    }

    public String navigateToVenuePage() {
        try {
            Log.info("Navigate to Venue page");
            selectVenueMenu();
            EventsPageLink.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    //get welcome message
    public String getWelcomeMsg() {
        String welcomeMsgStr = "";
        try {
            welcomeMsgStr = welcomeMsg.getText();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return welcomeMsgStr;
    }

    public String logout() {
        try {
            welcomeMsg.click();
            signOutBtn.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public void selectVenuesMenuLink() throws InterruptedException {
        scrollIntoView(venuesDropdownMenu);
        if (!venuesLiDropdownMenu.getAttribute("class").equalsIgnoreCase("p-menuitem-active"))
            venuesDropdownMenu.click();
    }

    public void selectCategoryMenuLink() throws InterruptedException {
        scrollIntoViewAndClick(CategoriesDropdownMenu);

    }
    public void selectEventMenuLink() throws InterruptedException {
        scrollIntoViewAndClick(EventsDropdownMenu);

    }

    public String navigateToListVenuesPage() {
        try {
            Log.info("Navigate to list Venues page");
            selectVenuesMenuLink();
            listVenueMenuItem.sendKeys(Keys.RETURN);

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String navigateToAddVenuePage() {
        try {
            Log.info("Navigate to add venue page");
            selectVenuesMenuLink();
            addVenueMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }
    public void selectTicketsOrderMenuLink() throws InterruptedException {
        scrollIntoView(ticketsOrderDropdownMenu);
        if (!ticketsOrderLiDropdownMenu.getAttribute("class").equalsIgnoreCase("p-menuitem-active"))
            ticketsOrderDropdownMenu.click();
    }

    public String navigateToBookTicketsPage() {
        try {
            Log.info("Navigate to book tickets page");
            selectTicketsOrderMenuLink();
            bookTicketMenuItem.click();

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String navigateToReprintTicketPage() {
        try {
            Log.info("Navigate to reprint ticket page");
            selectTicketsOrderMenuLink();
            reprintTicketMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String navigateToEventsModule() {
        try {
            Log.info("Navigate to events module");
            appsIcon.click();
            eventsIcon.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String navigateToAddCategoryPage() {
        try {
            Log.info("Navigate to add category page");
            selectCategoryMenuLink();
            addCategoryMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }
    public String navigateToAddEventPage() {
        try {
            Log.info("Navigate to add Event page");
            selectEventMenuLink();
            AddEventMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }
    public String navigateToListEventPage() {
        try {
            Log.info("Navigate to List Event page");
            selectEventMenuLink();
            EventMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String navigateToCategoryListPage() {
        try {
            Log.info("Navigate to List category page");
            selectCategoryMenuLink();
            listCategories.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

}
