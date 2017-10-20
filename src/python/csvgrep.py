#!/usr/bin/python
import sys
import subprocess
import StringIO
import csv


class csvgrep(object):
	
 	def __init__(self, filepath,searchkey,columnNums):
		self.filepath = filepath
		self.searchkey = searchkey
		self.columnNums = columnNums

	def grep(self):

		if self.filepath.find("/data/")>=0:
			p1 = subprocess.Popen(["hdfs","dfs","-cat",self.filepath],shell=False,stdout=subprocess.PIPE)
			p2 = subprocess.Popen(["csvgrep","-m",self.searchkey,"-c","1"],shell=False,stdin=p1.stdout,stdout=subprocess.PIPE)
		else:
			p2 = subprocess.Popen(["csvgrep","-m",self.searchkey,"-c","1", self.filepath],shell=False,stdout=subprocess.PIPE)
		out = p2.stdout.read().rstrip('\n')
		f = StringIO.StringIO(out)
		reader = csv.reader(f, delimiter=',')
		for row in reader:
			print("Legacy : %s \t" %(row[0]))

			for item in self.columnNums:
				print("Column(%s) Value : %s" %(item,row[int(item)]))


def main():
       	script,filepath,searchkey,columnNums = sys.argv	
       	csvgrepobj = csvgrep(filepath,searchkey,columnNums.split(','))
       	csvgrepobj.grep()

if __name__ == "__main__":
    main()


