<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/">
      <html xsl:version="1.0">
         <link href="/home/drale/Downloads/projects/java/Gestion_Scolarite/GestionDeScolartie/OUTPUT/Notes/XMLFiles/../../../style.css"
                rel="stylesheet"
                type="text/css"/>
         <body>
            <h1>Affichage du module GINF31 avant rattrappage</h1>
            <a href="./List_Rattrappage_GINF2_GINF31.html">afficher la liste des ratrappages</a>
            <table border="1">
               <tr>
                  <th>lastName</th>
                  <th>firstName</th>
                  <th>moyenne</th>
               </tr>
               <xsl:for-each select="//Module[@code='GINF31']//Student">
                  <tr>
                     <td>
                        <xsl:value-of select="lastName"/>
                     </td>
                     <td>
                        <xsl:value-of select="firstName"/>
                     </td>
                     <xsl:if test="moyenne &gt;= 12">
                        <td class="valide">
                           <xsl:value-of select="moyenne"/>
                        </td>
                     </xsl:if>
                     <xsl:if test="moyenne &lt; 12 and moyenne &gt;= 8">
                        <td class="ratt">
                           <xsl:value-of select="moyenne"/>
                        </td>
                     </xsl:if>
                     <xsl:if test="moyenne &lt; 8">
                        <td class="rattElemin">
                           <xsl:value-of select="moyenne"/>
                        </td>
                     </xsl:if>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
