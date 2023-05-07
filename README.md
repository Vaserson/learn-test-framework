# Different test approaches (LoginTests)
1. **successLoginNoPOM()** - no PageObject Model. Just driver.findElement;
2. **successLoginExplicitWaitNoPOM()** - no PageObject Model. Explicit wait by using WebDriverWait, which takes ***driver*** as an argument;
3. **successLoginPOMBadApproach()** - bad PageObject. External class that has ***elements*** and ***actions*** for all the pages;
4. **successLoginPOM()** and failedLoginPOM() - PageObject - external classes for every page that include ***elements*** and ***actions***. No Explicit wait;
5. **successLoginPOMExplicitWait()** - PageObject as previous, but using Explicit wait ***WebDriverWait***;
6. **successLoginPOMExplicitWaitBasePageMethods()** - PageObject as previous, but using common methods which declared in *BasePage* class (like ***click(element)*** instead of ***wait.until(ExpectedConditions.elementToBeClickable(element)).click()')***;
7. **successLoginPOMExplicitWaitPageFactory()** - PageFactory approach: ***@FindBy*** annotations for elements, ***PageFactory.initElements(driver, this)*** inside every class constructor.
