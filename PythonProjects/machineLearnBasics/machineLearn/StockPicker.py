import xlsxwriter
import urllib2
import sys
import zipfile
import os
import csv

stockFile = "C:\Users\ganes\PycharmProjects\machineLearnBasics\machineLearn\cm16MAR2018bhav.csv.zip"
nseStockUrl = "http://www.nseindia.com/content/historical/EQUITIES/2018/MAR/cm16MAR2018bhav.csv.zip"
extractPath = 'C:/Users/ganes/PycharmProjects/machineLearnBasics/machineLearn/files'

def downloadFile(url,fileName):
    try:
        hdr = {
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36',
                'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
                'Connection':'keep-alive',
                'Accept-Ecoding':'none'
                }


        webRequest = urllib2.Request(nseStockUrl,headers=hdr);
        page = urllib2.urlopen(webRequest)

        content = page.read()
        bhavFile = open(fileName,"wb")
        bhavFile.write(bytearray(content))
        bhavFile.close()
    except:
        print "********Unexpected error", sys.exc_info()


def extractFiles(fileName, extractPath):
    extractedFiles = []
    if os.path.exists(fileName):
        fh = open(fileName,'rb')
        zipFileHandler = zipfile.ZipFile(fh)
        for name in zipFileHandler.namelist():
            zipFileHandler.extract(name,extractPath)
            extractedFiles.append(name)
        fh.close()

    print 'extracted files:',extractedFiles
    return extractedFiles

def processFiles(extractedFiles):
    listOfLists = []

    for fileToProcess in extractedFiles:
        with open(fileToProcess,'rb') as csvFile:
            lineNumber =0;
            lineReader = csv.reader(csvFile,delimiter=',',quotechar='"')
            for row in lineReader:
                lineNumber+=1
                if lineNumber == 1:
                    print 'header found'
                    continue;
                #print row[0], row[5],row[7],row[9]
                ticker = row[0]
                close = row[5]
                prevClose = row[7]
                tradedValue = row[9]
                percChange = float(close)/float(prevClose)  -1
                resultRow = [ticker,percChange,float(tradedValue)]
                listOfLists.append(resultRow)

               # print ticker,"{:,.1f}".format(float(tradedValue)/1e6) + "M INR","{:,.1f}".format(percChange*100)+"%"

    return listOfLists;



#downloadFile(nseStockUrl, stockFile)
#extractedFiles = extractFiles(stockFile,extractPath)
extractedFiles = [extractPath+'/'+'cm16MAR2018bhav.csv'];
stocks = processFiles(extractedFiles)
sortedList = sorted(stocks,key=lambda x:x[2],reverse=True)
sortedList.

