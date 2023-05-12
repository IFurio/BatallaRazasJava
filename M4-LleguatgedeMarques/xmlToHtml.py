from lxml import etree
import os

# Llegir un arxiu XML
def read_xml(path):
   file = open(path, 'r', encoding='utf-8')
   string = file.read()
   file.close()
   return bytes(bytearray(string, encoding='utf-8'))

# Escriure un arxiu HTML
def write_html(path, html):
   file = open(path, 'w', encoding='utf-8')
   file.write(html)
   file.close()

# Crear un índex.html amb les 5 primeres noticies
def transform():
   xml = read_xml('./xml/battle.xml')
   xmlTree = etree.XML(xml)
   # Crear l'arbre XSL per l'index de totes les noticies
   xslfile = read_xml('./xml/template.xsl')
   xslTree = etree.XML(xslfile)
   # Transformar l'arxiu de dades-microsiervos.rss segons l'arxiu template-microsiervos.xsl
   transform = etree.XSLT(xslTree)
   htmlDom = transform(xmlTree)
   print(htmlDom)
   htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('utf-8')
   write_html("./html/battle.html", htmlResult)

transform()









