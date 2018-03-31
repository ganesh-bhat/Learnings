import urllib2
import sys

crawledLinks = {}
while True :
   try:
      urlToDownload = raw_input('enter the URL to download')
      shortcut = raw_input('enter shortcut to use for URL')


      if urlToDownload == '':
         print 'Exiting'
         break

      webfile = urllib2.urlopen(urlToDownload).read();
      crawledLinks[shortcut] = webfile
      print 'Downloaded successfully'
      print crawledLinks.keys();

   except:
      print "********Unexpected error", sys.exc_info()




