# Payment-Api-Spring-web-jpa

# Post Request

[
    {
        "name": "debit",
        "displayName": "Alfa Lebanon",
        "paymentType": "MOBILE_CARRIER",
        "paymentPlans": [
            {
                "netAmount": 5.99,
                "tax": 3,
                "grossAmount": 5.99,
                "currency": "USD",
                "duration": "Daily_demo"
            }
        ]
    }
]

# Put Request

{
        "name": "credit",
        "displayName": "Alfa Lebanon",
        "paymentType": "MOBILE_CARRIER",
        "paymentPlans": [
            {
            	"id":119,
                "netAmount": 5.99,
                "tax": 2,
                "grossAmount": 5.99,
                "currency": "USD",
                "duration": "Month_demo1"
            }
        ]
}

