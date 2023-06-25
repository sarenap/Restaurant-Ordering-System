class Order:
    def __init__(self, name, customer_orders, balance):
        self.name = name
        self.customer_orders = customer_orders
        self.balance = balance

    def valid_order(self):
        total_price = sum(self.customer_orders)
        return total_price <= self.balance

    def remaining_balance(self):
        total_price = sum(self.customer_orders)
        return self.balance - total_price

