
import os
import mysql.connector  

def collectData():
    config = {
            'host':'ip', 
            'port':'port',
            'user':'user', 
            'password':'passwd', 
            'database':'db'}
    conexion = mysql.connector.connect(**config)
    cursor = conexion.cursor()
    form = 'select * from battle order by battle_id desc;'
    cursor.execute(form)
    data = cursor.fetchone()
    return data

#Data Structure             0            1              2               3                  4                5                   6                     7                8               
#              data = ['battle_id', 'player_id', 'warrior_id', 'warrior_weapon_id', 'opponent_id', 'opponent_weapon_id', 'injuries_caused', 'injuries_suffered', 'battle_points']

def createXML(data):
    sep = "\n"
    tab = " "*4
    tab2 = tab + tab
    xml = '<?xml version="1.0" encoding="UTF-8"?>' + sep + '<!DOCTYPE battle SYSTEM "battle.dtd">' + sep + '<battle>' + sep 
    xml += '<battle_id>'+ str(data[0]) + '</battle_id>' + sep + tab2 + '<player_id>'.ljust(21) + str(data[1]) + '</player_id>' + sep + tab2 + '<warrior_id>'.ljust(21) + str(data[2]) + '</warrior_id>' + sep + tab2 + '<warrior_weapon_id>'.ljust(21) + str(data[3]) + '</warrior_weapon_id>' + sep + tab2 + '<opponent_id>'.ljust(21) + str(data[4]) + '</opponent_id>' + sep + tab2 + '<opponent_weapon_id>'.ljust(21) + str(data[5]) + '</opponent_weapon_id>' + sep + tab2 + '<injuries_caused>'.ljust(21) + str(data[6]) + '</injuries_caused>' + sep + tab2 + '<injuries_suffered>'.ljust(21) + str(data[7]) + '</injuries_seffered>' + sep + tab2 + '<battle_points>'.ljust(21) + str(data[8]) + '</battle_points>'
    xml += sep + '</battle>'
    file = open('./battle'+str(data[0])+'.xml', "w")
    file.write(xml)
    file.close()

data = collectData()
create = createXML(data)

