# Salesforce Automation Task

## Prerequisites

### Create Trial Salesforce Org
1. Go to <http://test.salesforce.com>
2. Use instructions on the page to create Free Trial Org in Salesforce


### Configure Salesforce Org to bypass login verification for the Test User
1. Navigate to the Setup Menu.
2. In the left-hand menu, navigate to Administration > Users > Users.
3. Select your test user 
4. Select the Profile of the test User.
5. Find the "Login IP Ranges" category on the page and click "New"
6. On the "Login IP Ranges" page, set
   Start IP Address = 0.0.0.0 and End IP Address = 255.255.255.255, 
fill in Description field and click Save.


### Environment Prerequisites
- JDK 11 
- Maven
- Google Chrome browser
- Chrome WebDriver

## How to run tests
In the command line, navigate to the root of project and run the command 
where values in the triangle brackets to be replaced with your data.
```
mvn clean test -DHOST=<URL path to SF Org> -DUSER=<username> -DPWD=<password>
```

For example,
```
mvn clean test -DHOST=https://nonamecompany.my.salesforce.com -DUSER=user@force.com -DPWD=12345
```

*By the way my passed Trailheads can be viewed at <https://trailblazer.me/id/kanavalau>*



