from Order import Order

def main():
    customer_orders = []
    menu_prices = [9.5, 6, 2.5]

    # Scan stuff to put into order constructor and create Order object
    name = input("Hi, enter your name: ")

    print("What would you like to order? Enter the number:\n1. Burger $9.50\n2. Milkshake $6.00\n3. Fries $3.00\n4. Done ordering")
    input_value = int(input())  # Item number they want

    if input_value == 4:
        print("Done ordering")
        return
    elif 1 <= input_value <= 3:
        customer_orders.append(menu_prices[input_value - 1])
        print("Item {} ordered".format(input_value))

    # Keep ordering if needed
    while input_value != 4:
        print("What would you like to order? Enter the number:\n1. Burger $9.50\n2. Milkshake $6.00\n3. Fries $2.5\n4. Done ordering\n5. Print & change order")
        input_value = int(input())
        #and
        if input_value == 4:
            print("Done ordering")
        elif 1 <= input_value <= 3: 
            customer_orders.append(menu_prices[input_value - 1])
            print("Item {} ordered".format(input_value))
        elif input_value == 5:
            item_num = 1
            total_price = 0
            for i in customer_orders:
                print("Ordered item #{}  ${}".format(item_num, i))
                item_num += 1
                total_price += i
            print("Total price ${}".format(total_price))    
            print("Enter 0 to delete an item. Enter 4 to finish ordering.")
            delete = int(input())
            if delete == 4:
                break
            print("Enter the item number to delete: ")
            choice = int(input())
            customer_orders.pop(choice - 1)
            print("Item {} deleted".format(choice))

    print("Enter your wallet balance:")
    balance = float(input())
    print("Wallet balance = ${}".format(balance))

    o1 = Order(name, customer_orders, balance)

    if o1.valid_order():
        print("Order success for {}. Your remaining balance is ${}".format(name, o1.remaining_balance()))
    else:
        print("Order failed. Not enough money.")


if __name__ == "__main__":
    main()
