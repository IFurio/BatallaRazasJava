from lxml import etree
import os
#
# Remember to do 'cd .\M4-LleguatgedeMarques\' before executing it
#
# Llegir un arxiu XML
def read_xml(path):
   file = open(path, 'r', encoding='utf-8')
   string = file.read()
   file.close()
   return bytes(bytearray(string, encoding='utf-8'))

# Write HTML File
def write_html(path, html):
   file = open(path, 'w', encoding='utf-8')
   file.write(html)
   file.close()

def transform():
   xml = read_xml('./xml/battle.xml')
   xmlTree = etree.XML(xml)
   # Create XSL tree
   xslfile = read_xml('./xml/template.xsl')
   xslTree = etree.XML(xslfile)
   # Transform the file
   transform = etree.XSLT(xslTree)
   htmlDom = transform(xmlTree)
   htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('utf-8')
   write_html("./html/battle.html", htmlResult)

transform()









