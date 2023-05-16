<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/battle">
        <html>
            <head>
                <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
                <meta http-equiv="Pragma" content="no-cache" />
                <meta http-equiv="Expires" content="0" />
                <meta name="viewport" content="initial-scale=1, maximum-scale=1"/>
                <link href="./battle.css" rel="stylesheet"/>
                <title>Battle Results</title>
           </head>
           <body>
               <xsl:for-each select="battle_info">
                    <div class="battleinfo">
                        <h1>Battle <xsl:value-of select="battle_id"/></h1>
                        <div class="portaits">
                            <xsl:element name="img">
                                <xsl:attribute name="class">photo</xsl:attribute>
                                <xsl:attribute name="src">../../M3-Programacio/Images/warrior<xsl:value-of select="warrior_id"/>1.png</xsl:attribute>
                            </xsl:element>
                            <xsl:element name="img">
                                <xsl:attribute name="class">photo</xsl:attribute>
                                <xsl:attribute name="src">../../M3-Programacio/Images/warrior<xsl:value-of select="opponent_id"/>1.png</xsl:attribute>
                            </xsl:element>
                        </div>
                        <table>
                            <tr>
                              <th></th>
                              <th></th>
                              <th></th>
                            </tr>
                            <tr>
                              <td>Players ID</td>
                              <td><xsl:value-of select="player_id"/></td>
                              <td>🤖</td>
                            </tr>
                            <tr>
                              <td>Warrior ID</td>
                              <td><xsl:value-of select="warrior_id"/></td>
                              <td><xsl:value-of select="opponent_id"/></td>
                            </tr>
                            <tr>
                              <td>Weapon ID</td>
                              <td><xsl:value-of select="warrior_weapon_id"/></td>
                              <td><xsl:value-of select="opponent_weapon_id"/></td>
                            </tr>
                            <tr>
                              <td>Injuries Caused</td>
                              <td><xsl:value-of select="injuries_caused"/></td>
                              <td><xsl:value-of select="injuries_suffered"/></td>
                            </tr>
                            <tr>
                              <td>Injuries Suffered</td>
                              <td><xsl:value-of select="injuries_suffered"/></td>
                              <td><xsl:value-of select="injuries_caused"/></td>
                            </tr>
                            <tr>
                              <td>Battle Points</td>
                              <td><xsl:value-of select="battle_points"/></td>
                              <td></td>
                            </tr>
                          </table>
                          <div class="portaits">
                            <xsl:element name="img">
                                <xsl:attribute name="class">weapon</xsl:attribute>
                                <xsl:attribute name="src">../../M3-Programacio/Images/weapon<xsl:value-of select="warrior_weapon_id"/>1.png</xsl:attribute>
                            </xsl:element>
                            <xsl:element name="img">
                                <xsl:attribute name="class">weapon</xsl:attribute>
                                <xsl:attribute name="src">../../M3-Programacio/Images/weapon<xsl:value-of select="opponent_weapon_id"/>1.png</xsl:attribute>
                            </xsl:element>
                          </div>
                    </div>
               </xsl:for-each>
           </body>
        </html>
    </xsl:template>
</xsl:stylesheet>