# tokenSystem
Assignment

1. ngToken app is Angular 6 app, Please run it with the following command - "ng serve --proxy-config proxy.config.json"

2. tokenSystem is springboot app, running in dev profile, sql script is included and backed by H2.

3. There are following Rest endpoints to hit : 
  i. POST Endpoint - 
        - localhost:8089/generate
        - Body is the customer number(optional). If no customer number is sent then the customer will be non-privileged.
        - If customer number is sent, it will be checked in the H2 db if it's Privileged or not.
  ii. GET Endpoint - 
        - localhost:8089/gettoken/{counterNumber}
        - This endpoint will assign a token to a counter with the counterNumber sent in the GET request.
        - This ebdpoint has to be accessed each time, by each counter operator when his/her current token is serviced.
 
 4. Angular routes - 
        - To generate token
                - http://localhost:4200/generatetoken
                
        - To get token for a counter
                - http://localhost:4200/counter
                
        - To display current tokens 
                - http://localhost:4200/display
                
5. Privileged customer handling logic is done in 
        - com.demo.tokensystem.Service.CounterServiceImpl#fillCounterQueue().
6. Number of counters and Privileged customer threshold percent(To avoid starvation of non privileged customers) can be set in Application    properties. Following are the properties - 
    - counter.number
    - privileged.customer.percent




