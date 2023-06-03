# Hotel

#Database project

#Question

Create a food ordering app for a hotel.<br>
There will be two main actors to play role:<br>
1. Customer<br>
2. Admin / manager<br>
Admin can Add / Update / Delete food and check all food items .<br>
Admin can track order records.<br>
Admin can manage payment details.<br>
Customer can view food list and order food.<br>


Tables in database :<br>
Table : Food_record<br>
food_id Item    Price<br>
F1      Pizza   900<br>
F2      Dosa    670<br>
F3      Idli    340<br>
F4      Noodles 200<br>

Table:Customer_record<br>
orderId            customerName Amount<br>
12-2-2020;10:12:22 Jerry        2000<br>
Table: Customer_food<br>
orderId            food_id Quantity<br>
12-2-2020;10:12:22 F1      2<br>
12-2-2020;10:12:22 F4      1<br>
