from typing import Optional
from typing import List
import math

class Account:
    def __init__(self, timestamp:int,account_id:str ):
        self.account_id = account_id
        self.timestamp = timestamp
        self.balance = 0

        self.totalOutgoingMoney = 0
        self.queries = []
        self.waiting_period = 86400000

    def deposit(self,timestamp, amount)-> Optional[int]:

        if amount <= 0:
            return self.balance
        self.balance += amount

        return self.balance



    def transfer(self, timestamp,amount,account_type)-> Optional[int]:

        if account_type == 'source':
            self.balance -= amount
            self.totalOutgoingMoney += amount
            return self.balance
        else:
            self.balance += amount
            return self.balance




class Transaction:
    def __init__(self,account_id, timestamp,type,amount,payment_id=None,balance=None):
        self.account_id = account_id
        self.timeStamp = timestamp
        self.type = type
        self.amount = amount
        self.payment_id = payment_id
        self.balance = balance


class Bank:
    def __init__(self, name):
        self.name = name
        self.accounts = {}
        self.queries = []
        self.ordinalNumber = 0

    def create_account(self, timestamp:int, account_id:str) -> bool:
        if account_id in self.accounts:
            return False
        else:
            account = Account(timestamp,account_id)
            self.accounts[account_id] = account
            return True



    def deposit(self, timestamp:int, account_id:str,amount:int) -> Optional[int]:
        if account_id not in self.accounts:
            return None
        else:
            account = self.accounts[account_id]

            return account.deposit(timestamp,amount)



    def transfer(self, timestamp:int, source_account:str, target_account:str,amount:int) -> Optional[int]:
        if source_account not in self.accounts or target_account not in self.accounts:
            return None


        if amount > self.accounts[source_account].balance:
            return None

        source_account_obj =  self.accounts[source_account]
        target_account_obj = self.accounts[target_account]

        source_balance = source_account_obj.transfer(timestamp,amount,'source')
        target_account_obj.transfer(timestamp,amount,'target')
        return source_balance












# Example Usage
bank = Bank("Python Bank")

#Create accounts
print(bank.create_account(1,'account1'))
print(bank.create_account(2,'account1'))
print(bank.create_account(3,'account2'))

print(bank.deposit(4,'non-existing',2700))
print(bank.deposit(5,'account1',2700))
print(bank.transfer(6,'account1','account2',2701))
print(bank.transfer(7,'account1','account2',200))


#level2


# print(bank.create_account(1,'account3'))
# print(bank.create_account(2,'account2'))
# print(bank.create_account(3,'account1'))
#
# print(bank.deposit(4,'account1',2000))
# print(bank.deposit(5,'account2',3000))
# print(bank.deposit(6,'account3',4000))
# print(bank.top_spenders(7,3))
# print(bank.transfer(8,'account3','account2',500))
# print(bank.transfer(9,'account3','account1',1000))
# print(bank.transfer(10,'account1','account2',2500))
# print(bank.top_spenders(11,3))

MILLIS_IN_ONE_DAY = 86400000
#level3

# print(bank.create_account(1,'account1'))
# print(bank.create_account(2,'account2'))
#
# print(bank.deposit(3,'account1',2000))
# print(bank.pay(4,'account1',1000))
# print(bank.pay(100,'account1',1000))
#
# print(bank.get_payment_status(101,'non-exist','payment1'))
# print(bank.get_payment_status(102,'account2','payment1'))
# print(bank.get_payment_status(103,'account1','payment1'))
#
#
# print(bank.top_spenders(104,2))
# print(bank.deposit(3+MILLIS_IN_ONE_DAY,'account1',100))
#
# print(bank.get_payment_status(4+MILLIS_IN_ONE_DAY,'account1','payment1'))
#
# print(bank.deposit(5+MILLIS_IN_ONE_DAY,'account1',100))
# print(bank.deposit(99+MILLIS_IN_ONE_DAY,'account1',100))
# print(bank.deposit(100+MILLIS_IN_ONE_DAY,'account1',100))


#Level 4
# print(bank.create_account(1,'account1'))
# print(bank.create_account(2,'account2'))
#
# print(bank.deposit(3,'account1',2000))
# print(bank.deposit(4,'account2',2000))
#
# print(bank.pay(5,'account2',300))
# print(bank.transfer(6,'account1','account2',500))
# print(bank.merge_accounts(7,'account1','non-existing'))
# print(bank.merge_accounts(8,'account1','account1'))
# print(bank.merge_accounts(9,'account1','account2'))
#
# print(bank.deposit(10,'account1',100))
# print(bank.deposit(11,'account2',100))
#
# print(bank.get_payment_status(12,'account2','payment1'))
# print(bank.get_payment_status(13,'account1','payment1'))
#
#
# print(bank.get_balance(14,'account2',1))
# print(bank.get_balance(15,'account2',9))
# print(bank.get_balance(16,'account1',11))
#
# print(bank.deposit(5+MILLIS_IN_ONE_DAY,'account1',100))

#Level 4 - Another Example

# print(bank.create_account(1,'account1'))
# print(bank.deposit(2,'account1',1000))
# print(bank.pay(3,'account1',300))
# print(bank.get_balance(4,'account1',3))
# print(bank.get_balance(5+MILLIS_IN_ONE_DAY,'account1',2+MILLIS_IN_ONE_DAY))
# print(bank.get_balance(6+MILLIS_IN_ONE_DAY,'account1',3+MILLIS_IN_ONE_DAY))


#Notes
'''
After merging

If there is a transaction for account2 right after account1
add the balance from account1 to all immediate account2 transactions
 

'''
