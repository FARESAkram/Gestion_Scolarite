<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times"
>
    <xsl:template match="/Note">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="paysage" page-height="21cm" page-width="29.7cm" margin-top="1.5cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                    <fo:region-before extent="2cm"/>
                    <fo:region-after extent="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="paysage">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block-container padding="15px" text-align="center" border-width="1mm" border-style="solid">
                        <fo:block  border-width="1px" border-style="solid">
                            Releve de notes de <xsl:value-of select="@class"/>
                        </fo:block>
                        <fo:block space-before="20px" font-weight="bold">Ecole nationale des sciences appliquées de Tanger</fo:block>
                    </fo:block-container>
                    <fo:table space-before="0.5cm" border-width="1px" border-style="solid">
                        <fo:table-body text-align="center">
                            <fo:table-row border-width="1px" border-style="solid">
                                <fo:table-cell border-width="1px" border-style="solid">
                                    <fo:block>Etudiant</fo:block>
                                </fo:table-cell >
                                <xsl:for-each select="//Module">
                                    <fo:table-cell border-width="1px" border-style="solid">
                                        <fo:block><xsl:value-of select="@code"/></fo:block>
                                    </fo:table-cell>
                                </xsl:for-each>
                                <fo:table-cell border-width="1px" border-style="solid">
                                    <fo:block>Moyenne</fo:block>
                                </fo:table-cell >
                            </fo:table-row>
                            <xsl:for-each select="//Module[1]/Students/Student">
                                <xsl:variable name="Student" select="." />
                                <fo:table-row>
                                    <fo:table-cell  border-width="1px" border-style="solid">
                                        <fo:block display-align="center" font-size="8px"><xsl:value-of select="concat(firstName,' ',lastName)"/></fo:block>
                                    </fo:table-cell>
                                    <xsl:for-each select="//Module//Students/Student[$Student/@CNE=@CNE]">
                                        <fo:table-cell border-width="1px" border-style="solid">
                                            <fo:block><xsl:value-of select="moyenne"/></fo:block>
                                        </fo:table-cell>
                                    </xsl:for-each>
                                    <fo:table-cell border-width="1px" border-style="solid">
                                        <fo:block><xsl:value-of select="format-number(sum(//Module/Students/Student[@CNE=$Student/@CNE]/moyenne) div count(//Module/Students/Student[@CNE=$Student/@CNE]/moyenne),'#.###')"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                            <fo:table-row>
                                <fo:table-cell border-width="1px" border-style="solid">
                                    <fo:block>Moyenne</fo:block>
                                </fo:table-cell>
                                <xsl:for-each select="//Module">
                                    <xsl:variable name="Module" select="." />
                                    <fo:table-cell border-width="1px" border-style="solid">
                                        <fo:block><xsl:value-of select="format-number(sum(//Module[@code=$Module/@code]//Students/Student/moyenne) div count(//Module[@code=$Module/@code]//Students/Student/moyenne),'#.###')"/></fo:block>
                                    </fo:table-cell>
                                </xsl:for-each>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>