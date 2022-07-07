# Salesforce Automation Task - simple

## Prerequisites

### Configure Salesforce Org to bypass login verification for the Test User
1. Navigate to the Setup Menu.
2. In the left-hand menu, navigate to Administration > Users > Users.
3. Select your test user 
4. Select the Profile of the test User.
5. Find the "Login IP Ranges" category on the page and click "New"
6. On the "Login IP Ranges" page, set
   Start IP Address = 0.0.0.0 and End IP Address = 255.255.255.255, 
fill in Description field and click Save.
   
A page with video on that - <https://roycon.com/how-to-bypass-login-verification-in-salesforce/>

### Environment Prerequisites
1. JDK 11
2. Maven
3. Google Chrome browser
4. Chrome WebDriver

### How to run tests
In the commont line, navigate to the root of project and run the command
`mvn clean test -DHOST=<URL path to SF Org> -DUSER=<username> -DPWD=<password>` 
where values in the triangle brackets to be replaced with your data. 

For example
`mvn clean test -DHOST=https://nonamecompany.my.salesforce.com -DUSER=user@force.com -DPWD=12345`

*By the way my passed Trailheads can be viewed at <https://trailblazer.me/id/kanavalau>*



