from typing import Optional
from typing import List
class Account:
    def __init__(self, timestamp:int,account_id:str ):
        self.account_id = account_id
        self.timestamp = timestamp
        self.balance = 0
        self.transactions = [Transaction(timestamp,'create',0)]
        self.totalOutgoingMoney = 0
        self.queries = []

    def deposit(self,timestamp, amount)->int:
        if amount <= 0:
            return self.balance
        self.balance += amount
        self.transactions.append(Transaction(timestamp,'deposit',amount))
        return self.balance

    def transfer(self, timestamp,amount,account_type):
        if account_type == 'source':
            self.balance -= amount
            self.totalOutgoingMoney += amount
            self.transactions.append(Transaction(timestamp,'transfer_from',amount))
            return self.balance
        else:
            self.balance += amount
            self.transactions.append(Transaction(timestamp,'transfer_to',amount))
            return self.balance


class Transaction:
    def __init__(self,timestamp,type,new_balance):
        self.type = type
        self.timeStamp = timestamp
        self.new_balance = new_balance


class Bank:
    def __init__(self, name):
        self.name = name
        self.accounts = {}
        self.queries = []

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





    def remove_account(self, account_number):
        if account_number not in self.accounts:
            raise ValueError("Account not found.")
        del self.accounts[account_number]
        print(f"Account {account_number} removed from {self.name}.")

    def get_account(self, account_number):
        return self.accounts.get(account_number, None)

    def __str__(self):
        return f"{self.name} - {len(self.accounts)} accounts"


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
# print(bank.transfer(6,'account1','account2',200))
# print(bank.top_spenders(7,3))


print(bank.create_account(1,'account3'))
print(bank.create_account(2,'account2'))
print(bank.create_account(3,'account1'))

print(bank.deposit(4,'account1',2000))
print(bank.deposit(5,'account2',3000))
print(bank.deposit(6,'account3',4000))
print(bank.top_spenders(7,3))
print(bank.transfer(8,'account3','account2',500))
print(bank.transfer(9,'account3','account1',1000))
print(bank.transfer(10,'account1','account2',2500))
print(bank.top_spenders(11,3))



