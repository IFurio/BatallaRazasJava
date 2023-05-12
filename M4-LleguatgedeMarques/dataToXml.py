#Remember that you have to be on the same folder of the .py file (doing a cd on terminal)
import os
import mysql.connector  

#Connect to DB and collect information
def collectData():
    config = {
            'host':'ip', 
            'port':'port',
            'user':'user', 
            'password':'passwd', 
            'database':'db'}
    try:
        conexion = mysql.connector.connect(**config)
        cursor = conexion.cursor()
        form = 'select * from battle order by battle_id asc;'
        cursor.execute(form)
        data = cursor.fetchall()
    except:
        print("Connection failed...")
    return data

#Data Structure             0            1              2               3                  4                5                   6                     7                8               
#               row = ['battle_id', 'player_id', 'warrior_id', 'warrior_weapon_id', 'opponent_id', 'opponent_weapon_id', 'injuries_caused', 'injuries_suffered', 'battle_points']

def createXML(data):
    sep = "\n"
    tab = " "*4
    tab2 = tab + tab
    xml = '<?xml version="1.0" encoding="UTF-8"?>' + sep + '<!DOCTYPE battle SYSTEM "battle.dtd">' + sep + '<battle>' + sep 
    for row in data:
        xml += '<battle_id>'+ str(row[0]) + '</battle_id>' + sep + tab2 + '<player_id>'.ljust(21) + str(row[1]) + '</player_id>' + sep + tab2 + '<warrior_id>'.ljust(21) + str(row[2]) + '</warrior_id>' + sep + tab2 + '<warrior_weapon_id>'.ljust(21) + str(row[3]) + '</warrior_weapon_id>' + sep + tab2 + '<opponent_id>'.ljust(21) + str(row[4]) + '</opponent_id>' + sep + tab2 + '<opponent_weapon_id>'.ljust(21) + str(row[5]) + '</opponent_weapon_id>' + sep + tab2 + '<injuries_caused>'.ljust(21) + str(row[6]) + '</injuries_caused>' + sep + tab2 + '<injuries_suffered>'.ljust(21) + str(row[7]) + '</injuries_suffered>' + sep + tab2 + '<battle_points>'.ljust(21) + str(row[8]) + '</battle_points>' + sep + '</battle>' + sep
    file = open('./xml/battle.xml', "w")
    file.write(xml)
    file.close()

data = collectData()
create = createXML(data)

