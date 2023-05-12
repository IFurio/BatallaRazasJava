<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
                <meta http-equiv="Pragma" content="no-cache" />
                <meta http-equiv="Expires" content="0" />
               
                <title>Battle Results</title>
           </head>
           <body>
               <xsl:for-each select="battle">
                    <div class="battleinfo">
                        <h1>Battle <xsl:value-of select="battle/battle_id"/></h1>
                        <div class="portaits">
                            <xsl:element name="img">
                                <xsl:attribute name="class">photo</xsl:attribute>
                                <xsl:attribute name="src">./Images/warrior<xsl:value-of select="battle/warrior_id"/></xsl:attribute>
                            </xsl:element>
                            <xsl:element name="img">
                                <xsl:attribute name="class">photo</xsl:attribute>
                                <xsl:attribute name="src">./Images/warrior<xsl:value-of select="battle/opponent_id"/></xsl:attribute>
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
                              <td><xsl:value-of select="battle/player_id"/></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>Warrior ID</td>
                              <td><xsl:value-of select="battle/warrior"/></td>
                              <td><xsl:value-of select="battle/opponent_id"/></td>
                            </tr>
                            <tr>
                              <td>Weapon ID</td>
                              <td><xsl:value-of select="battle/warrior_weapon_id"/></td>
                              <td><xsl:value-of select="battle/opponent_weapon_id"/></td>
                            </tr>
                            <tr>
                              <td>Injuries Caused</td>
                              <td><xsl:value-of select="battle/injuries_caused"/></td>
                              <td><xsl:value-of select="battle/injuries_suffered"/></td>
                            </tr>
                            <tr>
                              <td>Injuries Suffered</td>
                              <td><xsl:value-of select="battle/injuries_suffered"/></td>
                              <td><xsl:value-of select="battle/injuries_caused"/></td>
                            </tr>
                            <tr>
                              <td>Battle Points</td>
                              <td><xsl:value-of select="battle/battle_points"/></td>
                              <td></td>
                            </tr>
                          </table>
                          <div class="portaits">
                            <xsl:element name="img">
                                <xsl:attribute name="class">weapon</xsl:attribute>
                                <xsl:attribute name="src">./Images/weapon<xsl:value-of select="battle/warrior_weapon_id"/></xsl:attribute>
                            </xsl:element>
                            <xsl:element name="img">
                                <xsl:attribute name="class">weapon</xsl:attribute>
                                <xsl:attribute name="src">./Images/warrior<xsl:value-of select="battle/opponent_weapon_id"/></xsl:attribute>
                            </xsl:element>
                          </div>
                    </div>
               </xsl:for-each>
           </body>
        </html>
    </xsl:template>
</xsl:stylesheet>