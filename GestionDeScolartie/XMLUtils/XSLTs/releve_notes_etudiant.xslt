<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times">

    <xsl:template match="/student">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                    <fo:region-before extent="2cm"/>
                    <fo:region-after extent="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block-container border="solid 1px" font-size="9px">
                        <fo:block font-weight="bold" text-align="left" space-before="1mm" space-after="1mm">UNIVERSITÉ ABDELMALED ESSAÂDI</fo:block>
                        <fo:block text-align="center" space-after="1mm">Année universitaire <xsl:value-of select="concat(year-from-date(current-date()),'/',year-from-date(current-date())+1)"/> </fo:block>
                    </fo:block-container>
                    <fo:block-container text-align="center">
                        <fo:block text-align="left" font-size="9px" font-weight="bold" space-before="2mm" space-after="2mm">Ecole Nationale dees Sciences Appliquées de Tanger</fo:block>
                        <fo:block padding="2mm" border="1px black solid" font-weight="bold" text-align="center" font-size="16px" space-after="2mm">RELEVE DE NOTES ET RESULTATS</fo:block>
                        <fo:block padding="1mm" border="1px black solid" font-weight="bold" text-align="center" font-size="12px" space-before="1mm" space-after="2mm">Session 1</fo:block>

                        <fo:block white-space="pre" text-align="left" font-weight="bold" font-size="10px" space-before="2mm"><xsl:value-of select="concat(firstName,' ',lastName)"/></fo:block>
                        <fo:block text-align="left" space-before="1mm" font-size="10px">
                            né le <xsl:value-of select="dateOfBirth"/>
                        </fo:block>
                        <fo:block  text-align="left" space-before="1mm" font-size="10px">
                            inscrit en <xsl:value-of select="className"/>
                        </fo:block>
                        <fo:block  text-align="left" space-before="1mm" font-size="10px">
                            a obetenu les notes suivates:
                        </fo:block>
                        <fo:table width="100%">
                            <fo:table-body>
                                <fo:table-row border="1px solid">
                                    <fo:table-cell border="1px solid">
                                        <fo:block>Module</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1px solid">
                                        <fo:block>Note/Barème</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1px solid">
                                        <fo:block>Session</fo:block>
                                    </fo:table-cell>
                                </fo:table-row >
                                <xsl:for-each select="notes/modules/module">
                                    <fo:table-row border="1px solid">
                                        <fo:table-cell border="1px solid">
                                            <fo:block><xsl:value-of select="@code"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="1px solid">
                                            <fo:block><xsl:value-of select="moyenne"/>/20</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="1px solid">
                                            <fo:block>S1 <xsl:value-of select="concat(year-from-date(current-date()),'/',year-from-date(current-date())+1)"/></fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </fo:table-body>
                        </fo:table>
                        <fo:table space-before="2mm" space-after="9cm">
                            <fo:table-column/>
                            <fo:table-column/>
                            <fo:table-column/>
                            <fo:table-body font-weight="bold" font-size="10px">
                                <fo:table-cell>
                                    <fo:block>Résultat d'admission session 1:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block><xsl:value-of select="sum(/student/notes/modules/module/moyenne) div count(/student/notes/modules/module/moyenne)" />/20</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:if test="sum(/student/notes/modules/module/moyenne) div count(/student/notes/modules/module/moyenne) >= 12">Admis</xsl:if>
                                        <xsl:if test="sum(/student/notes/modules/module/moyenne) div count(/student/notes/modules/module/moyenne) &lt; 12"> Non Admis</xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-body>
                        </fo:table>
                        <fo:block text-align="right">Fait à Tanger le <xsl:value-of  select="format-date(current-date(),'[M01]/[D01]/[Y0001]')"/></fo:block>
                        <fo:block text-align="left">
                        <fo:block space-before="0.4cm" space-after="0.5cm">Directeur</fo:block>
                        <fo:block font-size="9px">Avis important: il ne peut être dêlivré qu'un seul exemplaire de cette attestation. Aucun duplicata ne sera fourni.</fo:block>
                        </fo:block>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>