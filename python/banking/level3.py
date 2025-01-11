from typing import Optional
from typing import List
import math

class Account:
    def __init__(self, timestamp:int,account_id:str ):
        self.account_id = account_id
        self.timestamp = timestamp
        self.balance = 0
        self.transactions = [Transaction(self.account_id,timestamp,'create',0)]
        self.cash_back_pending = []
        self.totalOutgoingMoney = 0
        self.queries = []
        self.waiting_period = 86400000

    def deposit(self,timestamp, amount)-> Optional[int]:
        self.checkCashBack(timestamp)
        if amount <= 0:
            return self.balance
        self.balance += amount
        self.transactions.append(Transaction(self.account_id,timestamp,'deposit',amount,balance=self.balance))
        print( [ [x.timeStamp,x.balance,x.account_id] for x in sorted(self.transactions,key=lambda x:x.timeStamp)])

        return self.balance

    def withdraw(self,timestamp, amount,payment_id)-> Optional[int]:
        self.checkCashBack(timestamp)
        if amount > self.balance:
            return None
        self.balance -= amount
        self.transactions.append(Transaction(self.account_id,timestamp,'withdraw',amount,payment_id,balance=self.balance))
        self.cash_back_pending.append(Transaction(timestamp,'IN_PROGRESS',amount,payment_id))
        self.totalOutgoingMoney += amount
        return self.balance

    def transfer(self, timestamp,amount,account_type):
        self.checkCashBack(timestamp)
        if account_type == 'source':
            self.balance -= amount
            self.totalOutgoingMoney += amount
            self.transactions.append(Transaction(self.account_id,timestamp,'transfer_from',amount,balance=self.balance))
            return self.balance
        else:
            self.balance += amount
            self.transactions.append(Transaction(self.account_id,timestamp,'transfer_to',amount,balance=self.balance))
            return self.balance


    def checkCashBack(self,timestamp):
        for t in self.cash_back_pending:
            if t.type == 'IN_PROGRESS' and timestamp >= self.waiting_period+t.timeStamp:
                cashback = math.floor(0.02 * t.amount)
                self.balance += cashback
                self.transactions.append(Transaction(self.account_id,self.waiting_period+t.timeStamp,'CASHBACK_RECEIVED',cashback,balance=self.balance))

                t.type = 'CASHBACK_RECEIVED'


    def get_payment_status(self,timestamp,payment_id):
        self.checkCashBack(timestamp)
        for t in self.cash_back_pending:
            if t.payment_id == payment_id:
                return t.type


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

    def top_spenders(self,timestamp:int, no_of_accounts:int) -> List[str]:
        sorted_values = [key for key, value in sorted(self.accounts.items(), key=lambda x: (-x[1].totalOutgoingMoney,x[1].account_id))]

        return sorted_values[:no_of_accounts]


    def pay(self,timestamp:int, account_id:str, amount:int)  -> Optional[str]:

        if account_id not in self.accounts:
            return None

        if amount > self.accounts[account_id].balance:
            return None

        self.ordinalNumber += 1
        payment_id = 'payment' + str(self.ordinalNumber)
        source_account = self.accounts[account_id]
        source_account.withdraw(timestamp,amount,payment_id)
        return payment_id


    def get_payment_status(self,timestamp:int, account_id:str, payment_id:str)  -> Optional[str]:
        if account_id not in self.accounts:
            return None


        source_account = self.accounts[account_id]
        return source_account.get_payment_status(timestamp,payment_id)

    def merge_accounts(self, timestamp:int, source_account:str, target_account:str) -> bool:
        if source_account not in self.accounts or target_account not in self.accounts:
            return False

        if source_account == target_account:
            return False

        source_account_obj = self.accounts[source_account]
        target_account_obj = self.accounts[target_account]

        source_account_obj.transactions.extend(target_account_obj.transactions)

        source_account_obj.cash_back_pending.extend(target_account_obj.cash_back_pending)
        source_account_obj.totalOutgoingMoney += target_account_obj.totalOutgoingMoney
        source_account_obj.balance += target_account_obj.balance
        source_account_obj.checkCashBack(timestamp)

        print( [ [x.timeStamp,x.balance] for x in sorted(source_account_obj.transactions,key=lambda x:x.timeStamp)])

        del self.accounts[target_account]
        return True


    def get_balance(self,timestamp:int,account_id:str,time_at:int):
        if account_id not in self.accounts:
            return None

        account = self.accounts[account_id]
        account.checkCashBack(time_at)
        account.checkCashBack(timestamp)

        sorted_trans = sorted(account.transactions, key = lambda x : x.timeStamp)
        balance = -1
        for t in sorted_trans:
            if time_at >= t.timeStamp:
                balance = t.balance

        if balance != -1:
            return balance
        return None






# Example Usage
bank = Bank("Python Bank")

# Create accounts
# print(bank.create_account(1,'account1'))
# print(bank.create_account(2,'account1'))
# print(bank.create_account(3,'account2'))
#
# print(bank.deposit(4,'non-existing',2700))
# print(bank.deposit(5,'account1',2700))
# print(bank.transfer(6,'account1','account2',2701))
# print(bank.transfer(7,'account1','account2',200))
# print(bank.top_spenders(8,3))


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
print(bank.create_account(1,'account1'))
print(bank.create_account(2,'account2'))

print(bank.deposit(3,'account1',2000))
print(bank.deposit(4,'account2',2000))

print(bank.pay(5,'account2',300))
print(bank.transfer(6,'account1','account2',500))
print(bank.merge_accounts(7,'account1','non-existing'))
print(bank.merge_accounts(8,'account1','account1'))
print(bank.merge_accounts(9,'account1','account2'))

print(bank.deposit(10,'account1',100))
print(bank.deposit(11,'account2',100))

print(bank.get_payment_status(12,'account2','payment1'))
print(bank.get_payment_status(13,'account1','payment1'))


print(bank.get_balance(14,'account2',1))
print(bank.get_balance(15,'account2',9))
print(bank.get_balance(16,'account1',11))

print(bank.deposit(5+MILLIS_IN_ONE_DAY,'account1',100))

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
