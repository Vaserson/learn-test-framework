# Different test approaches (LoginTests)
1. **successLoginNoPOM()** - no PageObject Model. Just driver.findElement;
2. **successLoginExplicitWaitNoPOM()** - no PageObject Model. Explicit wait by using WebDriverWait, which takes ***driver*** as an argument;
3. **successLoginPOMBadApproach()** - (`bad` package) bad PageObject. External class that has ***elements*** and ***actions*** for all the pages;
4. **successLoginPOMNoChaining()** - (`nochaining` package) page methods types are ***void***, no ***return***, no method chaining;
5. **successLoginPOMChaining()** - (`standard` package) page methods should return ***this*** or objects with type ***new OtherClass*** with a class page that will take control after such methods;
6. **successLoginPOM()** and failedLoginPOM() - (`standard` package) PageObject - external classes for every page that include ***elements*** and ***actions***. No Explicit wait;
7. **successLoginPOMExplicitWait()** - (`explicit` package) PageObject as previous, but using Explicit wait ***WebDriverWait***;
8. **successLoginPOMExplicitWaitBasePageMethods()** - (`bpmethods` package) PageObject as previous, but using common methods which declared in *BasePage* class (like ***click(element)*** instead of ***wait.until(ExpectedConditions.elementToBeClickable(element)).click()')***;
9. **successLoginPOMExplicitWaitPageFactory()** - (`pagefactory` package) PageFactory approach: ***@FindBy*** annotations for elements, ***PageFactory.initElements(driver, this)*** inside every class constructor.
