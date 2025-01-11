from banking_system import BankingSystem

class Account:
    def __init__(self, timestamp:int, account_id:str):
        self.account_id = account_id
        self.timestamp = timestamp
        self.balance = 0
        self.total_outgoing_money = 0
        self.transactions = [Transaction(self.account_id,timestamp,'create',0)]
        self.cashback_pending = []
        self.waiting_period = 86400000

    def deposit(self, timestamp, amount) -> int:
        self.check_cash_back(timestamp)
        if amount <= 0:
            return self.balance
        self.balance += amount
        self.transactions.append(Transaction(self.account_id,timestamp,'deposit',amount,balance = self.balance))
        return self.balance

    def transfer(self,timestamp,amount, account_type) -> int:
        self.check_cash_back(timestamp)
        if account_type == 'source':
            self.balance -= amount
            self.total_outgoing_money += amount
            self.transactions.append(Transaction(self.account_id,timestamp,'deposit',amount,balance = self.balance))
            return self.balance
        else:
            self.balance += amount
            self.transactions.append(Transaction(self.account_id,timestamp,'deposit',amount,balance = self.balance))
            return self.balance

    def withdraw(self,timestamp, amount,payment_id) -> int | None:
        self.check_cash_back(timestamp)
        if amount > self.balance:
            return None
        self.balance -= amount
        self.transactions.append(Transaction(self.account_id,timestamp,'withdraw',amount,payment_id))
        self.cashback_pending.append(Transaction(timestamp,'IN_PROGRESS',amount,payment_id))
        self.total_outgoing_money += amount
        return self.balance

    def check_cash_back(self,timestamp) -> None:
        for t in self.cashback_pending:
            print('cashback')
            if t.type == 'IN_PROGRESS' and timestamp >= self.waiting_period + t.timestamp:
                cashback = math.floor(0.02 * t.amount)
                self.balance += cashback
                self.transactions.append(self.account_id,self.waiting_period+t.timestamp, 'CASHBACK_RECEIVED', cashback, balance = self.balance)
                t.type = 'CASHBACK_RECEIVED'




class Transaction:
    def __init__(self, account_id, timestamp, type, amount, payment_id=None, balance = None):
        self.account_id = account_id
        self.timestamp = timestamp
        self.type = type
        self.amount = amount
        self.payment_id = payment_id
        self.balance = balance

class BankingSystemImpl(BankingSystem):

    def __init__(self):
        self.accounts = {}
        self.ordinal_number = 0

    def create_account(self, timestamp: int, account_id: str) -> bool:
        if account_id in self.accounts:
            return False
        else:
            account = Account(timestamp, account_id)
            self.accounts[account_id] = account
            return True

    def deposit(self, timestamp: int, account_id: str, amount: int) -> int | None:
        if account_id not in self.accounts:
            return None
        else:
            account = self.accounts[account_id]
            return account.deposit(timestamp,amount)





    def transfer(self, timestamp: int, source_account_id: str, target_account_id: str, amount: int) -> int | None:
        if source_account_id not in self.accounts or target_account_id not in self.accounts:
            return None

        if source_account_id == target_account_id:
            return None

        if amount > self.accounts[source_account_id].balance:
            return None

        source_account = self.accounts[source_account_id]
        target_account = self.accounts[target_account_id]

        source_balance = source_account.transfer(timestamp,amount,'source')
        target_account.transfer(timestamp,amount,'target')
        return source_balance


    def top_spenders(self, timestamp: int, n: int) -> list[str]:
        sorted_accounts =[ f'''{key}({value.total_outgoing_money})'''  for key, value in sorted(self.accounts.items(), key = lambda x: (-x[1].total_outgoing_money, x[1].account_id))]
        return sorted_accounts[:n]


    def pay(self, timestamp: int, account_id: str, amount: int) -> str | None:
        if account_id not in self.accounts:
            return None

        if amount > self.accounts[account_id].balance:
            return None

        self.ordinal_number += 1
        payment_id = 'payment' + str(self.ordinal_number)
        source_account = self.accounts[account_id]
        source_account.withdraw(timestamp,amount,payment_id)
        return payment_id